package god.sample.a.a.web;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.sample.a.a.service.SampleAa01RegistVO;
import god.sample.a.a.service.SampleAa01VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SampleAa01Controller {

	private final DefaultBeanValidator beanValidator;

	@GetMapping("/do/sample/selectSampleAa01List.do")
	public String selectList(SampleAa01VO vo, BindingResult bindingResult, ModelMap model) {
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		Assert.notNull(loginVO, "loginVO는 null이 아니어야 합니다.");
		if (loginVO == null) {
			throw new BaseRuntimeException("loginVO는 null이 아니어야 합니다.");
		}
		List<String> authorities = EgovUserDetailsHelper.getAuthorities();
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		if (log.isDebugEnabled()) {
			log.debug("loginVO={}", loginVO);
			log.debug("getId={}", loginVO.getId());
			log.debug("getName={}", loginVO.getName());
			log.debug("getUniqId={}", loginVO.getUniqId());
			log.debug("");

			log.debug("authorities={}", authorities);

			log.debug("isAuthenticated={}", isAuthenticated);
		}

		if ("Y".equals(vo.getSearchUseYn())) {
			beanValidator.validate(vo, bindingResult);
			if (bindingResult.hasErrors()) {
				return "god/sample/a/a/SampleAa01Regist";
			}
		}

		return "god/sample/a/a/SampleAa01List";
	}

	@GetMapping("/do/sample/insertSampleAa01.do")
	public String insert(@ModelAttribute("voRegist") SampleAa01RegistVO vo, ModelMap model) {
		return "god/sample/a/a/SampleAa01Regist";
	}

	@PostMapping("/do/sample/insertSampleAa01.do")
	public String insert(@ModelAttribute("voRegist") SampleAa01RegistVO vo, BindingResult bindingResult,
			ModelMap model) {
		beanValidator.validate(vo, bindingResult);
		if (bindingResult.hasErrors()) {
			return "god/sample/a/a/SampleAa01Regist";
		}
		return "redirect:/do/sample/selectSampleAa01List.do";
	}

}
