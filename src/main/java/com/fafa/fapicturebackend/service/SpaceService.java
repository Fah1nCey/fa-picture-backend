package com.fafa.fapicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fafa.fapicturebackend.model.dto.space.SpaceAddRequest;
import com.fafa.fapicturebackend.model.dto.space.SpaceQueryRequest;
import com.fafa.fapicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fafa.fapicturebackend.model.entity.User;
import com.fafa.fapicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 86156
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-12-17 16:43:14
*/
public interface SpaceService extends IService<Space> {

    /**
     * 校验空间数据
     * @param space
     * @param add 区分创建空间和编辑空间 true:创建 false:编辑
     */
    void validSpace(Space space, boolean add);

    /**
     * 根据空间级别，自动填充限额
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 创建空间
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 获取空间包装类（单条）
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 获取查询对象
     * @param spaceQueryRequest
     * @return
     */
    Wrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 获取空间包装类（分页）
     * @param spacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);
}
