package com.java.boutique.dao;

import com.java.boutique.models.Category;
import com.java.boutique.models.Product;
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

    public List<Product> triCroissantName(){
        String sql = "SELECT * FROM product ORDER BY name";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }
    public List<Product> triCroissantId(){
        String sql = "SELECT * FROM product ORDER BY id";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    public List<Product> triCroissantType(){
        String sql = "SELECT * FROM product ORDER BY type";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    public List<Product> triDecroissantName(){
        String sql = "SELECT * FROM product ORDER BY name DESC";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    public List<Product> triDecroissantType(){
        String sql = "SELECT * FROM product ORDER BY type DESC";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    public List<Product> triDecroissantId(){
        String sql = "SELECT * FROM product ORDER BY id DESC";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    //afficher le premier
    public List<Product> first() {
        String sql = "SELECT * FROM product WHERE id=(SELECT min(id) FROM category)";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    //afficher le dernier
    public List<Product> last() {
        String sql = "SELECT * FROM product WHERE id=(SELECT max(id) FROM category)";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    //afficher 10 premiers
    public List<Product> range() {
        String sql = "SELECT * FROM product LIMIT 10";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    //en affiche 3 a partir de 5
    public List<Product> rangeLimit() {
        String sql = "SELECT * FROM product LIMIT 3 OFFSET 5";
        List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
        return list;
    }

    //recherche par nom ou type ou date
    public List<Product> search(String type, String name, String createdAt) {
        String sql = "SELECT * FROM product WHERE type=?  OR name=? OR createdAt=?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class), type, name, createdAt);
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


