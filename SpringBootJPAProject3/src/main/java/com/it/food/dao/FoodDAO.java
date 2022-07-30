package com.it.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.food.entity.FoodEntity;
import java.util.*;

public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
    @Query(value="SELECT cno,title,subject,poster,link "
    	  +"FROM food_category "
    	  +"WHERE cno BETWEEN :start AND :end",nativeQuery = true)
    public List<FoodEntity> foodCategoryData(@Param("start") Integer start,
    		    @Param("end") Integer end);
    
}
