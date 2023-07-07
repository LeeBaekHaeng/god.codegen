package egovframework.com.cop.cmt.service.impl;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.cop.bbs.service.Board;
import egovframework.com.cop.bbs.service.BoardMaster;
import egovframework.com.cop.bbs.service.impl.BBSAddedOptionsDAO;
import egovframework.com.cop.bbs.service.impl.EgovArticleDAO;
import egovframework.com.cop.bbs.service.impl.EgovBBSMasterDAO;
import egovframework.com.cop.cmt.service.Comment;
import egovframework.com.cop.cmt.service.CommentVO;
import egovframework.com.test.EgovTestAbstractDAO;
import lombok.RequiredArgsConstructor;

/**
 * 댓글 DAO 단위 테스트
 * 
 * @author 이백행
 *
 */

@ContextConfiguration(classes = { EgovTestAbstractDAO.class, EgovArticleCommentDAOTest.class, })

@Configuration

@ImportResource({

        "classpath*:egovframework/spring/com/idgn/context-idgn-AnswerNo.xml",

        "classpath*:egovframework/spring/com/idgn/context-idgn-bbs.xml",

})

@ComponentScan(

        useDefaultFilters = false,

        basePackages = {

                "egovframework.com.cop.cmt.service.impl",

                "egovframework.com.cop.bbs.service.impl",

        },

        includeFilters = {

                @Filter(

                        type = FilterType.ASSIGNABLE_TYPE,

                        classes = {

                                EgovArticleCommentDAO.class,

                                EgovArticleCommentServiceImpl.class,

                                BBSAddedOptionsDAO.class,

                                EgovBBSMasterDAO.class,

                                EgovArticleDAO.class,

                        }

                )

        }

)

@RequiredArgsConstructor
//@Commit
public class EgovArticleCommentDAOTest extends EgovTestAbstractDAO {

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
            LOGGER.error("FdlException egovBBSMstrIdGnrService");
        }
        egovBBSMasterDAO.insertBBSMasterInf(boardMaster);

        try {
            board.setNttId(egovNttIdGnrService.getNextLongId());
        } catch (FdlException e) {
            LOGGER.error("FdlException egovNttIdGnrService");
        }
        board.setBbsId(boardMaster.getBbsId());
        egovArticleDAO.insertArticle(board);
    }

    private void testData(final Board board, final LoginVO loginVO, final Comment comment) {
        testData(board, loginVO);

        try {
            comment.setCommentNo(String.valueOf(egovAnswerNoGnrService.getNextLongId()));
        } catch (FdlException e) {
            LOGGER.error("FdlException egovAnswerNoGnrService");
        }

        comment.setNttId(board.getNttId());
        comment.setBbsId(board.getBbsId());

        comment.setCommentPassword("rhdxhd12");
        comment.setCommentCn("test 이백행 댓글 " + LocalDateTime.now());

        setLoginVO(comment, loginVO);

        egovArticleCommentDAO.insertArticleComment(comment);
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
            LOGGER.error("FdlException egovAnswerNoGnrService");
        }

        comment.setNttId(board.getNttId());
        comment.setBbsId(board.getBbsId());

        comment.setCommentPassword("rhdxhd12");
        comment.setCommentCn("test 이백행 댓글 " + LocalDateTime.now());

        setLoginVO(comment, loginVO);

        // when

        egovArticleCommentDAO.insertArticleComment(comment);

        // then
        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, 1);
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

    /**
     * 댓글 DAO 단위 테스트: 조회(멀티건)
     */
    @Test
    public void testA20selectList() {
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
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("result={}", result);

            LOGGER.debug("getCommentNo={}", result.getCommentNo());
            LOGGER.debug("getNttId={}", result.getNttId());
            LOGGER.debug("getBbsId={}", result.getBbsId());

            LOGGER.debug("getWrterId={}", result.getWrterId());
            LOGGER.debug("getWrterNm={}", result.getWrterNm());
            LOGGER.debug("getCommentPassword={}", result.getCommentPassword());
            LOGGER.debug("getCommentCn={}", result.getCommentCn());

            LOGGER.debug("getUseAt={}", result.getUseAt());

            LOGGER.debug("getFrstRegisterPnttm={}", result.getFrstRegisterPnttm());
            LOGGER.debug("getFrstRegisterNm={}", result.getFrstRegisterNm());
        }
    }

    /* default */ void debug2(final CommentVO result) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("result={}", result);

            LOGGER.debug("getNttId={}", result.getNttId());
            LOGGER.debug("getBbsId={}", result.getBbsId());
            LOGGER.debug("getCommentNo={}", result.getCommentNo());

            LOGGER.debug("getWrterId={}", result.getWrterId());
            LOGGER.debug("getWrterNm={}", result.getWrterNm());
            LOGGER.debug("getCommentCn={}", result.getCommentCn());

            LOGGER.debug("getUseAt={}", result.getUseAt());

            LOGGER.debug("getFrstRegisterPnttm={}", result.getFrstRegisterPnttm());
            LOGGER.debug("getFrstRegisterId={}", result.getFrstRegisterId());
            LOGGER.debug("getFrstRegisterNm={}", result.getFrstRegisterNm());

            LOGGER.debug("getLastUpdusrPnttm={}", result.getLastUpdusrPnttm());
            LOGGER.debug("getLastUpdusrId={}", result.getLastUpdusrId());

            LOGGER.debug("getCommentPassword={}", result.getCommentPassword());
        }
    }

    /**
     * 댓글 DAO 단위 테스트: 조회(멀티건) 총 수
     */
    @Test
    public void testA30selectListTotCnt() {
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

        LOGGER.debug("totCnt={}", totCnt);

        // then
        assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), 1, totCnt);
    }

    /**
     * 댓글 DAO 단위 테스트: 조회(단건)
     */
    @Test
    public void testA40select() {
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
    public void testA50update() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        final Comment comment = new Comment();
        testData(board, loginVO, comment);

        // given
        comment.setCommentCn(comment.getCommentCn() + " > 수정 test 이백행 댓글 " + LocalDateTime.now());
        updateArticleComment(loginVO, comment);

        // when
        egovArticleCommentDAO.updateArticleComment(comment);

        // then
        assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, 1);
    }

    private void updateArticleComment(final LoginVO loginVO, final Comment comment) {
        comment.setLastUpdusrId(loginVO.getUniqId());
    }

    /**
     * 댓글 DAO 단위 테스트: 삭제
     */
    @Test
    public void testA60delete() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        final Comment comment = new Comment();
        testData(board, loginVO, comment);

        // given
        final CommentVO commentVO = new CommentVO();
        commentVO.setCommentNo(comment.getCommentNo());

        // when

        egovArticleCommentDAO.deleteArticleComment(commentVO);

        // then
        assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, 1);
    }

}
