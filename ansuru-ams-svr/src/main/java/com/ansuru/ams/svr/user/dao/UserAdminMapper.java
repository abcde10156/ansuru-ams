package com.ansuru.ams.svr.user.dao;

import com.ansuru.ams.svr.user.entity.UserAdmin;
import com.ansuru.ams.svr.user.entity.UserAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int countByExample(UserAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int deleteByExample(UserAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int insert(UserAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int insertSelective(UserAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    List<UserAdmin> selectByExample(UserAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    UserAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserAdmin record, @Param("example") UserAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int updateByExample(@Param("record") UserAdmin record, @Param("example") UserAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int updateByPrimaryKeySelective(UserAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_admin
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    int updateByPrimaryKey(UserAdmin record);
}