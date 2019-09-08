package com.ansuru.ams.svr.user.service;

import com.ansuru.ams.svr.user.dao.UserMapper;
import com.ansuru.ams.svr.user.dto.request.RequestSvrUserFind;
import com.ansuru.ams.svr.user.dto.request.RequestSvrUserGet;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserFind;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserGet;
import com.ansuru.ams.svr.user.entity.EntityUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public ResponseSvrUserGet findById(RequestSvrUserGet id) {
        EntityUser byId = userMapper.findById(id.getId());
        ResponseSvrUserGet responseSvrUserGet = new ResponseSvrUserGet();
        responseSvrUserGet.setEntityUser(byId);
        return responseSvrUserGet;
    }


    @Override
    public ResponseSvrUserFind find(RequestSvrUserFind request) {
        EntityUser entityUser = new EntityUser();
        entityUser.setUsername(request.getUsername());
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<EntityUser> entityUsers = userMapper.find(entityUser);
        ResponseSvrUserFind response = new ResponseSvrUserFind();
        response.setPageResult(new PageInfo<>(entityUsers, request.getPageSize()));
        return response;
    }
}
