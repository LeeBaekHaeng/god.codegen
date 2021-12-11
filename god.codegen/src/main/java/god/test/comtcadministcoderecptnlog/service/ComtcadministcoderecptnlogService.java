package god.test.comtcadministcoderecptnlog.service;

import java.util.List;
import god.test.comtcadministcoderecptnlog.service.ComtcadministcoderecptnlogDefaultVO;
import god.test.comtcadministcoderecptnlog.service.ComtcadministcoderecptnlogVO;

/**
 * @Class Name : ComtcadministcoderecptnlogService.java
 * @Description : Comtcadministcoderecptnlog Business class
 * @Modification Information
 *
 * @author 이백행
 * @since 2021-12-11 18:20:49
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ComtcadministcoderecptnlogService {
	
	/**
	 * comtcadministcoderecptnlog을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception;
    
    /**
	 * comtcadministcoderecptnlog을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return void형
	 * @exception Exception
	 */
    void updateComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception;
    
    /**
	 * comtcadministcoderecptnlog을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception;
    
    /**
	 * comtcadministcoderecptnlog을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return 조회한 comtcadministcoderecptnlog
	 * @exception Exception
	 */
    ComtcadministcoderecptnlogVO selectComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception;
    
    /**
	 * comtcadministcoderecptnlog 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return comtcadministcoderecptnlog 목록
	 * @exception Exception
	 */
    List selectComtcadministcoderecptnlogList(ComtcadministcoderecptnlogDefaultVO searchVO) throws Exception;
    
    /**
	 * comtcadministcoderecptnlog 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return comtcadministcoderecptnlog 총 갯수
	 * @exception
	 */
    int selectComtcadministcoderecptnlogListTotCnt(ComtcadministcoderecptnlogDefaultVO searchVO);
    
}
