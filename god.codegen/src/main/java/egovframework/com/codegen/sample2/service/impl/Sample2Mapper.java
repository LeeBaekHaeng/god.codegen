package egovframework.com.codegen.sample2.service.impl;

import java.util.List;

import egovframework.com.codegen.sample2.service.Sample2VO;
import egovframework.com.codegen.sample2.service.Sample2DefaultVO;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : Sample2Mapper.java
 * @Description : Sample2 Mapper Class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper
public interface Sample2Mapper {

	/**
	 * SAMPLE2을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sample2VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertSample2(Sample2VO vo) throws Exception;

    /**
	 * SAMPLE2을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sample2VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSample2(Sample2VO vo) throws Exception;

    /**
	 * SAMPLE2을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sample2VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSample2(Sample2VO vo) throws Exception;

    /**
	 * SAMPLE2을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sample2VO
	 * @return 조회한 SAMPLE2
	 * @exception Exception
	 */
    public Sample2VO selectSample2(Sample2VO vo) throws Exception;

    /**
	 * SAMPLE2 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SAMPLE2 목록
	 * @exception Exception
	 */
    public List<?> selectSample2List(Sample2DefaultVO searchVO) throws Exception;

    /**
	 * SAMPLE2 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SAMPLE2 총 갯수
	 * @exception
	 */
    public int selectSample2ListTotCnt(Sample2DefaultVO searchVO);

}
