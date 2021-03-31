package com.lemon.api.auto.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.DataProvider;


/**
 * @author: shishanju
 * @date: 2021/3/15
 * @protocol:
 * @apiName:
 * @description:
 */
public class DataProviders {
    @DataProvider(name = "Data")
    public static Object[][] getData(){
        return getTestData("data/test.json");
    }

    /*
   解析thrift数据，DataProvider读取
    */
    public static Object[][] getTestData(String fileName){
        String text = getFromFile(fileName);
        JSONArray tableData = JSONArray.parseArray(text);
        Object[][] objects = getUseCase(tableData);
        return objects;
    }

    public static String getFromFile(String fileName){
        try {
            String text = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName), "utf-8");
            return text;
        } catch (Exception e) {
            throw new RuntimeException(String.format("classpath中未找到数据文件 %s", fileName), e);
        }
    }

    private static Object[][] getUseCase(JSONArray tableData){
        int len = tableData.size();
        Object[][] objects = new Object[len][3];
        try{
            for (int i = 0; i < len; i++) {
                objects[i][0] = ((JSONObject) tableData.get(i)).getString("comments");
                objects[i][1] = JSON.parseObject(((JSONObject) tableData.get(i)).getString("request"));
                objects[i][2] = JSON.parseObject(((JSONObject) tableData.get(i)).getString("expResult"));
        }
    }catch (Exception e) {
            e.printStackTrace();//数据驱动解析错误
        }
        return objects;
    }

}
