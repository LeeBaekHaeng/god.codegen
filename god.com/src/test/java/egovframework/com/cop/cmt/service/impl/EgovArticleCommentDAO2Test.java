package egovframework.com.cop.cmt.service.impl;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.cop.bbs.service.Board;
import egovframework.com.cop.bbs.service.BoardMaster;
import egovframework.com.cop.bbs.service.impl.EgovArticleDAO;
import egovframework.com.cop.bbs.service.impl.EgovBBSMasterDAO;
import egovframework.com.cop.cmt.service.Comment;
import egovframework.com.cop.cmt.service.CommentVO;
import egovframework.com.test.Test2EgovAbstractDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 댓글 DAO 단위 테스트
 * 
 * @author 이백행
 *
 */
@RequiredArgsConstructor
@Slf4j
public class EgovArticleCommentDAO2Test extends Test2EgovAbstractDAO {

    /**
     * EgovArticleCommentDAO
     */
    @Autowired
    private EgovArticleCommentDAO egovArticleCommentDAO;

    /**
     * 답글 ANSWER_NO 생성
     */
//    @Resource(name = "egovAnswerNoGnrService")
    @Autowired
    @Qualifier("egovAnswerNoGnrService")
    private EgovIdGnrService egovAnswerNoGnrService;

    /**
     * 메시지 리소스 사용을 위한 MessageSource 인터페이스 및 ReloadableResourceBundleMessageSource 클래스의 구현체
     */
    @Resource(name = "egovMessageSource")
    private EgovMessageSource egovMessageSource;

    /**
     * EgovBBSMasterDAO
     */
    @Autowired
    private EgovBBSMasterDAO egovBBSMasterDAO;

    /**
     * EgovArticleDAO
     */
    @Autowired
    private EgovArticleDAO egovArticleDAO;

    /**
     * 게시판용 BBS_ID 생성
     */
    @Autowired
    @Qualifier("egovBBSMstrIdGnrService")
    private EgovIdGnrService egovBBSMstrIdGnrService;

    /**
     * 게시판용 NTT_ID 생성
     */
    @Autowired
    @Qualifier("egovNttIdGnrService")
    private EgovIdGnrService egovNttIdGnrService;

    /**
     * insertArticleComment
     */
    private int insertArticleComment = 1;

    /**
     * 조회에 실패하였습니다.
     */
    private static final String FAIL_COMMON_SELECT = "fail.common.select";

    private void testData(final Board board, final LoginVO loginVO) {
        final BoardMaster boardMaster = new BoardMaster();

        if (loginVO != null) {
            boardMaster.setFrstRegisterId(loginVO.getUniqId());
//          boardMaster.setLastUpdusrId(loginVO.getUniqId());

            board.setFrstRegisterId(loginVO.getUniqId());
//          board.setLastUpdusrId(loginVO.getUniqId());
        }

        try {
            boardMaster.setBbsId(egovBBSMstrIdGnrService.getNextStringId());
        } catch (FdlException e) {
            log.error("FdlException egovBBSMstrIdGnrService");
        }
        egovBBSMasterDAO.insertBBSMasterInf(boardMaster);

        try {
            board.setNttId(egovNttIdGnrService.getNextLongId());
        } catch (FdlException e) {
            log.error("FdlException egovNttIdGnrService");
        }
        board.setBbsId(boardMaster.getBbsId());
        egovArticleDAO.insertArticle(board);
    }

    private void testData(final Board board, final LoginVO loginVO, final Comment comment) {
        testData(board, loginVO);

        try {
            comment.setCommentNo(String.valueOf(egovAnswerNoGnrService.getNextLongId()));
        } catch (FdlException e) {
            log.error("FdlException egovAnswerNoGnrService");
        }

        comment.setNttId(board.getNttId());
        comment.setBbsId(board.getBbsId());

        comment.setCommentPassword("rhdxhd12");
        comment.setCommentCn("test 이백행 댓글 " + LocalDateTime.now());

        setLoginVO(comment, loginVO);

        // when
        try {
            egovArticleCommentDAO.insertArticleComment(comment);
        } catch (DataAccessException e) {
            if (log.isErrorEnabled()) {
                log.error("DataAccessException insertArticleComment");
                log.error(egovMessageSource.getMessage("fail.common.insert"));
            }
            error(e);
        }
    }

    /**
     * 댓글 DAO 단위 테스트: 등록
     */
    @Test
//    @Commit
    public void testA10insert() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        testData(board, loginVO);

        // given
        final Comment comment = new Comment();
        try {
            comment.setCommentNo(String.valueOf(egovAnswerNoGnrService.getNextLongId()));
        } catch (FdlException e) {
            log.error("FdlException egovAnswerNoGnrService");
        }

        comment.setNttId(board.getNttId());
        comment.setBbsId(board.getBbsId());

        comment.setCommentPassword("rhdxhd12");
        comment.setCommentCn("test 이백행 댓글 " + LocalDateTime.now());

        setLoginVO(comment, loginVO);

        // when
        try {
            egovArticleCommentDAO.insertArticleComment(comment);
        } catch (DataAccessException e) {
            if (log.isErrorEnabled()) {
                log.error("DataAccessException insertArticleComment");
                log.error(egovMessageSource.getMessage("fail.common.insert"));
            }
            error(e);

            insertArticleComment = 0;
        }

        // then
        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, insertArticleComment);
    }

    private void setLoginVO(final Comment comment, final LoginVO loginVO) {
        if (loginVO != null) {
            comment.setFrstRegisterId(loginVO.getUniqId());
//            comment.setLastUpdusrId(loginVO.getUniqId());

//            comment.setWrterId(loginVO.getId());
            comment.setWrterId(loginVO.getUniqId());
            comment.setWrterNm(loginVO.getName());
        }
    }

    private Object[] args(final SQLException sqle) {
        return new Object[] { sqle.getErrorCode(), sqle.getMessage(), sqle.getSQLState(), };
//        return new Object[] { sqle.getErrorCode(), sqle.getSQLState(), sqle.getMessage(), };
    }

    /**
     * 댓글 DAO 단위 테스트: 조회(멀티건)
     */
    @Test
    public void testB10selectList() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        final Comment comment = new Comment();
        testData(board, loginVO, comment);

        // given
        final CommentVO commentVO = new CommentVO();
        commentVO.setBbsId(comment.getBbsId());
        commentVO.setNttId(comment.getNttId());
        commentVO.setSubRecordCountPerPage(1);
        commentVO.setSubFirstIndex(0);

        // when
        @SuppressWarnings("unchecked")
        final List<CommentVO> results = (List<CommentVO>) egovArticleCommentDAO.selectArticleCommentList(commentVO);
        for (final CommentVO result : results) {
            debug(result);
//            debug2(result);

            // then
            assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), comment.getCommentNo(),
                    result.getCommentNo());
        }
    }

    /* default */ void debug(final CommentVO result) {
        if (log.isDebugEnabled()) {
            log.debug("result={}", result);

            log.debug("getCommentNo={}", result.getCommentNo());
            log.debug("getNttId={}", result.getNttId());
            log.debug("getBbsId={}", result.getBbsId());

            log.debug("getWrterId={}", result.getWrterId());
            log.debug("getWrterNm={}", result.getWrterNm());
            log.debug("getCommentPassword={}", result.getCommentPassword());
            log.debug("getCommentCn={}", result.getCommentCn());

            log.debug("getUseAt={}", result.getUseAt());

            log.debug("getFrstRegisterPnttm={}", result.getFrstRegisterPnttm());
            log.debug("getFrstRegisterNm={}", result.getFrstRegisterNm());
        }
    }

    /* default */ void debug2(final CommentVO result) {
        if (log.isDebugEnabled()) {
            log.debug("result={}", result);

            log.debug("getNttId={}", result.getNttId());
            log.debug("getBbsId={}", result.getBbsId());
            log.debug("getCommentNo={}", result.getCommentNo());

            log.debug("getWrterId={}", result.getWrterId());
            log.debug("getWrterNm={}", result.getWrterNm());
            log.debug("getCommentCn={}", result.getCommentCn());

            log.debug("getUseAt={}", result.getUseAt());

            log.debug("getFrstRegisterPnttm={}", result.getFrstRegisterPnttm());
            log.debug("getFrstRegisterId={}", result.getFrstRegisterId());
            log.debug("getFrstRegisterNm={}", result.getFrstRegisterNm());

            log.debug("getLastUpdusrPnttm={}", result.getLastUpdusrPnttm());
            log.debug("getLastUpdusrId={}", result.getLastUpdusrId());

            log.debug("getCommentPassword={}", result.getCommentPassword());
        }
    }

    /**
     * 댓글 DAO 단위 테스트: 조회(멀티건) 총 수
     */
    @Test
    public void testC10selectListTotCnt() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        final Comment comment = new Comment();
        testData(board, loginVO, comment);

        // given
        final CommentVO commentVO = new CommentVO();
        commentVO.setBbsId(comment.getBbsId());
        commentVO.setNttId(comment.getNttId());

        // when
        final int totCnt = egovArticleCommentDAO.selectArticleCommentListCnt(commentVO);

        log.debug("totCnt={}", totCnt);

        // then
        assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), 1, totCnt);
    }

    /**
     * 댓글 DAO 단위 테스트: 조회(단건)
     */
    @Test
    public void testD10select() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        final Comment comment = new Comment();
        testData(board, loginVO, comment);

        // given
        final CommentVO commentVO = new CommentVO();
        commentVO.setCommentNo(comment.getCommentNo());

        // when
        final CommentVO result = egovArticleCommentDAO.selectArticleCommentDetail(commentVO);

        debug(result);

        // then
//        assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), commentVO.getCommentNo(), result.getCommentNo());
        assert1(commentVO, result);
    }

    private void assert1(final CommentVO commentVO, final CommentVO result) {
        assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), commentVO.getCommentNo(), result.getCommentNo());
    }

    /**
     * 댓글 DAO 단위 테스트: 수정
     */
    @Test
    public void testE10update() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        final Comment comment = new Comment();
        testData(board, loginVO, comment);

        // given
        comment.setCommentCn(comment.getCommentCn() + " > 수정 test 이백행 댓글 " + LocalDateTime.now());
        updateArticleComment(loginVO, comment);

        // when
        int result = 1;
        try {
            egovArticleCommentDAO.updateArticleComment(comment);
        } catch (DataAccessException e) {
            if (log.isErrorEnabled()) {
                log.error("DataAccessException updateArticleComment");
                log.error(egovMessageSource.getMessage("fail.common.update"));
            }
            error(e);

            result = 0;
        }

        // then
        assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
    }

    private void updateArticleComment(final LoginVO loginVO, final Comment comment) {
        comment.setLastUpdusrId(loginVO.getUniqId());
    }

    /**
     * 댓글 DAO 단위 테스트: 삭제
     */
    @Test
    public void testF10delete() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        final Comment comment = new Comment();
        testData(board, loginVO, comment);

        // given
        final CommentVO commentVO = new CommentVO();
        commentVO.setCommentNo(comment.getCommentNo());

        // when
        int result = 1;
        try {
            egovArticleCommentDAO.deleteArticleComment(commentVO);
        } catch (DataAccessException e) {
            if (log.isErrorEnabled()) {
                log.error("DataAccessException deleteArticleComment");
                log.error(egovMessageSource.getMessage("fail.common.delete"));
            }
            error(e);

            result = 0;
        }

        // then
        assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
    }

    /* default */ void error(final DataAccessException dataAccessException) {
        if (log.isErrorEnabled()) {
            log.error(egovMessageSource.getMessage("fail.common.msg"));

            final SQLException sqle = (SQLException) dataAccessException.getCause();
            log.error(egovMessageSource.getMessageArgs("fail.common.sql", args(sqle)));
        }
    }

}
