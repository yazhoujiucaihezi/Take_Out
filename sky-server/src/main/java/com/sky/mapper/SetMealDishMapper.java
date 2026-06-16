package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SetMealDishMapper {

    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getBySetMealId(Long setmealId);

//    @Select("select setmeal_id from setmeal_dish where dish_id in " +
//            "<foreach collection='dishIds' item='dishId' open='(' separator=',' close=')'>#{dishId}</foreach>")
    List<Long> getSetMealDishIdsBySetId(@Param("dishIds") List<Long> dishIds);

    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);
//
//    @Insert("<script>" +
//            "insert into setmeal_dish (setmeal_id, dish_id, name, price, copies) values " +
//            "<foreach collection='setmealDishes' item='item' separator=','>" +
//            "(#{item.setmealId}, #{item.dishId}, #{item.name}, #{item.price}, #{item.copies})" +
//            "</foreach>" +
//            "</script>")
    void insertBatch(List<SetmealDish> setmealDishes);
}