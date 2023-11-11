package god.test.cmm.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.exception.EgovFileExtensionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestCmmController {

    private final EgovMessageSource egovMessageSource;

    @GetMapping("/do/test/cmm/selectTestCmmList.do")
    public String selectTestCmmList(final ComDefaultVO comDefaultVO, final ModelMap model) {
        if (!"Y".equals(comDefaultVO.getSearchUseYn())) {
            comDefaultVO.setSearchCondition("01");
            comDefaultVO.setSearchKeyword("test 이백행 " + LocalDateTime.now() + " 검색어");
//            comDefaultVO.setSearchUseYn("Y");
            model.addAttribute("result", "test 이백행 " + LocalDateTime.now());
        } else if ("Y".equals(comDefaultVO.getSearchUseYn())) {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<ComDefaultVO> results = null;
            try {
                results = mapper.readValue("", new TypeReference<List<ComDefaultVO>>() {
                });
            } catch (JsonProcessingException e) {
//                e.printStackTrace();
                log.error("1-1 JsonProcessingException readValue");
//                throw new BaseRuntimeException("1-2 JsonProcessingException readValue");
//                throw new BaseRuntimeException("1-2 JsonProcessingException readValue");
//                throw new BaseRuntimeException(egovMessageSource, "1-2 JsonProcessingException readValue");
                throw new EgovFileExtensionException("1-2 JsonProcessingException readValue", "fail.common.msg");
            }
            log.debug("results={}", results);
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
