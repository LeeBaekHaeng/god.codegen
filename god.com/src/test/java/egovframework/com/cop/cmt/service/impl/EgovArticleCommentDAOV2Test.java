package egovframework.com.cop.cmt.service.impl;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.annotation.Resource;

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
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.cop.bbs.service.Board;
import egovframework.com.cop.bbs.service.BoardMaster;
import egovframework.com.cop.bbs.service.impl.BBSAddedOptionsDAO;
import egovframework.com.cop.bbs.service.impl.EgovArticleDAO;
import egovframework.com.cop.bbs.service.impl.EgovBBSMasterDAO;
import egovframework.com.cop.cmt.service.Comment;
import egovframework.com.test.EgovAbstractDAOV2Test;
import lombok.RequiredArgsConstructor;

/**
 * 댓글 DAO 단위 테스트
 * 
 * @author 이백행
 *
 */
@ContextConfiguration(classes = { EgovAbstractDAOV2Test.class, EgovArticleCommentDAOV2Test.class, })

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
public class EgovArticleCommentDAOV2Test extends EgovAbstractDAOV2Test {

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
            egovLogger.error("FdlException egovBBSMstrIdGnrService");
        }
        egovBBSMasterDAO.insertBBSMasterInf(boardMaster);

        try {
            board.setNttId(egovNttIdGnrService.getNextLongId());
        } catch (FdlException e) {
            egovLogger.error("FdlException egovNttIdGnrService");
        }
        board.setBbsId(boardMaster.getBbsId());
        egovArticleDAO.insertArticle(board);
    }

    /**
     * 댓글 DAO 단위 테스트: 등록
     */
    @Test
//    @Commit
    public void testA10Insert() {
        final Board board = new Board();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        testData(board, loginVO);

        // given
        final Comment comment = new Comment();
        try {
            comment.setCommentNo(String.valueOf(egovAnswerNoGnrService.getNextLongId()));
        } catch (FdlException e) {
            egovLogger.error("FdlException egovAnswerNoGnrService");
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
            egovLogger.error("DataAccessException insertArticleComment");

            egovLogger.error(egovMessageSource.getMessage("fail.common.msg"));

            final SQLException sqle = (SQLException) e.getCause();
            egovLogger.error(egovMessageSource.getMessageArgs("fail.common.sql", args(sqle)));

            egovLogger.error(egovMessageSource.getMessage("fail.common.insert"));

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

}
