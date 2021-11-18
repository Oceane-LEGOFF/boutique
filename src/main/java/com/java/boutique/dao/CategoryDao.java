package com.java.boutique.dao;

import com.java.boutique.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDao {
    @Autowired
    private JdbcTemplate  jdbcTemplate;

    //methode GET list
    public List<Category> listAll(){
        String sql = "SELECT * FROM category";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return list;
    }

    public List<Category> listAllPaginated(int start, int size){
        String sql = "SELECT * FROM category";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        if(start + size > list.size()) return new ArrayList<Category>();
        return list.subList(start, start + size);
    }

    public List<Category> find(String name){
        String sql = "SELECT * FROM category WHERE name=?";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class), name);
        return list;
    }

    //methode GetById
    public List<Category> findById(int id) {
        String sql = "SELECT * FROM category WHERE id=?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class), id);
    }

    //afficher le premier
    public List<Category> first() {
        String sql = "SELECT * FROM category WHERE id=(SELECT min(id) FROM category)";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return list;
    }

    //afficher le dernier
    public List<Category> last() {
        String sql = "SELECT * FROM category WHERE id=(SELECT max(id) FROM category)";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return list;
    }

    //afficher 10 premiers
    public List<Category> range() {
        String sql = "SELECT * FROM category LIMIT 10";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return list;
    }

    //en affiche 3 a partir de 5
    public List<Category> rangeLimit() {
        String sql = "SELECT * FROM category LIMIT 3 OFFSET 5";
        List<Category> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return list;
    }

    //methode add
    public int add (Category category){
        return jdbcTemplate.update("INSERT INTO category (name) VALUES (?)",new Object[] {category.getName()});
    }

    //methode update
    public int updateById(Category category, int id){
         return jdbcTemplate.update("UPDATE category SET name = ? WHERE id = ?", new Object[] {category.getName(), id});
    }

    //methode delete
    public int deleteById(int id) {
        String sql = "DELETE FROM category WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
