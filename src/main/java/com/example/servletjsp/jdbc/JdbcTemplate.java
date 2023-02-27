package com.example.servletjsp.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplate {
    private static Connection connection;

    private static String url = "jdbc:mariadb://61.98.130.164:3306/KTO";
    private static String username = "front";
    private static String password = "front!@#$";

    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> findFestivalList() throws SQLException {
        String sql = "SELECT " +
                "CM.COT_ID, TITLE, CONTENT_STATUS, CONTENT_TYPE, CREATE_DATE, MAPX, MAPY " +
                "FROM CONTENT_MASTER CM " +
                "INNER JOIN DATABASE_MASTER DM " +
                "ON CM.COT_ID = DM.COT_ID " +
                "INNER JOIN FESTIVAL_INTRO FI " +
                "ON DM.COT_ID = FI.COT_ID " +
                "LIMIT 0, 10";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();

        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("COT_ID", resultSet.getString(1));
            map.put("TITLE", resultSet.getString(2));
            map.put("CONTENT_STATUS", resultSet.getInt(3));
            map.put("CONTENT_TYPE", resultSet.getInt(4));
            map.put("CREATE_DATE", resultSet.getString(5));
            map.put("MAPX", resultSet.getDouble(6));
            map.put("MAPY", resultSet.getDouble(7));
            list.add(map);
        }

        return list;
    }
}
