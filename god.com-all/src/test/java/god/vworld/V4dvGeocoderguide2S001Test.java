package god.vworld;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import god.vworld.CoordVO.Response;
import god.vworld.CoordVO.Result;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Geocoder API 2.0 레퍼런스
 * 
 * @author 이백행
 * @since 2023-08-03
 */
@NoArgsConstructor
@Slf4j
public class V4dvGeocoderguide2S001Test {

    /**
     * apikey
     */
    private String apikey = "B39D552C-5843-33E4-B394-906CC9F51C75";

    /**
     * 주소를 좌표로 변환
     */
    @Test
    public void test_a10() {
        // https://www.vworld.kr/dev/v4dv_geocoderguide2_s002.do

        // 오픈API > 지도검색 API 레퍼런스 > Geocoder API 레퍼런스

        // Geocoder API 2.0 레퍼런스

        // 좌표를 주소로 변환

        // http://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=126.978275264,37.566642192&format=xml&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

        // http://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=127.3768023,36.3597805&format=xml&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

        // https://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=127.3768023,36.3597805&format=json&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

//        String apikey = "[인증키]";
//        String apikey = "B39D552C-5843-33E4-B394-906CC9F51C75";
//        String searchType = "road";
        final String searchType = "both";
//        String searchPoint = "127.101313354,37.402352535";
        final String searchPoint = "127.3768023,36.3597805";
//        String searchPoint = gpsDirectory.getGeoLocation().getLatitude() + ","
//                + gpsDirectory.getGeoLocation().getLongitude();
        final String epsg = "epsg:4326";

        final StringBuffer sb = new StringBuffer(1600);
//        sb.append("https://api.vworld.kr/req/address");
//        sb.append("?service=address");
//        sb.append("&request=getaddress");
////        sb.append("&format=json");
////        sb.append("&format=xml");
//        sb.append("&crs=");
//        sb.append(epsg);
//        sb.append("&key=");
//        sb.append(apikey);
//        sb.append("&type=");
//        sb.append(searchType);
//        sb.append("&point=");
//        sb.append(searchPoint);

// @formatter:off
        sb.append("https://api.vworld.kr/req/address")
          .append("?service=address")
          .append("&request=getaddress")
//        .append("&format=json")
//        .append("&format=xml")
          .append("&crs=")
          .append(epsg)
          .append("&key=")
          .append(apikey)
          .append("&type=")
          .append(searchType)
          .append("&point=")
         .append(searchPoint)
         ;
// @formatter:on

        final String spec = sb.toString();

        URL url = null;
        try {
            url = new URL(spec);
        } catch (MalformedURLException e) {
//            e.printStackTrace();
            log.error("MalformedURLException URL");
        }

        String s = null;

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
        }

        CoordVO coordVO = null;
        final ObjectMapper mapper = new ObjectMapper();
//        final XmlMapper mapper = new XmlMapper();
//        final ObjectMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            coordVO = mapper.readValue(s, CoordVO.class);
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
            log.error("JsonProcessingException readValue");
        }

        debug(coordVO);

        assertEquals("", "", "");
    }

    /**
     * 주소를 좌표로 변환
     */
    @Test
    public void test_b10() {
        // https://www.vworld.kr/dev/v4dv_geocoderguide2_s002.do

        // 오픈API > 지도검색 API 레퍼런스 > Geocoder API 레퍼런스

        // Geocoder API 2.0 레퍼런스

        // 좌표를 주소로 변환

        // http://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=126.978275264,37.566642192&format=xml&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

        // http://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=127.3768023,36.3597805&format=xml&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

        // https://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=127.3768023,36.3597805&format=json&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

//        String apikey = "[인증키]";
//        String apikey = "B39D552C-5843-33E4-B394-906CC9F51C75";
//        String searchType = "road";
        final String searchType = "both";
//        String searchPoint = "127.101313354,37.402352535";
        final String searchPoint = "127.3768023,36.3597805";
//        String searchPoint = gpsDirectory.getGeoLocation().getLatitude() + ","
//                + gpsDirectory.getGeoLocation().getLongitude();
        final String epsg = "epsg:4326";

        final StringBuffer sb = new StringBuffer(1600);
//        sb.append("https://api.vworld.kr/req/address");
//        sb.append("?service=address");
//        sb.append("&request=getaddress");
////        sb.append("&format=json");
////        sb.append("&format=xml");
//        sb.append("&crs=");
//        sb.append(epsg);
//        sb.append("&key=");
//        sb.append(apikey);
//        sb.append("&type=");
//        sb.append(searchType);
//        sb.append("&point=");
//        sb.append(searchPoint);

// @formatter:off
        sb.append("https://api.vworld.kr/req/address")
        .append("?service=address")
        .append("&request=getaddress")
//        .append("&format=json")
        .append("&format=xml")
        .append("&crs=")
        .append(epsg)
        .append("&key=")
        .append(apikey)
        .append("&type=")
        .append(searchType)
        .append("&point=")
        .append(searchPoint)
        ;
// @formatter:on

        final String spec = sb.toString();

        URL url = null;
        try {
            url = new URL(spec);
        } catch (MalformedURLException e) {
//            e.printStackTrace();
            log.error("MalformedURLException URL");
        }

        String s = null;

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
        }

        Response response = null;
//        final ObjectMapper mapper = new ObjectMapper();
        final XmlMapper mapper = new XmlMapper();
//        final ObjectMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            response = mapper.readValue(s, Response.class);
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
            log.error("JsonProcessingException readValue");
        }

        final CoordVO coordVO = new CoordVO();
        coordVO.setResponse(response);
        debug(coordVO);

        assertEquals("", "", "");
    }

    private void debug(final CoordVO coordVO) {
        if (log.isDebugEnabled()) {
            log.debug("result={}", coordVO);
            log.debug("getResponse={}", coordVO.getResponse());

            log.debug("getService={}", coordVO.getResponse().getService());
            log.debug("getName={}", coordVO.getResponse().getService().getName());
            log.debug("getVersion={}", coordVO.getResponse().getService().getVersion());
            log.debug("getOperation={}", coordVO.getResponse().getService().getOperation());
            log.debug("getTime={}", coordVO.getResponse().getService().getTime());

            log.debug("getStatus={}", coordVO.getResponse().getStatus());

            log.debug("getError={}", coordVO.getResponse().getError());
            if (coordVO.getResponse().getError() != null) {
                log.debug("getLevel={}", coordVO.getResponse().getError().getLevel());
                log.debug("getCode={}", coordVO.getResponse().getError().getCode());
                log.debug("getText={}", coordVO.getResponse().getError().getText());
            }

            log.debug("getInput={}", coordVO.getResponse().getInput());
            log.debug("getPoint={}", coordVO.getResponse().getInput().getPoint());
            log.debug("getX={}", coordVO.getResponse().getInput().getPoint().getX());
            log.debug("getY={}", coordVO.getResponse().getInput().getPoint().getY());
            log.debug("getCrs={}", coordVO.getResponse().getInput().getCrs());
            log.debug("getType={}", coordVO.getResponse().getInput().getType());

            log.debug("getResult={}", coordVO.getResponse().getResult());
            for (final Result result : coordVO.getResponse().getResult()) {
                log.debug("getZipcode={}", result.getZipcode());
                log.debug("getType={}", result.getType());
                log.debug("getText={}", result.getText());

                log.debug("getStructure={}", result.getStructure());
                log.debug("getLevel0={}", result.getStructure().getLevel0());
                log.debug("getLevel1={}", result.getStructure().getLevel1());
                log.debug("getLevel2={}", result.getStructure().getLevel2());
                log.debug("getLevel3={}", result.getStructure().getLevel3());
                log.debug("getLevel4L={}", result.getStructure().getLevel4L());
                log.debug("getLevel4LC={}", result.getStructure().getLevel4LC());
                log.debug("getLevel4A={}", result.getStructure().getLevel4A());
                log.debug("getLevel4AC={}", result.getStructure().getLevel4AC());
                log.debug("getLevel5={}", result.getStructure().getLevel5());
                log.debug("getDetail={}", result.getStructure().getDetail());
            }
        }
    }

}
