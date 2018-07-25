package com.views.service;


import com.views.entity.Comment;
import com.views.entity.Essay;
import com.views.entity.Message;
import com.views.entity.User;

import java.util.List;

public interface UserInfoService {

    /**
     * 显示信息
     * @param id
     * @return
     */
    public  User getUserByuserid(int id);

    /**
     * 显示消息
     * @param username
     * @return
     */
    public List<Message> getMessageByusername(String username);


    /**
     *修改信息
     * @param user
     * @return
     */
    public  void updatauserinfo(User user);

    /**
     * 显示评论
     */
    public List<Comment> getCommentByuserid(int id);

    /**
     * 显示文章
     */
    public List<Essay> getEssayByuserid(int id);


}
