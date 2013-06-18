package tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.bugsprod.geektic.City;
import com.bugsprod.geektic.Geek;
import com.bugsprod.geektic.GeekDao;
import com.bugsprod.geektic.GeekService;
import com.bugsprod.geektic.Interest;

public class GeekServiceTest {

	Geek kevin;
	Geek julie;
	Geek paul;
	Interest java;
	Interest cpp;
	City lyon;
	
	String[] inters;
	String[] cities;
	List<Geek> geeks;
	
	GeekDao mockedGD;
	
	GeekService gServM;
	
	@Before
	public void setUp() {
		kevin = new Geek(0l, "Dupond", "Kevin");
		julie = new Geek(1l, "Ker", "Julie" );
		paul = new Geek(2l, "Dupond", "Paul");
		java = new Interest(0, "java");
		cpp = new Interest(0, "C++");
		lyon = new City(0,"Lyon");
		
		geeks = new ArrayList<Geek>();
		
		mockedGD = mock(GeekDao.class);
		
		gServM = new GeekService(mockedGD);
	}

	@Test
	public void luckyFindGeekJavaLyonOneGeekTest() {
		inters = new String[1];
		cities = new String[1];
		inters[0] = "java";
		cities[0] = "Lyon";

		geeks.add(paul);
		geeks.add(kevin);
		
		when(mockedGD.findGeeks(true, inters, cities)).thenReturn(geeks);
		
		assertEquals(Geek.class, gServM.findLuckyGeek(true, inters, cities).getClass());
	}
	
	@Test
	public void luckyFindGeekCppLyonPaulTest() {
		inters = new String[1];
		cities = new String[1];
		inters[0] = "C++";
		cities[0] = "Lyon";
		
		geeks.add(paul);
		
		when(mockedGD.findGeeks(true, inters, cities)).thenReturn(geeks);
		
		assertEquals(2l, gServM.findLuckyGeek(true, inters, cities).getId());
	}
	
}
