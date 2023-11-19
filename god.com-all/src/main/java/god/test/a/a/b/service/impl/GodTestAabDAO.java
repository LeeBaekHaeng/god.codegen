package god.test.a.a.b.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.a.a.b.service.GodTestAabVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class GodTestAabDAO extends GodComCmmDAOImpl<GodTestAabVO, GodTestAabVO> {

    /**
     * mapperNamespace 값설정
     */
    public GodTestAabDAO() {
        super("GodTestAabDAO");
    }

    @Override
    public int insert(final GodTestAabVO vo) {
        log.debug("vo={}", vo);
        return super.insert(vo);
    }

    public int insert2(final GodTestAabVO vo) {
        log.debug("vo={}", vo);
        return super.insert(getMapperNamespace() + "insert2", vo);
    }

    @Override
    public GodTestAabVO select(final GodTestAabVO vo) {
        log.debug("vo={}", vo);
        return super.select(vo);
    }

    public GodTestAabVO select2(final GodTestAabVO vo) {
        log.debug("vo={}", vo);
        return super.selectOne(super.getMapperNamespace() + "select2", vo);
    }

    @Override
    public List<GodTestAabVO> selectList(GodTestAabVO vo) {
        return super.selectList(vo);
    }

    @Override
    public int selectListTotCnt(GodTestAabVO vo) {
        return super.selectListTotCnt(vo);
    }

    @Override
    public int update(GodTestAabVO vo) {
        return super.update(vo);
    }

    public int update2(final GodTestAabVO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "update2", vo);
    }

    @Override
    public int delete(GodTestAabVO vo) {
        return super.delete(vo);
    }

    public int delete2(final GodTestAabVO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "delete2", vo);
    }

    @Override
    public int merge(GodTestAabVO vo) {
        return super.merge(vo);
    }

    @Override
    public int multi(GodTestAabVO vo) {
        return super.multi(vo);
    }

}
