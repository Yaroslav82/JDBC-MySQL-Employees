package org.example.app.repositories;

import org.example.app.database.DBConn;
import org.example.app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseRepository<T> {

    protected abstract T resultSetToObject(ResultSet rs) throws SQLException;

    public abstract String create(T entity);

    public List<T> findAll(String table) {
        List<T> list = new ArrayList<>();
        try (Connection conn = DBConn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + table)) {

            while (rs.next()) {
                list.add(resultSetToObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return list;
    }

    public String create(String insertSql, Object... params) {
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}

