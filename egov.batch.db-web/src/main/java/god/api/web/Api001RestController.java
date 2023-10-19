package god.api.web;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Geocoder API 2.0 레퍼런스
 * 
 * @author 이백행
 * @since 2023-10-19
 */
@RestController
public class Api001RestController {

    /**
     * apikey
     */
    private static final String API_KEY = "B39D552C-5843-33E4-B394-906CC9F51C75";

    /**
     * 주소를 좌표로 변환
     * 
     * @return
     * @throws IOException
     */
    @GetMapping("/api/api001")
    public String api001() throws IOException {
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
          .append(API_KEY)
          .append("&type=")
          .append(searchType)
          .append("&point=")
         .append(searchPoint)
         ;
// @formatter:on

        final String spec = sb.toString();
        final URL url = new URL(spec);
        final URLConnection urlConnection = url.openConnection();
        urlConnection.setConnectTimeout(10_000);
        urlConnection.setReadTimeout(10_000);

        return IOUtils.toString(urlConnection.getInputStream(), StandardCharsets.UTF_8);
    }

}
