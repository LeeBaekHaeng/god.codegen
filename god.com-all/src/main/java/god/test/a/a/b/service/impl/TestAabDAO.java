package god.test.a.a.b.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.a.a.b.service.TestAabVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class TestAabDAO extends GodComCmmDAOImpl<TestAabVO, TestAabVO> {

    /**
     * mapperNamespace 값설정
     */
    public TestAabDAO() {
        super("GodTestAabDAO");
    }

    @Override
    public int insert(final TestAabVO vo) {
        log.debug("vo={}", vo);
        return super.insert(vo);
    }

    public int insert2(final TestAabVO vo) {
        log.debug("vo={}", vo);
        return super.insert(getMapperNamespace() + "insert2", vo);
    }

    @Override
    public TestAabVO select(final TestAabVO vo) {
        log.debug("vo={}", vo);
        return super.select(vo);
    }

    public TestAabVO select2(final TestAabVO vo) {
        log.debug("vo={}", vo);
        return super.selectOne(super.getMapperNamespace() + "select2", vo);
    }

    @Override
    public List<TestAabVO> selectList(TestAabVO vo) {
        return super.selectList(vo);
    }

    @Override
    public int selectListTotCnt(TestAabVO vo) {
        return super.selectListTotCnt(vo);
    }

    @Override
    public int update(TestAabVO vo) {
        return super.update(vo);
    }

    public int update2(final TestAabVO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "update2", vo);
    }

    @Override
    public int delete(TestAabVO vo) {
        return super.delete(vo);
    }

    public int delete2(final TestAabVO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "delete2", vo);
    }

    @Override
    public int merge(TestAabVO vo) {
        return super.merge(vo);
    }

    @Override
    public int multi(TestAabVO vo) {
        return super.multi(vo);
    }

}
