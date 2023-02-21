package com.present.webdrawer.webdrawer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
class WebdrawerApplicationTestsLocal {

	@Test
	@DirtiesContext
	void contextLoads() {
	}

}
