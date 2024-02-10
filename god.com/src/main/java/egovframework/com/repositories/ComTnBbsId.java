package egovframework.com.repositories;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author 이백행
 * @since 2024-02-10
 *
 */
@Getter
@RequiredArgsConstructor
public class ComTnBbsId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5915943467378386471L;

	/**
	 * `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
	 */
	private long nttId;

	/**
	 * `BBS_ID` char(30) NOT NULL COMMENT '게시판ID',
	 */
	private String bbsId;

	/**
	 * 
	 * @param nttId
	 * @param bbsId
	 */
	@Builder
	public ComTnBbsId(final long nttId, final String bbsId) {
		super();
		this.nttId = nttId;
		this.bbsId = bbsId;
	}

}
