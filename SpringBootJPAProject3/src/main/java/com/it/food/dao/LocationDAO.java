package com.it.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.food.entity.LocationEntity;
import java.util.*;
public interface LocationDAO extends JpaRepository<LocationEntity, Integer>{
    public LocationEntity findByNo(Integer no);
    
    @Query(value="SELECT no,name,poster,msg,address "
    	  +"FROM seoul_location "
    	  +"ORDER BY no ASC "
    	  +"LIMIT :start,12",nativeQuery = true)
    public List<LocationEntity> locationListData(@Param("start") Integer start);
    
    @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location",nativeQuery = true)
    public int locationTotalPage();
    
}
