package god.user.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 사용자 메인 Controller
 * 
 * @author 이백행
 *
 */
@Controller
public class UserController {

    /**
     * 사용자 메인
     * 
     * @param model
     * @return
     */
    @RequestMapping("/user/main.do")
    public String main(ModelMap model) {
        return "god/user/cmm/UserMain";
    }

}
