package egovframework.com.cop.cmt.service.impl;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cop.bbs.service.impl.BBSAddedOptionsDAO;
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
    @Resource(name = "egovAnswerNoGnrService")
    private EgovIdGnrService egovAnswerNoGnrService;

    /**
     * 메시지 리소스 사용을 위한 MessageSource 인터페이스 및 ReloadableResourceBundleMessageSource 클래스의 구현체
     */
    @Resource(name = "egovMessageSource")
    private EgovMessageSource egovMessageSource;

    /**
     * 테스트
     */
    @Test
    public void testa10insertArticleComment() {
        // given
        final Comment comment = new Comment();

        try {
            comment.setCommentNo(String.valueOf(egovAnswerNoGnrService.getNextLongId()));
        } catch (FdlException e) {
            egovLogger.error("FdlException egovAnswerNoGnrService");
        }

        // when
        boolean result = true;
        try {
            egovArticleCommentDAO.insertArticleComment(comment);
        } catch (DataAccessException e) {
            egovLogger.error("DataAccessException insertArticleComment");

            egovLogger.error(egovMessageSource.getMessage("fail.common.msg"));

            final SQLException sqle = (SQLException) e.getCause();
            egovLogger.error(egovMessageSource.getMessageArgs("fail.common.sql", args(sqle)));

            egovLogger.error(egovMessageSource.getMessage("fail.common.insert"));

            result = false;
        }

        // then
        assertTrue(egovMessageSource.getMessage("success.common.insert"), result);
    }

    private Object[] args(final SQLException sqle) {
        return new Object[] { sqle.getErrorCode(), sqle.getMessage(), sqle.getSQLState(), };
//        return new Object[] { sqle.getErrorCode(), sqle.getSQLState(), sqle.getMessage(), };
    }

}
