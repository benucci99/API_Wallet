package br.com.wallet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	@Autowired
	UserRepository repository;
	
	@Before
	public void setUp() {
		User u = new User();
		u.setName("Set up User");
		u.setPassword("senha123");
		u.setEmail(EMAIL);
		
	}
	
	@After
	public void tearDown() {
		
		repository.deleteAll();
		
	}
	
	
	@Test
	public void testSave() {
		User u = new User();
		u.setName("Teste");
		u.setPassword("123456");
		u.setEmail("teste@teste.com");
		
		User response = repository.save(u);
		
		assertNotNull(response);
		
	}
	
	
	
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmail(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
		
		
	}

}
