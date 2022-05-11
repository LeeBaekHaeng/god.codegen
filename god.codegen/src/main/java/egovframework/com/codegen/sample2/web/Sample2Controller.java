package egovframework.com.codegen.sample2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.com.cmm.web.EgovComAbstractController;
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
public class Sample2Controller extends EgovComAbstractController {

	private final Sample2Service sample2Service;

	public Sample2Controller(Sample2Service sample2Service) {
		this.sample2Service = sample2Service;
	}

	/**
	 * SAMPLE2 목록을 조회한다. (pageing)
	 *
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @param model
	 * @return "egovframework/com/codegen/sample2/Sample2List"
	 */
	@GetMapping("/sample2/selectSample2List.do")
	public String selectSample2List(Sample2VO sample2VO, Model model) {

		PaginationInfo paginationInfo = builderPaginationInfo(sample2VO);

		List<EgovMap> sample2List = sample2Service.selectSample2List(sample2VO);
		model.addAttribute("resultList", sample2List);

		int totCnt = sample2Service.selectSample2ListTotCnt(sample2VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "egovframework/com/codegen/sample2/Sample2List";
	}

	@GetMapping("/sample2/insertSample2.do")
	public String insertSample2(Sample2VO sample2VO, Model model) {
		return "egovframework/com/codegen/sample2/Sample2Regist";
	}

	@PostMapping("/sample2/insertSample2.do")
	public String insertSample2(Sample2VO sample2VO) {
		int insertSample2 = sample2Service.insertSample2(sample2VO);
		return "redirect:/sample2/selectSample2List.do?insertSample2=" + insertSample2;
	}

	@GetMapping("/sample2/updateSample2.do")
	public String updateSample2(Sample2VO sample2VO,
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

	/**
	 * 등록/수정
	 * 
	 * @param sample2VO
	 * @return
	 */
	@PostMapping("/sample2/mergeSample2.do")
	public String mergeSample2(Sample2VO sample2VO) {
		int mergeSample2 = sample2Service.mergeSample2(sample2VO);
		return "redirect:/sample2/selectSample2List.do?mergeSample2=" + mergeSample2;
	}

	/**
	 * 등록/수정/삭제
	 * 
	 * @param sample2VO
	 * @return
	 */
	@PostMapping("/sample2/multiSample2.do")
	public String multiSample2(Sample2VO sample2VO) {
		int multiSample2 = sample2Service.multiSample2(sample2VO);
		return "redirect:/sample2/selectSample2List.do?multiSample2=" + multiSample2;
	}

}
