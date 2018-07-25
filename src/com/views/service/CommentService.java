package com.views.service;

import com.views.entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018/1/3.
 */
public interface CommentService {
    //保存评论
    public boolean addComment(Comment comment);

    //查询所有评论
    public ArrayList<Comment> getCommentstoviews();

    //删除评论
    public boolean del(int cid);

    //查询评论
    public List<Comment> getCommentByEid(int ceid);


}
