package org.egovframe.rte.fdl.cryptography;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * EgovPasswordEncoderTest
 * 
 * @author 이백행
 * @since 2023-09-22
 */
@NoArgsConstructor
@Slf4j
public class EgovPasswordEncoderTest {

    // Encryption/Decryption 서비스
    // https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte2:fdl:encryption_decryption

    // crypto 간소화 서비스
    // https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte4.1:fdl:crypto

    // 암호화/복호화
    // https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:com:v4.1:sec:%EC%95%94%ED%98%B8%ED%99%94_%EB%B3%B5%ED%98%B8%ED%99%94

    // src/main/resources/egovframework/spring/com/context-crypto.xml

    /**
     * test Crypto algorithmKey, algorithmKeyHash 생성
     */
    @Test
    public void test() {
        final EgovPasswordEncoder egovPasswordEncoder = new EgovPasswordEncoder();

        log.debug("getAlgorithm={}", egovPasswordEncoder.getAlgorithm());

        // algorithmKey="egovframe"
        final String plainPassword = "egovframe";
        log.debug("plainPassword={}", plainPassword);
        log.debug("algorithmKey={}", plainPassword);

        // algorithmKeyHash="gdyYs/IZqY86VcWhT8emCYfqY1ahw2vtLG+/FzNqtrQ="
        final String encryptedPassword = egovPasswordEncoder.encryptPassword(plainPassword);
        log.debug("encryptedPassword={}", encryptedPassword);
        log.debug("algorithmKeyHash={}", encryptedPassword);

        boolean checkPassword = egovPasswordEncoder.checkPassword(plainPassword);
        log.debug("checkPassword={}", checkPassword);

        boolean checkPassword2 = egovPasswordEncoder.checkPassword(plainPassword, encryptedPassword);
        log.debug("checkPassword2={}", checkPassword2);

        assertEquals("에러가 발생했습니다!", "gdyYs/IZqY86VcWhT8emCYfqY1ahw2vtLG+/FzNqtrQ=", encryptedPassword);
    }

}
