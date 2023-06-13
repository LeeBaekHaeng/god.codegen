package god.admin2.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 관리자2 메인 Controller
 * 
 * @author 이백행
 *
 */
@Controller
public class Admin2Controller {

    /**
     * 관리자2 메인
     * 
     * @param model
     * @return
     */
    @RequestMapping("/admin2/main.do")
    public String main(ModelMap model) {
        return "god/admin2/cmm/Admin2Main";
    }

}
