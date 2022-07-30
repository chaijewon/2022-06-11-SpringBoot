package com.it.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.food.entity.NatureEntity;

public interface NatureDAO extends JpaRepository<NatureEntity, Integer>{
    public NatureEntity findByNo(Integer no);
}
