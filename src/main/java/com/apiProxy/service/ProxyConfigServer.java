package com.apiProxy.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.mapper.ProxyConfigMapper;
import com.apiProxy.mbg.po.ProxyConfig;
import com.apiProxy.mbg.po.ProxyConfigExample;
import com.apiProxy.model.JsonBody;
import com.apiProxy.model.JsonString;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.apiProxy.security.SecurityUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author：hem
 * @Date：6/3/21 3:33 下午
 */
@Service
public class ProxyConfigServer {

    @Autowired
    private ProxyConfigMapper proxyConfigMapper;

    private ThreadLocal<Integer> number = new ThreadLocal<>();

    private void setNumber(Integer erromsg){
        number.set(erromsg);
    }
    private Integer getNumber(){
        return number.get();
    }

    private void removeNumber(){
        number.remove();
    }

    public void add(ProxyConfig proxyConfig){
        proxyConfig.setCreateTime(new Date());
        proxyConfig.setUpdateTime(new Date());
        proxyConfig.setCreatorUid(SecurityUtil.getCurrentUserId());

        try {
            int insertCount = proxyConfigMapper.insertSelective(proxyConfig);
            if (insertCount != 1) {
                throw new ServerException("添加失败，请稍后重试");
            }
        } catch (DuplicateKeyException e) {
            throw new ServerException(proxyConfig.getInterceptPath() + "已存在");
        }
    }

    public void delete(Integer proxyConfigId){
        if (proxyConfigId == null) {
            throw new ServerException("proxyConfigId不能为空");
        }

        int deleteCount = proxyConfigMapper.deleteByPrimaryKey(proxyConfigId);
        if (deleteCount != 1) {
            throw new ServerException("删除失败，请稍后重试");
        }
    }


    public void update(ProxyConfig proxyConfig){
        try {
            int updateCount = proxyConfigMapper.updateByPrimaryKeySelective(proxyConfig);
            if (updateCount != 1) {
                throw new ServerException("更新失败，请稍后重试");
            }
        } catch (DuplicateKeyException e) {
            throw new ServerException(proxyConfig.getInterceptPath() + "已存在");
        }
    }

    public PagedData<ProxyConfig> list(ProxyConfig query, String orderBy, PageRequest pageRequest) {
        Page page = PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());

        if (StringUtils.isEmpty(orderBy)) {
            orderBy = "create_time desc";
        }

        List<ProxyConfig> proxyConfig = getProxyConfig(query, orderBy);
        return new PagedData<>(proxyConfig, page.getTotal());
    }

    public List<ProxyConfig> getProxyConfig(ProxyConfig query, String orderBy) {
        ProxyConfigExample example = new ProxyConfigExample();
        ProxyConfigExample.Criteria criteria = example.createCriteria();

        if (query != null) {
            if (query.getId() != null) {
                criteria.andIdEqualTo(query.getId());
            }
            if (query.getProjectId() != null){
                criteria.andProjectIdEqualTo(query.getProjectId());
            }
            if (query.getInterceptPath() != null){
                criteria.andInterceptPathEqualTo(query.getInterceptPath());
            }
        }
        criteria.andStatusEqualTo(true);
        if (!StringUtils.isEmpty(orderBy)) {
            example.setOrderByClause(orderBy);
        }
        return proxyConfigMapper.selectByExample(example);
    }


    /**
     * json转换为平台使用的Schema
     * @param jsonString
     * @return
     */
    public Object importJson(JsonString jsonString){
        if (jsonString == null){
            throw new ServerException("jsonString不能为空");
        }
        setNumber(1);
        JsonBody jsonBody = new JsonBody();
        jsonBody.setKey("#root");
        jsonBody.setNum(getNumber());
        setNumber(getNumber()+1);
        jsonBody.setValue(null);
        jsonBody.setChildren(new ArrayList<>());
        try {
            JSONObject jsonObject = JSONObject.parseObject(jsonString.getJsonString());
            jsonBody.setType("object");
            jsontObjectToSchema(jsonObject,jsonBody);
            return jsonBody;
        }catch (Exception e){
            try {
                JSONArray jsonArray = JSONArray.parseArray(jsonString.getJsonString());
                jsonBody.setType("array");
                for (int i=0;i<jsonArray.size();i++){
                    JsonBody jsonBodys = new JsonBody();
                    jsonBodys.setKey("#items");
                    jsonBodys.setNum(getNumber());
                    setNumber(getNumber()+1);
                    jsonBodys.setValue(null);
                    jsonBodys.setType("object");
                    jsonBodys.setChildren(new ArrayList());
                    jsontObjectToSchema(jsonArray.getJSONObject(i),jsonBodys);
                    jsonBody.getChildren().add(jsonBodys);
                }
                return jsonBody;
            }catch (Exception e1){
                throw new ServerException("json格式错误");
            }
        }
    }

    private void jsontObjectToSchema(JSONObject jsonObject,JsonBody jsonBody){
        for (String key:jsonObject.keySet()){
            JsonBody body = new JsonBody();
            body.setKey(key);
            body.setNum(getNumber());
            setNumber(getNumber()+1);
            body.setChildren(new ArrayList<>());
            if (jsonObject.get(key) instanceof String){
                body.setValue(String.valueOf(jsonObject.get(key)));
                body.setType("string");
            }else if (jsonObject.get(key) instanceof Long || jsonObject.get(key) instanceof Integer || jsonObject.get(key) instanceof BigDecimal){
                body.setValue(String.valueOf(jsonObject.get(key)));
                body.setType("int");
            } else if (jsonObject.get(key) instanceof Boolean){
                body.setValue(String.valueOf(jsonObject.get(key)));
                body.setType("boolean");
            }else if (jsonObject.get(key) instanceof List){
                body.setValue(null);
                body.setType("array");
                jsontArrayToSchema(jsonObject.getJSONArray(key),body.getChildren());
            }else if (jsonObject.get(key) instanceof JSONObject){
                body.setValue(null);
                body.setType("object");
                jsontObjectToSchema(jsonObject.getJSONObject(key),body);
            }
            jsonBody.getChildren().add(body);
        }
    }

    private void jsontArrayToSchema(JSONArray jsonArray,List list){

        for (int i = 0;i<jsonArray.size();i++){
            JsonBody jsonBody = new JsonBody();
            jsonBody.setKey("#items");
            jsonBody.setNum(getNumber());
            setNumber(getNumber()+1);
            jsonBody.setChildren(new ArrayList<>());
            if (jsonArray.get(i) instanceof String){
                jsonBody.setValue(String.valueOf(jsonArray.get(i)));
                jsonBody.setType("string");
                list.add(jsonBody);
            }else if (jsonArray.get(i) instanceof Long || jsonArray.get(i) instanceof Integer || jsonArray.get(i) instanceof BigDecimal){
                jsonBody.setValue(String.valueOf(jsonArray.get(i)));
                jsonBody.setType("int");
                list.add(jsonBody);
            } else if (jsonArray.get(i) instanceof Boolean){
                jsonBody.setValue(String.valueOf(jsonArray.get(i)));
                jsonBody.setType("boolean");
                list.add(jsonBody);
            }else if (jsonArray.get(i) instanceof List){
                jsonBody.setValue(null);
                jsonBody.setType("array");
                jsontArrayToSchema(jsonArray.getJSONArray(i),new ArrayList());
                list.add(jsonBody);
            }else if (jsonArray.get(i) instanceof JSONObject){
                jsonBody.setValue(null);
                jsonBody.setType("object");
                jsontObjectToSchema(jsonArray.getJSONObject(i),jsonBody);
                list.add(jsonBody);
            }
        }
    }
}
