package org.example.app.repositories;

import org.example.app.entities.Position;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionRepository extends BaseRepository<Position> {

    @Override
    protected Position resultSetToObject(ResultSet rs) throws SQLException {
        return new Position(
                rs.getInt("id"),
                rs.getString("name"));
    }

    @Override
    public String create(Position position) {
        String insertSql = "INSERT INTO " + Constants.TABLE_POSITIONS + "(name) VALUES(?)";
        return super.create(insertSql, position.getName());
    }
}


