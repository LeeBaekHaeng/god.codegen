package egovframework.com.cmm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath*:egovframework/spring/com/**/context-*.xml" })
@ActiveProfiles({ "mysql", "security" })
@Transactional

@Slf4j
public class CmmUseDAOTest {

    @Resource
    private CmmUseDAO cmmUseDAO;

    @Test
    public void test() {
        log.debug("test");

        ComDefaultCodeVO vo = new ComDefaultCodeVO();

        vo.setCodeId("COM001");

        List<CmmnDetailCode> resultList = null;

        try {
            resultList = cmmUseDAO.selectCmmCodeDetail(vo);
        } catch (Exception e) {
            log.error("Exception selectCmmCodeDetail");
        }

        log.debug("resultList={}", resultList);
    }

}
