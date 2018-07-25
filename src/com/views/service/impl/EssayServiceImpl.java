package com.views.service.impl;

import com.views.entity.Essay;
import com.views.dao.EssayDao;
import com.views.service.EssayService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*注入服务*/
@Service("EssayService")
public class EssayServiceImpl implements EssayService {

    @Resource
    private EssayDao essayDao;
//    @Resource
//    private Essay essay;

    @Override
    public boolean writes(Essay essay) {
        this.essayDao.writes(essay);
        return true;
    }
    public void deleessay(int eid)
    {
        this.essayDao.deleess(eid);
    }

    public ArrayList<Essay> getAllEssay(){
        return  this.essayDao.getAll();
    }

    public List<Essay> getEssayByEid(int eid)
    {
        return  this.essayDao.getEssayByEid(eid);
    }
}
