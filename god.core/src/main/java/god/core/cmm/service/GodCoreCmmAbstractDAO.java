package god.core.cmm.service;

import java.util.List;

/**
 * data 처리관련(DAO 공통)
 * 
 * @author 이백행
 * @since 2023-11-19
 *
 * @param <T>
 * @param <R>
 */
public interface GodCoreCmmAbstractDAO<T, R> {

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return
	 */
	int insert(T vo);

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return
	 */
	R select(T vo);

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return
	 */
	List<R> selectList(T vo);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return
	 */
	int update(T vo);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return
	 */
	int delete(T vo);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return
	 */
	int merge(T vo);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return
	 */
	int multi(T vo);

}
