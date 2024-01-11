package egovframework.com.cmm.service;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

/**
 * Service Generic
 * 
 * @author 이백행
 * @since 2024-01-11
 *
 */
public interface EgovGenericService<T, R> {

    /**
     * 목록 List
     * 
     * @param vo
     * @return resultList
     */
    void selectList(T vo, ModelMap model);

    /**
     * 등록 Regist
     * 
     * @param vo
     * @return result
     */
    void insert(T vo, ModelMap model);

    /**
     * 등록 Regist
     * 
     * @param vo
     * @return result
     */
    void insert(T vo, BindingResult bindingResult, ModelMap model);

    /**
     * 상세 Detail
     * 
     * @param vo
     * @return result
     */
    void select(T vo, ModelMap model);

    /**
     * 수정 Updt
     * 
     * @param vo
     * @return result
     */
    void update(T vo, ModelMap model);

    /**
     * 수정 Updt
     * 
     * @param vo
     * @return result
     */
    void update(T vo, BindingResult bindingResult, ModelMap model);

    /**
     * 삭제
     * 
     * @param vo
     * @return result
     */
    void delete(T vo, ModelMap model);

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
     * 조회(멀티건) 전체건수
     * 
     * @param vo
     * @return resultList
     */
    long selectListTotCnt(T vo);

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

}
