package com.java.boutique.dao;

import com.java.boutique.models.Category;
import com.java.boutique.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> listAll(){
        String sql = "SELECT * FROM product";

        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));

        return list;
    }

    public int add(Product u) {
        String sql = "INSERT INTO users (lastname, firstname, email, phone) VALUES (?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql, u.getId(), u.getType(), u.getRating(), u.getName(), u.getCreatedAt());
    }
}
