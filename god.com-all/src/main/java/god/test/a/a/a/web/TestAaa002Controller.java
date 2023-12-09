package god.test.a.a.a.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.core.cmm.web.GodCoreCmmAbstractController;
import god.test.a.a.a.service.TestAaa002VO;

@Controller
public class TestAaa002Controller extends GodCoreCmmAbstractController<TestAaa002VO, TestAaa002VO> {

	@Override
	public String insert(TestAaa002VO vo, ModelMap model) {
		return super.insert(vo, model);
	}

//	@Override
	@Override
	@GetMapping("/test/a/a/a/selectGodTestAaa002List.do")
	public String selectList(@ModelAttribute("listVO") TestAaa002VO godTestAaa002VO, ModelMap model) {
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		org.egovframe.rte.fdl.access.service.EgovUserDetailsHelper.getAuthenticatedUser();
		org.egovframe.rte.fdl.security.userdetails.util.EgovUserDetailsHelper.getAuthenticatedUser();

		return "god/test/a/a/a/GodTestAaa002List";
	}

}
