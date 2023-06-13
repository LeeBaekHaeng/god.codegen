package god.admin.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 관리자 메인 Controller
 * 
 * @author 이백행
 *
 */
@Controller
public class AdminController {

    /**
     * 관리자 메인
     * 
     * @param model
     * @return
     */
    @RequestMapping("/admin/main.do")
    public String main(ModelMap model) {
        return "god/admin/cmm/AdminMain";
    }

}
