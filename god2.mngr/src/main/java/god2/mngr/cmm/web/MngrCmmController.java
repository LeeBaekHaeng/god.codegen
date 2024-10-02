package god2.mngr.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import egovframework.com.cmm.ComDefaultCodeVO;
import god2.mngr.cmm.service.MngrCmmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MngrCmmController {

	private final MngrCmmService mngrCmmService;

	@GetMapping("/mngr/cmm/selectCmmCodeDetail.do")
	public String selectCmmCodeDetail(ComDefaultCodeVO vo, Model model) {
		if (log.isDebugEnabled()) {
			log.debug("vo={}", vo);
		}
		model.addAttribute("resultList", mngrCmmService.selectCmmCodeDetail(vo));
		if (log.isDebugEnabled()) {
			log.debug("model={}", model);
		}
		return "jsonView";
	}

}
