package god.test.a.a.a.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import god.core.cmm.service.GodCoreCmmAbstractService;

/**
 * 행정코드 Service
 * 
 * @author 이백행
 * @since 2023-12-06
 *
 * @param <T>
 * @param <R>
 */
public interface GodTestAaa002Service extends GodCoreCmmAbstractService<GodTestAaa002VO, GodTestAaa002VO> {

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return result
	 */
	int insert2(GodTestAaa002VO vo);

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	GodTestAaa002VO select2(GodTestAaa002VO vo);

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	List<GodTestAaa002VO> select2List(GodTestAaa002VO vo);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return result
	 */
	int update2(GodTestAaa002VO vo);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	int delete2(GodTestAaa002VO vo);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	int merge2(GodTestAaa002VO vo);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	int multi2(GodTestAaa002VO vo);

	/**
	 * 조회(단건) 전체 건수
	 * 
	 * @param vo
	 * @return totCnt
	 */
	int select2ListTotCnt(GodTestAaa002VO vo);

	/**
	 * 등록
	 * 
	 * @param vo
	 * @param model
	 */
	void insert2(GodTestAaa002VO vo, ModelMap model);

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @param model
	 */
	void select2(GodTestAaa002VO vo, ModelMap model);

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @param model
	 */
	void select2List(GodTestAaa002VO vo, ModelMap model);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @param model
	 */
	void update2(GodTestAaa002VO vo, ModelMap model);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @param model
	 */
	void delete2(GodTestAaa002VO vo, ModelMap model);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @param model
	 */
	void merge2(GodTestAaa002VO vo, ModelMap model);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @param model
	 */
	void multi2(GodTestAaa002VO vo, ModelMap model);

}
