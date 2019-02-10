package com.afyahmis.demo.core.interfaces;

import com.afyahmis.demo.core.model.Practice;

import java.util.List;

public interface PracticeRepository {
    void create(Practice practice) throws Exception;

    void update(Practice practice) throws Exception;

    void delete(long code) throws Exception;

    Practice get(long code) throws Exception;
    List<Practice> getAll() throws Exception;
    void execute(String query) throws Exception;
}
