package com.java.boutique.dao;

import com.java.boutique.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Repository
public class CategoryDao {
    @Autowired
    private JdbcTemplate  jdbcTemplate;

    public List<Category> listAll(){
        String sql = "SELECT * FROM category";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return list;
    }


    public List<Category> findById(int id) {
        String sql = "SELECT * FROM category WHERE id=?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class), id);
    }


    public int deleteById(int id) {
        String sql = "DELETE FROM category WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
