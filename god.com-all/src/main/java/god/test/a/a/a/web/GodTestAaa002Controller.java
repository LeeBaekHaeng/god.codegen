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
import god.core.cmm.service.GodCoreCmmController;
import god.core.cmm.web.GodCoreCmmAbstractController;
import god.test.a.a.a.service.GodTestAaa002Service;
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
public class GodTestAaa002Controller extends GodCoreCmmAbstractController<TestAaa002VO, TestAaa002VO>
		implements GodCoreCmmController<TestAaa002VO, TestAaa002VO> {

	/**
	 * 등록 화면
	 */
	private static final String RETURN_REGIST = "god/test/a/a/a/TestAaa002Regist";

	/**
	 * 수정 화면
	 */
	private static final String RETURN_UPDT = "god/test/a/a/a/TestAaa002Updt";

	/**
	 * 행정코드 Service
	 */
	private final GodTestAaa002Service service;

	/**
	 * 행정코드 등록 화면
	 */
	@Override
	@GetMapping("/do/test/insertTestAaa002.do")
	public String insert(@ModelAttribute("registVO") final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		service.insert(vo, model);
		return RETURN_REGIST;
	}

	/**
	 * 행정코드 등록
	 */
	@Override
	@PostMapping("/do/test/insertTestAaa002.do")
	public String insert(@ModelAttribute("registVO") final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		debugVO(vo);

		beanValidator.validate(vo, bindingResult);
		if (bindingResult.hasErrors()) {
			return RETURN_REGIST;
		}

		service.insert(vo, model);
		return getRedirectSelectList();
	}

	/**
	 * 행정코드 상세 화면
	 */
	@Override
	@GetMapping("/do/test/selectTestAaa002.do")
	public String select(@ModelAttribute("detailVO") final TestAaa002VO vo, final ModelMap model) {
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

		beanValidator.validate(vo, bindingResult);
		if (bindingResult.hasErrors()) {
			return "god/test/a/a/a/TestAaa002List";
		}

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

		log.debug("getName={}", loginVO.getName());

		if (loginVO3 != null) {
			log.debug("getName={}", loginVO2.getName());
		}

		if (loginVO3 != null) {
			log.debug("getName={}", loginVO3.getName());
		}
	}

	/**
	 * 행정코드 수정 화면
	 */
	@Override
	@GetMapping("/do/test/updateTestAaa002.do")
	public String update(@ModelAttribute("updtVO") final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		return RETURN_UPDT;
	}

	/**
	 * 행정코드 수정
	 */
	@Override
	@PostMapping("/do/test/updateTestAaa002.do")
	public String update(@ModelAttribute("updtVO") final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		debugVO(vo);

		beanValidator.validate(vo, bindingResult);
		if (bindingResult.hasErrors()) {
			return RETURN_UPDT;
		}

		service.update(vo, model);
		return getRedirectSelectList();
	}

	/**
	 * 행정코드 삭제
	 */
	@Override
	@PostMapping("/do/test/deleteTestAaa002.do")
	public String delete(@ModelAttribute("deleteVO") final TestAaa002VO vo, final BindingResult bindingResult,
			final ModelMap model) {
		debugVO(vo);

		beanValidator.validate(vo, bindingResult);
		if (bindingResult.hasErrors()) {
			return RETURN_UPDT;
		}

		service.delete(vo, model);
		return getRedirectSelectList();
	}

	/**
	 * 행정코드 등록/수정
	 */
	@Override
	@PostMapping("/do/test/mergeTestAaa002.do")
	public String merge(@ModelAttribute("mergeVO") final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		debugVO(vo);

		beanValidator.validate(vo, bindingResult);
		if (bindingResult.hasErrors()) {
			final String merge = multiRequest.getParameter("merge");
			if ("update".equals(merge)) {
				return RETURN_UPDT;
			} else {
				return RETURN_REGIST;
			}
		}

		service.merge(vo, model);
		return getRedirectSelectList();
	}

	/**
	 * 행정코드 등록/수정/삭제
	 */
	@Override
	@PostMapping("/do/test/multiTestAaa002.do")
	public String multi(@ModelAttribute("multiVO") final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		debugVO(vo);

		beanValidator.validate(vo, bindingResult);
		if (bindingResult.hasErrors()) {
			final String multi = multiRequest.getParameter("multi");
			if ("update".equals(multi) || "delete".equals(multi)) {
				return RETURN_UPDT;
			} else {
				return RETURN_REGIST;
			}
		}

		service.multi(vo, model);
		return getRedirectSelectList();
	}

	@Override
	public String getRedirectSelectList() {
		return "redirect:/do/test/selectTestAaa002List.do";
	}

}
