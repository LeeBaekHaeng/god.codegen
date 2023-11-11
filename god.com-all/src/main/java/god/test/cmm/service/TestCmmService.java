package god.test.cmm.service;

import java.util.List;

import org.springframework.ui.ModelMap;

public interface TestCmmService {

    /**
     * 목록 화면
     * 
     * @param testCmmVO
     * @param model
     */
    void selectTestCmmList(final TestCmmVO testCmmVO, final ModelMap model);

    /**
     * 등록 화면
     * 
     * @param testCmmVO
     * @param model
     */
    void insertTestCmmView(final TestCmmVO testCmmVO, final ModelMap model);

    /**
     * 등록
     * 
     * @param testCmmVO
     * @param model
     */
    void insertTestCmm(final TestCmmVO testCmmVO, final ModelMap model);

    /**
     * 상세 화면
     * 
     * @param testCmmVO
     * @param model
     */
    void selectTestCmm(final TestCmmVO testCmmVO, final ModelMap model);

    /**
     * 수정 화면
     * 
     * @param testCmmVO
     * @param model
     */
    void updateTestCmmView(final TestCmmVO testCmmVO, final ModelMap model);

    /**
     * 수정
     * 
     * @param testCmmVO
     * @param model
     */
    void updateTestCmm(final TestCmmVO testCmmVO, final ModelMap model);

    /**
     * 삭제
     * 
     * @param testCmmVO
     * @param model
     */
    void deleteTestCmm(final TestCmmVO testCmmVO, final ModelMap model);

    /**
     * 등록
     * 
     * @param testCmmVO
     * @return
     */
    int insertTestCmm(final TestCmmVO testCmmVO);

    /**
     * 조회(단건)
     * 
     * @param testCmmVO
     * @return
     */
    TestCmmVO selectTestCmm(final TestCmmVO testCmmVO);

    /**
     * 조회(멀티건)
     * 
     * @param testCmmVO
     * @return
     */
    List<TestCmmVO> selectTestCmmList(final TestCmmVO testCmmVO);

    /**
     * 조회(멀티건) 전체 게시물 건 수
     * 
     * @param testCmmVO
     * @return
     */
    int selectTestCmmListTotCnt(final TestCmmVO testCmmVO);

    /**
     * 수정
     * 
     * @param testCmmVO
     * @return
     */
    int updateTestCmm(final TestCmmVO testCmmVO);

    /**
     * 삭제
     * 
     * @param testCmmVO
     * @return
     */
    int deleteTestCmm(final TestCmmVO testCmmVO);

}
