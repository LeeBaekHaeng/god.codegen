package god.admin.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import egovframework.com.cmm.ComDefaultVO;

/**
 * 관리자 메인 Controller
 * 
 * @author 이백행
 *
 */
@Controller
public class AdminCmmController {

    /**
     * 관리자 메인
     * 
     * @param model
     * @return
     */
    @GetMapping("/do/admin/cmm/main.do")
    public String main(ModelMap model) {
        return "god/admin/cmm/AdminCmmMain";
    }

    @GetMapping("/rest/admin/cmm/main")
    public String main(ComDefaultVO comDefaultVO, ModelMap model) {
        model.addAttribute("god", "test 이백행 2023-06-15");
        return "jsonView";
    }

}
