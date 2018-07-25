package com.views.service.impl;

import com.views.dao.SearchDao;
import com.views.entity.Essay;
import com.views.service.SearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
    @Resource
    private SearchDao searchDao;

    @Override
    public List<Essay> search(String keyward) {
        return this.searchDao.search(keyward);
    }
}
