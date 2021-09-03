package com.apiProxy.controller;

import com.apiProxy.mbg.po.ProxyDetails;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.apiProxy.model.Response;
import com.apiProxy.service.ProxyDetailServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：hem
 * @Date：6/3/21 3:31 下午
 */
@RestController
@RequestMapping("/details")
public class ProxyDetailsController {

    @Autowired
    private ProxyDetailServer proxyDetailServer;

    @PostMapping("/delete")
    public Response delete(@RequestBody List<Integer> ids) {
        proxyDetailServer.delete(ids);
        return Response.success("删除成功");
    }


    @PostMapping("/list")
    public Response list(ProxyDetails query, String orderBy, PageRequest pageRequest) {
        if (pageRequest.needPaging()) {
            PagedData<ProxyDetails> pagedData = proxyDetailServer.list(query, orderBy, pageRequest);
            return Response.success(pagedData);
        } else {
            List<ProxyDetails> projectVos = proxyDetailServer.getProxyDetails(query, orderBy);
            return Response.success(projectVos);
        }
    }

}
