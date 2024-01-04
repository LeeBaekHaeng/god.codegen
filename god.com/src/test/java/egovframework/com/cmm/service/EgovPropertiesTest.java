package egovframework.com.cmm.service;

import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.Test;

import egovframework.com.cmm.EgovWebUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 프로퍼티 단위 테스트
 * 
 * @author 이백행
 * @since 2024-01-04
 *
 */
@RequiredArgsConstructor
@Slf4j
public class EgovPropertiesTest {

    /**
     * 프로퍼티 파일의 물리적 위치 단위 테스트
     */
    @Test
    public void test() {
        if (log.isDebugEnabled()) {
            log.debug("RELATIVE_PATH_PREFIX={}", EgovProperties.RELATIVE_PATH_PREFIX);

            log.debug("{}", EgovProperties.class.getResource(""));
            log.debug("{}", EgovProperties.class.getResource("").getPath());
            log.debug("{}", EgovProperties.class.getResource("").getPath().lastIndexOf("com"));
            log.debug("{}", EgovProperties.class.getResource("").getPath().substring(0,
                    EgovProperties.class.getResource("").getPath().lastIndexOf("com")));

//            log.debug("{}", Paths.get(EgovWebUtil.filePathBlackList(
//                    "/D:/GOD_CODE_GEN/eGovFrameDev-4.1.0-64bit/workspace/god.codegen/god.com/target/test-classes/egovframework/")));
            log.debug("{}", Paths.get(EgovWebUtil.filePathBlackList(
                    "D:/GOD_CODE_GEN/eGovFrameDev-4.1.0-64bit/workspace/god.codegen/god.com/target/test-classes/egovframework/")));

            log.debug("{}", EgovProperties.class.getResource("").getPath().substring(1,
                    EgovProperties.class.getResource("").getPath().lastIndexOf("com")));
            log.debug("{}", Paths.get(EgovWebUtil.filePathBlackList(EgovProperties.class.getResource("").getPath()
                    .substring(1, EgovProperties.class.getResource("").getPath().lastIndexOf("com")))));
        }

        assertEquals("", "", "");
    }

    /**
     * Property 파일패스로 Properties 객체를 리턴한다. 단위 테스트
     */
    @Test
    public void loadPropertiesFromFile() {
        final String fileName = EgovProperties.GLOBALS_PROPERTIES_FILE;

        if (log.isDebugEnabled()) {
            log.debug("fileName={}", fileName);
        }

        final Properties props = new Properties();

        try (

//                FileInputStream fis = new FileInputStream(EgovWebUtil.filePathBlackList(fileName));
//                BufferedInputStream bis = new BufferedInputStream(fis);

                InputStream fis = Files.newInputStream(Paths.get(EgovWebUtil.filePathBlackList(fileName)));
                BufferedInputStream bis = new BufferedInputStream(fis);

        ) {
            props.load(bis);
        } catch (FileNotFoundException fne) {
            log.debug("Property file not found.", fne);
            throw new BaseRuntimeException("Property file not found", fne);
        } catch (IOException ioe) {
            log.debug("Property file IO exception", ioe);
            throw new BaseRuntimeException("Property file IO exception", ioe);
        }

        if (log.isDebugEnabled()) {
            log.debug("Globals.DbType={}", props.getProperty("Globals.DbType"));
            log.debug("Globals.Auth={}", props.getProperty("Globals.Auth"));
        }

        assertEquals("", "", "");
    }

}
