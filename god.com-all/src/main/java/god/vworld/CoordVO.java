package god.vworld;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 주소를 좌표로 변환 응답결과
 * 
 * @author 이백행
 * @since 2023-08-03
 */
@Data
@NoArgsConstructor
public class CoordVO {

    /**
     * response
     */
    private Response response;

    /**
     * response
     * 
     * @author 이백행
     * @since 2023-08-03
     */
    @Data
    public static class Response {

        /**
         * 요청 서비스 정보 Root
         */
        private Service service;

        /**
         * 처리 결과의 상태 표시, 유효값 : OK(성공), NOT_FOUND(결과없음), ERROR(에러)
         */
        private String status;

        /**
         * 에러 정보 Root
         */
        private Error error;

        /**
         * 입력 주소 정보 Root, 생략조건 : simple=true
         */
        private Input input;

        /**
         * 응답결과 Root
         */
        private List<Result> result;

    }

    /**
     * 요청 서비스 정보 Root
     * 
     * @author 이백행
     * @since 2023-08-03
     */
    @Data
    public static class Service {

        /**
         * 요청 서비스명
         */
        private String name;

        /**
         * 요청 서비스 버전
         */
        private String version;
//        private Double version;

        /**
         * 요청 서비스 오퍼레이션 이름
         */
        private String operation;

        /**
         * 응답결과 생성 시간
         */
        private String time;

    }

    /**
     * 입력 주소 정보 Root, 생략조건 : simple=true
     * 
     * @author 이백행
     * @since 2023-08-03
     */
    @Data
    public static class Input {

        /**
         * 주소 좌표 Root
         */
        private Point point;

        /**
         * 입력에 적용되는 좌표계
         */
        private String crs;

        /**
         * 입력 주소 유형(ROAD, PARCEL)
         */
        private String type;

    }

    /**
     * 주소 좌표 Root
     * 
     * @author 이백행
     * @since 2023-08-03
     */
    @Data
    public static class Point {

        /**
         * x좌표
         */
//        private String x;
        private Double x;

        /**
         * y좌표
         */
//        private String y;
        private Double y;

    }

    /**
     * 응답결과 Root
     * 
     * @author 이백행
     * @since 2023-08-03
     */
    @Data
    public static class Result {

        /**
         * 우편번호, 생략조건 : zipcode=false
         */
        private String zipcode;

        /**
         * 주소 유형(ROAD, PARCEL), 생략조건 : simple=true
         */
        private String type;

        /**
         * 전체 주소 텍스트
         */
        private String text;

        /**
         * 구조화된 주소 Root
         */
        private Structure structure;

    }

    /**
     * 구조화된 주소 Root
     * 
     * @author 이백행
     * @since 2023-08-03
     */
    @Data
    public static class Structure {

        /**
         * 국가
         */
        private String level0;

        /**
         * 시·도
         */
        private String level1;

        /**
         * 시·군·구
         */
        private String level2;

        /**
         * (일반구)구
         */
        private String level3;

        /**
         * (도로)도로명, (지번)법정읍·면·동 명
         */
        private String level4L;

        /**
         * (도로)도로코드, (지번)법정읍·면·동 코드
         */
        private String level4LC;

        /**
         * (도로)행정읍·면·동 명, (지번)지원안함
         */
        private String level4A;

        /**
         * (도로)행정읍·면·동 코드, (지번)지원안함
         */
        private String level4AC;

        /**
         * (도로)길, (지번)번지
         */
        private String level5;

        /**
         * 상세주소
         */
        private String detail;

    }

    /**
     * 에러 정보 Root
     * 
     * @author 이백행
     * @since 2023-08-03
     */
    @Data
    public static class Error {

        /**
         * 에러 레벨
         */
        private String level;

        /**
         * 에러 코드
         */
        private String code;

        /**
         * 에러 메시지
         */
        private String text;

    }

}
