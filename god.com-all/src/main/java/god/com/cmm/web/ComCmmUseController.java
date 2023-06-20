package god.com.cmm.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import lombok.Data;

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
        model.addAttribute("result", egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO));
        return "jsonView";
    }

    /**
     * 공통코드를 조회한다.
     * 
     * @param requestDto
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/do/com/cmm/select2CmmCodeDetail.do")
    public String select2CmmCodeDetail(final Select2CmmCodeDetailRequestDto requestDto, final ModelMap model)
            throws Exception {
        final ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
        comDefaultCodeVO.setCodeId(requestDto.getCodeId());

        final List<CmmnDetailCode> items = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);
        final List<Select2CmmCodeDetailResponseDto> resultList = new ArrayList<>();
        for (final CmmnDetailCode item : items) {
            final Select2CmmCodeDetailResponseDto responseDto = new Select2CmmCodeDetailResponseDto();
            responseDto.setCodeId(item.getCodeId());
            responseDto.setCode(item.getCode());
            responseDto.setCodeNm(item.getCodeNm());
            responseDto.setCodeDc(item.getCodeDc());
            resultList.add(responseDto);
        }
        model.addAttribute("resultList", resultList);

        return "jsonView";
    }

    /**
     * 공통코드를 조회한다. 요청 Dto
     * 
     * @author 이백행
     *
     */
    @Data
    private static class Select2CmmCodeDetailRequestDto {
        /**
         * 코드 ID
         */
        private String codeId;
    }

    /**
     * 공통코드를 조회한다. 응답 Dto
     * 
     * @author 이백행
     *
     */
    @Data
    private static class Select2CmmCodeDetailResponseDto {
        /**
         * 코드ID
         */
        private String codeId;

        /**
         * 상세코드
         */
        private String code;

        /**
         * 상세코드명
         */
        private String codeNm;

        /**
         * 상세코드설명
         */
        private String codeDc;
    }

    /**
     * ComDefaultCodeVO의 리스트를 받아서 여러개의 코드 리스트를 맵에 담아서 리턴한다.
     * 
     * @param requestDto
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/do/com/cmm/selectCmmCodeDetails.do")
    public String selectCmmCodeDetails(final SelectCmmCodeDetailsRequestDto requestDto, final ModelMap model)
            throws Exception {
        List<ComDefaultCodeVO> voList = new ArrayList<>();
        for (String codeId : requestDto.getCodeId()) {
            ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
            comDefaultCodeVO.setCodeId(codeId);
            voList.add(comDefaultCodeVO);
        }

        model.addAttribute("resultList", egovCmmUseService.selectCmmCodeDetails(voList));

        return "jsonView";
    }

    /**
     * ComDefaultCodeVO의 리스트를 받아서 여러개의 코드 리스트를 맵에 담아서 리턴한다. 요청 Dto
     * 
     * @author 이백행
     *
     */
    @Data
    private static class SelectCmmCodeDetailsRequestDto {
        /**
         * 코드 ID
         */
        private List<String> codeId;
    }
}
