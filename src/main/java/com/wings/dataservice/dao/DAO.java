package com.wings.dataservice.dao;

import java.util.List;
import java.util.Map;

public interface DAO {
    void execute(String query);

    List<Map<String, Object>> select(String query);
}
