package tdd;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bugsprod.geektic.City;

public class CityTests {

	City java;
	List<City> inters;
	
	@Before
	public void setUp() {
		java = new City(0, "Lyon");
		inters = new ArrayList<City>();
	}
	
	@Test
	public void equalsStringTest() {
		assertEquals(true, java.equals("Lyon"));
	}
	
	@Test
	public void equalsCityTest() {
		City inter2 = new City(1, "Lyon");
		assertEquals(true, java.equals(inter2));
	}

}
