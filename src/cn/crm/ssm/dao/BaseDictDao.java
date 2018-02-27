package cn.crm.ssm.dao;

import cn.crm.ssm.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {
    List<BaseDict> queryBaseDictByTypeCode(String dict_type_code);
}
