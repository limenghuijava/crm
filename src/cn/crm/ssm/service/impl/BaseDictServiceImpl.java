package cn.crm.ssm.service.impl;

import cn.crm.ssm.dao.BaseDictDao;
import cn.crm.ssm.pojo.BaseDict;
import cn.crm.ssm.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {
//    @Resource(name="baseDictDao")
    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> queryBaseDictByTypeCode(String dict_type_code) {
        return baseDictDao.queryBaseDictByTypeCode(dict_type_code);
    }

}
