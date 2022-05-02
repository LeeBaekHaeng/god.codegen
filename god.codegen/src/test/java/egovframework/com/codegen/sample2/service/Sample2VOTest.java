package egovframework.com.codegen.sample2.service;

import java.util.ArrayList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Class Name : Sample2VOTest.java
 * @Description : Sample2 VO Test class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Sample2VOTest {

	protected Logger egovLogger = LoggerFactory.getLogger(Sample2VOTest.class);

	@Test
	public void test() {
		egovLogger.debug("test");

		Sample2VO sample2VO = new Sample2VO();

		sample2VO.setId(null);
		sample2VO.setName(null);
		sample2VO.setDescription(null);
		sample2VO.setUseYn(null);
		sample2VO.setRegUser(null);

		sample2VO.setId("");
		sample2VO.setName("");
		sample2VO.setDescription("");
		sample2VO.setUseYn("");
		sample2VO.setRegUser("");

		sample2VO.setId("test id");
		sample2VO.setName("test name");
		sample2VO.setDescription("test description");
		sample2VO.setUseYn("test useYn");
		sample2VO.setRegUser("test regUser");

		egovLogger.debug("sample2VO={}", sample2VO);

		egovLogger.debug("id={}", sample2VO.getId());
		egovLogger.debug("name={}", sample2VO.getName());
		egovLogger.debug("description={}", sample2VO.getDescription());
		egovLogger.debug("useYn={}", sample2VO.getUseYn());
		egovLogger.debug("regUser={}", sample2VO.getRegUser());
	}

	@Test
	public void test2() {
		egovLogger.debug("test2");

		Sample2VO sample2VO = new Sample2VO();

//		String id = null;
//		String name = null;
//		String description = null;
//		String useYn = null;
//		String regUser = null;

//		String id = "";
//		String name = "";
//		String description = "";
//		String useYn = "";
//		String regUser = "";

		String id = "test id";
		String name = "test name";
		String description = "test description";
		String useYn = "test useYn";
		String regUser = "test regUser";

		egovLogger.debug("id={}", id);
		egovLogger.debug("name={}", name);
		egovLogger.debug("description={}", description);
		egovLogger.debug("useYn={}", useYn);
		egovLogger.debug("regUser={}", regUser);

		sample2VO.setId(id);
		sample2VO.setName(name);
		sample2VO.setDescription(description);
		sample2VO.setUseYn(useYn);
		sample2VO.setRegUser(regUser);

		egovLogger.debug("sample2VO={}", sample2VO);

		egovLogger.debug("id={}", sample2VO.getId());
		egovLogger.debug("name={}", sample2VO.getName());
		egovLogger.debug("description={}", sample2VO.getDescription());
		egovLogger.debug("useYn={}", sample2VO.getUseYn());
		egovLogger.debug("regUser={}", sample2VO.getRegUser());
	}

	@Test
	public void test_Sample2DefaultVO() {
		egovLogger.debug("test_Sample2DefaultVO");

		Sample2VO sample2VO = new Sample2VO();

		sample2VO.setIds(null);
		sample2VO.setNames(null);
		sample2VO.setDescriptions(null);
		sample2VO.setUseYns(null);
		sample2VO.setRegUsers(null);

		sample2VO.setIds(new ArrayList<>());
		sample2VO.setNames(new ArrayList<>());
		sample2VO.setDescriptions(new ArrayList<>());
		sample2VO.setUseYns(new ArrayList<>());
		sample2VO.setRegUsers(new ArrayList<>());

		for (int i = 1; i < 10; i++) {
			sample2VO.getIds().add("test id " + i);
			sample2VO.getNames().add("test name " + i);
			sample2VO.getDescriptions().add("test description " + i);
			sample2VO.getUseYns().add("test useYn " + i);
			sample2VO.getRegUsers().add("test regUser " + i);
		}

		egovLogger.debug("sample2VO={}", sample2VO);

		egovLogger.debug("ids={}", sample2VO.getIds());
		egovLogger.debug("size={}", sample2VO.getIds().size());
		egovLogger.debug("isEmpty={}", sample2VO.getIds().isEmpty());

		egovLogger.debug("names={}", sample2VO.getNames());
		egovLogger.debug("size={}", sample2VO.getNames().size());
		egovLogger.debug("isEmpty={}", sample2VO.getNames().isEmpty());

		egovLogger.debug("descriptions={}", sample2VO.getDescriptions());
		egovLogger.debug("size={}", sample2VO.getDescriptions().size());
		egovLogger.debug("isEmpty={}", sample2VO.getDescriptions().isEmpty());

		egovLogger.debug("useYns={}", sample2VO.getUseYns());
		egovLogger.debug("size={}", sample2VO.getUseYns().size());
		egovLogger.debug("isEmpty={}", sample2VO.getUseYns().isEmpty());

		egovLogger.debug("regUsers={}", sample2VO.getRegUsers());
		egovLogger.debug("size={}", sample2VO.getRegUsers().size());
		egovLogger.debug("isEmpty={}", sample2VO.getRegUsers().isEmpty());
	}

}
