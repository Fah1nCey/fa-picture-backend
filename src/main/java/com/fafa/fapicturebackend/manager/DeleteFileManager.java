package com.fafa.fapicturebackend.manager;

import com.fafa.fapicturebackend.exception.BusinessException;
import com.fafa.fapicturebackend.exception.ErrorCode;
import com.fafa.fapicturebackend.exception.ThrowUtils;
import com.qcloud.cos.model.DeleteObjectsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
@Slf4j
public class DeleteFileManager {

    @Resource
    private CosManager cosManager;

    /**
     * 删除对象(单个)
     *
     * @param key 文件 key
     */
    public void deletePictureObject(String key) {
        ThrowUtils.throwIf(key == null, ErrorCode.PARAMS_ERROR, "图片的key不存在");
        try {
            cosManager.deleteObject(key);
        } catch (Exception e) {
            log.error("删除图片失败", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "删除图片失败");
        }
    }

    /**
     * 批量删除对象(多个)
     * @param keyList 要删除的key列表
     */
    public void deletePictureObjects(ArrayList<DeleteObjectsRequest.KeyVersion> keyList) {
        ThrowUtils.throwIf(keyList.isEmpty(), ErrorCode.PARAMS_ERROR, "图片的keyList为空");
        try {
            cosManager.deleteObjects(keyList);
        } catch (Exception e) {
            log.error("批量删除图片失败", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "批量删除图片失败");
        }
    }
}
