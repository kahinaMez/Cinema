package tpnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;

import com.cinema.dao.FilmDAO;
import com.cinema.dao.ProjectionDAO;
import com.cinema.dao.ReservationDAO;
import com.cinema.dao.SalleDAO;
import com.cinema.dao.UserDAO;
import com.cinema.dto.FilmDto;
import com.cinema.dto.ProjectionDto;
import com.cinema.dto.ReservationDto;
import com.cinema.dto.SalleDto;
import com.cinema.dto.UserDto;

@TestMethodOrder(Alphanumeric.class)
public class TestReservationDAO {
	private static ReservationDAO dao = new ReservationDAO();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		UserDAO userdao = new UserDAO();
		userdao.delete(999);
		userdao.save(new UserDto(999,"","","0000-00-00","","",""));
		
		FilmDAO filmDao = new FilmDAO();
		filmDao.delete(999);
		filmDao.save(new FilmDto(999, "", "0000-00-00", "", ""));
		
		SalleDAO salleDao = new SalleDAO();
		salleDao.delete(999);
		salleDao.save(new SalleDto(999,45));
		
		ProjectionDAO pjDao = new ProjectionDAO();
		pjDao.delete(999);
		pjDao.save(new ProjectionDto(999,"0000-00-00",0,0,999,999));
		
		dao.delete(999);
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		new UserDAO().delete(999);
		new FilmDAO().delete(999);
		new SalleDAO().delete(999);
		new ProjectionDAO().delete(999);
	}
	
	@Test
	void test1SaveReservationDto() {
		System.out.println("");
		ReservationDto reservation = new ReservationDto(999,999,999,"2020-04-04",false);
		assertTrue(dao.save(reservation));
	}
	
	@Test
	void test2FindById() {
		ReservationDto reservation = dao.findById(999);
		assertEquals(reservation.getId_user(),999);
		assertEquals(reservation.getId_projection(),999);
		assertEquals(reservation.getN_reservation(),999);
		assertEquals(reservation.getDateReservation(),"2020-04-04");
		assertFalse(reservation.isValidation());
	}
	
	@Test
	void test3UpdateReservationDto() {
		ReservationDto reservation = new ReservationDto();
		reservation.setValidation(true);
		reservation.setDateReservation("2020-04-05");
		
		assertTrue(dao.update(999, reservation));
		
		ReservationDto modified = dao.findById(999);
		assertTrue(modified.isValidation());
		assertEquals(modified.getDateReservation(),"2020-04-05");
		
	}

	@Test
	void test4DeleteReservation() {
		assertTrue(dao.delete(999));
	}
}
