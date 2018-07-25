package com.views.dao;


import com.views.entity.Comment;
import com.views.entity.Essay;
import com.views.entity.Message;
import com.views.entity.User;

import java.util.List;

/**
 * 类名称：UserInfoDao
 * 类描述：用户控制dao实现数据库操作接口
 * 创建人：lp
 * 修改备注：
 * @version
 * */
public interface UserInfoDao {


    /**
     * 通过用户ID得到用户文章
     */
    public List<Essay> getUseressayByuserid(int id);

    /**
     * 通过名得到用户消息
     */
    public List<Message> getUsermessageByusername(String username);


    /**
     * 通过用户id得到评论
     */
    public List<Comment> getUsercommentByuserid(int id);

    /**
     * 通过用户id显示用户信息
     */
    public User showUserinfo(int id);

    /**
     * 修改用户信息
     */
    public void updataUserinfo(User user);
}
