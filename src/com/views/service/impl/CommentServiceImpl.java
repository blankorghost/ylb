package com.views.service.impl;

import com.views.entity.Comment;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.views.dao.CommentDao;
import com.views.service.CommentService;

/**
 * Created by user on 2018/1/3.
 */
@Service("CommentService")
public class CommentServiceImpl implements CommentService{
    @Resource
    private CommentDao commentDao;

    @Override
    public boolean addComment(Comment comment){
        this.commentDao.addComment(comment);
        return true;
    }
    @Override
    public ArrayList<Comment> getCommentstoviews(){
        return this.commentDao.getAllCommentstoviews();
    }
    @Override
    public boolean del(int cid){
        this.commentDao.delComment(cid);
        return  true;
    }

    @Override
    public List<Comment> getCommentByEid(int ceid) {
        return this.commentDao.getCommentByEid(ceid);
    }
}
