package com.views.service.impl;


import com.views.dao.UserInfoDao;
import com.views.entity.Comment;
import com.views.entity.Essay;
import com.views.entity.Message;
import com.views.entity.User;
import com.views.service.UserInfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;


//注入服务
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public User getUserByuserid(int id) {

        return userInfoDao.showUserinfo(id);
    }

    @Override
    public List<Message> getMessageByusername(String username) {

        return userInfoDao.getUsermessageByusername(username);
    }

    @Override
    public void updatauserinfo(User user) {

        userInfoDao.updataUserinfo(user);
    }

    @Override
    public List<Comment> getCommentByuserid(int id) {
        return userInfoDao.getUsercommentByuserid(id);
    }

    @Override
    public List<Essay> getEssayByuserid(int id) {
        return userInfoDao.getUseressayByuserid(id);
    }
}
