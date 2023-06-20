package god.com.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;

/**
 * 공통 Controller
 * 
 * @author 이백행
 *
 */
@Controller
public class ComCmmUseController {

    /**
     * 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기 위한 서비스 인터페이스
     */
    private final transient EgovCmmUseService egovCmmUseService;

    /**
     * Constructor-based Dependency Injection 생성자 기반 종속성 주입
     * 
     * @param egovCmmUseService
     */
    public ComCmmUseController(final EgovCmmUseService egovCmmUseService) {
        super();
        this.egovCmmUseService = egovCmmUseService;
    }

    /**
     * 공통코드를 조회한다.
     * 
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/do/com/cmm/selectCmmCodeDetail.do")
    public String selectCmmCodeDetail(final ComDefaultCodeVO comDefaultCodeVO, final ModelMap model) throws Exception {
        model.addAttribute(egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO));
        return "jsonView";
    }

}
