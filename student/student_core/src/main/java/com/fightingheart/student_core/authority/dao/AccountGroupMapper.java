package com.fightingheart.student_core.authority.dao;


import java.util.List;

import com.fightingheart.student_core.authority.entity.AccountGroup;
import com.fightingheart.student_core.authority.entity.AccountGroupExample;
import org.apache.ibatis.annotations.Param;

public interface AccountGroupMapper {
    long countByExample(AccountGroupExample example);

    int deleteByExample(AccountGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountGroup record);

    int insertSelective(AccountGroup record);

    List<AccountGroup> selectByExample(AccountGroupExample example);

    AccountGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountGroup record, @Param("example") AccountGroupExample example);

    int updateByExample(@Param("record") AccountGroup record, @Param("example") AccountGroupExample example);

    int updateByPrimaryKeySelective(AccountGroup record);

    int updateByPrimaryKey(AccountGroup record);
}