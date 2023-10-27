package com.springboot.main;

import java.util.Arrays;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import god.api.cmm.service.ApiGlobals;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 배치실행개발팀
 * @since 2021. 11.25
 * @version 1.0
 * @see
 *  <pre>
 *      개정이력(Modification Information)
 *
 *  수정일               수정자                 수정내용
 *  ----------   -----------   ---------------------------
 *  2021.11.25   신용호                 최초 생성
 *  
 *  </pre>
 */

@SpringBootApplication
@ImportResource({"classpath*:/egovframework/batch/context-*.xml"})
@Import(EgovBootInitialization.class)
@EnableBatchProcessing
@Slf4j
public class EgovBootApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EgovBootApplication.class, args);

		System.out.println("##### EgovSampleBootApplication Start #####");

		ApplicationContext context = new SpringApplicationBuilder(EgovBootApplication.class)
                .headless(false)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
		ApiGlobals.createApiGlobals(context.getEnvironment());
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (int i = 0; i < beanDefinitionNames.length; i++) {
//            System.out.println(beanDefinitionNames[i]);
//        }
//        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        Arrays.stream(beanDefinitionNames).forEach(log::debug);
		/*
		SpringApplication springApplication = new SpringApplication(EgovBootApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.setLogStartupInfo(false);
		springApplication.run(args);
		*/
		System.out.println("##### EgovSampleBootApplication End #####");
	}
	
}
