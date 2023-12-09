package god.core.cmm.web;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	 * @param bindingResult
	 * @param multiRequest
	 * @param model
	 * @return
	 */
	public abstract String insert(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest,
			ModelMap model);

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
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	public abstract String selectList(T vo, BindingResult bindingResult, ModelMap model);

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
	 * @param bindingResult
	 * @param multiRequest
	 * @param model
	 */
	public abstract void update(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest,
			ModelMap model);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param model
	 */
	public abstract void delete(T vo, BindingResult bindingResult, ModelMap model);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param multiRequest
	 * @param model
	 */
	public abstract void merge(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest,
			ModelMap model);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param multiRequest
	 * @param model
	 */
	public abstract void multi(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest,
			ModelMap model);

}
