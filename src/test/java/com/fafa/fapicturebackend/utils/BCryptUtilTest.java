package com.fafa.fapicturebackend.utils;



import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * JBCrypt测试密码加密和验证
 */
@SpringBootTest
public class BCryptUtilTest {
    
    private final String password = "12345678";

    @Test
    void testBCryptEncode() {
        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("Hash password: " + hashpw);
        // $2a$10$OHpZmYVgU5XiiT4KjH/rzuh6J0ndTVCfJ.UzOX.8mqoptML4eoQIm
    }

    @Test
    void testBCryptMatches() {
        String hashpw = "$2a$10$OHpZmYVgU5XiiT4KjH/rzuh6J0ndTVCfJ.UzOX.8mqoptML4eoQIm";
        boolean checkpw = BCrypt.checkpw(password, hashpw);
        System.out.println("Check password: " + checkpw);
        // true
    }


}
