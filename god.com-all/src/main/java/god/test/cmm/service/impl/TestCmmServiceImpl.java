package god.test.cmm.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import god.test.cmm.service.TestCmmService;
import god.test.cmm.service.TestCmmVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestCmmServiceImpl extends EgovAbstractServiceImpl implements TestCmmService {

    private final TestCmmDAO testCmmDAO;

    @Override
    public void selectTestCmmList(TestCmmVO testCmmVO, ModelMap model) {

    }

    @Override
    public void insertTestCmmView(TestCmmVO testCmmVO, ModelMap model) {

    }

    @Override
    public void insertTestCmm(TestCmmVO testCmmVO, ModelMap model) {
        log.debug("testCmmVO={}", testCmmVO);
        log.debug("model={}", model);
        model.addAttribute("result", testCmmDAO.insertTestCmm(testCmmVO));
        log.debug("model={}", model);
    }

    @Override
    public void selectTestCmm(TestCmmVO testCmmVO, ModelMap model) {

    }

    @Override
    public void updateTestCmmView(TestCmmVO testCmmVO, ModelMap model) {

    }

    @Override
    public void updateTestCmm(TestCmmVO testCmmVO, ModelMap model) {

    }

    @Override
    public void deleteTestCmm(TestCmmVO testCmmVO, ModelMap model) {

    }

    @Override
    public int insertTestCmm(TestCmmVO testCmmVO) {

        return 0;
    }

    @Override
    public TestCmmVO selectTestCmm(TestCmmVO testCmmVO) {

        return null;
    }

    @Override
    public List<TestCmmVO> selectTestCmmList(TestCmmVO testCmmVO) {

        return null;
    }

    @Override
    public int selectTestCmmListTotCnt(TestCmmVO testCmmVO) {

        return 0;
    }

    @Override
    public int updateTestCmm(TestCmmVO testCmmVO) {

        return 0;
    }

    @Override
    public int deleteTestCmm(TestCmmVO testCmmVO) {

        return 0;
    }

}
