package com.hsc.tacocloud;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// class DemoApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// }
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//它会让这个测试在 Spring MVC 应用的上下文中执行。
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)

public class HomeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/")) // 发起对 “/”的get
		.andExpect(status().isOk()) //期望得到 HTTP 200
		.andExpect(view().name("home")) //期望得到 home 视图
		.andExpect(content().string(
			containsString("Welcome to...")
		))
	}
}
