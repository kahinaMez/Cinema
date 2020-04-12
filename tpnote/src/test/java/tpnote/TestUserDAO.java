package tpnote;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cinema.dao.UserDAO;
import com.cinema.dto.UserDto;

@TestMethodOrder(Alphanumeric.class)
class TestUserDAO {
	
	private static UserDAO dao = new UserDAO();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao.delete(999);
		dao.delete(998);
	}
	
	@Test
	void test1SaveUserDto() {
		UserDto user = new UserDto(999,"MEZIANI","Kahina","1993-07-06","","123456789","test@test.com");
		assertTrue(dao.save(user));
	}
	
	@Test
	void test2FindById() {
		UserDto user = dao.findById(999);
		assertTrue(999==user.getId());
		assertTrue("MEZIANI".equals(user.getNom()));
		assertTrue("Kahina".equals(user.getPrenom()));
		assertTrue("1993-07-06".equals(user.getDate()));
		assertTrue("".equals(user.getAdresse()));
		assertTrue("123456789".equals(user.getMdp()));
		assertTrue("test@test.com".equals(user.getMail()));
	}
	
	@Test
	void test3UpdateUserDto() {
		UserDto updatedUser = new UserDto();
		updatedUser.setNom("aaaa");
		assertTrue(dao.update(999, updatedUser));
	}

	@Test
	@Order(4)
	void test4DeleteUser() {
		assertTrue(dao.delete(999));
	}

}
