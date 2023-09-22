package org.egovframe.rte.fdl.cryptography.impl;

import static org.junit.Assert.assertEquals;

import org.egovframe.rte.fdl.cryptography.EgovEnvCryptoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * EgovEnvCryptoServiceImplTest
 * 
 * @author 이백행
 * @since 2023-09-22
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath*:egovframework/spring/com/context-crypto.xml",
        "classpath*:egovframework/spring/com/test-context-common.xml" })

@NoArgsConstructor
@Slf4j
public class EgovEnvCryptoServiceImplTest {

    /**
     * EgovEnvCryptoService
     */
    @Autowired
    private EgovEnvCryptoService egovEnvCryptoService;

    /**
     * test
     */
    @Test
    public void test() {
        final String encrypt = "com01";
        final String encrypted = egovEnvCryptoService.encrypt(encrypt);
        log.debug("encrypted={}", encrypted);
        assertEquals("에러가 발생했습니다!", "xz4fmrSdr1vGGl6UtwPLwA%3D%3D", encrypted);

        final String decrypted = egovEnvCryptoService.decrypt(encrypted);
        log.debug("decrypted={}", decrypted);
        assertEquals("에러가 발생했습니다!", encrypt, decrypted);
    }

    /**
     * test
     */
    @Test
    public void test2() {
        final String encrypt = "com01";
        final String encrypted = egovEnvCryptoService.encryptNone(encrypt);
        log.debug("encrypted={}", encrypted);
        assertEquals("에러가 발생했습니다!", "xz4fmrSdr1vGGl6UtwPLwA==", encrypted);

        final String decrypted = egovEnvCryptoService.decryptNone(encrypted);
        log.debug("decrypted={}", decrypted);
        assertEquals("에러가 발생했습니다!", encrypt, decrypted);
    }

}
