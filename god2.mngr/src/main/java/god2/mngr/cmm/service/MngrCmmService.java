package god2.mngr.cmm.service;

import java.util.List;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;

public interface MngrCmmService {

	List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo);

}
