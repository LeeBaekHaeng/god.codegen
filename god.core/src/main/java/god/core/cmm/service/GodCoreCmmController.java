package god.core.cmm.service;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * data 처리관련(Controller 공통)
 * 
 * @author 이백행
 * @since 2023-12-12
 *
 * @param <T>
 * @param <R>
 */
public interface GodCoreCmmController<T, R> {

	/**
	 * 등록 화면
	 * 
	 * @param vo
	 * @param model
	 * @return
	 */
	String insert(T vo, ModelMap model);

	/**
	 * 등록
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param multiRequest
	 * @param model
	 * @return
	 */
	String insert(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest, ModelMap model);

	/**
	 * 상세 화면
	 * 
	 * @param vo
	 * @param model
	 */
	String select(T vo, ModelMap model);

	/**
	 * 목록 화면
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	String selectList(T vo, BindingResult bindingResult, ModelMap model);

	/**
	 * 수정 화면
	 * 
	 * @param vo
	 * @param model
	 */
	String update(T vo, ModelMap model);

	/**
	 * 수정
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param multiRequest
	 * @param model
	 */
	String update(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest, ModelMap model);

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param model
	 */
	String delete(T vo, BindingResult bindingResult, ModelMap model);

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param multiRequest
	 * @param model
	 */
	String merge(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest, ModelMap model);

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @param bindingResult
	 * @param multiRequest
	 * @param model
	 */
	String multi(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest, ModelMap model);

}
