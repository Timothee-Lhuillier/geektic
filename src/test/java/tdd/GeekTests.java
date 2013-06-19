package tdd;
import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.bugsprod.model.Geek;

public class GeekTests {

	Geek kevin;
	Geek julie;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		kevin = new Geek(0l, "Dupond", "Kevin", true);
		julie = new Geek(1l, "Ker", "Julie", false );
		julie.setDateOfBirth(new Date(90,11,05)); //date of birth 1990-12-05
	}
	
	@Test
	public void getGenderString_geek() {
		assertEquals("geek", kevin.getGenderString());
	}
	
	@Test
	public void getGenderString_geekette() {
		assertEquals("geekette", julie.getGenderString());
	}
	
	@Test
	public void getFrDateOfBirth_geekette() {
		assertEquals("05/12/1990", julie.getFrDateOfBirth());
	}
}
