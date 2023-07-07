package egovframework.com.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import lombok.RequiredArgsConstructor;

/**
 * DAO 테스트
 * 
 * @author 이백행
 */

@Configuration

@ImportResource({

//		"classpath*:egovframework/spring/com/**/context-*.xml",

        "classpath*:egovframework/spring/com/test-context-common.xml",

        "classpath*:egovframework/spring/com/context-crypto.xml",
        "classpath*:egovframework/spring/com/context-datasource.xml",
        "classpath*:egovframework/spring/com/context-egovuserdetailshelper.xml",
        "classpath*:egovframework/spring/com/context-mapper.xml",
        "classpath*:egovframework/spring/com/context-transaction.xml",

})

@RequiredArgsConstructor

public class EgovTestAbstractDAO extends EgovTestAbstract {

}
