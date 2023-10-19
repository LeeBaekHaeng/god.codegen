package god.api.web;

import java.util.List;

import org.junit.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import god.api.cmm.service.ApiGlobals;
import god.api.web.ApiTest001.Api001Result.Result;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiTest001 {

    @Test
    public void test() throws JsonMappingException, JsonProcessingException {
//        RestTemplate restTemplate = new RestTemplate();

        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        final int timeout = 10_000;
        requestFactory.setConnectTimeout(timeout);
        requestFactory.setConnectionRequestTimeout(timeout);
        requestFactory.setReadTimeout(timeout);
        final RestTemplate restTemplate = new RestTemplate(requestFactory);

//        final String content = restTemplate.getForObject("http://localhost:9300/api/api001", String.class);
        final String content = restTemplate.getForObject(ApiGlobals.LOCALHOST_9300 + "/api/api001", String.class);
        log.debug("content={}", content);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Api001Result api001Result = mapper.readValue(content, Api001Result.class);
        log.debug("api001Result={}", api001Result);
        log.debug("getResponse={}", api001Result.getResponse());

        log.debug("getService={}", api001Result.getResponse().getService());
        log.debug("getName={}", api001Result.getResponse().getService().getName());
        log.debug("getVersion={}", api001Result.getResponse().getService().getVersion());

        log.debug("getResult={}", api001Result.getResponse().getResult());
        for (final Result result : api001Result.getResponse().getResult()) {
            log.debug("result={}", result);
            log.debug("getZipcode={}", result.getZipcode());
            log.debug("getType={}", result.getType());
            log.debug("getText={}", result.getText());
        }
    }

    static class Api001Result {

        private Response response;

        public Response getResponse() {
            return response;
        }

        public void setResponse(Response response) {
            this.response = response;
        }

        static class Response {
            private Service service;
            private List<Result> result;

            public Service getService() {
                return service;
            }

            public void setService(Service service) {
                this.service = service;
            }

            public List<Result> getResult() {
                return result;
            }

            public void setResult(List<Result> result) {
                this.result = result;
            }
        }

        static class Service {
            private String name;
            private String version;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }
        }

        static class Result {
            private String zipcode;
            private String type;
            private String text;

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

    }

}
