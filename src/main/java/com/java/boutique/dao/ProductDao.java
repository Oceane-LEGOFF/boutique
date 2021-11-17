package com.java.boutique.dao;

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

    //methode GET list
    public List<Product> listAll(){
        String sql = "SELECT * FROM product";

        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));

        return list;
    }

    //methode getById
    public List<Product> findById(int id) {
        String sql = "SELECT * FROM product WHERE id=?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class), id);
    }

    //methode add
    public int add (Product product){
        return jdbcTemplate.update("INSERT INTO product (type, rating, name, createdAt, categoryId) VALUES (?, ?, ?, ?, ?)",new Object[] {product.getType(), product.getRating(), product.getName(), product.getCreatedAt(), product.getCategoryId()});
    }

    //methode update
    public int updateById(Product product, int id){
        return jdbcTemplate.update("UPDATE product SET type = ?, rating = ?, name = ? WHERE id = ?", new Object[] {product.getType(), product.getRating(), product.getName(), id});
    }

    //methode delete
    public int deleteById(int id) {
        String sql = "DELETE FROM product WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
