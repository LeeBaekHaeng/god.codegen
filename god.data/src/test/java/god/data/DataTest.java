package god.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import egovframework.com.cmm.service.Globals;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 데이터 테스트
 * 
 * @author 이백행
 * @since 2024-08-01
 *
 */
@NoArgsConstructor
@Slf4j
public class DataTest {

	/**
	 * 테스트
	 */
	@Test
	public void test() {
		if (log.isDebugEnabled()) {
			log.debug("test");
			log.debug("DB_TYPE={}", Globals.DB_TYPE);
		}

		assertEquals("", "", "");
	}

}
