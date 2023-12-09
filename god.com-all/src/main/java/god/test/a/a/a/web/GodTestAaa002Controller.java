package god.test.a.a.a.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.core.cmm.web.GodCoreCmmAbstractController;
import god.test.a.a.a.service.TestAaa002Service;
import god.test.a.a.a.service.TestAaa002VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 Controller
 * 
 * @author 이백행
 * @since 2023-12-09
 *
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class GodTestAaa002Controller extends GodCoreCmmAbstractController<TestAaa002VO, TestAaa002VO> {

	/**
	 * 행정코드 Service
	 */
	private final TestAaa002Service service;

	/**
	 * 행정코드 등록 화면
	 */
	@Override
	@GetMapping("/do/test/insertTestAaa002.do")
	public String insertView(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		return "god/test/a/a/a/TestAaa002Regist";
	}

	/**
	 * 행정코드 등록
	 */
	@Override
	@PostMapping("/do/test/insertTestAaa002.do")
	public String insert(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		debugVO(vo);
		service.insert(vo, model);
		return getRedirect();
	}

	/**
	 * 행정코드 상세 화면
	 */
	@Override
	@GetMapping("/do/test/selectTestAaa002.do")
	public String select(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		service.select(vo, model);
		return "god/test/a/a/a/TestAaa002Detail";
	}

	/**
	 * 행정코드 목록 화면
	 */
	@Override
	@GetMapping("/do/test/selectTestAaa002List.do")
	public String selectList(@ModelAttribute("listVO") final TestAaa002VO vo, final BindingResult bindingResult,
			final ModelMap model) {
		debugVO(vo);

		final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		debug(loginVO);

		service.selectList(vo, model);

		return "god/test/a/a/a/TestAaa002List";
	}

	private void debug(final LoginVO loginVO) {
		final LoginVO loginVO2 = (LoginVO) org.egovframe.rte.fdl.access.service.EgovUserDetailsHelper
				.getAuthenticatedUser();
		final LoginVO loginVO3 = (LoginVO) org.egovframe.rte.fdl.security.userdetails.util.EgovUserDetailsHelper
				.getAuthenticatedUser();

		if (log.isDebugEnabled()) {
			log.debug("getName={}", loginVO.getName());
			log.debug("getName={}", loginVO2.getName());
			log.debug("getName={}", loginVO3.getName());
		}
	}

	/**
	 * 행정코드 수정 화면
	 */
	@Override
	@GetMapping("/do/test/updateTestAaa002.do")
	public String updateView(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		return "god/test/a/a/a/TestAaa002Updt";
	}

	/**
	 * 행정코드 수정
	 */
	@Override
	@PostMapping("/do/test/updateTestAaa002.do")
	public String update(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		debugVO(vo);
		service.update(vo, model);
		return getRedirect();
	}

	/**
	 * 행정코드 삭제
	 */
	@Override
	@PostMapping("/do/test/deleteTestAaa002.do")
	public String delete(final TestAaa002VO vo, final BindingResult bindingResult, final ModelMap model) {
		debugVO(vo);
		service.delete(vo, model);
		return getRedirect();
	}

	/**
	 * 행정코드 등록/수정
	 */
	@Override
	@PostMapping("/do/test/mergeTestAaa002.do")
	public String merge(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		debugVO(vo);
		service.merge(vo, model);
		return getRedirect();
	}

	/**
	 * 행정코드 등록/수정/삭제
	 */
	@Override
	@PostMapping("/do/test/multiTestAaa002.do")
	public String multi(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		debugVO(vo);
		service.multi(vo, model);
		return getRedirect();
	}

	@Override
	public String getRedirect() {
		return "redirect:/do/test/selectTestAaa002List.do";
	}

}
