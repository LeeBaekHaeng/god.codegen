package god.data.a.a.a.service;

import god.data.cmm.service.DataCmmResponseDTO;

/**
 * 공통상세코드 Service
 * 
 * @author 이백행
 * @since 2024-07-26
 *
 */
public interface DataAaaService {

	/**
	 * 공통상세코드 조회(단건)
	 * 
	 * @param requestDTO
	 * @return
	 */
	DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> selectDataAaa(
			DataAaaRequestDTO requestDTO);

}
