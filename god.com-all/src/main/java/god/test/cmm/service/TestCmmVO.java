package god.test.cmm.service;

public class TestCmmVO extends TestCmmDefaultVO {

    private static final long serialVersionUID = -1501016016820009930L;

    /**
     * 행정구역구분
     */
    private String administZoneSe;

    /**
     * 행정구역코드
     */
    private String administZoneCode;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * 행정구역구분 값읽기
     * 
     * @return
     */
    public String getAdministZoneSe() {
        return administZoneSe;
    }

    /**
     * 행정구역구분 값설정
     * 
     * @param administZoneSe
     */
    public void setAdministZoneSe(String administZoneSe) {
        this.administZoneSe = administZoneSe;
    }

    /**
     * 행정구역코드 값읽기
     * 
     * @return
     */
    public String getAdministZoneCode() {
        return administZoneCode;
    }

    /**
     * 행정구역코드값설정
     * 
     * @param administZoneCode
     */
    public void setAdministZoneCode(String administZoneCode) {
        this.administZoneCode = administZoneCode;
    }

}
