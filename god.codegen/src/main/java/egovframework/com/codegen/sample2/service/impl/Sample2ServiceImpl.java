package egovframework.com.codegen.sample2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.com.codegen.sample2.service.Sample2Service;
import egovframework.com.codegen.sample2.service.Sample2VO;
/**
 * @Class Name : Sample2ServiceImpl.java
 * @Description : Sample2 Business Implement class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 *
 *  Copyright (C)  All right reserved.
 */

@Service
public class Sample2ServiceImpl extends EgovAbstractServiceImpl implements Sample2Service {

	@Autowired
	private Sample2Mapper sample2DAO;

//	@Autowired
//	private Sample2DAO sample2DAO;

	/** ID Generation */
	//@Resource(name="{egovSample2IdGnrService}")
	//private EgovIdGnrService egovIdGnrService;

	/**
	 * SAMPLE2을 등록한다.
	 * 
	 * @param sample2VO - 등록할 정보가 담긴 Sample2VO
	 * @return 등록 결과
	 */
	public int insertSample2(Sample2VO sample2VO) {
		egovLogger.debug(sample2VO.toString());

		/** ID Generation Service */
		//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		//String id = egovIdGnrService.getNextStringId();
		//sample2VO.setId(id);
		egovLogger.debug(sample2VO.toString());

		return sample2DAO.insertSample2(sample2VO);
	}

	/**
	 * SAMPLE2을 수정한다.
	 * 
	 * @param sample2VO - 수정할 정보가 담긴 Sample2VO
	 * @return void형
	 */
	public int updateSample2(Sample2VO sample2VO) {
		return sample2DAO.updateSample2(sample2VO);
	}

	/**
	 * SAMPLE2을 삭제한다.
	 * 
	 * @param sample2VO - 삭제할 정보가 담긴 Sample2VO
	 * @return void형
	 */
	public int deleteSample2(Sample2VO sample2VO) {
		return sample2DAO.deleteSample2(sample2VO);
	}

	/**
	 * SAMPLE2을 조회한다.
	 * 
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return 조회한 SAMPLE2
	 */
	public Sample2VO selectSample2(Sample2VO sample2VO) {
		Sample2VO resultVO = sample2DAO.selectSample2(sample2VO);
		if (resultVO == null) {
			try {
				throw processException("info.nodata.msg");
			} catch (Exception e) {
				egovLogger.error(e.getMessage());
				return null;
			}
		}
		return resultVO;
	}

	/**
	 * SAMPLE2 목록을 조회한다.
	 * 
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return SAMPLE2 목록
	 */
	public List<EgovMap> selectSample2List(Sample2VO sample2VO) {
		return sample2DAO.selectSample2List(sample2VO);
	}

	/**
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * 
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return SAMPLE2 총 갯수
	 */
	public int selectSample2ListTotCnt(Sample2VO sample2VO) {
		return sample2DAO.selectSample2ListTotCnt(sample2VO);
	}

}
