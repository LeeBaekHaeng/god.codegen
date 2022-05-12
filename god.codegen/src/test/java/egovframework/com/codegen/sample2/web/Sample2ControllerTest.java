package egovframework.com.codegen.sample2.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import egovframework.com.codegen.sample2.service.Sample2VO;

/**
 * @Class Name : ${daoClassName}.java
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath*:egovframework/spring/com/**/context-*.xml",
		"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml" })
@ActiveProfiles("mysql")
public class Sample2ControllerTest {

	protected Logger egovLogger = LoggerFactory.getLogger(Sample2ControllerTest.class);

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;


	static Sample2VO sample2VO;

	@Before
	public void setup() {
		mockMvc = webAppContextSetup(wac).build();
	}

	/**
	 * SAMPLE2을 등록한다.
	 * 
	 * @throws Exception
	 */
	@Test
	public void a1_insertSample2View() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

//		params.add("id", "test id");

//		params.add("name", "test name");
//		params.add("description", "test description");
//		params.add("useYn", "test useYn");
//		params.add("regUser", "test regUser");

		// @formatter:off
		mockMvc.perform(get("/sample2/insertSample2.do").params(params))
			.andExpect(status().isOk())
//			.andExpect(content().contentType("text/html"))
			.andExpect(forwardedUrl("/WEB-INF/jsp/egovframework/com/codegen/sample2/Sample2Regist.jsp"))
			.andDo(print())
		;
		// @formatter:on
	}

	/**
	 * SAMPLE2을 등록한다.
	 * 
	 * @throws Exception
	 */
	@Test
	public void b1_insertSample2() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

//		params.add("id", "test id");

//		params.add("name", "test name");
//		params.add("description", "test description");
//		params.add("useYn", "test useYn");
//		params.add("regUser", "test regUser");

		// @formatter:off
		ResultActions resultActions = mockMvc.perform(post("/sample2/insertSample2.do").params(params))
			.andExpect(status().isFound())
//			.andExpect(content().contentType("text/html"))
			.andExpect(redirectedUrl("/sample2/selectSample2List.do?insertSample2=1"))
			.andDo(print())
		;
		// @formatter:on

		MvcResult mvcResult = resultActions.andReturn();
		sample2VO = (Sample2VO) mvcResult.getModelAndView().getModel().get("sample2VO");
		egovLogger.debug("id={}", sample2VO.getId());
	}

	/**
	 * SAMPLE2 목록을 조회한다.
	 * 
	 * @throws Exception
	 */
	@Test
	public void c1_selectSample2List() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		params.add("setPageIndex", "1");
		params.add("setPageUnit", "10");

//		params.add("setSearchCondition", "");
//		params.add("setSearchKeyword", "");
//		params.add("setSearchUseYn", "Y");
//		params.add("setPageIndex", "1");
//		params.add("setPageUnit", "10");
//		params.add("setPageSize", "10");
//		params.add("setSearchKeywordFrom", "");
//		params.add("setSearchKeywordTo", "");

		params.add("id", sample2VO.getId());
		egovLogger.debug("id={}", sample2VO.getId());

//		params.add("name", "test name");
//		params.add("description", "test description");
//		params.add("useYn", "test useYn");
//		params.add("regUser", "test regUser");

		// @formatter:off
		mockMvc.perform(get("/sample2/selectSample2List.do").params(params))
			.andExpect(status().isOk())
//			.andExpect(content().contentType("text/html"))
			.andExpect(forwardedUrl("/WEB-INF/jsp/egovframework/com/codegen/sample2/Sample2List.jsp"))
			.andDo(print())
		;
		// @formatter:on
	}

	/**
	 * SAMPLE2을 조회한다.
	 * 
	 * @throws Exception
	 */
	@Test
	public void d1_selectSample2() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		params.add("id", sample2VO.getId());
		egovLogger.debug("id={}", sample2VO.getId());

//		params.add("name", "test name");
//		params.add("description", "test description");
//		params.add("useYn", "test useYn");
//		params.add("regUser", "test regUser");

		// @formatter:off
		mockMvc.perform(get("/sample2/selectSample2.do").params(params))
			.andExpect(status().isOk())
//			.andExpect(content().contentType("text/html"))
			.andExpect(forwardedUrl("/WEB-INF/jsp/egovframework/com/codegen/sample2/Sample2Detail.jsp"))
			.andDo(print())
		;
		// @formatter:on
	}

	/**
	 * SAMPLE2을 수정한다.
	 * 
	 * @throws Exception
	 */
	@Test
	public void e1_updateSample2View() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		params.add("id", sample2VO.getId());
		egovLogger.debug("id={}", sample2VO.getId());

//		params.add("name", "test name");
//		params.add("description", "test description");
//		params.add("useYn", "test useYn");
//		params.add("regUser", "test regUser");

		// @formatter:off
		mockMvc.perform(get("/sample2/updateSample2.do").params(params))
			.andExpect(status().isOk())
//			.andExpect(content().contentType("text/html"))
			.andExpect(forwardedUrl("/WEB-INF/jsp/egovframework/com/codegen/sample2/Sample2Regist.jsp"))
			.andDo(print())
		;
		// @formatter:on
	}

	/**
	 * SAMPLE2을 수정한다.
	 * 
	 * @throws Exception
	 */
	@Test
	public void f1_updateSample2() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		params.add("id", sample2VO.getId());
		egovLogger.debug("id={}", sample2VO.getId());

//		params.add("name", "test name");
//		params.add("description", "test description");
//		params.add("useYn", "test useYn");
//		params.add("regUser", "test regUser");

		// @formatter:off
		mockMvc.perform(post("/sample2/updateSample2.do").params(params))
			.andExpect(status().isFound())
//			.andExpect(content().contentType("text/html"))
			.andExpect(redirectedUrl("/sample2/selectSample2List.do?updateSample2=1"))
			.andDo(print())
		;
		// @formatter:on
	}

	/**
	 * SAMPLE2을 삭제한다.
	 * 
	 * @throws Exception
	 */
	@Test
	public void g1_deleteSample2() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		params.add("id", sample2VO.getId());
		egovLogger.debug("id={}", sample2VO.getId());

//		params.add("name", "test name");
//		params.add("description", "test description");
//		params.add("useYn", "test useYn");
//		params.add("regUser", "test regUser");

		// @formatter:off
		mockMvc.perform(post("/sample2/deleteSample2.do").params(params))
			.andExpect(status().isFound())
//			.andExpect(content().contentType("text/html"))
			.andExpect(redirectedUrl("/sample2/selectSample2List.do?deleteSample2=1"))
			.andDo(print())
		;
		// @formatter:on
	}

}
