package ru.tinkoff.fintech.lesson4.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;

import com.google.gson.JsonElement;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.MappedJdbcTypes;
import ru.tinkoff.fintech.lesson4.model.Course;


@Slf4j
@MappedJdbcTypes(JdbcType.VARCHAR)
public class UuidTypeHandler extends BaseTypeHandler<Course> {



    @Override
    public Course getNullableResult(ResultSet rs, String s) throws SQLException {
        Gson gson = new Gson();
        Course course = gson.fromJson((JsonElement) rs, Course.class);

        return rs.getObject(s, Course.class);
    }

    @Override
    public Course getNullableResult(ResultSet rs, int i) throws SQLException {

        return rs.getObject(i, Course.class);

    }

    @Override
    public Course getNullableResult(CallableStatement cs, int i) throws SQLException {
        return cs.getObject(i, Course.class);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int columnIndex, Course parameter, JdbcType jdbcType)
            throws SQLException {
        Gson gson = new Gson();
        ps.setString(columnIndex, gson.toJson(parameter));

    }
}




//
//public class UuidTypeHandler extends BaseTypeHandler<UUID> {
//
//    @Override
//    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UUID uuid, JdbcType jdbcType
//    ) throws SQLException {
//        preparedStatement.setString(i, uuid.toString());
//    }
//
//    @Override
//    public UUID getNullableResult(ResultSet resultSet, String s) throws SQLException {
//        return resultSet.getObject(s, UUID.class);
//    }
//
//    @Override
//    public UUID getNullableResult(ResultSet resultSet, int i) throws SQLException {
//        return resultSet.getObject(i, UUID.class);
//    }
//
//    @Override
//    public UUID getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
//        return callableStatement.getObject(i, UUID.class);
//    }
//}
