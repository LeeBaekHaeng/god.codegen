package egovframework.com.codegen.sample2.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.codegen.sample2.service.Sample2VO;

/**
 * @Class Name : Sample2DAO.java
 * @Description : Sample2 DAO Class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 *
 *  Copyright (C)  All right reserved.
 */

@Repository
public class Sample2DAO extends EgovComAbstractDAO {

	/**
	 * SAMPLE2을 등록한다.
	 * @param sample2VO - 등록할 정보가 담긴 Sample2VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public int insertSample2(Sample2VO sample2VO) {
		return (int) insert("sample2DAO.insertSample2_S", sample2VO);
	}

	/**
	 * SAMPLE2을 수정한다.
	 * @param sample2VO - 수정할 정보가 담긴 Sample2VO
	 * @return void형
	 * @exception Exception
	 */
	public int updateSample2(Sample2VO sample2VO) {
		return update("sample2DAO.updateSample2_S", sample2VO);
	}

	/**
	 * SAMPLE2을 삭제한다.
	 * @param sample2VO - 삭제할 정보가 담긴 Sample2VO
	 * @return void형
	 * @exception Exception
	 */
	public int deleteSample2(Sample2VO sample2VO) {
		return delete("sample2DAO.deleteSample2_S", sample2VO);
	}

	/**
	 * SAMPLE2을 조회한다.
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return 조회한 SAMPLE2
	 * @exception Exception
	 */
	public Sample2VO selectSample2(Sample2VO sample2VO) {
		return (Sample2VO) select("sample2DAO.selectSample2_S", sample2VO);
	}

	/**
	 * SAMPLE2 목록을 조회한다.
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return SAMPLE2 목록
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EgovMap> selectSample2List(Sample2VO sample2VO) {
		return (List<EgovMap>) list("sample2DAO.selectSample2List_D", sample2VO);
	}

	/**
	 * SAMPLE2 총 갯수를 조회한다.
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return SAMPLE2 총 갯수
	 * @exception
	 */
	public int selectSample2ListTotCnt(Sample2VO sample2VO) {
		return (int) select("sample2DAO.selectSample2ListTotCnt_S", sample2VO);
	}

}
