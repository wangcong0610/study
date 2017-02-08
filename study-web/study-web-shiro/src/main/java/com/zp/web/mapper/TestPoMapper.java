package com.zp.web.mapper;

import com.zp.web.po.TestPo;

public interface TestPoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestPo record);

    int insertSelective(TestPo record);

    TestPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestPo record);

    int updateByPrimaryKey(TestPo record);
}