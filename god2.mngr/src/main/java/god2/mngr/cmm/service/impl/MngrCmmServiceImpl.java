package god2.mngr.cmm.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.impl.CmmUseDAO;
import god2.mngr.cmm.service.MngrCmmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MngrCmmServiceImpl extends EgovAbstractServiceImpl implements MngrCmmService {

	private final CmmUseDAO cmmUseDAO;

	@Override
	public List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo={}", vo);
		}
		try {
			return cmmUseDAO.selectCmmCodeDetail(vo);
		} catch (Exception e) {
			throw new BaseRuntimeException("Exception: selectCmmCodeDetail", e);
		}
	}

}
