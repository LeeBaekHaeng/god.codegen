package god.test.a.a.a.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.core.cmm.web.GodCoreCmmAbstractController;
import god.test.a.a.a.service.TestAaa002Service;
import god.test.a.a.a.service.TestAaa002VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestAaa002Controller extends GodCoreCmmAbstractController<TestAaa002VO, TestAaa002VO> {

	private final TestAaa002Service service;

	@Override
	public String insertView(final TestAaa002VO vo, final ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(final TestAaa002VO vo, final ModelMap model, final BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void select(final TestAaa002VO vo, final ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	@GetMapping("/do/test/selectTestAaa002List.do")
	public String selectList(@ModelAttribute("listVO") TestAaa002VO testAaa002VO, ModelMap model,
			final BindingResult bindingResult) {
		service.selectList(testAaa002VO, model);

		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		log.debug("getName={}", loginVO.getName());

		LoginVO loginVO2 = (LoginVO) org.egovframe.rte.fdl.access.service.EgovUserDetailsHelper.getAuthenticatedUser();
		log.debug("getName={}", loginVO2.getName());

		LoginVO loginVO3 = (LoginVO) org.egovframe.rte.fdl.security.userdetails.util.EgovUserDetailsHelper
				.getAuthenticatedUser();
		log.debug("getName={}", loginVO3.getName());

		return "god/test/a/a/a/TestAaa002List";
	}

	@Override
	public void updateView(final TestAaa002VO vo, final ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(final TestAaa002VO vo, final ModelMap model, final BindingResult bindingResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(final TestAaa002VO vo, final ModelMap model, final BindingResult bindingResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(final TestAaa002VO vo, final ModelMap model, final BindingResult bindingResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void multi(final TestAaa002VO vo, final ModelMap model, final BindingResult bindingResult) {
		// TODO Auto-generated method stub

	}

}
