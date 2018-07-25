package com.views.service;

import com.views.entity.Essay;

import java.util.List;

public interface SearchService {
    public List<Essay> search(String keyward);
}
