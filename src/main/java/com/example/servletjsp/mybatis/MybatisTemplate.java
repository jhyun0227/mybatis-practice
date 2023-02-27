package com.example.servletjsp.mybatis;

import com.example.servletjsp.mybatis.dto.Festival;
import com.example.servletjsp.mybatis.mapper.FestivalMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTemplate {
    private static SqlSession sqlSession;

    static {
        try {
            sqlSession = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("mybatis/MybatisConfig.xml"))
                    .openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Step 1. 조회만 해본 것
     */
    public List<Map<String, Object>> findFestivalList() {
        return sqlSession.selectList("com.example.servletjsp.mybatis.mapper.FestivalMapper.findFestivalList");
    }

    /**
     * Step 2. 파라미터 바인딩 해보기
     */
    public List<Map<String, Object>> findFestivalList(
            List<Integer> contentStatusList,
            List<Integer> areaCodeList,
            LocalDate createDateFrom) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("contentStatusList", contentStatusList);
        parameters.put("areaCodeList", areaCodeList);
        parameters.put("createDateFrom", createDateFrom);
        return sqlSession.selectList("com.example.servletjsp.mybatis.mapper.FestivalMapper.findFestivalListBy", parameters);
    }

    /**
     * Step 3. 반환타입을 Dto로 받기
     */
    public List<Festival> findFestivalDtoList() {
        return sqlSession.selectList("com.example.servletjsp.mybatis.mapper.FestivalMapper.findFestivalDtoList");
    }

    /**
     * Step 4. 반환타입을 ResultMap을 활용한 Dto로 받기
     */
    public List<Festival> findFestivalResultMapDtoList() {
        return sqlSession.selectList("com.example.servletjsp.mybatis.mapper.FestivalMapper.findFestivalResultMapDtoList");
    }

    /**
     * Step 5. 반환타입을 ResultMap을 활용한 연관관계 매핑된 Dto로 받기
     */
    public List<Festival> findFestivalRelationList() {
        return sqlSession.selectList("com.example.servletjsp.mybatis.mapper.FestivalMapper.findFestivalRelationList");
    }

    /**
     * Step 6. 인터페이스를 활용한 Mapper로 조회하기
     */
    public List<Festival> findFestivalInterfaceList(List<Integer> areaCodeList) {
        FestivalMapper festivalMapper = sqlSession.getMapper(FestivalMapper.class);
        return festivalMapper.findFestivalInterfaceList(areaCodeList);
    }
}
