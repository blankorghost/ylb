package com.views.dao;

import com.views.entity.Essay;

import java.util.ArrayList;
import java.util.List;

public interface EssayDao {
    public void writes(Essay essay);
    public  void deleess(int eid);
    /*遍历得到文章*/
    public ArrayList<Essay> getAll();
    public List<Essay> getEssayByEid(int eid);
}
