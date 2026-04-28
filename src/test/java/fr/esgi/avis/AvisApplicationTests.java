package fr.esgi.avis;

import fr.esgi.avis.application.security.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class AvisApplicationTests {

	@MockitoBean
    JwtService jwtService;

	@Test
	void contextLoads() {
	}

}
