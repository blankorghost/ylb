package com.views.dao;

import com.views.entity.Essay;

import java.util.List;


public interface SearchDao {

    public List<Essay> search(String keyword);
}
