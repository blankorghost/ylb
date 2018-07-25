package com.views.dao;

import com.views.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public interface CommentDao{
    public void addComment(Comment comment);

    public void delComment(int cid);

    public ArrayList<Comment> getAllCommentstoviews();

    public List<Comment> getCommentByEid(int ceid);
}