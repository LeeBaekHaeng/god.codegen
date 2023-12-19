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
	 * 네임스페이스 값설정
	 * 
	 * @param namespace
	 */
	void postConstruct(String namespace);

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
	 * 전체건수
	 * 
	 * @param vo
	 * @return
	 */
	int selectListTotCnt(T vo);

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
