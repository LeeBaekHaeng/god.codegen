package org.egovframe.rte.fdl.cryptography;

import static org.junit.Assert.assertEquals;

import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 암호화/복호화
 * 
 * @see <a href=
 *      "https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:com:v4.1:sec:%EC%95%94%ED%98%B8%ED%99%94_%EB%B3%B5%ED%98%B8%ED%99%94">암호화/복호화</a>
 * 
 * @author 이백행
 * @since 2023-11-17
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath*:egovframework/spring/com/context-crypto.xml",
        "classpath*:egovframework/spring/com/test-context-common.xml" })

@NoArgsConstructor
@Slf4j
public class 암호화_복호화 {

    /**
     * egovEnvPasswordEncoderService
     */
    @Autowired
    private EgovPasswordEncoder egovEnvPasswordEncoderService;

    /**
     * egovEnvARIACryptoService
     */
    @Autowired
    private EgovARIACryptoService egovEnvARIACryptoService;

    /**
     * egovEnvCryptoService
     */
    @Autowired
    private EgovEnvCryptoService egovEnvCryptoService;

    /**
     * test
     */
    @Test
    public void test() {
        log.debug("getAlgorithm={}", egovEnvPasswordEncoderService.getAlgorithm());
        test("rhdxhd12");
        test("rhdxhd12rhdxhd12");
        test("rhdxhd12rhdxhd12rhdxhd12");
    }

    /**
     * test
     * 
     * @param plainPassword
     */
    private void test(String plainPassword) {
        log.debug("plainPassword={}", plainPassword);

        String encryptedPassword = egovEnvPasswordEncoderService.encryptPassword(plainPassword);
        log.debug("encryptedPassword={}", encryptedPassword);
        log.debug("length={}", encryptedPassword.length());

        boolean checkPassword = egovEnvPasswordEncoderService.checkPassword(plainPassword);
        log.debug("checkPassword={}", checkPassword);

        boolean checkPassword2 = egovEnvPasswordEncoderService.checkPassword(plainPassword, encryptedPassword);
        log.debug("checkPassword2={}", checkPassword2);

        log.debug("");
    }

    /**
     * test2
     */
    @Test
    public void test2() {
        log.debug("getCyptoAlgorithmKey={}", egovEnvCryptoService.getCyptoAlgorithmKey());

        test2("rhdxhd12".getBytes(StandardCharsets.UTF_8));
        test2("rhdxhd12rhdxhd12".getBytes(StandardCharsets.UTF_8));
        test2("rhdxhd12rhdxhd12rhdxhd12".getBytes(StandardCharsets.UTF_8));
    }

    /**
     * test2
     * 
     * @param data
     */
    private void test2(byte[] data) {
        log.debug("getCyptoAlgorithmKey={}", egovEnvCryptoService.getCyptoAlgorithmKey());

        byte[] encryptedData = egovEnvARIACryptoService.encrypt(data, egovEnvCryptoService.getCyptoAlgorithmKey());
        log.debug("encryptedData={}", encryptedData);
        String encrypted = new String(encryptedData, StandardCharsets.UTF_8);
        log.debug("encrypted={}", encrypted);
        log.debug("length={}", encrypted.length());

        byte[] decryptedData = egovEnvARIACryptoService.decrypt(encryptedData,
                egovEnvCryptoService.getCyptoAlgorithmKey());
        log.debug("decryptedData={}", decryptedData);
        String decrypted = new String(decryptedData, StandardCharsets.UTF_8);
        log.debug("decrypted={}", decrypted);
//        log.debug("length={}", decrypted.length());

        log.debug("");
    }

    /**
     * test3
     */
    @Test
    public void test3() {
        // 일방향(해시 함수) 암호화 저장
        // 비밀번호

        // 암호화 저장
        // 주민등록번호
        // 여권번호
        // 운전면허번호
        // 외국인등록번호
        // 신용카드번호
        // 계좌번호
        // 바이오정보

        test3("rhdxhd12");
        test3("rhdxhd12rhdxhd12");
        test3("rhdxhd12rhdxhd12rhdxhd12");
    }

    private void test3(String plain) {
        String encrypt = egovEnvCryptoService.encrypt(plain);
        log.debug("encrypt={}", encrypt);
        log.debug("encrypt={}", encrypt.length());

        String decrypt = egovEnvCryptoService.decrypt(encrypt);
        log.debug("decrypt={}", decrypt);

        log.debug("");

        assertEquals("", plain, decrypt);
    }

    /**
     * test4
     */
    @Test
    public void test4() {
        test4("rhdxhd12");
        test4("rhdxhd12rhdxhd12");
        test4("rhdxhd12rhdxhd12rhdxhd12");
    }

    private void test4(String plain) {
        String encrypt = egovEnvCryptoService.encryptNone(plain);
        log.debug("encrypt={}", encrypt);
        log.debug("encrypt={}", encrypt.length());

        String decrypt = egovEnvCryptoService.decryptNone(encrypt);
        log.debug("decrypt={}", decrypt);

        log.debug("");

        assertEquals("", plain, decrypt);
    }

}
