package tpnote;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.cinema.dao.ActeurDAO;
import com.cinema.dto.ActeurDto;

class TestActeurDAO {
	
	private static ActeurDAO dao = new ActeurDAO();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao.delete(999);
	}
	
	@Test
	@Order(1)
	void testSaveActeurDto() {
		ActeurDto acteur=new ActeurDto(999,"meziani","kahina","1993-07-06");
		assertTrue(dao.save(acteur));
	}
	
	@Test
	@Order(2)
	void testFindByIdInt() {
		ActeurDto acteur = dao.findById(999);
		assertTrue(999==acteur.getId());
		assertTrue("meziani".equals(acteur.getNom()));
		assertTrue("kahina".equals(acteur.getPrenom()));
		assertTrue("1993-07-06".equals(acteur.getDate_naissance()));
	}
	
	@Test
	void testUpdateIntActeurDto() {
		ActeurDto updatedActeur = new ActeurDto();
		updatedActeur.setId(998);
		dao.update(999, updatedActeur);
	}

	@Test
	void testDelete() {
		
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}



	

	

}
