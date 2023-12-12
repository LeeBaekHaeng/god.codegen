package god.core.cmm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springmodules.validation.commons.DefaultBeanValidator;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class GodCoreCmmAbstractController<T, R> {

	/**
	 * 기본 Bean 유효성 검사기
	 */
	@Autowired
	protected DefaultBeanValidator beanValidator;

//	/**
//	 * data 처리관련(Service 공통)
//	 */
//	private GodCoreCmmService<T, R> service;
//
//	/**
//	 * service 주입
//	 * 
//	 * @param service
//	 */
//	protected void postConstruct(final GodCoreCmmService<T, R> service) {
//		this.service = service;
//	}
//
//	@Override
//	public String insert(T vo, ModelMap model) {
//		return "";
//	}
//
//	@Override
//	public String insert(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest, ModelMap model) {
//		service.insert(vo, model);
//		return "";
//	}
//
//	@Override
//	public String select(T vo, ModelMap model) {
//		service.select(vo, model);
//		return "";
//	}
//
//	@Override
//	public String selectList(T vo, BindingResult bindingResult, ModelMap model) {
//		service.selectList(vo, model);
//		return "";
//	}
//
//	@Override
//	public String update(T vo, ModelMap model) {
//		return "";
//	}
//
//	@Override
//	public String update(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest, ModelMap model) {
//		service.update(vo, model);
//		return "";
//	}
//
//	@Override
//	public String delete(T vo, BindingResult bindingResult, ModelMap model) {
//		service.delete(vo, model);
//		return "";
//	}
//
//	@Override
//	public String merge(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest, ModelMap model) {
//		service.merge(vo, model);
//		return "";
//	}
//
//	@Override
//	public String multi(T vo, BindingResult bindingResult, MultipartHttpServletRequest multiRequest, ModelMap model) {
//		service.multi(vo, model);
//		return "";
//	}

	/**
	 * Redirect 목록 화면 값읽기
	 * 
	 * @return
	 */
	public String getRedirectSelectList() {
		return null;
	}

	/**
	 * Debug VO
	 * 
	 * @param vo
	 */
	protected void debugVO(final T vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo={}", vo);
		}
	}

}
