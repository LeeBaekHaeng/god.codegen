package god.com.cmm.service;

import java.util.List;

/**
 * 
 * @author LeeBaekHaeng
 *
 * @param <T>
 * @param <R>
 */
public interface GodComCmmDAO<T, R> {

    /**
     * 등록
     * 
     * @param vo
     * @return
     */
    int insert(T vo);

    /**
     * 조회(단건)
     * 
     * @param vo
     * @return
     */
    R select(T vo);

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
    int delete(T vo);

    /**
     * 등록/수정
     * 
     * @param vo
     * @return
     */
    int merge(T vo);

    /**
     * 등록/수정/삭제
     * 
     * @param vo
     * @return
     */
    int multi(T vo);

}
