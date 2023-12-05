package god.test.a.a.a.service.impl;

import static org.junit.Assert.assertEquals;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.test.EgovTestAbstractDAO;
import god.test.a.a.a.service.GodTestAaa002Service;
import god.test.a.a.a.service.GodTestAaa002VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 ServiceImpl 테스트
 * 
 * @author 이백행
 * @since 2023-12-06
 *
 */
@ContextConfiguration(classes = { GodTestAaa002ServiceImplTest.class, EgovTestAbstractDAO.class, })

@Configuration

@ImportResource({

		"classpath*:egovframework/spring/com/idgn/context-idgn-AdministCodeRecptn.xml",

})

@ComponentScan(

		useDefaultFilters = false,

		basePackages = {

				"god.test.a.a.a.service.impl",

		},

		includeFilters = {

				@Filter(

						type = FilterType.ASSIGNABLE_TYPE,

						classes = {

								GodTestAaa002ServiceImpl.class,

								GodTestAaa002DAO.class,

						}

				)

		}

)

@NoArgsConstructor
@Slf4j
public class GodTestAaa002ServiceImplTest extends EgovTestAbstractDAO {

	/**
	 * 행정코드 Service
	 */
	@Autowired
	private GodTestAaa002Service service;

	/**
	 * 행정코드 ID
	 */
	@Autowired
	@Qualifier("egovAdministCodeRecptnIdGnrService")
	private EgovIdGnrService egovAdministCodeRecptnIdGnrService;

	/**
	 * 행정코드 등록 테스트
	 */
	@Test
	public void insert() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode("0000000001");

		setOpertSn(vo);

		// when
		final int result = service.insert(vo);

		// then
		log.debug("result={}", result);

		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
	}

	private void setOpertSn(final GodTestAaa002VO vo) {
		try {
			vo.setOpertSn(egovAdministCodeRecptnIdGnrService.getNextLongId());
		} catch (FdlException e) {
			log.error("FdlException egovAdministCodeRecptnIdGnrService");
//        } catch (BaseRuntimeException e) {
//            log.error("BaseRuntimeException egovAdministCodeRecptnIdGnrService");
//        } catch (Exception e) {
//            log.error("Exception egovAdministCodeRecptnIdGnrService");
			throw new BaseRuntimeException(e);
		}

		if (log.isDebugEnabled()) {
			log.debug("getOpertSn={}", vo.getOpertSn());
		}
	}

//	/**
//	 * 
//	 * @param testData
//	 */
//	private void testData(final GodTestAaa002VO testData) {
//		// given
//		testData.setAdministZoneSe("1");
//		testData.setAdministZoneCode("0000000001");
//
//		setOpertSn(testData);
//
//		// when
//		final int result = service.insert(testData);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void select() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final GodTestAaa002VO result = service.select(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertSelect(testData, result);
//	}
//
//	private void assertSelect(final GodTestAaa002VO testData, final GodTestAaa002VO result) {
//		if (log.isDebugEnabled()) {
//			log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
//			log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());
//		}
//
//		assertEquals(egovMessageSource.getMessage("fail.common.select"), testData.getAdministZoneCode(),
//				result.getAdministZoneCode());
//		assertEquals(egovMessageSource.getMessage("fail.common.select"), testData.getAdministZoneCode(),
//				result.getAdministZoneCode());
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void selectList() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setFirstIndex(0);
//		vo.setRecordCountPerPage(10);
//
////        vo.setSearchCondition("0");
//		vo.setSearchKeyword("test 이백행 2023-11-18");
//
//		// when
//		final List<GodTestAaa002VO> resultList = service.selectList(vo);
//
//		// then
//		log.debug("resultList={}", resultList);
//
//		assertSelectList(testData, resultList);
//	}
//
//	private void assertSelectList(final GodTestAaa002VO testData, final List<GodTestAaa002VO> resultList) {
////        assertFalse(egovMessageSource.getMessage("fail.common.select"), resultList.isEmpty());
//		assertTrue(egovMessageSource.getMessage("fail.common.select"), resultList.size() > -1);
//
//		int i = 1;
//
//		for (final GodTestAaa002VO result : resultList) {
//			if (log.isDebugEnabled()) {
//				log.debug("i={}", i);
//
//				log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
//				log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());
//
//				log.debug("getUseAt={}, {}", testData.getUseAt(), result.getUseAt());
//				log.debug("");
//			}
//
//			i++;
//		}
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void update() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		vo.setUseAt("Y");
//
//		// when
//		final int result = service.update(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void delete() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final int result = service.delete(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void merge() {
//		// given
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe("1");
//		vo.setAdministZoneCode("0000000001");
//
//		setOpertSn(vo);
//
//		// when
//		final int result = service.merge(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void multi() {
//		// given
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe("1");
//		vo.setAdministZoneCode("0000000001");
//
//		setOpertSn(vo);
//
//		// when
//		final int result = service.multi(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void selectListTotCnt() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//
//		// when
//		final int totCnt = service.selectListTotCnt(vo);
//
//		// then
//		log.debug("totCnt={}", totCnt);
//
//		assertTrue(egovMessageSource.getMessage("fail.common.select"), totCnt > -1);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void insert2() {
//		// given
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe("1");
//		vo.setAdministZoneCode("0000000001");
//
//		setOpertSn(vo);
//
//		// when
//		final int result = service.insert2(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void select2() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final GodTestAaa002VO result = service.select2(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertSelect(testData, result);
//	}
//
//	/**
//	     * 
//	     */
//	@Test
//	public void select2List() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setFirstIndex(0);
//		vo.setRecordCountPerPage(10);
//
//		// vo.setSearchCondition("0");
//		vo.setSearchKeyword("test 이백행 2023-11-18");
//
//		// when
//		final List<GodTestAaa002VO> resultList = service.select2List(vo);
//
//		// then
//		log.debug("resultList={}", resultList);
//
//		assertSelectList(testData, resultList);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void update2() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		vo.setUseAt("Y");
//
//		// when
//		final int result = service.update2(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void delete2() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final int result = service.delete2(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void merge2() {
//		// given
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe("1");
//		vo.setAdministZoneCode("0000000001");
//
//		setOpertSn(vo);
//
//		// when
//		final int result = service.merge2(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void multi2() {
//		// given
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//		vo.setAdministZoneSe("1");
//		vo.setAdministZoneCode("0000000001");
//
//		setOpertSn(vo);
//
//		// when
//		final int result = service.multi2(vo);
//
//		// then
//		log.debug("result={}", result);
//
//		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void select2ListTotCnt() {
//		// given
//		final GodTestAaa002VO testData = new GodTestAaa002VO();
//		testData(testData);
//
//		final GodTestAaa002VO vo = new GodTestAaa002VO();
//
//		// when
//		final int totCnt = service.selectListTotCnt(vo);
//
//		// then
//		log.debug("totCnt={}", totCnt);
//
//		assertTrue(egovMessageSource.getMessage("fail.common.select"), totCnt > -1);
//	}

}
