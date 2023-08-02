package god.com.drew;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDescriptor;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ImageMetadataReaderTest
 * 
 * @author 이백행
 * @since 2023-08-02
 */
@NoArgsConstructor
@Slf4j
public class ImageMetadataReaderTest {

    /**
     * test
     */
    @Test
    public void test() {
        final File jpegFile = new File("src/test/resources/god/com/drew/20230802_155003.jpg");
        Metadata metadata = null;
        try {
            metadata = ImageMetadataReader.readMetadata(jpegFile);
        } catch (ImageProcessingException e) {
//            e.printStackTrace();
            log.error("ImageProcessingException");
        } catch (IOException e) {
//            e.printStackTrace();
            log.error("IOException");
        }

        for (final Directory directory : metadata.getDirectories()) {
            for (final Tag tag : directory.getTags()) {
                log.debug("tag={}", tag);
            }
        }

        test2(metadata);
        test3(metadata);

        assertEquals("", "", "");
    }

    /**
     * Query the raw value of a specific Tag
     * 
     * 특정 태그의 원시 값 쿼리
     * 
     * @param metadata
     */
    private void test2(final Metadata metadata) {
        // obtain the Exif directory
        final ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

        // query the tag's value
        final Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        log.debug("date={}", date);

        final GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
        if (log.isDebugEnabled()) {
            log.debug("getLatitude={}", gpsDirectory.getGeoLocation().getLatitude());
            log.debug("getLongitude={}", gpsDirectory.getGeoLocation().getLongitude());
        }

        // https://www.vworld.kr/dev/v4dv_geocoderguide2_s002.do

        // 오픈API > 지도검색 API 레퍼런스 > Geocoder API 레퍼런스

        // Geocoder API 2.0 레퍼런스

        // 좌표를 주소로 변환

        // http://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=126.978275264,37.566642192&format=xml&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

        // http://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=127.3768023,36.3597805&format=xml&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

        // https://api.vworld.kr/req/address?service=address&request=getAddress&version=2.0&crs=epsg:4326&point=127.3768023,36.3597805&format=json&type=both&zipcode=true&simple=false&key=B39D552C-5843-33E4-B394-906CC9F51C75

//        String apikey = "[인증키]";
        String apikey = "B39D552C-5843-33E4-B394-906CC9F51C75";
//        String searchType = "road";
        String searchType = "both";
//        String searchPoint = "127.101313354,37.402352535";
        String searchPoint = "127.3768023,36.3597805";
//        String searchPoint = gpsDirectory.getGeoLocation().getLatitude() + ","
//                + gpsDirectory.getGeoLocation().getLongitude();
        String epsg = "epsg:4326";

        StringBuilder sb = new StringBuilder("https://api.vworld.kr/req/address");
        sb.append("?service=address");
        sb.append("&request=getaddress");
        sb.append("&format=json");
        sb.append("&crs=" + epsg);
        sb.append("&key=" + apikey);
        sb.append("&type=" + searchType);
        sb.append("&point=" + searchPoint);

        try {
            JSONParser jspa = new JSONParser();
            JSONObject jsob = (JSONObject) jspa.parse(new BufferedReader(
                    new InputStreamReader(new URL(sb.toString()).openStream(), StandardCharsets.UTF_8)));
            JSONObject jsrs = (JSONObject) jsob.get("response");
            JSONArray jsonArray = (JSONArray) jsrs.get("result");
            JSONObject jsonfor = new JSONObject();

            for (int i = 0; i < jsonArray.size(); i++) {
                jsonfor = (JSONObject) jsonArray.get(i);
                System.out.println(jsonfor.get("text"));
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Query a decoded description of a specific Tag
     * 
     * 특정 태그의 디코딩된 설명 쿼리
     * 
     * @param metadata
     */
    private void test3(final Metadata metadata) {
        // obtain a specific directory
        final Directory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

        // create a descriptor
        final ExifSubIFDDescriptor descriptor = new ExifSubIFDDescriptor((ExifSubIFDDirectory) directory);

        // get tag description
        final String program = descriptor.getExposureProgramDescription();

        log.debug("program={}", program);

        // 주소를 좌표로 변환

        // 대전광역시 서구 월평동 1505

        // http://api.vworld.kr/req/address?service=address&request=getcoord&version=2.0&crs=epsg:4326&address=%ED%9A%A8%EB%A0%B9%EB%A1%9C72%EA%B8%B8%2060&refine=true&simple=false&format=xml&type=road&key=B39D552C-5843-33E4-B394-906CC9F51C75
        // http://api.vworld.kr/req/address?service=address&request=getcoord&version=2.0&crs=epsg:4326&address=%EB%8C%80%EC%A0%84%EA%B4%91%EC%97%AD%EC%8B%9C+%EC%84%9C%EA%B5%AC+%EC%9B%94%ED%8F%89%EB%8F%99+1505&refine=true&simple=false&format=xml&type=PARCEL&key=B39D552C-5843-33E4-B394-906CC9F51C75

        try {
            log.debug(URLDecoder.decode("%ED%9A%A8%EB%A0%B9%EB%A1%9C72%EA%B8%B8%2060",
                    StandardCharsets.UTF_8.toString()));
            log.debug(URLEncoder.encode("대전광역시 서구 월평동 1505", StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
            log.error("UnsupportedEncodingException");
        }

//        String apikey = "[인증키]";
        String apikey = "B39D552C-5843-33E4-B394-906CC9F51C75";
        String searchType = "parcel";
//        String searchAddr = "삼평동 624";
        String searchAddr = "대전광역시 서구 월평동 1505";
        String epsg = "epsg:4326";

        StringBuilder sb = new StringBuilder("https://api.vworld.kr/req/address");
        sb.append("?service=address");
        sb.append("&request=getCoord");
        sb.append("&format=json");
        sb.append("&crs=" + epsg);
        sb.append("&key=" + apikey);
        sb.append("&type=" + searchType);
        try {
            sb.append("&address=" + URLEncoder.encode(searchAddr, StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
            log.error("UnsupportedEncodingException");
        }

        try {
            URL url = new URL(sb.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

            JSONParser jspa = new JSONParser();
            JSONObject jsob = (JSONObject) jspa.parse(reader);
            JSONObject jsrs = (JSONObject) jsob.get("response");
            JSONObject jsResult = (JSONObject) jsrs.get("result");
            JSONObject jspoitn = (JSONObject) jsResult.get("point");

            System.out.println(jspoitn.get("x"));
            System.out.println(jspoitn.get("y"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
