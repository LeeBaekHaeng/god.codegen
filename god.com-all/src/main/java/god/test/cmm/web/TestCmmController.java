package god.test.cmm.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.com.cmm.ComDefaultVO;

@Controller
public class TestCmmController {

    @GetMapping("/do/test/cmm/selectTestCmmList.do")
    public String selectTestCmmList(final ComDefaultVO comDefaultVO, final ModelMap model) {
        if (!"Y".equals(comDefaultVO.getSearchUseYn())) {
            comDefaultVO.setSearchCondition("01");
            comDefaultVO.setSearchKeyword("test 이백행 " + LocalDateTime.now() + " 검색어");
//            comDefaultVO.setSearchUseYn("Y");
            model.addAttribute("result", "test 이백행 " + LocalDateTime.now());
        }
        return "god/test/cmm/TestCmmList";
    }

    @GetMapping("/do/test/cmm/selectTestCmm.do")
    public String selectTestCmm(final ComDefaultVO comDefaultVO, final ModelMap model) {
        return "god/test/cmm/TestCmmDetail";
    }

    @GetMapping("/do/test/cmm/insertTestCmmView.do")
    public String insertTestCmmView(final ComDefaultVO comDefaultVO, final ModelMap model) {
        return "god/test/cmm/TestCmmRegist";
    }

    @PostMapping("/do/test/cmm/insertTestCmm.do")
    public String insertTestCmm(final ComDefaultVO comDefaultVO, final ModelMap model) {
        model.addAttribute("searchKeyword", comDefaultVO.getSearchKeyword());
        model.addAttribute("searchUseYn", "Y");
        model.addAttribute("test", "test 이백행");
//        comDefaultVO.setSearchKeyword("test 이백행");
//        model.addAttribute(comDefaultVO);
        return "redirect:/do/test/cmm/selectTestCmmList.do";
    }

}
