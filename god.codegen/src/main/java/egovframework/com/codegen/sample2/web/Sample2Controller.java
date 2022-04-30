package egovframework.com.codegen.sample2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.com.codegen.sample2.service.Sample2Service;
import egovframework.com.codegen.sample2.service.Sample2DefaultVO;
import egovframework.com.codegen.sample2.service.Sample2VO;

/**
 * @Class Name : Sample2Controller.java
 * @Description : Sample2 Controller class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 *
 *  Copyright (C)  All right reserved.
 */

@Controller
public class Sample2Controller {

	private final Sample2Service sample2Service;
	private final EgovPropertyService egovPropertyService;

	public Sample2Controller(Sample2Service sample2Service,
			@Qualifier("propertiesService") EgovPropertyService egovPropertyService) {
		this.sample2Service = sample2Service;
		this.egovPropertyService = egovPropertyService;
	}

	/**
	 * SAMPLE2 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 Sample2DefaultVO
	 * @return "egovframework/com/codegen/sample2/Sample2List"
	 * @exception Exception
	 */
	@RequestMapping(value="/sample2/Sample2List.do")
	public String selectSample2List(Sample2VO sample2VO, Model model) {

		/** EgovPropertyService.sample */
		sample2VO.setPageUnit(egovPropertyService.getInt("pageUnit"));
		sample2VO.setPageSize(egovPropertyService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(sample2VO.getPageIndex());
		paginationInfo.setRecordCountPerPage(sample2VO.getPageUnit());
		paginationInfo.setPageSize(sample2VO.getPageSize());

		sample2VO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		sample2VO.setLastIndex(paginationInfo.getLastRecordIndex());
		sample2VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> sample2List = sample2Service.selectSample2List(sample2VO);
		model.addAttribute("resultList", sample2List);

		int totCnt = sample2Service.selectSample2ListTotCnt(sample2VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "egovframework/com/codegen/sample2/Sample2List";
	}

	@RequestMapping("/sample2/addSample2View.do")
	public String addSample2View(
			@ModelAttribute("searchVO") Sample2DefaultVO searchVO, Model model)
			throws Exception {
		model.addAttribute("sample2VO", new Sample2VO());
		return "egovframework/com/codegen/sample2/Sample2Regist";
	}

	@RequestMapping("/sample2/addSample2.do")
	public String addSample2(
			Sample2VO sample2VO,
			@ModelAttribute("searchVO") Sample2DefaultVO searchVO, SessionStatus status)
			throws Exception {
		sample2Service.insertSample2(sample2VO);
		status.setComplete();
		return "forward:/sample2/Sample2List.do";
	}

	@RequestMapping("/sample2/updateSample2View.do")
	public String updateSample2View(
			@RequestParam("id") String id ,
			@ModelAttribute("searchVO") Sample2DefaultVO searchVO, Model model)
			throws Exception {
		Sample2VO sample2VO = new Sample2VO();
		sample2VO.setId(id);
		// 변수명은 CoC 에 따라 sample2VO
		model.addAttribute(selectSample2(sample2VO, searchVO));
		return "egovframework/com/codegen/sample2/Sample2Regist";
	}

	@RequestMapping("/sample2/selectSample2.do")
	public @ModelAttribute("sample2VO")
	Sample2VO selectSample2(
			Sample2VO sample2VO,
			@ModelAttribute("searchVO") Sample2DefaultVO searchVO) throws Exception {
		return sample2Service.selectSample2(sample2VO);
	}

	@RequestMapping("/sample2/updateSample2.do")
	public String updateSample2(
			Sample2VO sample2VO,
			@ModelAttribute("searchVO") Sample2DefaultVO searchVO, SessionStatus status)
			throws Exception {
		sample2Service.updateSample2(sample2VO);
		status.setComplete();
		return "forward:/sample2/Sample2List.do";
	}

	@RequestMapping("/sample2/deleteSample2.do")
	public String deleteSample2(
			Sample2VO sample2VO,
			@ModelAttribute("searchVO") Sample2DefaultVO searchVO, SessionStatus status)
			throws Exception {
		sample2Service.deleteSample2(sample2VO);
		status.setComplete();
		return "forward:/sample2/Sample2List.do";
	}

}
