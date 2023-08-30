package egovframework.com.god.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.god.util.GetAddressVO.Response;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * 브이월드 유틸
 * 
 * @author 이백행
 * @since 2023-08-30
 */
//@NoArgsConstructor
@Slf4j
@UtilityClass
public class VworldUtils {

    /**
     * PARCEL : 지번주소
     */
    public static final String GET_ADDRESS_TYPE_PARCEL = "parcel";

    /**
     * ROAD : 도로명주소
     */
    public static final String GET_ADDRESS_TYPE_ROAD = "road";

    /**
     * BOTH(기본값) : 도로명주소, 지번주소
     */
    public static final String GET_ADDRESS_TYPE_BOTH = "both";

    /**
     * 처리 결과의 상태 표시, 유효값 : OK(성공)
     */
    public static final String GET_ADDRESS_STATUS_OK = "OK";

    /**
     * 처리 결과의 상태 표시, 유효값 : NOT_FOUND(결과없음)
     */
    public static final String GET_ADDRESS_STATUS_NOT_FOUND = "NOT_FOUND";

    /**
     * 처리 결과의 상태 표시, 유효값 : ERROR(에러)
     */
    public static final String GET_ADDRESS_STATUS_ERROR = "ERROR";

    /**
     * 좌표를 주소로 변환
     * 
     * <pre>
     * Geocoder API 2.0 레퍼런스
     * 
     * https://www.vworld.kr/dev/v4dv_geocoderguide2_s002.do
     * </pre>
     * 
     * @param point
     */
    public static GetAddressVO getAddress(final String point, final String type) {
        GetAddressVO getAddressVO;

//        final String apikey = "[인증키]";
        final String apikey = "B39D552C-5843-33E4-B394-906CC9F51C75";
//        final String searchType = "road";
//        final String searchType = "both";
//        final String searchType = "parcel";
//        final String searchPoint = "127.101313354,37.402352535";
        final String epsg = "epsg:4326";

        final StringBuilder sb = new StringBuilder(1600);

// @formatter:off
        sb.append("https://api.vworld.kr/req/address")
//        sb.append("https://61.97.240.69/req/address")
        .append("?service=address")
        .append("&request=getaddress")
        .append("&format=json")
        .append("&crs=" + epsg)
        .append("&key=" + apikey)
        .append("&type=" + type)
        .append("&point=" + point)
        ;
// @formatter:on

        final String spec = sb.toString();

        URL url;
        try {
            url = new URL(spec);
        } catch (MalformedURLException e) {
//            e.printStackTrace();
            log.error("MalformedURLException URL");

            getAddressVO = new GetAddressVO();
            final Response response = new Response();
            response.setStatus(GET_ADDRESS_STATUS_ERROR);
            final egovframework.com.god.util.GetAddressVO.Error error = new egovframework.com.god.util.GetAddressVO.Error();
            error.setText(e.getMessage());
            response.setError(error);
            getAddressVO.setResponse(response);
            return getAddressVO;
        }

        String s;

        URLConnection urlConnection;
        try {
            urlConnection = url.openConnection();
            urlConnection.setConnectTimeout(10_000);
            urlConnection.setReadTimeout(10_000);
            s = IOUtils.toString(urlConnection.getInputStream(), StandardCharsets.UTF_8);
            if (log.isDebugEnabled()) {
                log.debug(s);
            }
        } catch (IOException e) {
//            e.printStackTrace();
            log.error("IOException openConnection getInputStream toString");

            getAddressVO = new GetAddressVO();
            final Response response = new Response();
            response.setStatus(GET_ADDRESS_STATUS_ERROR);
            final egovframework.com.god.util.GetAddressVO.Error error = new egovframework.com.god.util.GetAddressVO.Error();
            error.setText(e.getMessage());
            response.setError(error);
            getAddressVO.setResponse(response);
            return getAddressVO;
        }

        final ObjectMapper mapper = new ObjectMapper();
//        final XmlMapper mapper = new XmlMapper();
//        final ObjectMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            getAddressVO = mapper.readValue(s, GetAddressVO.class);
        } catch (JsonMappingException e) {
//            e.printStackTrace();
            log.error("JsonMappingException readValue");

            getAddressVO = new GetAddressVO();
            final Response response = new Response();
            response.setStatus(GET_ADDRESS_STATUS_ERROR);
            final egovframework.com.god.util.GetAddressVO.Error error = new egovframework.com.god.util.GetAddressVO.Error();
            error.setText(e.getMessage());
            response.setError(error);
            getAddressVO.setResponse(response);
            return getAddressVO;
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
            log.error("JsonProcessingException readValue");

            getAddressVO = new GetAddressVO();
            final Response response = new Response();
            response.setStatus(GET_ADDRESS_STATUS_ERROR);
            final egovframework.com.god.util.GetAddressVO.Error error = new egovframework.com.god.util.GetAddressVO.Error();
            error.setText(e.getMessage());
            response.setError(error);
            getAddressVO.setResponse(response);
            return getAddressVO;
        }

        return getAddressVO;
    }

}
