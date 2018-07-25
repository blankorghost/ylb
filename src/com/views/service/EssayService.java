package com.views.service;

import com.views.entity.Essay;

import java.util.ArrayList;
import java.util.List;

public interface EssayService {

        /*写文章*/
        public boolean writes(Essay essay);

        /*查询文章*/
        public List<Essay> getEssayByEid(int eid);

        /*删除文章*/
        public void deleessay(int eid);
        /*修改文章*/
                /*遍历得到文章*/
        public ArrayList<Essay> getAllEssay();
}
