package egovframework.com.god.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 브이월드 테스트
 * 
 * @author 이백행
 * @since 2023-08-30
 */
@Slf4j
@NoArgsConstructor
public class VworldUtilsTest {

    /**
     * 좌표를 주소로 변환
     */
    @Test
    public void testgetAddress() {
        // given
        final String point = "127.101313354,37.402352535"; // 처리 결과의 상태 표시, 유효값 : OK(성공)
//        final String point = "127.1,37.4"; // 처리 결과의 상태 표시, 유효값 : NOT_FOUND(결과없음)
//        final String point = "127.101313354,37.402352535-error"; // 처리 결과의 상태 표시, 유효값 : ERROR(에러)

        // when
        final GetAddressVO getAddressVO = VworldUtils.getAddress(point, VworldUtils.GET_ADDRESS_TYPE_ROAD);

        // then
        if (VworldUtils.GET_ADDRESS_STATUS_OK.equals(getAddressVO.getResponse().getStatus())) {

            if (log.isDebugEnabled()) {
                log.debug("getStatus={}", getAddressVO.getResponse().getStatus());
                log.debug("getText={}", getAddressVO.getResponse().getResult().get(0).getText());
            }

            assertEquals("에러가 발생했습니다!", VworldUtils.GET_ADDRESS_STATUS_OK, getAddressVO.getResponse().getStatus());
        } else if (VworldUtils.GET_ADDRESS_STATUS_NOT_FOUND.equals(getAddressVO.getResponse().getStatus())) {
            if (log.isDebugEnabled()) {
                log.debug("getStatus={}", getAddressVO.getResponse().getStatus());
            }

            assertEquals("에러가 발생했습니다!", VworldUtils.GET_ADDRESS_STATUS_NOT_FOUND,
                    getAddressVO.getResponse().getStatus());
        } else if (VworldUtils.GET_ADDRESS_STATUS_ERROR.equals(getAddressVO.getResponse().getStatus())
                && log.isDebugEnabled()) {
            log.debug("getStatus={}", getAddressVO.getResponse().getStatus());
            log.debug("getLevel={}", getAddressVO.getResponse().getError().getLevel());
            log.debug("getCode={}", getAddressVO.getResponse().getError().getCode());
            log.debug("getText={}", getAddressVO.getResponse().getError().getText());

            assertEquals("에러가 발생했습니다!", VworldUtils.GET_ADDRESS_STATUS_ERROR, getAddressVO.getResponse().getStatus());
        }
    }

}
