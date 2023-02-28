package com.wings.dataservice.controller;

import com.wings.dataservice.dao.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DefaultController {

    @Autowired
    private DAOImpl db;

    @Value("${service.authentication.key}")
    private String serviceAuthenticationKey;

    @PostMapping("/select")
    public ResponseEntity<List<Map<String,Object>>> select(@RequestBody String query, @RequestHeader("authenticationKey") String authenticationKey) {
        if(!serviceAuthenticationKey.equals(authenticationKey)) {
            return ResponseEntity.badRequest().build();
        }
        List<Map<String, Object>> queryResults = db.select(query);
        return ResponseEntity.ok(queryResults);
    }

    @PostMapping("/execute")
    public ResponseEntity<String> execute(@RequestBody String query, @RequestHeader("authenticationKey") String authenticationKey) {
        if(!serviceAuthenticationKey.equals(authenticationKey)) {
            return ResponseEntity.badRequest().build();
        }
        db.execute(query);
        return ResponseEntity.ok("Query execution completed");
    }

}
