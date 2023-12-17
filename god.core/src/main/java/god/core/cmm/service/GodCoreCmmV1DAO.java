package god.core.cmm.service;

import java.util.List;

/**
 * data 처리관련(DAO 공통) V1
 * 
 * @author 이백행
 * @since 2023-12-15
 *
 * @param <T>
 * @param <R>
 */
public interface GodCoreCmmV1DAO<T, R> {

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return result
	 */
	int insert(T vo);

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return result
	 */
	int insert2(T vo);

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	R select(T vo);

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	R select2(T vo);

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	List<R> selectList(T vo);

	/**
	 * 전체건수
	 * 
	 * @param vo
	 * @return
	 */
	int selectListTotCnt(T vo);

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	List<R> select2List(T vo);

	/**
	 * 전체건수
	 * 
	 * @param vo
	 * @return
	 */
	int select2ListTotCnt(T vo);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return result
	 */
	int update(T vo);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return result
	 */
	int update2(T vo);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	int delete(T vo);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	int delete2(T vo);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	int merge(T vo);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	int merge2(T vo);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	int multi(T vo);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	int multi2(T vo);

}
