package god.test.a.a.a.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.a.a.a.service.TestAAAVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class TestAAADAO extends GodComCmmDAOImpl<TestAAAVO, TestAAAVO> {

    /**
     * mapperNamespace 값설정
     */
    public TestAAADAO() {
        super("GodTestAAADAO");
    }

    @Override
    public int insert(final TestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.insert(vo);
    }

    public int insert2(final TestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.insert(getMapperNamespace() + "insert2", vo);
    }

    @Override
    public TestAAAVO select(final TestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.select(vo);
    }

    public TestAAAVO select2(final TestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.selectOne(super.getMapperNamespace() + "select2", vo);
    }

    @Override
    public List<TestAAAVO> selectList(TestAAAVO vo) {
        return super.selectList(vo);
    }

    @Override
    public int selectListTotCnt(TestAAAVO vo) {
        return super.selectListTotCnt(vo);
    }

    @Override
    public int update(TestAAAVO vo) {
        return super.update(vo);
    }

    public int update2(final TestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "update2", vo);
    }

    @Override
    public int delete(TestAAAVO vo) {
        return super.delete(vo);
    }

    public int delete2(final TestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "delete2", vo);
    }

    @Override
    public int merge(TestAAAVO vo) {
        return super.merge(vo);
    }

    @Override
    public int multi(TestAAAVO vo) {
        return super.multi(vo);
    }

}
