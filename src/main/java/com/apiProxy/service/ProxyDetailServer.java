package com.apiProxy.service;

import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.mapper.ProxyDetailsMapper;
import com.apiProxy.mbg.po.ProxyDetails;
import com.apiProxy.mbg.po.ProxyDetailsExample;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author：hem
 * @Date：6/3/21 3:09 下午
 */
@Service
public class ProxyDetailServer {
    @Autowired
    private ProxyDetailsMapper proxyDetailsMapper;

    public void add(ProxyDetails proxyDetails){
        proxyDetails.setCreatTime(new Date());
        try {
            int insertCount = proxyDetailsMapper.insertSelective(proxyDetails);
            if (insertCount != 1) {
                throw new ServerException("添加失败，请稍后重试");
            }
        } catch (DuplicateKeyException e) {
            throw new ServerException(proxyDetails.getId() + "已存在");
        }
    }

    public void delete(List<Integer> ids){
        if (CollectionUtils.isEmpty(ids)) {
            throw new ServerException("proxyDetailId不能为空");
        }
        ProxyDetailsExample example = new ProxyDetailsExample();
        ProxyDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        int deleteCount = proxyDetailsMapper.deleteByExample(example);
        if (deleteCount < 1) {
            throw new ServerException("删除失败，请稍后重试");
        }
    }

    public PagedData<ProxyDetails> list(ProxyDetails query, String orderBy, PageRequest pageRequest) {
        Page page = PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());

        if (StringUtils.isEmpty(orderBy)) {
            orderBy = "creat_time desc";
        }

        List<ProxyDetails> proxyConfig = getProxyDetails(query, orderBy);
        return new PagedData<>(proxyConfig, page.getTotal());
    }


    public List<ProxyDetails> getProxyDetails(ProxyDetails query, String orderBy) {
        ProxyDetailsExample example = new ProxyDetailsExample();
        ProxyDetailsExample.Criteria criteria = example.createCriteria();

        if (query != null) {
            if (query.getId() != null) {
                criteria.andIdEqualTo(query.getId());
            }
            if(query.getProjectId() != null){
                criteria.andProjectIdEqualTo(query.getProjectId());
            }
        }

        if (!StringUtils.isEmpty(orderBy)) {
            example.setOrderByClause(orderBy);
        }
        return proxyDetailsMapper.selectByExample(example);
    }
}
