package god.test.a.a.b.service;

public class TestAabVO extends TestAab {

    /**
     * 
     */
    private static final long serialVersionUID = -5190108519224572957L;

    private String administZoneSeNm;

    /**
     * 작업일련번호
     * 
     * <pre>
     * comtcadministcoderecptnlog 행정코드수신로그
     * `OPERT_SN` decimal(10,0) NOT NULL COMMENT '작업일련번호',
     * </pre>
     */
    private long opertSn;

    public String getAdministZoneSeNm() {
        return administZoneSeNm;
    }

    public void setAdministZoneSeNm(String administZoneSeNm) {
        this.administZoneSeNm = administZoneSeNm;
    }

    public long getOpertSn() {
        return opertSn;
    }

    public void setOpertSn(long opertSn) {
        this.opertSn = opertSn;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
