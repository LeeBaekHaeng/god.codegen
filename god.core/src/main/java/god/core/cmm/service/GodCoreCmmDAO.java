package god.core.cmm.service;

import java.util.List;

/**
 * data 처리관련(DAO 공통)
 * 
 * @author 이백행
 * @since 2023-12-11
 *
 * @param <T>
 * @param <R>
 */
public interface GodCoreCmmDAO<T, R> {

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return result
	 */
	int insert(T vo);

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	R select(T vo);

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	List<R> selectList(T vo);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return result
	 */
	int update(T vo);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	int delete(T vo);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	int merge(T vo);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	int multi(T vo);

}
