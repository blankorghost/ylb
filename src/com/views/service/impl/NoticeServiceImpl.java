package com.views.service.impl;

import com.views.dao.NoticeDao;
import com.views.entity.Notice;
import com.views.service.NoticeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by user on 2018/1/3.
 */
@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService{
    @Resource
    private NoticeDao noticeDao;

    /*@Override
    public boolean write(Notice notice) {
        this.noticeDao.write(notice);
        return true;
    }*/

    @Override
    public String getNoticeById() {
        return noticeDao.getInfo();
    }



}
