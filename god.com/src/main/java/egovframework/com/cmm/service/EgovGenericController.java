package egovframework.com.cmm.service;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

/**
 * Controller Generic
 * 
 * @author 이백행
 * @since 2024-01-11
 *
 */
public interface EgovGenericController<T, R> {

    /**
     * 목록 List
     * 
     * @param vo
     * @return resultList
     */
    String selectList(T vo, ModelMap model);

    /**
     * 등록 Regist
     * 
     * @param vo
     * @return result
     */
    String insert(T vo, ModelMap model);

    /**
     * 등록 Regist
     * 
     * @param vo
     * @return result
     */
    String insert(T vo, BindingResult bindingResult, ModelMap model);

    /**
     * 상세 Detail
     * 
     * @param vo
     * @return result
     */
    String select(T vo, ModelMap model);

    /**
     * 수정 Updt
     * 
     * @param vo
     * @return result
     */
    String update(T vo, ModelMap model);

    /**
     * 수정 Updt
     * 
     * @param vo
     * @return result
     */
    String update(T vo, BindingResult bindingResult, ModelMap model);

    /**
     * 삭제
     * 
     * @param vo
     * @return result
     */
    String delete(T vo, ModelMap model);

}
