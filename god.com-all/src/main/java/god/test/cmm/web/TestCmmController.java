package god.test.cmm.web;

import java.time.LocalDateTime;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.EgovMessageSource;
import god.test.cmm.service.TestCmmService;
import god.test.cmm.service.TestCmmVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestCmmController {

    private final TestCmmService testCmmService;

    private final EgovMessageSource egovMessageSource;

    @GetMapping("/do/test/cmm/selectTestCmmList.do")
    public String selectTestCmmList(final TestCmmVO testCmmVO, final ComDefaultVO comDefaultVO, final ModelMap model) {
        log.debug(egovMessageSource.getMessage("fail.common.msg"));
        log.debug(egovMessageSource.getMessage("fail.common.sql"));
        log.debug(egovMessageSource.getMessageArgs("fail.common.msg",
                new Object[] { "test 이백행 2023-11-11 에러 코드", "test 이백행 2023-11-11 오류 메시지" }));
        log.debug(egovMessageSource.getMessageArgs("fail.common.sql",
                new Object[] { "test 이백행 2023-11-11 에러 코드", "test 이백행 2023-11-11 오류 메시지" }));

        PaginationInfo paginationInfo = new PaginationInfo();
        log.debug("paginationInfo={}", paginationInfo);

        if (!"Y".equals(comDefaultVO.getSearchUseYn())) {
            comDefaultVO.setSearchCondition("01");
            comDefaultVO.setSearchKeyword("test 이백행 " + LocalDateTime.now() + " 검색어");
//            comDefaultVO.setSearchUseYn("Y");
            model.addAttribute("result", "test 이백행 " + LocalDateTime.now());
//        } else if ("Y".equals(comDefaultVO.getSearchUseYn())) {
//            final ObjectMapper mapper = new ObjectMapper();
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            List<ComDefaultVO> results = null;
//            try {
//                results = mapper.readValue("", new TypeReference<List<ComDefaultVO>>() {
//                });
//            } catch (JsonProcessingException e) {
////                e.printStackTrace();
//                log.error("1-1 JsonProcessingException readValue");
////                throw new BaseRuntimeException("1-2 JsonProcessingException readValue");
////                throw new BaseRuntimeException("1-2 JsonProcessingException readValue");
////                throw new BaseRuntimeException(egovMessageSource, "1-2 JsonProcessingException readValue");
//                throw new EgovFileExtensionException("1-2 JsonProcessingException readValue", "fail.common.msg");
//            }
//            log.debug("results={}", results);
        }
        return "god/test/cmm/TestCmmList";
    }

    @GetMapping("/do/test/cmm/selectTestCmm.do")
    public String selectTestCmm(final TestCmmVO testCmmVO, final ComDefaultVO comDefaultVO, final ModelMap model) {
        return "god/test/cmm/TestCmmDetail";
    }

    @GetMapping("/do/test/cmm/insertTestCmmView.do")
    public String insertTestCmmView(final TestCmmVO testCmmVO, final ComDefaultVO comDefaultVO, final ModelMap model) {
        return "god/test/cmm/TestCmmRegist";
    }

    @PostMapping("/do/test/cmm/insertTestCmm.do")
    public String insertTestCmm(final TestCmmVO testCmmVO, final ComDefaultVO comDefaultVO, final ModelMap model) {
        testCmmService.insertTestCmm(testCmmVO, model);
        model.addAttribute("searchKeyword", comDefaultVO.getSearchKeyword());
        model.addAttribute("searchUseYn", "Y");
        model.addAttribute("test", "test 이백행");
//        comDefaultVO.setSearchKeyword("test 이백행");
//        model.addAttribute(comDefaultVO);
        return "redirect:/do/test/cmm/selectTestCmmList.do";
    }

}
