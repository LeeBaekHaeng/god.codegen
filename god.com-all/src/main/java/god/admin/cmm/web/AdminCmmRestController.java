package god.admin.cmm.web;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.ComDefaultVO;
import god.admin.cmm.service.GodRequestMessageDTO;
import god.admin.cmm.service.GodResponseMessageDTO;
import god.admin.cmm.service.GodResponseMessageDTO.ComMsgHeader;
import god.admin.cmm.service.GodResponseMessageDTO.ReturnCode;
import god.admin.cmm.service.GodResponseMessageDTO.SuccessYN;
import lombok.extern.slf4j.Slf4j;

/**
 * 관리자 공통 RestController
 * 
 * @author 이백행
 *
 */
@RestController
@Slf4j
public class AdminCmmRestController {

    /**
     * 관리자 공통 메인 json
     * 
     * @param comDefaultVO
     * @return
     */
    @GetMapping("/rest/admin/cmm/main")
    public Map<String, Object> main(final ComDefaultVO comDefaultVO) {
        final Map<String, Object> model = new ConcurrentHashMap<>();
        model.put("comDefaultVO", comDefaultVO);
        model.put("god", "test 이백행 " + LocalDateTime.now());
        return model;
    }

    /**
     * 관리자 공통 메인 json
     * 
     * @param comDefaultVO
     * @return
     */
    @GetMapping("/rest/admin/cmm/main/v1")
    public GodResponseMessageDTO<Mainv1ResDto> mainv1(final GodRequestMessageDTO godRequestMessageDTO,
            final ComDefaultVO comDefaultVO) {
        log.debug("godRequestMessageDTO={}", godRequestMessageDTO);

        final GodResponseMessageDTO<Mainv1ResDto> godResponseMessageDTO = new GodResponseMessageDTO<>();
        final ComMsgHeader comMsgHeader = new ComMsgHeader();
        comMsgHeader.setRequestMsgID("test 이백행 요청 메시지 ID " + LocalDateTime.now());
        comMsgHeader.setResponseTime(LocalDateTime.now().toString());
        comMsgHeader.setResponseMsgID(UUID.randomUUID().toString());
        comMsgHeader.setSuccessYN(SuccessYN.Y);
        comMsgHeader.setReturnCode(ReturnCode.A00);
        godResponseMessageDTO.setComMsgHeader(comMsgHeader);

//        final ModelMap model = new ModelMap();
//        model.put("a", "에이");
//        model.put("a2", "에이2");

        Mainv1ResDto mainv1ResDto = new Mainv1ResDto();
        mainv1ResDto.setA("에이");
        mainv1ResDto.setA2("에이2");

        godResponseMessageDTO.setMsgBody(mainv1ResDto);

        log.debug("godResponseMessageDTO={}", godResponseMessageDTO);

        return godResponseMessageDTO;
    }

    static class Mainv1ResDto {

        private String a;
        private String a2;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getA2() {
            return a2;
        }

        public void setA2(String a2) {
            this.a2 = a2;
        }

    }

}
