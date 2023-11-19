package god.com.cmm.service;

import java.util.List;

/**
 * 
 * @author LeeBaekHaeng
 *
 * @param <T>
 * @param <R>
 */
public interface GodComCmm001DAO<T, R> {

    /**
     * 
     * @return
     */
    String getMapperNamespace();

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
     * @return
     */
    int insert2(T vo);

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
     * @return
     */
    R select2(T vo);

    /**
     * 조회(멀티건)
     * 
     * @param vo
     * @return
     */
    List<R> selectList(T vo);

    /**
     * 조회(멀티건) 전체 건수
     * 
     * @param vo
     * @return
     */
    int selectListTotCnt(T vo);

    /**
     * 조회(멀티건)
     * 
     * @param vo
     * @return
     */
    List<R> select2List(T vo);

    /**
     * 조회(멀티건) 전체 건수
     * 
     * @param vo
     * @return
     */
    int select2ListTotCnt(T vo);

    /**
     * 등록
     * 
     * @param vo
     * @return
     */
    int update(T vo);

    /**
     * 등록
     * 
     * @param vo
     * @return
     */
    int update2(T vo);

    /**
     * 등록
     * 
     * @param vo
     * @return
     */
    int delete(T vo);

    /**
     * 등록
     * 
     * @param vo
     * @return
     */
    int delete2(T vo);

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
     * @return
     */
    int merge2(T vo);

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
     * @return
     */
    int multi2(T vo);

}
