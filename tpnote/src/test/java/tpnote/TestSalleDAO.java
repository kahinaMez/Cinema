package tpnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;

import com.cinema.dao.SalleDAO;
import com.cinema.dto.SalleDto;

@TestMethodOrder(Alphanumeric.class)
public class TestSalleDAO {
	
	private static SalleDAO dao = new SalleDAO();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao.delete(999);
		dao.delete(998);
	}
	
	@Test
	public void test1CreateSalle() {
		SalleDto salle = new SalleDto(999,50);
		assertTrue(dao.save(salle));
	}
	
	@Test
	public void test2FindSalleById() {
		SalleDto salle = dao.findById(999);
		assertEquals(salle.getN_salle(),999);
		assertEquals(salle.getNb_place(),50);
	}
	
	@Test
	public void test3UpdateSalleById() {
		SalleDto beforeUpdate = dao.findById(999);
		assertEquals(beforeUpdate.getNb_place(),50);
		
		SalleDto toUpdate = new SalleDto();
		toUpdate.setNb_place(100);
		
		assertTrue(dao.update(999, toUpdate));
		SalleDto updated = dao.findById(999);
		
		assertEquals(updated.getNb_place(),100);
		
		toUpdate.setN_salle(998);
		assertTrue(dao.update(999,toUpdate));
		
		updated = dao.findById(998);
		assertEquals(updated.getN_salle(),998);
		assertEquals(updated.getNb_place(),100);
	}
	
	@Test
	public void test4DeleteSalleById() {
		assertTrue(dao.delete(998));
	}
}
