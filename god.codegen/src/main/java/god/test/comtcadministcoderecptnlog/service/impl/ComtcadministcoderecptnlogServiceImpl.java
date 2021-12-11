package god.test.comtcadministcoderecptnlog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import god.test.comtcadministcoderecptnlog.service.ComtcadministcoderecptnlogService;
import god.test.comtcadministcoderecptnlog.service.ComtcadministcoderecptnlogDefaultVO;
import god.test.comtcadministcoderecptnlog.service.ComtcadministcoderecptnlogVO;
// Dao 객체에 대한 import 구문
// import (dao package).ComtcadministcoderecptnlogDAO;
import god.test.comtcadministcoderecptnlog.service.impl.ComtcadministcoderecptnlogMapper;
/**
 * @Class Name : ComtcadministcoderecptnlogServiceImpl.java
 * @Description : Comtcadministcoderecptnlog Business Implement class
 * @Modification Information
 *
 * @author 이백행
 * @since 2021-12-11 18:20:49
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("comtcadministcoderecptnlogService")
public class ComtcadministcoderecptnlogServiceImpl extends EgovAbstractServiceImpl implements
        ComtcadministcoderecptnlogService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ComtcadministcoderecptnlogServiceImpl.class);

    @Resource(name="comtcadministcoderecptnlogMapper")
    private ComtcadministcoderecptnlogMapper comtcadministcoderecptnlogMapper;
    
    //@Resource(name="comtcadministcoderecptnlogDAO")
    //private ComtcadministcoderecptnlogDAO comtcadministcoderecptnlogDAO;
    
    /** ID Generation */
    //@Resource(name="{egovComtcadministcoderecptnlogIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * comtcadministcoderecptnlog을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	comtcadministcoderecptnlogMapper.insertComtcadministcoderecptnlog(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * comtcadministcoderecptnlog을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception {
        comtcadministcoderecptnlogMapper.updateComtcadministcoderecptnlog(vo);
    }

    /**
	 * comtcadministcoderecptnlog을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception {
        comtcadministcoderecptnlogMapper.deleteComtcadministcoderecptnlog(vo);
    }

    /**
	 * comtcadministcoderecptnlog을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ComtcadministcoderecptnlogVO
	 * @return 조회한 comtcadministcoderecptnlog
	 * @exception Exception
	 */
    public ComtcadministcoderecptnlogVO selectComtcadministcoderecptnlog(ComtcadministcoderecptnlogVO vo) throws Exception {
        ComtcadministcoderecptnlogVO resultVO = comtcadministcoderecptnlogMapper.selectComtcadministcoderecptnlog(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * comtcadministcoderecptnlog 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return comtcadministcoderecptnlog 목록
	 * @exception Exception
	 */
    public List<?> selectComtcadministcoderecptnlogList(ComtcadministcoderecptnlogDefaultVO searchVO) throws Exception {
        return comtcadministcoderecptnlogMapper.selectComtcadministcoderecptnlogList(searchVO);
    }

    /**
	 * comtcadministcoderecptnlog 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return comtcadministcoderecptnlog 총 갯수
	 * @exception
	 */
    public int selectComtcadministcoderecptnlogListTotCnt(ComtcadministcoderecptnlogDefaultVO searchVO) {
		return comtcadministcoderecptnlogMapper.selectComtcadministcoderecptnlogListTotCnt(searchVO);
	}
    
}
