package com.apiProxy.controller;

import com.apiProxy.mbg.po.ProxyConfig;
import com.apiProxy.model.JsonString;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.apiProxy.model.Response;
import com.apiProxy.service.ProxyConfigServer;
import com.apiProxy.validator.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author：hem
 * @Date：6/3/21 3:31 下午
 */
@RestController
@RequestMapping("/config")
public class ProxyConfigController {

    @Autowired
    private ProxyConfigServer proxyConfigServer;

    @PostMapping("/add")
    public Response add(@Valid @RequestBody ProxyConfig proxyConfig) {
        proxyConfigServer.add(proxyConfig);
        return Response.success("添加成功");
    }

    @DeleteMapping("/{proxyConfigId}")
    public Response delete(@PathVariable Integer proxyConfigId) {
        proxyConfigServer.delete(proxyConfigId);
        return Response.success("删除成功");
    }

    @PostMapping("/update")
    public Response update(@Validated({UpdateGroup.class}) @RequestBody ProxyConfig proxyConfig) {
        proxyConfigServer.update(proxyConfig);
        return Response.success("更新成功");
    }

    @PostMapping("/list")
    public Response list(ProxyConfig query, String orderBy, PageRequest pageRequest) {
        if (pageRequest.needPaging()) {
            PagedData<ProxyConfig> pagedData = proxyConfigServer.list(query, orderBy, pageRequest);
            return Response.success(pagedData);
        } else {
            List<ProxyConfig> projectVos = proxyConfigServer.getProxyConfig(query, orderBy);
            return Response.success(projectVos);
        }
    }

    @PostMapping("/importJson")
    public Response importJson(@RequestBody JsonString jsonString) {
        return Response.success(proxyConfigServer.importJson(jsonString));
    }
}
