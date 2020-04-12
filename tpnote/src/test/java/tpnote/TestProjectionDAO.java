package tpnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;

import com.cinema.dao.FilmDAO;
import com.cinema.dao.ProjectionDAO;
import com.cinema.dao.SalleDAO;
import com.cinema.dto.FilmDto;
import com.cinema.dto.ProjectionDto;
import com.cinema.dto.SalleDto;

@TestMethodOrder(Alphanumeric.class)
public class TestProjectionDAO {
	
	private static ProjectionDAO dao = new ProjectionDAO();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		FilmDAO filmDao = new FilmDAO();
		filmDao.delete(999);
		filmDao.save(new FilmDto(999, "", "0000-00-00", "", ""));
		
		SalleDAO salleDao = new SalleDAO();
		salleDao.delete(999);
		salleDao.save(new SalleDto(999,45));
		
		dao.delete(999);
		dao.delete(998);
		
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		new FilmDAO().delete(999);
		new SalleDAO().delete(999);
	}
	
	@Test
	void test1SaveProjectionDto() {
		ProjectionDto projection = new ProjectionDto(999,"2020-03-03",20,19.99,999,999);
		assertTrue(dao.save(projection));
	}
	
	@Test
	void test2FindProjectionById() {
		ProjectionDto projection = dao.findById(999);
		assertEquals(projection.getId(),999);
		assertEquals(projection.getDate(),"2020-03-03");
		assertEquals(projection.getNb_place_libre(),20);
		assertEquals(projection.getTarif(),19.99);
		assertEquals(projection.getId_salle(),999);
		assertEquals(projection.getId_film(),999);
	}
	
	@Test
	void test3UpdateProjection() {
		ProjectionDto projection = new ProjectionDto();
		projection.setDate("2020-04-04");
		projection.setNb_place_libre(30);
		projection.setTarif(20.00);
		assertTrue(dao.update(999, projection));
		
		ProjectionDto projectionModified = dao.findById(999);
		assertEquals("2020-04-04",projectionModified.getDate());
		assertEquals(30,projectionModified.getNb_place_libre());
		assertEquals(20.00,projectionModified.getTarif());
	}

	@Test
	@Order(4)
	void test4DeleteProjection() {
		assertTrue(dao.delete(999));
	}
}
