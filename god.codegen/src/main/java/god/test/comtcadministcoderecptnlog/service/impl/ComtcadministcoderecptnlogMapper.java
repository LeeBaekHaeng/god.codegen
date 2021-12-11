package god.test.comtcadministcoderecptnlog.service.impl;

import java.util.List;

import god.test.comtcadministcoderecptnlog.service.ComtcadministcoderecptnlogVO;
import god.test.comtcadministcoderecptnlog.service.ComtcadministcoderecptnlogDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : ComtcadministcoderecptnlogMapper.java
 * @Description : Comtcadministcoderecptnlog Mapper Class
 * @Modification Information
 *
 * @author 이백행
 * @since 2021-12-11 18:20:49
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("comtcadministcoderecptnlogMapper")
public interface ComtcadministcoderecptnlogMapper {

	/**
	 * comtcadministcoderecptnlog을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception;

    /**
	 * comtcadministcoderecptnlog을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception;

    /**
	 * comtcadministcoderecptnlog을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception;

    /**
	 * comtcadministcoderecptnlog을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return 조회한 comtcadministcoderecptnlog
	 * @exception Exception
	 */
    public ComtcadministcoderecptnlogVO selectComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception;

    /**
	 * comtcadministcoderecptnlog 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return comtcadministcoderecptnlog 목록
	 * @exception Exception
	 */
    public List<?> selectComtcadministcoderecptnlogList(ComtcadministcoderecptnlogDefaultVO searchVO) throws Exception;

    /**
	 * comtcadministcoderecptnlog 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return comtcadministcoderecptnlog 총 갯수
	 * @exception
	 */
    public int selectComtcadministcoderecptnlogListTotCnt(ComtcadministcoderecptnlogDefaultVO searchVO);

}
