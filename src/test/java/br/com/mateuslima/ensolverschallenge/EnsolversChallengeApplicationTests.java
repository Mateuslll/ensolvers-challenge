package br.com.mateuslima.ensolverschallenge;

import br.com.mateuslima.ensolverschallenge.entity.UserNotes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
class EnsolversChallengeApplicationTests {
@Autowired
//version async test
private WebTestClient webTestClient;
	@Test
	void testCreateTodoSucess() {
		var userNotes = new UserNotes("Food","description one", false, 1,"filed");
	}
	@Test
	void testCreateTodoFailure(){

	}

}
