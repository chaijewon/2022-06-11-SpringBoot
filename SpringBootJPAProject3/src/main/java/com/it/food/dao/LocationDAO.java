package com.it.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.food.entity.LocationEntity;

public interface LocationDAO extends JpaRepository<LocationEntity, Integer>{
    public LocationEntity findByNo(Integer no);
}
