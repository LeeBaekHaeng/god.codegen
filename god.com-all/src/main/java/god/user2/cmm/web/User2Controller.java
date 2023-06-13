package god.user2.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 사용자2 메인 Controller
 * 
 * @author 이백행
 *
 */
@Controller
public class User2Controller {

    /**
     * 사용자2 메인
     * 
     * @param model
     * @return
     */
    @RequestMapping("/user2/main.do")
    public String main(ModelMap model) {
        return "god/user2/cmm/User2Main";
    }

}
