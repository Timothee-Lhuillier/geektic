package tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bugsprod.geektic.City;
import com.bugsprod.geektic.Geek;
import com.bugsprod.geektic.GeekDao;
import com.bugsprod.geektic.GeekService;
import com.bugsprod.geektic.Interest;
import com.bugsprod.geektic.View;

public class GeekServiceTest {

	String ip;
	Geek kevin;
	Geek julie;
	Geek paul;
	Interest java;
	Interest cpp;
	City lyon;
	
	String gender;
	String inters;
	String cities;
	List<Geek> geeks;
	
	GeekDao mockedGD;
	
	GeekService gServM;
	
	@Before
	public void setUp() {
		ip = "127.0.0.1";
		kevin = new Geek(0l, "Dupond", "Kevin");
		kevin.setViews(new ArrayList<View>());
		julie = new Geek(1l, "Ker", "Julie" );
		julie.setViews(new ArrayList<View>());
		paul = new Geek(2l, "Dupond", "Paul");
		paul.setViews(new ArrayList<View>());
		java = new Interest(0, "java");
		cpp = new Interest(0, "C++");
		lyon = new City(0,"Lyon");
		
		gender = "true";
		
		geeks = new ArrayList<Geek>();
		
		mockedGD = mock(GeekDao.class);
		
		gServM = new GeekService(mockedGD);
	}

	@Test
	public void luckyFindGeek_OneGeek_Test() {
		inters = "java";
		cities = "Lyon";

		geeks.add(paul);
		geeks.add(kevin);
		
		when(mockedGD.findGeeks(true, inters.split(", "), cities.split(", "))).thenReturn(geeks);
		
		assertEquals(Geek.class, gServM.findLuckyGeek(gender, inters, cities, ip).getClass());
	}
	
	@Test
	public void luckyFindGeek_Paul_Test() {
		inters = "C++";
		cities = "Lyon";
		
		geeks.add(paul);
		
		when(mockedGD.findGeeks(true, inters.split(", "), cities.split(", "))).thenReturn(geeks);
		
		assertEquals(2l, gServM.findLuckyGeek(gender, inters, cities, ip).getId());
	}
	
	@Test
	public void luckyFindGeek_TwoLucky_Test() {
		inters = "java";
		cities = "Lyon";

		kevin.getViews().add(new View(kevin, ip));
	    try{
	    	Thread.sleep(100);
	    }catch(InterruptedException e){}
		paul.getViews().add(new View(paul, ip));
		geeks.add(kevin);
		geeks.add(paul);
		
		when(mockedGD.findGeeks(true, inters.split(", "), cities.split(", "))).thenReturn(geeks);
		
		gServM.findLuckyGeek(gender, inters, cities, ip).getId();
		assertEquals(2l, gServM.findLuckyGeek(gender, inters, cities, ip).getId());
	}
	
}
