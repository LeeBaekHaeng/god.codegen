package god.core.cmm.web;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import lombok.NoArgsConstructor;

/**
 * data 처리관련(Controller 공통)
 * 
 * @author 이백행
 * @since 2023-12-09
 *
 * @param <T>
 * @param <R>
 */
@NoArgsConstructor
public abstract class GodCoreCmmAbstractController<T, R> {

	/**
	 * 등록 화면
	 * 
	 * @param vo
	 * @param model
	 * @return
	 */
	public abstract String insertView(T vo, ModelMap model);

	/**
	 * 등록
	 * 
	 * @param vo
	 * @param model
	 * @param bindingResult
	 * @return
	 */
	public abstract String insert(T vo, ModelMap model, BindingResult bindingResult);

	/**
	 * 상세 화면
	 * 
	 * @param vo
	 * @param model
	 */
	public abstract void select(T vo, ModelMap model);

	/**
	 * 목록 화면
	 * 
	 * @param vo
	 * @param model
	 * @param bindingResult
	 * @return
	 */
	public abstract String selectList(T vo, ModelMap model, BindingResult bindingResult);

	/**
	 * 수정 화면
	 * 
	 * @param vo
	 * @param model
	 */
	public abstract void updateView(T vo, ModelMap model);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @param model
	 * @param bindingResult
	 */
	public abstract void update(T vo, ModelMap model, BindingResult bindingResult);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @param model
	 * @param bindingResult
	 */
	public abstract void delete(T vo, ModelMap model, BindingResult bindingResult);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @param model
	 * @param bindingResult
	 */
	public abstract void merge(T vo, ModelMap model, BindingResult bindingResult);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @param model
	 * @param bindingResult
	 */
	public abstract void multi(T vo, ModelMap model, BindingResult bindingResult);

}
