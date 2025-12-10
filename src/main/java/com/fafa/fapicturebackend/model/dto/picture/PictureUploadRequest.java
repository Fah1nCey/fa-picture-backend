package com.fafa.fapicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 由于图片需要支持重复上传（基础信息不变，只改变图片文件），所以要添加图片id参数
 * 解释：客户端在上传图片时，可以选择「新增」或者「替换已有图片」。
 */
@Data
public class PictureUploadRequest implements Serializable {
  
    /**  
     * 图片 id（用于修改）  
     */  
    private Long id;  
  
    private static final long serialVersionUID = 1L;  
}
