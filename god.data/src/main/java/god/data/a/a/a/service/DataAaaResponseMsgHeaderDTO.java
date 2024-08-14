package god.data.a.a.a.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 공통상세코드 응답 제공 기관별 공통 메시지헤더
 * 
 * @author 이백행
 * @since 2024-08-02
 *
 */
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class DataAaaResponseMsgHeaderDTO {

	/**
	 * 
	 */
	private String header;

}
