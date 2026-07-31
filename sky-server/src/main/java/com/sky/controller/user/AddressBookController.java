package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.result.Result;
import com.sky.service.AddressBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("userAddressBookController")
@RequestMapping("/user/addressBook")
@Api(tags = "C端-地址簿接口")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * 查看地址
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("查看地址")
    public Result<List<AddressBook>> list() {
        AddressBook addressBook = new AddressBook();
        addressBook.setUserId(BaseContext.getCurrentId());
        List<AddressBook> list = addressBookService.list(addressBook);
        return Result.success(list);
    }



    /**
     * 添加地址
     * @param addressBook
     * @return
     */
    @PostMapping
    @ApiOperation("添加地址")
    public Result add(@RequestBody AddressBook addressBook) {
        log.info("接收到的地址{}", addressBook);
        addressBookService.add(addressBook);
        return Result.success();
    }

    /**
     * 设置默认地址
     * @param addressBook
     * @return
     */
    @PutMapping("/default")
    @ApiOperation("设置默认地址")
    public Result setDefault(@RequestBody AddressBook addressBook) {
        log.info("设置默认地址，接收到的 id={}", addressBook.getId());
        addressBookService.setDefault(addressBook);
        log.info("设置默认地址完成，返回成功");
        return Result.success();
    }

    /**
     * 修改地址
     */
    @PutMapping
    @ApiOperation("修改地址")
    public Result update(@RequestBody AddressBook addressBook) {
        log.info("修改地址，接收到的数据{}", addressBook);
        addressBookService.update(addressBook);
        return Result.success();
    }

    /**
     * 查询默认地址
     * @return
     */
    @GetMapping("/default")
    @ApiOperation("查询默认地址")
    public Result<AddressBook> getDefault() {
        AddressBook addressBook = addressBookService.getDefault();
        return Result.success(addressBook);
    }

    /**
     * 根据id查询地址
     * @param id
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询地址")
    public Result<AddressBook> get(@PathVariable Long id) {
        AddressBook addressBook = addressBookService.getById(id);
        return Result.success(addressBook);
    }




    @DeleteMapping
    @ApiOperation("删除地址")
    public Result delete(Long id) {
        addressBookService.delete(id);
        return Result.success();
    }
}
