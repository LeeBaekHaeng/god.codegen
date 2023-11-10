package god.com.cmm.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import lombok.Data;

/**
 * 공통 RestController
 * 
 * @author 이백행
 *
 */
@RestController
public class ComCmmUseRestController {
    /**
     * 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기 위한 서비스 인터페이스
     */
    private final transient EgovCmmUseService egovCmmUseService;

    /**
     * Constructor-based Dependency Injection 생성자 기반 종속성 주입
     * 
     * @param egovCmmUseService
     */
    public ComCmmUseRestController(final EgovCmmUseService egovCmmUseService) {
        super();
        this.egovCmmUseService = egovCmmUseService;
    }

    /**
     * v1 공통코드목록조회
     * 
     * @param requestDto
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/rest/com/cmm/v1/cmmcodedetail")
    public List<GetV1CmmCodeDetailListResponseDto> getV1CmmCodeDetailList(
            final GetV1CmmCodeDetailListRequestDto requestDto) throws Exception {
        final ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
        comDefaultCodeVO.setCodeId(requestDto.getCodeId());

        final List<CmmnDetailCode> items = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);
        final List<GetV1CmmCodeDetailListResponseDto> responseDtos = new ArrayList<>();
        for (final CmmnDetailCode item : items) {
            final GetV1CmmCodeDetailListResponseDto responseDto = new GetV1CmmCodeDetailListResponseDto();
            responseDto.setCodeId(item.getCodeId());
            responseDto.setCode(item.getCode());
            responseDto.setCodeNm(item.getCodeNm());
            responseDto.setCodeDc(item.getCodeDc());
            responseDtos.add(responseDto);
        }

        return responseDtos;
    }

    /**
     * v1 공통코드목록조회 요청 Dto
     * 
     * @author 이백행
     *
     */
    @Data
    public static class GetV1CmmCodeDetailListRequestDto {
        /**
         * 코드 ID
         */
        private String codeId;
    }

    /**
     * v1 공통코드목록조회 응답 Dto
     * 
     * @author 이백행
     *
     */
    @Data
    public static class GetV1CmmCodeDetailListResponseDto {
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
     * v2 공통코드목록조회
     * 
     * @param requestDto
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/rest/com/cmm/v2/cmmcodedetail/{codeId}")
    public List<GetV2CmmCodeDetailListResponseDto> getV2CmmCodeDetailList(final @PathVariable String codeId)
            throws Exception {
        final ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
        comDefaultCodeVO.setCodeId(codeId);

        final List<CmmnDetailCode> items = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);
        final List<GetV2CmmCodeDetailListResponseDto> responseDtos = new ArrayList<>();
        for (final CmmnDetailCode item : items) {
            final GetV2CmmCodeDetailListResponseDto responseDto = new GetV2CmmCodeDetailListResponseDto();
            responseDto.setCodeId(item.getCodeId());
            responseDto.setCode(item.getCode());
            responseDto.setCodeNm(item.getCodeNm());
            responseDto.setCodeDc(item.getCodeDc());
            responseDtos.add(responseDto);
        }

        return responseDtos;
    }

    /**
     * v2 공통코드목록조회 응답 Dto
     * 
     * @author 이백행
     *
     */
    @Data
    private static class GetV2CmmCodeDetailListResponseDto {
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
}
