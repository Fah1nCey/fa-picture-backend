package com.fafa.fapicturebackend.utils;

import cn.hutool.core.util.StrUtil;
import com.fafa.fapicturebackend.exception.BusinessException;
import com.fafa.fapicturebackend.exception.ErrorCode;
import org.mindrot.jbcrypt.BCrypt;

/**
 * JBCrypt密码加密工具类
 * 封装意义：
 * 1. 隔离第三方依赖，换加密算法时仅需修改此类
 * 2. 统一加密配置（如cost因子），避免散落在业务代码中
 * 3. 统一参数校验，避免空指针等低级异常
 */
public class PasswordEncoderUtil {

    // 统一配置bcrypt的cost因子（生产建议12~14，值越大加密越慢但越安全）
    private static final int BCRYPT_COST = 12;

    /**
     * 加密密码
     * @param password 原密码
     * @return bcrypt加密后的哈希值（格式：$2a$12$xxx...）
     */
    public static String encode(String password) {
        if (StrUtil.isBlank(password)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码不能为空");
        }
        return BCrypt.hashpw(password, BCrypt.gensalt(BCRYPT_COST));
    }

    /**
     * 验证密码是否正确
     * @param password 原密码
     * @param hashedPassword 加密后的密码
     * @return
     */
    public static boolean matches(String password, String hashedPassword) {
        if (StrUtil.hasBlank(password, hashedPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数不能为空");
        }
        return BCrypt.checkpw(password, hashedPassword);
    }
}
