package egovframework.com.cmm.service;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;

import egovframework.com.cmm.EgovWebUtil;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * Class Name : EgovProperties.java Description : properties값들을 파일로부터 읽어와
 * Globals클래스의 정적변수로 로드시켜주는 클래스로 문자열 정보 기준으로 사용할 전역변수를 시스템 재시작으로 반영할 수 있도록 한다.
 * Modification Information
 * 
 * <pre>
 *   수정일              수정자          수정내용
 *   ----------  --------  ---------------------------
 *   2009.01.19  박지욱          최초 생성
 *	 2011.07.20    서준식 	   Globals파일의 상대경로를 읽은 메서드 추가
 *	 2014.10.13    이기하 	   Globals.properties 값이 null일 경우 오류처리
 *   2019.04.26    신용호 	   RELATIVE_PATH_PREFIX Path 적용 방식 개선
 *   2022.01.21    윤주호 	   Try-catch-resource 조치 및 Method Refactoring
 * </pre>
 * 
 * @author 공통 서비스 개발팀 박지욱
 * @since 2009. 01. 19
 * @version 1.0
 * @see
 *
 */
@UtilityClass
@Slf4j
public class EgovProperties {

    /**
     * 파일구분자
     */
    private final static String FILE_SEPARATOR = System.getProperty("file.separator");

    // public static final String GLOBALS_PROPERTIES_FILE =
    // System.getProperty("user.home") + FILE_SEPARATOR + "egovProps"
    // +FILE_SEPARATOR + "globals.properties";

    /**
     * 프로퍼티 파일의 물리적 위치
     */
    public static final String RELATIVE_PATH_PREFIX = EgovProperties.class.getResource("") == null ? ""
            : EgovProperties.class.getResource("").getPath().substring(1,
                    EgovProperties.class.getResource("").getPath().lastIndexOf("com"));
    // public static final String RELATIVE_PATH_PREFIX =
    // EgovProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(0,EgovProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath().indexOf("WEB-INF/classes/")+"WEB-INF/classes/".length())+"egovframework/";

    /**
     * 전역 속성 파일
     */
    public static final String GLOBALS_PROPERTIES_FILE = RELATIVE_PATH_PREFIX + "egovProps" + FILE_SEPARATOR
            + "globals.properties";

    /**
     * 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 값을 반환한다(Globals.java 전용)
     * 
     * @param keyName String
     * @return String
     */
    public static String getProperty(final String keyName) {
        // 221116 김혜준 2022 시큐어코딩 조치
        if (log.isDebugEnabled()) {
            log.debug("===>>> getProperty" + EgovStringUtil.isNullToString(
                    EgovProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
            log.debug("getProperty : {} = {}", GLOBALS_PROPERTIES_FILE, keyName);
        }

        return getPropertyValueByKey(keyName);
    }

    /**
     * 인자로 주어진 문자열을 Key값으로 하는 상대경로 프로퍼티 값을 절대경로로 반환한다(Globals.java 전용)
     * 
     * @param keyName String
     * @return String
     */
    public static String getPathProperty(final String keyName) {
        log.debug("getPathProperty : {} = {}", GLOBALS_PROPERTIES_FILE, keyName);

        return RELATIVE_PATH_PREFIX + "egovProps" + FILE_SEPARATOR + getProperty(keyName);
    }

    /**
     * 주어진 파일에서 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 값을 반환한다
     * 
     * @param fileName String
     * @param key      String
     * @return String
     */
    public static String getProperty(final String fileName, final String keyName) {
        return getPropertyValueByKey(fileName, keyName);
    }

    /**
     * 주어진 파일에서 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 상대 경로값을 절대 경로값으로 반환한다
     * 
     * @param fileName String
     * @param key      String
     * @return String
     */
    public static String getPathProperty(final String fileName, final String keyName) {
        return RELATIVE_PATH_PREFIX + "egovProps" + FILE_SEPARATOR + getProperty(fileName, keyName);
    }

    /**
     * 주어진 프로파일의 내용을 파싱하여 (key-value) 형태의 구조체 배열을 반환한다.
     * 
     * @param property String
     * @return ArrayList
     */
    public static List<Map<String, String>> loadPropertyFile(final String property) {

        // key - value 형태로 된 배열 결과
        final List<Map<String, String>> keyList = new ArrayList<>();

        final String src = property.replace("\\", FILE_SEPARATOR).replace("/", FILE_SEPARATOR);

        if (Files.exists(Paths.get(EgovWebUtil.filePathBlackList(src)))) { // 2022.01 Potential Path Traversal
            final Properties props = loadPropertiesFromFile(src);

            final Enumeration<?> plist = props.propertyNames();
            if (plist != null) {
                while (plist.hasMoreElements()) {
                    final Map<String, String> map = new ConcurrentHashMap<>();
                    final String key = (String) plist.nextElement();
                    map.put(key, props.getProperty(key));
                    keyList.add(map);
                }
            }
        }

        return keyList;
    }

    /**
     * 기본 Property 에서 Property Key로 Property value 받아온다.
     * 
     * @param keyName
     * @return
     */
    public static String getPropertyValueByKey(final String keyName) {
        return getPropertyValueByKey(GLOBALS_PROPERTIES_FILE, keyName);
    }

    /**
     * Property 파일을 지정하여 Property Key로 Property value 받아온다.
     * 
     * @param fileName
     * @param keyName
     * @return
     */
    public static String getPropertyValueByKey(final String fileName, final String keyName) {
        String propertyValue = "";
        final Properties props = loadPropertiesFromFile(fileName);

        if (props.containsKey(keyName)) {
            propertyValue = props.getProperty(keyName).trim();
        }

        return propertyValue;
    }

    /**
     * Property 파일패스로 Properties 객체를 리턴한다.
     * 
     * @param fileName
     * @return
     */
    private static Properties loadPropertiesFromFile(final String fileName) {
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

        return props;
    }
}
