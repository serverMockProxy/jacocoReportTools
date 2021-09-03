package com.apiProxy.service;

import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.mapper.JacocoConfigMapper;
import com.apiProxy.mbg.po.JacocoConfig;
import com.apiProxy.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @Author：hem
 * @Date：8/27/21 4:47 下午
 */
@Service
public class JacocoConfigServer {

    @Autowired
    private JacocoConfigMapper jacocoConfigMapper;

    public void creatOrUpdate(JacocoConfig jacocoConfig){
        try {
            int insertCount = jacocoConfigMapper.insert(jacocoConfig);
            if (insertCount != 1) {
                throw new ServerException("添加失败，请稍后重试");
            }
        } catch (DuplicateKeyException e) {
            jacocoConfigMapper.updateByPrimaryKey(jacocoConfig);
        }
    }

    public JacocoConfig getJacocoConfig(Integer projectId){
        try {
            return jacocoConfigMapper.selectByPrimaryKey(projectId);
        }catch (Exception e){
            throw new ServerException("获取配置失败");
        }
    }
}
