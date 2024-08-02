package god.data.a.a.a.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import god.data.a.a.a.service.DataAaaResponseVO;
import lombok.NoArgsConstructor;

/**
 * 공통상세코드 서비스별 개별 메시지바디
 * 
 * @author 이백행
 * @since 2024-08-02
 *
 */
@NoArgsConstructor
public class DataAaaResponseMsgBody {

	/**
	 * 
	 */
	private List<DataAaaResponseVO> results;

	/**
	 * 
	 */
	private PaginationInfo paginationInfo;

	public List<DataAaaResponseVO> getResults() {
		return results;
	}

	public void setResults(final List<DataAaaResponseVO> results) {
		this.results = results;
	}

	public PaginationInfo getPaginationInfo() {
		return paginationInfo;
	}

	public void setPaginationInfo(final PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

}
