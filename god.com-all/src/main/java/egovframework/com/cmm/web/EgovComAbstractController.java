/**
 *
 */
package egovframework.com.cmm.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.Globals;
import egovframework.com.cmm.util.EgovUserDetailsHelper;

/**
 * EgovComAbstractController.java 클래스
 *
 * @author 이백행
 * @since 2022. 5. 4.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2022. 5. 4.   이백행        최초 생성
 *      </pre>
 */
public abstract class EgovComAbstractController {

    protected static final Logger egovLogger = LoggerFactory.getLogger(EgovComAbstractController.class);

    @Resource(name = "propertiesService")
    protected EgovPropertyService egovPropertyService;

    protected PaginationInfo builderPaginationInfo(ComDefaultVO comDefaultVO) {
        if (comDefaultVO.getPageUnit() == 10) {
            comDefaultVO.setPageUnit(egovPropertyService.getInt("pageUnit"));
        }
        if (comDefaultVO.getPageSize() == 10) {
            comDefaultVO.setPageSize(egovPropertyService.getInt("pageSize"));
        }

        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(comDefaultVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(comDefaultVO.getPageUnit());
        paginationInfo.setPageSize(comDefaultVO.getPageSize());

        comDefaultVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
        comDefaultVO.setLastIndex(paginationInfo.getLastRecordIndex());
        comDefaultVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        return paginationInfo;
    }

    @ModelAttribute("Globals")
    protected Map<String, String> getGlobals() {
        Map<String, String> map = new HashMap<>();
        map.put("OS_TYPE", Globals.OS_TYPE);
        map.put("DB_TYPE", Globals.DB_TYPE);
        map.put("MAIN_PAGE", Globals.MAIN_PAGE);
        return map;
    }

    @ModelAttribute
    protected LoginVO getLoginVO() {
        return (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    }

}
