package egovframework.com.codegen.sample2.service.impl;

import java.util.List;

import egovframework.com.codegen.sample2.service.Sample2VO;
import egovframework.com.codegen.sample2.service.Sample2DefaultVO;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;

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
interface Sample2Mapper {

	/**
	 * SAMPLE2을 등록한다.
	 * @param sample2VO - 등록할 정보가 담긴 Sample2VO
	 * @return 등록 결과
	 */
	 int insertSample2(Sample2VO sample2VO);

	 /**
	 * SAMPLE2을 수정한다.
	 * @param sample2VO - 수정할 정보가 담긴 Sample2VO
	 * @return void형
	 */
	 int updateSample2(Sample2VO sample2VO);

	 /**
	 * SAMPLE2을 삭제한다.
	 * @param sample2VO - 삭제할 정보가 담긴 Sample2VO
	 * @return void형
	 */
	 int deleteSample2(Sample2VO sample2VO);

	 /**
	 * SAMPLE2을 조회한다.
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return 조회한 SAMPLE2
	 */
	 Sample2VO selectSample2(Sample2VO sample2VO);

	 /**
	 * SAMPLE2 목록을 조회한다.
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return SAMPLE2 목록
	 */
	 List<EgovMap> selectSample2List(Sample2VO sample2VO);

	 /**
	 * SAMPLE2 총 갯수를 조회한다.
	 * @param sample2VO - 조회할 정보가 담긴 Sample2VO
	 * @return SAMPLE2 총 갯수
	 */
	 int selectSample2ListTotCnt(Sample2VO sample2VO);

}
