package com.fightingheart.student_core.authority.dao;


import java.util.List;

import com.fightingheart.student_core.authority.entity.RoleAccount;
import com.fightingheart.student_core.authority.entity.RoleAccountExample;
import org.apache.ibatis.annotations.Param;

public interface RoleAccountMapper {
    long countByExample(RoleAccountExample example);

    int deleteByExample(RoleAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleAccount record);

    int insertSelective(RoleAccount record);

    List<RoleAccount> selectByExample(RoleAccountExample example);

    RoleAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleAccount record, @Param("example") RoleAccountExample example);

    int updateByExample(@Param("record") RoleAccount record, @Param("example") RoleAccountExample example);

    int updateByPrimaryKeySelective(RoleAccount record);

    int updateByPrimaryKey(RoleAccount record);
}