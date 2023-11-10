package god.com.cmm.web;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.exception.EgovFileExtensionException;
import god.com.cmm.web.ComCmmUseRestController.GetV1CmmCodeDetailListResponseDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComCmmUseRestControllerTest {

    @Test
    public void test() {
        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        final int timeout = 10_000;
        requestFactory.setConnectTimeout(timeout);
        requestFactory.setConnectionRequestTimeout(timeout);
        requestFactory.setReadTimeout(timeout);
        final RestTemplate restTemplate = new RestTemplate(requestFactory);

        final String content = restTemplate.getForObject(
                "http://localhost:8080/egovframework-all-in-one/rest/com/cmm/v1/cmmcodedetail?codeId=COM001",
                String.class);
        log.debug("content={}", content);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<GetV1CmmCodeDetailListResponseDto> results = null;
        try {
            results = mapper.readValue(content, new TypeReference<List<GetV1CmmCodeDetailListResponseDto>>() {
            });
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
            log.error("JsonProcessingException readValue");
//            fail("JsonProcessingException readValue");
            throw new AssertionError("JsonProcessingException readValue");
        }
        log.debug("results={}", results);
        for (final GetV1CmmCodeDetailListResponseDto result : results) {
            log.debug("result={}", result);
            log.debug("getCodeId={}", result.getCodeId());
            log.debug("getCode={}", result.getCode());
            log.debug("getCodeNm={}", result.getCodeNm());
            log.debug("getCodeDc={}", result.getCodeDc());
        }
    }

    @Test(expected = EgovFileExtensionException.class)
    public void test2() {

        log.debug("s");
        try {
            test2a();
        } catch (EgovFileExtensionException e) {
//            e.printStackTrace();
            log.error("2-1 EgovFileExtensionException test2a");
            log.error("getMessage={}", e.getMessage());
            log.error("getMessageKey={}", e.getMessageKey());
//            log.error(e.getMessageParameters().toString());
            log.error("getLocalizedMessage={}", e.getLocalizedMessage());
//            fail("EgovFileExtensionException test2a");
        }
        log.debug("e");
    }

    private void test2a() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<GetV1CmmCodeDetailListResponseDto> results = null;
        try {
            results = mapper.readValue("", new TypeReference<List<GetV1CmmCodeDetailListResponseDto>>() {
            });
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
            log.error("1-1 JsonProcessingException readValue");
//            fail("JsonProcessingException readValue");
//            throw new JsonProcessingException();
//            throw new IllegalArgumentException("JsonProcessingException readValue");
//            throw new EgovFileExtensionException("2 JsonProcessingException readValue", "fail.common.msg");
//            throw new EgovFileExtensionException(null, "fail.common.msg");
//            throw new EgovFileExtensionException(null, "errors.file.extension.none");
            throw new EgovFileExtensionException("1-2 JsonProcessingException readValue", "fail.common.msg");
//            throw new EgovXssException("", "");
//            throw new BaseException("JsonProcessingException readValue");
//            throw new BaseRuntimeException("JsonProcessingException readValue");
//            throw new EgovBizException("JsonProcessingException readValue");
//            throw new FdlException("JsonProcessingException readValue");
        }
        log.debug("results={}", results);
    }

    @Test(expected = BaseRuntimeException.class)
    public void test3() {

        log.debug("s");
        try {
            test3a();
        } catch (BaseRuntimeException e) {
//            e.printStackTrace();
            log.error("2-1 EgovFileExtensionException test2a");
            log.error("getMessage={}", e.getMessage());
            log.error("getMessageKey={}", e.getMessageKey());
//            log.error(e.getMessageParameters().toString());
            log.error("getLocalizedMessage={}", e.getLocalizedMessage());
//            fail("EgovFileExtensionException test2a");
        }
        log.debug("e");

        log.debug("s-2");
        test3a();
        log.debug("e-2");
    }

    private void test3a() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<GetV1CmmCodeDetailListResponseDto> results = null;
        try {
            results = mapper.readValue("", new TypeReference<List<GetV1CmmCodeDetailListResponseDto>>() {
            });
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
            log.error("1-1 JsonProcessingException readValue");
            throw new BaseRuntimeException("1-2 JsonProcessingException readValue");
        }
        log.debug("results={}", results);
    }

}
