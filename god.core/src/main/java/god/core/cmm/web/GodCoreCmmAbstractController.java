package god.core.cmm.web;

import org.springframework.ui.ModelMap;

import god.core.cmm.service.GodCoreCmmAbstractService;
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
	 * data 처리관련(Service 공통)
	 */
	private GodCoreCmmAbstractService<T, R> service;

	/**
	 * service 주입
	 * 
	 * @param service
	 */
	protected void postConstruct(final GodCoreCmmAbstractService<T, R> service) {
		this.service = service;
	}

	public String insert(final T vo, final ModelMap model) {
		service.insert(vo, model);
		return null;
	}

	public void select(final T vo, final ModelMap model) {
		service.select(vo, model);
	}

	public String selectList(final T vo, final ModelMap model) {
		service.selectList(vo, model);
		return null;
	}

	public void update(final T vo, final ModelMap model) {
		service.update(vo, model);
	}

	public void delete(final T vo, final ModelMap model) {
		service.delete(vo, model);
	}

	public void merge(final T vo, final ModelMap model) {
		service.merge(vo, model);
	}

	public void multi(final T vo, final ModelMap model) {
		service.multi(vo, model);
	}

}
