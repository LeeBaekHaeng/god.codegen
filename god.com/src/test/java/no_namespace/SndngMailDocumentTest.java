package no_namespace;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import egovframework.com.cmm.service.Globals;
import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.utl.sim.service.EgovXMLDoc;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import noNamespace.SndngMailDocument;

/**
 * sndng-mail-1.0.jar 단위 테스트
 * 
 * @author 이백행
 * @since 2023-12-25
 *
 */
@NoArgsConstructor
@Slf4j
public class SndngMailDocumentTest {

    /**
     * 발송할 메일을 XML파일로 만들어 저장한다. 단위 테스트
     */
    @Test
    public void test() {
        final SndngMailVO vo = new SndngMailVO();
        vo.setMssageId("MAILMSG_000000000226");
        vo.setDsptchPerson("TEST1");
        vo.setRecptnPerson("dlqorgod@naver.com;"); // 받는사람
        vo.setSj("test 이백행 통합포털 메일발송 제목 2023-12-25T15:52:32.783");
        vo.setEmailCn("test 이백행 통합포털 메일발송 발신내용 2023-12-25T15:52:32.783");

        // 2. XML데이터를 만든다.
        SndngMailDocument mailDoc;
        SndngMailDocument.SndngMail mailElement;
        mailDoc = (SndngMailDocument) SndngMailDocument.Factory.newInstance();
        mailElement = mailDoc.addNewSndngMail();
        mailElement.setMssageId(vo.getMssageId());
        mailElement.setDsptchPerson(vo.getDsptchPerson());
        mailElement.setRecptnPerson(vo.getRecptnPerson());
        mailElement.setSj(vo.getSj());
        mailElement.setEmailCn(vo.getEmailCn());
        mailElement.setSndngResultCode(vo.getSndngResultCode());
//        mailElement.setOrignlFileList(orignlFileList);
//        mailElement.setStreFileList(streFileList);

        // 2. XML파일로 저장한다.
        final String xmlFile = Globals.MAIL_REQUEST_PATH + vo.getMssageId() + ".xml";
        final boolean result = EgovXMLDoc.getClassToXML(mailDoc, xmlFile);

        if (log.isDebugEnabled()) {
            log.debug("result={}", result);
        }

        assertTrue("에러가 발생했습니다!", result);
    }

}
