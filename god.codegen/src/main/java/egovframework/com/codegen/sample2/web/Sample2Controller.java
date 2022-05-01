package egovframework.com.codegen.sample2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.com.codegen.sample2.service.Sample2Service;
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
	 */
	@GetMapping(value="/sample2/selectSample2List.do")
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

		List<EgovMap> sample2List = sample2Service.selectSample2List(sample2VO);
		model.addAttribute("resultList", sample2List);

		int totCnt = sample2Service.selectSample2ListTotCnt(sample2VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "egovframework/com/codegen/sample2/Sample2List";
	}

	@GetMapping("/sample2/addSample2View.do")
	public String addSample2View(Sample2VO sample2VO, Model model) {
		return "egovframework/com/codegen/sample2/Sample2Regist";
	}

	@PostMapping("/sample2/addSample2.do")
	public String addSample2(Sample2VO sample2VO) {
		int insertSample2 = sample2Service.insertSample2(sample2VO);
		return "redirect:/sample2/selectSample2List.do?insertSample2=" + insertSample2;
	}

	@GetMapping("/sample2/updateSample2View.do")
	public String updateSample2View(Sample2VO sample2VO,
			@RequestParam("id") String id,
			Model model) {
		model.addAttribute(sample2Service.selectSample2(sample2VO));
		return "egovframework/com/codegen/sample2/Sample2Regist";
	}

	@GetMapping("/sample2/selectSample2.do")
	public String selectSample2(Sample2VO sample2VO, Model model) {
		model.addAttribute(sample2Service.selectSample2(sample2VO));
		return "egovframework/com/codegen/sample2/Sample2Detail";
	}

	@PostMapping("/sample2/updateSample2.do")
	public String updateSample2(Sample2VO sample2VO) {
		int updateSample2 = sample2Service.updateSample2(sample2VO);
		return "redirect:/sample2/selectSample2List.do?updateSample2=" + updateSample2;
	}

	@PostMapping("/sample2/deleteSample2.do")
	public String deleteSample2(Sample2VO sample2VO) {
		int deleteSample2 = sample2Service.deleteSample2(sample2VO);
		return "redirect:/sample2/selectSample2List.do?deleteSample2=" + deleteSample2;
	}

}
