package com.zerostech.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019-08-22.
 *
 * @author 迹_Jason
 */
@RestController
public class DockerController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public List<Map<String, Object>> index() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from  test");
        return list;
    }
}
