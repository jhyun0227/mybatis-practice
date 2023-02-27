package com.example.servletjsp.mybatis.mapper;

import com.example.servletjsp.mybatis.dto.Festival;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FestivalMapper {

    List<Festival> findFestivalInterfaceList(@Param("areaCodeList") List<Integer> areaCodeList);
}
