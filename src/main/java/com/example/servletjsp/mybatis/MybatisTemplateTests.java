package com.example.servletjsp.mybatis;

import com.example.servletjsp.mybatis.dto.Festival;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MybatisTemplateTests {
    public static void main(String[] args) {
//      step1();
//      step2();
//      step3();
//        step4();
//        step5();
        step6();
    }

    public static void step1() {
        MybatisTemplate mybatisTemplate = new MybatisTemplate();
        List<Map<String, Object>> festivalList = mybatisTemplate.findFestivalList();
        System.out.println("festivalList --> " + festivalList);
    }

    public static void step2() {
        MybatisTemplate mybatisTemplate = new MybatisTemplate();

        List<Integer> contentStatusList = Arrays.asList(2);
        List<Integer> areaCodeList = Arrays.asList(1, 2);
        LocalDate createDateFrom = LocalDate.of(2022, 1, 1);
        List<Map<String, Object>> festivalList = mybatisTemplate.findFestivalList(contentStatusList, areaCodeList, createDateFrom);
        System.out.println("festivalList --> " + festivalList);
    }

    public static void step3() {
        MybatisTemplate mybatisTemplate = new MybatisTemplate();
        List<Festival> festivalList = mybatisTemplate.findFestivalDtoList();
        System.out.println("festivalList --> " + festivalList);
    }

    public static void step4() {
        MybatisTemplate mybatisTemplate = new MybatisTemplate();
        List<Festival> festivalList = mybatisTemplate.findFestivalResultMapDtoList();
        System.out.println("festivalList --> " + festivalList);
    }

    public static void step5() {
        MybatisTemplate mybatisTemplate = new MybatisTemplate();
        List<Festival> festivalList = mybatisTemplate.findFestivalRelationList();
        System.out.println("festivalList --> " + festivalList);
    }

    public static void step6() {
        MybatisTemplate mybatisTemplate = new MybatisTemplate();
        List<Festival> festivalList = mybatisTemplate.findFestivalInterfaceList(Arrays.asList(1, 2));
        System.out.println("festivalList --> " + festivalList);
    }
}
