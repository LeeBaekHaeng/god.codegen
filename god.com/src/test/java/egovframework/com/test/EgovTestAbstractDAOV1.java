package egovframework.com.test;

import org.springframework.test.context.ContextConfiguration;

import lombok.RequiredArgsConstructor;

@ContextConfiguration(locations = {

//		"classpath*:egovframework/spring/com/**/context-*.xml",

        "classpath*:egovframework/spring/com/context-*.xml",

        "classpath*:egovframework/spring/com/idgn/context-*.xml",

        "classpath*:egovframework/spring/com/scheduling/context-*.xml",

})

@RequiredArgsConstructor

/**
 * DAO 단위 테스트
 * 
 * @author 이백행
 *
 */
public class EgovTestAbstractDAOV1 extends EgovTestAbstract {

}
