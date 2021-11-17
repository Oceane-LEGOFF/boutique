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

    //methode Get list
    public List<Category> listAll(){
        String sql = "SELECT * FROM category";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return list;
    }

    //methode GetById
    public List<Category> findById(int id) {
        String sql = "SELECT * FROM category WHERE id=?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class), id);
    }

    //methode add
    public int add (Category category){
        return jdbcTemplate.update("INSERT INTO category (name) VALUES (?)",new Object[] {category.getName()});
    }

    //methode delete
    public int deleteById(int id) {
        String sql = "DELETE FROM category WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
