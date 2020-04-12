package tpnote;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cinema.dao.ActeurDAO;
import com.cinema.dto.ActeurDto;

@TestMethodOrder(Alphanumeric.class)
class TestActeurDAO {
	
	private static ActeurDAO dao = new ActeurDAO();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao.delete(999);
		dao.delete(998);
	}
	
	@Test
	void test1SaveActeurDto() {
		ActeurDto acteur=new ActeurDto(999,"meziani","kahina","1993-07-06");
		assertTrue(dao.save(acteur));
	}
	
	@Test
	void test2FindById() {
		ActeurDto acteur = dao.findById(999);
		assertTrue(999==acteur.getId());
		assertTrue("meziani".equals(acteur.getNom()));
		assertTrue("kahina".equals(acteur.getPrenom()));
		assertTrue("1993-07-06".equals(acteur.getDate_naissance()));
	}
	
	@Test
	void test3UpdateActeurDto() {
		ActeurDto updatedActeur = new ActeurDto();
		updatedActeur.setNom("aaaa");
		assertTrue(dao.update(999, updatedActeur));
	}

	@Test
	@Order(4)
	void test4DeleteActeur() {
		assertTrue(dao.delete(999));
	}

}
