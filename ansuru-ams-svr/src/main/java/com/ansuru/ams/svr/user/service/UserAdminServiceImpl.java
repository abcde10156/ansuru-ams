package com.ansuru.ams.svr.user.service;

import com.ansuru.ams.svr.user.dao.UserAdminMapper;
import com.ansuru.ams.svr.user.dto.request.RequestSvrUserAdminFind;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrUserAdminFind;
import com.ansuru.ams.svr.user.entity.UserAdmin;
import com.ansuru.ams.svr.user.entity.UserAdminExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserAdminServiceImpl implements UserAdminService {

    @Resource
    UserAdminMapper userAdminMapper;


    @Override
    public ResponseSvrUserAdminFind findByUserName(RequestSvrUserAdminFind request) {
        UserAdminExample userAdminExample = new UserAdminExample();
        userAdminExample.createCriteria().andUsernameEqualTo(request.getLoginName());
        List<UserAdmin> userAdmins = userAdminMapper.selectByExample(userAdminExample);
        if(userAdmins.size()!=1){
            throw new RuntimeException("username error");
        }
        UserAdmin userAdmin = userAdmins.get(0);
        ResponseSvrUserAdminFind responseUserAdminFind = new ResponseSvrUserAdminFind();
        responseUserAdminFind.setUserAdmin(userAdmin);
        return responseUserAdminFind;
    }
}
