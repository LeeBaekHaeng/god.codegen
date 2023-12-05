package god.core.cmm.service;

import java.util.List;

import org.springframework.ui.ModelMap;

/**
 * data 처리관련(Service 공통)
 * 
 * @author 이백행
 * @since 2023-12-05
 *
 * @param <T>
 * @param <R>
 */
public interface GodCoreCmmAbstractService<T, R> {

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return
	 */
	int insert(T vo);

	/**
	 * 등록
	 * 
	 * @param vo
	 * @param model
	 */
	void insert(T vo, ModelMap model);

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return
	 */
	R select(T vo);

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @param model
	 */
	void select(T vo, ModelMap model);

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return
	 */
	List<R> selectList(T vo);

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @param model
	 */
	void selectList(T vo, ModelMap model);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return
	 */
	int update(T vo);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @param model
	 */
	void update(T vo, ModelMap model);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return
	 */
	int delete(T vo);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @param model
	 */
	void delete(T vo, ModelMap model);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return
	 */
	int merge(T vo);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @param model
	 */
	void merge(T vo, ModelMap model);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return
	 */
	int multi(T vo);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @param model
	 */
	void multi(T vo, ModelMap model);

}
