package egovframework.com.test;

import org.springframework.test.context.ContextConfiguration;

import lombok.RequiredArgsConstructor;

/**
 * DAO 테스트
 * 
 * @author 이백행
 */

@ContextConfiguration(locations = {

//		"classpath*:egovframework/spring/com/**/context-*.xml",

        "classpath*:egovframework/spring/com/context-*.xml",

        "classpath*:egovframework/spring/com/idgn/context-*.xml",

        "classpath*:egovframework/spring/com/scheduling/context-*.xml",

})

@RequiredArgsConstructor

public class EgovTestAbstractDAO2 extends EgovTestAbstract {

}
