package com.ansuru.ams.svr.user.dao;

import com.ansuru.ams.svr.user.entity.EntityUser;

import java.util.List;

public interface UserMapper {
     EntityUser findById(Long id);

     List<EntityUser> find(EntityUser entityUser);

     List<EntityUser> findByName(String name);
}
