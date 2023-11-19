package god.test.a.a.a.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.a.a.a.service.GodTestAAAVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class GodTestAAADAO extends GodComCmmDAOImpl<GodTestAAAVO, GodTestAAAVO> {

    /**
     * mapperNamespace 값설정
     */
    public GodTestAAADAO() {
        super("GodTestAAADAO");
    }

    @Override
    public int insert(final GodTestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.insert(vo);
    }

    public int insert2(final GodTestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.insert(getMapperNamespace() + "insert2", vo);
    }

    @Override
    public GodTestAAAVO select(final GodTestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.select(vo);
    }

    public GodTestAAAVO select2(final GodTestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.selectOne(super.getMapperNamespace() + "select2", vo);
    }

    @Override
    public List<GodTestAAAVO> selectList(GodTestAAAVO vo) {
        return super.selectList(vo);
    }

    @Override
    public int selectListTotCnt(GodTestAAAVO vo) {
        return super.selectListTotCnt(vo);
    }

    @Override
    public int update(GodTestAAAVO vo) {
        return super.update(vo);
    }

    public int update2(final GodTestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "update2", vo);
    }

    @Override
    public int delete(GodTestAAAVO vo) {
        return super.delete(vo);
    }

    public int delete2(final GodTestAAAVO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "delete2", vo);
    }

    @Override
    public int merge(GodTestAAAVO vo) {
        return super.merge(vo);
    }

    @Override
    public int multi(GodTestAAAVO vo) {
        return super.multi(vo);
    }

}
