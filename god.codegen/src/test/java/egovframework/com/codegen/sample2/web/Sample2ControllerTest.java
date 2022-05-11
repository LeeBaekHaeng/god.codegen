package egovframework.com.codegen.sample2.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath*:egovframework/spring/com/**/context-*.xml",
		"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml" })
@ActiveProfiles("mysql")
public class Sample2ControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(wac).build();
	}

	@Test
	public void test() throws Exception {
//		this.mockMvc
//				.perform(get("/sample2/selectSample2List.do")
//						.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//				.andExpect(status().isOk()).andExpect(content().contentType("application/json"))
//				.andExpect(jsonPath("$.name").value("Lee"));

		this.mockMvc.perform(get("/sample2/selectSample2List.do")).andDo(print()).andExpect(status().isOk());
	}

}
