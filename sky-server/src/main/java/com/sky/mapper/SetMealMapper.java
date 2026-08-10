package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SetMealMapper {

    /**
     * 根据分类id查询套餐的数量
     *
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    @AutoFill(OperationType.INSERT)
    void insert(Setmeal setmeal);

//    @Select("<script>" +
//            "select * from setmeal" +
//            "<where>" +
//            "   <if test='name != null and name != \"\"'>" +
//            "       and name like concat('%', #{name}, '%')" +
//            "   </if>" +
//            "   <if test='categoryId != null'>" +
//            "       and category_id = #{categoryId}" +
//            "   </if>" +
//            "   <if test='status != null'>" +
//            "       and status = #{status}" +
//            "   </if>" +
//            "</where>" +
//            "order by create_time desc" +
//            "</script>")
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    @Select("select * from setmeal where id = #{id}")
    Setmeal getById(Long id);

    @Delete("delete from setmeal where id = #{id}")
    void deleteById(Long id);
//
//    @Update("<script>" +
//            "update setmeal " +
//            "<set>" +
//            "   <if test='categoryId != null'>category_id = #{categoryId},</if>" +
//            "   <if test='name != null'>name = #{name},</if>" +
//            "   <if test='price != null'>price = #{price},</if>" +
//            "   <if test='status != null'>status = #{status},</if>" +
//            "   <if test='description != null'>description = #{description},</if>" +
//            "   <if test='image != null'>image = #{image},</if>" +
//            "   <if test='updateTime != null'>update_time = #{updateTime},</if>" +
//            "   <if test='updateUser != null'>update_user = #{updateUser},</if>" +
//            "</set>" +
//            "where id = #{id}" +
//            "</script>")
    void update(Setmeal setmeal);

    /**
     * 动态条件查询套餐
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据套餐id查询菜品选项
     * @param setmealId
     * @return
     */
    @Select("select sd.name, sd.copies, d.image, d.description " +
            "from setmeal_dish sd left join dish d on sd.dish_id = d.id " +
            "where sd.setmeal_id = #{setmealId}")
    List<DishItemVO> getDishItemBySetmealId(Long setmealId);


    /**
     * 根据条件统计套餐数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);

}
