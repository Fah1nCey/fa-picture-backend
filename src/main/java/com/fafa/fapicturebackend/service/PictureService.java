package com.fafa.fapicturebackend.service;

import com.fafa.fapicturebackend.model.dto.picture.PictureUploadRequest;
import com.fafa.fapicturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fafa.fapicturebackend.model.entity.User;
import com.fafa.fapicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

/**
* @author 86156
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-12-10 15:01:17
*/
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);


}
