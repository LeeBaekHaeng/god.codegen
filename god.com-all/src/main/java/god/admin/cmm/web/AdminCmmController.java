package god.admin.cmm.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.web.EgovComAbstractController;

/**
 * 관리자 공통 Controller
 * 
 * @author 이백행
 *
 */
@Controller
public class AdminCmmController extends EgovComAbstractController {

    /**
     * 관리자 공통 메인
     * 
     * @param model
     * @return
     */
    @GetMapping("/do/admin/cmm/main.do")
    public String main(ModelMap model) {
        return "god/admin/cmm/AdminCmmMain";
    }

    /**
     * 관리자 공통 메인 json
     * 
     * @param comDefaultVO
     * @param model
     * @return
     */
    @GetMapping("/do/admin/cmm/main.json")
    public String main(ComDefaultVO comDefaultVO, ModelMap model) {
        model.addAttribute("god", "test 이백행 " + LocalDateTime.now());
        return "jsonView";
    }

}
