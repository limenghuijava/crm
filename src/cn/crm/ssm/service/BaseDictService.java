package cn.crm.ssm.service;

import cn.crm.ssm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> queryBaseDictByTypeCode(String s);
}
