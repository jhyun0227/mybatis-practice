package com.example.servletjsp.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTests {
    public static void main(String[] args) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        List<Map<String, Object>> festivalList = jdbcTemplate.findFestivalList();
        System.out.println("festivalList --> " + festivalList);
    }
}
