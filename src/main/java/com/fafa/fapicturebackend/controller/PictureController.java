package com.fafa.fapicturebackend.controller;

import com.fafa.fapicturebackend.annotation.AuthCheck;
import com.fafa.fapicturebackend.common.BaseResponse;
import com.fafa.fapicturebackend.common.ResultUtils;
import com.fafa.fapicturebackend.constant.UserConstant;
import com.fafa.fapicturebackend.model.dto.picture.PictureUploadRequest;
import com.fafa.fapicturebackend.model.entity.User;
import com.fafa.fapicturebackend.model.vo.PictureVO;
import com.fafa.fapicturebackend.service.PictureService;
import com.fafa.fapicturebackend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class PictureController {

    @Resource
    private PictureService pictureService;

    @Resource
    private UserService userService;

    /**
     * 上传图片（可重新上传）
     */
    @PostMapping("/upload")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<PictureVO> uploadPicture(
            @RequestPart("file") MultipartFile multipartFile,
            PictureUploadRequest pictureUploadRequest,
            HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        PictureVO pictureVO = pictureService.uploadPicture(multipartFile, pictureUploadRequest, loginUser);
        return ResultUtils.success(pictureVO);
    }

}
