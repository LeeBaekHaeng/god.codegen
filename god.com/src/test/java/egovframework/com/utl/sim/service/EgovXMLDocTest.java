package egovframework.com.utl.sim.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import noNamespace.SndngMailDocument;

/**
 * XML파일을 파싱하여 구조체 형태로 반환 또는 구조체 형태의 데이터를 XML파일로 저장하는 Business Interface class
 * 단위 테스트
 * 
 * @author 이백행
 * @since 2023-12-25
 *
 */
@NoArgsConstructor
@Slf4j
public class EgovXMLDocTest {

    /**
     * XML파일을 파싱하여 메일발송 클래스(임의)에 내용을 담아 반환 단위 테스트
     */
    @Test
    public void test() {
        final String file = "MAILMSG_000000000226.xml";
        final SndngMailDocument mailDoc = EgovXMLDoc.getXMLToClass(file);

        if (log.isDebugEnabled()) {
            log.debug("mailDoc={}{", mailDoc);
        }

        assertEquals("에러가 발생했습니다!", "", "");
    }

}
