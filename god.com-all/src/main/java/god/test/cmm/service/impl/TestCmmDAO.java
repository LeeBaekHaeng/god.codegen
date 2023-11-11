package god.test.cmm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import god.test.cmm.service.TestCmmVO;

@Repository
public class TestCmmDAO extends EgovComAbstractDAO {

    public int insertTestCmm(TestCmmVO testCmmVO) {
        return insert("TestCmmDAO.insertTestCmm", testCmmVO);
    }

    public TestCmmVO selectTestCmm(TestCmmVO testCmmVO) {
        return selectOne("TestCmmDAO.selectTestCmm", testCmmVO);
    }

    public List<TestCmmVO> selectTestCmmList(TestCmmVO testCmmVO) {
        return selectList("TestCmmDAO.selectTestCmmList", testCmmVO);
    }

    public int selectTestCmmListTotCnt(TestCmmVO testCmmVO) {
        return selectOne("TestCmmDAO.selectTestCmmListTotCnt", testCmmVO);
    }

    public int updateTestCmm(TestCmmVO testCmmVO) {
        return update("TestCmmDAO.updateTestCmm", testCmmVO);
    }

    public int deleteTestCmm(TestCmmVO testCmmVO) {
        return delete("TestCmmDAO.deleteTestCmm", testCmmVO);
    }

}
