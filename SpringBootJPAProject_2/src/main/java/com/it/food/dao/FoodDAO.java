package com.it.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.food.entity.FoodEntity;

public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
    public FoodEntity findByNo(Integer no);
    // findAll()
}
