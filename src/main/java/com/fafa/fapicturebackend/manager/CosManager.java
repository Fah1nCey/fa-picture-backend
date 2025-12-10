package com.fafa.fapicturebackend.manager;

import com.fafa.fapicturebackend.config.CosClientConfig;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

/**
 * 提供通用的对象存储操作，比如文件上传、文件下载等。
 * Manager包表示通用的、可复用的能力，可供其他代码（比如Service）调用
 */
@Component
public class CosManager {  
  
    @Resource
    private CosClientConfig cosClientConfig;
  
    @Resource  
    private COSClient cosClient;

    /**
     * 上传对象
     *
     * @param key  唯一键
     * @param file 文件
     */
    public PutObjectResult putObject(String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(cosClientConfig.getBucket(), key,
                file);
        return cosClient.putObject(putObjectRequest);
    }

    /**
     * 下载对象(流式下载)
     *
     * @param key 存储桶中的唯一键 /test/Snipaste_2025-12-05_10-22-27.png
     */
    public COSObject getObject(String key) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(cosClientConfig.getBucket(), key);
        return cosClient.getObject(getObjectRequest);
    }


}
