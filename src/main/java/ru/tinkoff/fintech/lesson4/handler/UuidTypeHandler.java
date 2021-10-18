package ru.tinkoff.fintech.lesson4.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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
        ObjectMapper objectMapper = new ObjectMapper();
        String data = rs.getString(s).replace("\\", "" );
        try {
            return objectMapper.readValue(data.substring(1, data.length() - 1), Course.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }



    }

    @Override
    public Course getNullableResult(ResultSet rs, int i) throws SQLException {

//        return rs.getObject(i, Course.class);
        ObjectMapper objectMapper = new ObjectMapper();
        String data = rs.getString(i);
        try {
            return objectMapper.readValue(data, Course.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Course getNullableResult(CallableStatement cs, int i) throws SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = cs.getString(i);
        try {
            return objectMapper.readValue(data, Course.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }



    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int columnIndex, Course parameter, JdbcType jdbcType)
            throws SQLException {
        Gson gson = new Gson();
        ps.setString(columnIndex, gson.toJson(parameter));
    }
}



