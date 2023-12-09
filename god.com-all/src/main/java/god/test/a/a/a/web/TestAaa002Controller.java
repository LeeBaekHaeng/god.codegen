package god.test.a.a.a.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class TestAaa002Controller extends GodCoreCmmAbstractController<TestAaa002VO, TestAaa002VO> {

	/**
	 * 행정코드 Service
	 */
	private final TestAaa002Service service;

	@Override
	public String insertView(final TestAaa002VO vo, final ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void select(final TestAaa002VO vo, final ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	@GetMapping("/do/test/selectTestAaa002List.do")
	public String selectList(@ModelAttribute("listVO") final TestAaa002VO testAaa002VO,
			final BindingResult bindingResult, final ModelMap model) {
		final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		final LoginVO loginVO2 = (LoginVO) org.egovframe.rte.fdl.access.service.EgovUserDetailsHelper
				.getAuthenticatedUser();
		final LoginVO loginVO3 = (LoginVO) org.egovframe.rte.fdl.security.userdetails.util.EgovUserDetailsHelper
				.getAuthenticatedUser();
		debug(loginVO, loginVO2, loginVO3);

		service.selectList(testAaa002VO, model);

		return "god/test/a/a/a/TestAaa002List";
	}

	private void debug(final LoginVO loginVO, final LoginVO loginVO2, final LoginVO loginVO3) {
		if (log.isDebugEnabled()) {
			log.debug("getName={}", loginVO.getName());
			log.debug("getName={}", loginVO2.getName());
			log.debug("getName={}", loginVO3.getName());
		}
	}

	@Override
	public void updateView(final TestAaa002VO vo, final ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(final TestAaa002VO vo, final BindingResult bindingResult, final ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void multi(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		// TODO Auto-generated method stub

	}

}
