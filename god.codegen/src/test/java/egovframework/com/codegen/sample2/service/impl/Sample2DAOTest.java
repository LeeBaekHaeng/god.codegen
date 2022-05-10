package egovframework.com.codegen.sample2.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.com.codegen.sample2.service.Sample2VO;

/**
 * @Class Name : Sample2DAO.java
 * @Description : Sample2 DAO Class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 *
 *  Copyright (C)  All right reserved.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:egovframework/spring/com/**/context-*.xml" })
@ActiveProfiles("mysql")
public class Sample2DAOTest {

	protected Logger egovLogger = LoggerFactory.getLogger(Sample2DAOTest.class);

	@Autowired
	private Sample2DAO sample2DAO;

	@Autowired
	@Qualifier("egovFileIdGnrService")
	private EgovIdGnrService sample2EgovIdGnrService;

	/**
	 * SAMPLE2을 등록한다.
	 */
	@Test
	public void insertSample2() {
		Sample2VO sample2VO = new Sample2VO();

		try {
			sample2VO.setId(sample2EgovIdGnrService.getNextStringId());
			egovLogger.debug("id={}", sample2VO.getId());
		} catch (FdlException e) {
			egovLogger.error("sample2EgovIdGnrService FdlException");
		}

//		sample2VO.setName("test name");
//		sample2VO.setDescription("test description");
//		sample2VO.setUseYn("test useYn");
//		sample2VO.setRegUser("test regUser");

		int insertSample2 = sample2DAO.insertSample2(sample2VO);
		egovLogger.debug("insertSample2={}", insertSample2);
	}

	/**
	 * SAMPLE2을 수정한다.
	 */
	@Test
	public void updateSample2() {
		Sample2VO sample2VO = new Sample2VO();

		sample2VO.setId("test id");

//		sample2VO.setName("test name");
//		sample2VO.setDescription("test description");
//		sample2VO.setUseYn("test useYn");
//		sample2VO.setRegUser("test regUser");

		int updateSample2 = sample2DAO.updateSample2(sample2VO);
		egovLogger.debug("updateSample2={}", updateSample2);
	}

	/**
	 * SAMPLE2을 삭제한다.
	 */
	@Test
	public void deleteSample2() {
		Sample2VO sample2VO = new Sample2VO();

		sample2VO.setId("test id");

//		sample2VO.setName("test name");
//		sample2VO.setDescription("test description");
//		sample2VO.setUseYn("test useYn");
//		sample2VO.setRegUser("test regUser");

		int deleteSample2 = sample2DAO.deleteSample2(sample2VO);
		egovLogger.debug("deleteSample2={}", deleteSample2);
	}

	/**
	 * SAMPLE2을 조회한다.
	 */
	@Test
	public void selectSample2() {
		Sample2VO sample2VO = new Sample2VO();

		sample2VO.setId("test id");

//		sample2VO.setName("test name");
//		sample2VO.setDescription("test description");
//		sample2VO.setUseYn("test useYn");
//		sample2VO.setRegUser("test regUser");

		Sample2VO result = sample2DAO.selectSample2(sample2VO);
		egovLogger.debug("result={}", result);
	}

	/**
	 * SAMPLE2 목록을 조회한다.
	 */
	@Test
	public void selectSample2List() {
		Sample2VO sample2VO = new Sample2VO();

		sample2VO.setFirstIndex(1);
		sample2VO.setRecordCountPerPage(10);

		sample2VO.setSearchCondition("");
		sample2VO.setSearchKeyword("");
		sample2VO.setSearchUseYn("");
//		sample2VO.setPageIndex(1);
//		sample2VO.setPageUnit(10);
//		sample2VO.setPageSize(10);
//		sample2VO.setFirstIndex(1);
//		sample2VO.setLastIndex(1);
//		sample2VO.setRecordCountPerPage(10);
		sample2VO.setSearchKeywordFrom("");
		sample2VO.setSearchKeywordTo("");

//		sample2VO.setId("test id");

//		sample2VO.setName("test name");
//		sample2VO.setDescription("test description");
//		sample2VO.setUseYn("test useYn");
//		sample2VO.setRegUser("test regUser");

		List<EgovMap> resultList = sample2DAO.selectSample2List(sample2VO);
		egovLogger.debug("resultList={}", resultList);
	}

	/**
	 * SAMPLE2 총 갯수를 조회한다.
	 */
	@Test
	public void selectSample2ListTotCnt() {
		Sample2VO sample2VO = new Sample2VO();

		sample2VO.setFirstIndex(1);
		sample2VO.setRecordCountPerPage(10);

		sample2VO.setSearchCondition("");
		sample2VO.setSearchKeyword("");
		sample2VO.setSearchUseYn("");
//		sample2VO.setPageIndex(1);
//		sample2VO.setPageUnit(10);
//		sample2VO.setPageSize(10);
//		sample2VO.setFirstIndex(1);
//		sample2VO.setLastIndex(1);
//		sample2VO.setRecordCountPerPage(10);
		sample2VO.setSearchKeywordFrom("");
		sample2VO.setSearchKeywordTo("");

//		sample2VO.setId("test id");

//		sample2VO.setName("test name");
//		sample2VO.setDescription("test description");
//		sample2VO.setUseYn("test useYn");
//		sample2VO.setRegUser("test regUser");

		int selectSample2ListTotCnt = sample2DAO.selectSample2ListTotCnt(sample2VO);
		egovLogger.debug("selectSample2ListTotCnt={}", selectSample2ListTotCnt);
	}

}
