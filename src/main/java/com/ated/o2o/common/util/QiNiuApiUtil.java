package com.ated.o2o.common.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.io.*;

/**
 * 七牛云储存api调用工具类
 * @author zengwx
 */
@Slf4j
public class QiNiuApiUtil {

    private static final String ACCESS_KEY = "NmPK4INFrgaFdAfPjF6EI4omtG4_F1wmB83Rqssy";

    private static final String SECRET_KEY = "P7hgfiL2FEdlQUv-9QFJ4jZWFTmq2Ztm-qF5Ce6y";

    private static final String BUCKET = "o2o-pic";


    /**
     * 本地地址上传
     * @param localFilePath
     * @return
     */
    public static String uploadForFilePath(String localFilePath, String name){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET);
        try {
            Response response = uploadManager.put(localFilePath, name, upToken);
            //解析上传成功的结果
            return new Gson().fromJson(response.bodyString(), DefaultPutRet.class).hash;
        } catch (QiniuException ex) {
            Response r = ex.response;
            log.error(r.toString());
            try {
                log.error(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 流上传
     * @param inputStream
     * @param name
     * @return
     */
    public static String uploadForStream(InputStream inputStream, String name){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET);
        try {
            Response response = uploadManager.put(inputStream, name, upToken,null, null);
            //解析上传成功的结果
            return new Gson().fromJson(response.bodyString(), DefaultPutRet.class).hash;
        } catch (QiniuException ex) {
            Response r = ex.response;
            log.error(r.toString());
            try {
                log.error(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //本地上传
//        String localFilePath = "/home/hungwai/Projects/ated/test.png";
//        String hash = uploadForFilePath(localFilePath,"test.png");

        //流上传
        String localFilePath = "/home/hungwai/Projects/ated/test.png";
        File file = new File(localFilePath);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /** 这里注意，只要使用七牛的资源域名（详情见 OmsProperties）和返回的hash进行拼接就是文件的访问地址 */
        String hash = uploadForStream(inputStream,"test.png");
        System.out.println(hash);

    }

}
