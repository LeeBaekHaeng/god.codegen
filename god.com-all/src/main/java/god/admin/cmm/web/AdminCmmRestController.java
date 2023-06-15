package god.admin.cmm.web;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public Map<String, Object> main(ComDefaultVO comDefaultVO) {
        Map<String, Object> model = new HashMap<>();
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
    public GodResponseMessageDTO mainv1(GodRequestMessageDTO godRequestMessageDTO, ComDefaultVO comDefaultVO) {
        log.debug("godRequestMessageDTO={}", godRequestMessageDTO);

        GodResponseMessageDTO godResponseMessageDTO = new GodResponseMessageDTO();
        ComMsgHeader comMsgHeader = new ComMsgHeader();
        comMsgHeader.setRequestMsgID("test 이백행 요청 메시지 ID " + LocalDateTime.now());
        comMsgHeader.setResponseTime(LocalDateTime.now().toString());
        comMsgHeader.setResponseMsgID(UUID.randomUUID().toString());
        comMsgHeader.setSuccessYN(SuccessYN.Y);
        comMsgHeader.setReturnCode(ReturnCode.A00);
        godResponseMessageDTO.setComMsgHeader(comMsgHeader);

        log.debug("godResponseMessageDTO={}", godResponseMessageDTO);

        return godResponseMessageDTO;
    }

}
