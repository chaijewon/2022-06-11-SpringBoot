package com.it.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.food.entity.FoodEntity;
@Repository
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
    public FoodEntity findByNo(Integer no);
    // findAll()
}
