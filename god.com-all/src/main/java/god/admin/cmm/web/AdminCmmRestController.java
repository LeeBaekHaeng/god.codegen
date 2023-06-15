package god.admin.cmm.web;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.ComDefaultVO;

/**
 * 관리자 공통 RestController
 * 
 * @author 이백행
 *
 */
@RestController
public class AdminCmmRestController {

    /**
     * 관리자 공통 메인 json
     * 
     * @param comDefaultVO
     * @return
     */
    @GetMapping("/rest/admin/cmm/main")
    public Map<String, Object> main(ComDefaultVO comDefaultVO) {
        Map<String, Object> model = new HashMap<>();
        model.put("comDefaultVO", comDefaultVO);
        model.put("god", "test 이백행 " + LocalDateTime.now());
        return model;
    }

}
