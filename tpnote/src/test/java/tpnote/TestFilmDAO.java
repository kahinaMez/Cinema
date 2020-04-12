package tpnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;

import com.cinema.dao.FilmDAO;
import com.cinema.dto.FilmDto;

@TestMethodOrder(Alphanumeric.class)
public class TestFilmDAO {
	
	private static FilmDAO dao = new FilmDAO();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao.delete(999);
		dao.delete(998);
	}
	
	@Test
	void test1SaveFilmDto() {
		FilmDto film = new FilmDto(999,"the-film","2020-01-01","action","");
		assertTrue(dao.save(film));
	}
	
	@Test
	void test2FindById() {
		FilmDto film = dao.findById(999);
		assertTrue(999==film.getId());
		assertTrue("the-film".equals(film.getTitre()));
		assertTrue("2020-01-01".equals(film.getDate_sortie()));
		assertTrue("action".equals(film.getGenre()));
		assertTrue("".equals(film.getUrl()));
	}
	
	@Test
	void test3UpdateFilmDto() {
		FilmDto updatedFilm = new FilmDto();
		updatedFilm.setTitre("aaaa");
		assertTrue(dao.update(999, updatedFilm));
		
		FilmDto filmModified = dao.findById(999);
		assertEquals("aaaa",filmModified.getTitre());
	}

	@Test
	@Order(4)
	void test4DeleteFilm() {
		assertTrue(dao.delete(999));
	}
}
