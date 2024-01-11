package egovframework.com.cmm.service;

import java.util.List;

/**
 * DAO Generic
 * 
 * @author 이백행
 * @since 2024-01-11
 *
 */
public interface EgovGenericDAO<T, R> {

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
