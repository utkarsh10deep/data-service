package com.wings.dataservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class DAOImpl implements DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    //will work for delete, update and insert
    public void execute(String query) {
        jdbcTemplate.update(query);
    }

    @Override
    public List<Map<String, Object>> select(String query) {
        return jdbcTemplate.queryForList(query);


    }
}
