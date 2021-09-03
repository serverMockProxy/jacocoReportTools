package com.apiProxy.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.apiProxy.model.ApiHeaders;
import com.apiProxy.model.QueryBodys;
import com.apiProxy.model.Schema;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 将前端传入的key转为json
 * @Author：hem
 * @Date：6/2/20 3:18 下午
 */

public class Transform {
    private Map var;

    public Transform(Map var){
        this.var = var;
    }
    public String transformToJsonString(String requestBody){
        Schema schema = JSONObject.parseObject(JSONArray.parseArray(requestBody).getString(0),Schema.class);
        if (schema.getType().equals("array")){
            List list = new ArrayList();
            for (Schema s:schema.getChildren()){
                if (s.getType().equals("string")) {
                    list.add(s.getValue());
                }else if (s.getType().equals("int")) {
                    list.add(Integer.valueOf(s.getValue()));
                }else {
                    list.add(transformToHashmap(s,new HashMap()));
                }

            }
            return JSONArray.toJSONString(list, SerializerFeature.WriteNullStringAsEmpty);
        }else {
            return JSONObject.toJSONString(transformToHashmap(schema,new HashMap()), SerializerFeature.WriteNullStringAsEmpty);
        }
    }

    public String transformToQueryString(String requestBody){
        List<QueryBodys> queries = JSONArray.parseArray(requestBody, QueryBodys.class);
        String transformQuery="";
        int a = 0;
        for (QueryBodys query:queries){
            if (a==0){
                transformQuery = transformQuery + query.getKey()+"="+query.getValue();
            }else {
                transformQuery = transformQuery +"&"+ query.getKey()+"="+query.getValue();
            }
            a++;
        }
        return transformQuery;
    }

    public Map transformToQueryMap(List<QueryBodys>  queries){
        if (CollectionUtils.isEmpty(queries)){
            return null;
        }
        Map hashMap = new HashMap();
        for (QueryBodys query:queries){
            hashMap.put(query.getKey(),replaceVariable(query.getValue()));
            //transformQuery = transformQuery + query.getKey()+"="+query.getValue()+"&";
        }
        return hashMap;
    }

    public Map transformHeaders(List<ApiHeaders> apiHeaders){
        if (CollectionUtils.isEmpty(apiHeaders)){
            return null;
        }
        Map hashMap = new HashMap();
        for (ApiHeaders apiHeader:apiHeaders){
            hashMap.put(apiHeader.getHeaderKey(),apiHeader.getHeaderValue());
        }
        return hashMap;
    }

    private HashMap transformToHashmap(Schema schema, HashMap object){
        if (schema.getChildren() != null){
            for (Schema s:schema.getChildren()){
                switch (s.getType()){
                    case "object":
                        if (s.getKey().equals("#items")){
                            object.putAll(transformToHashmap(s,new HashMap()));
                        }else {
                            object.put(s.getKey(),transformToHashmap(s,new HashMap()));
                        }
                        break;
                    case "array":
                        List list = new ArrayList();
                        for (Schema schema1:s.getChildren()){
                            getList(schema1,list);
                        }
                        object.put(s.getKey(),list);
                        break;
                    case "string":
                        object.put(s.getKey(),replaceVariable(s.getValue()));
                        break;
                    case "int":
                        try {
                            object.put(s.getKey(),Long.valueOf(replaceVariable(s.getValue())));
                        }catch (Exception e){
                            try {
                                object.put(s.getKey(),Float.valueOf(replaceVariable(s.getValue())));
                            }catch (Exception e1){

                            }
                        }
                        break;
                    case "boolean":
                        object.put(s.getKey(),Boolean.valueOf(replaceVariable(s.getValue())));
                        break;
                }
            }
        }
        return object;
    }

    private List getList(Schema schema,List list){
        switch (schema.getType()){
            case "string":
                if (!schema.getValue().equals("")){
                    String[] values = schema.getValue().split(",");
                    for (String value:values){
                        //list.add(value);
                        list.add(replaceVariable(value));
                    }
                }else {
                    return list;
                }
                break;
            case "int":
                if (!schema.getValue().equals("")){
                    String[] values = schema.getValue().split(",");
                    for (String value:values){
                        //list.add(Integer.valueOf(value));
                        list.add(Long.valueOf(replaceVariable(value)));
                    }
                }else {
                    return list;
                }
                break;
            case "boolean":
                if (!schema.getValue().equals("")){
                    String[] values = schema.getValue().split(",");
                    for (String value:values){
                        //list.add(Boolean.valueOf(value));
                        list.add(Boolean.valueOf(replaceVariable(value)));
                    }
                }else {
                    return list;
                }
                break;
            case "array":
                list.add(getList(schema.getChildren().get(0),new ArrayList()));
                break;
            default:
                list.add(transformToHashmap(schema,new HashMap()));
        }
        return list;
    }

    private String replaceVariable(String value){
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        if (value.equals("null")){
            return null;
        }
        try {
            Map<String, Object> map = JSONObject.parseObject(value,Map.class);
            for (String key:map.keySet()){
                if (map.get(key) instanceof String){
                    map.replace(key,replaceVar((String) map.get(key)));
                }
            }
            return JSONObject.toJSONString(map);
        }catch (Exception e){

        }
        return replaceVar(value);
    }

    private String replaceVar(String value){
        String varName = StringTools.substringBefore(StringTools.substringAfter(value,"${"),"}");
        if (!varName.equals("") && varName != null){
            String r="${"+varName+"}";
            value = StringUtils.replace(value,r, String.valueOf(var.get(varName)));
        }
        return value;
    }

}
