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
import com.bugsprod.geektic.Interest;

public class GeekDaoTest {

	Geek kevin;
	Geek paul;
	Interest java;
	Interest cpp;
	City lyon;
	
	String[] inters;
	String[] cities;
	List<Geek> geeks;
	
	EntityManager mockedEM;
	GeekDao mockedGD;
	
	GeekDao gDaoM;
	
	@Before
	public void setUp() {
		kevin = new Geek(0l, "Dupond", "Kevin");
		paul = new Geek(2l, "Dupond", "Paul");
		java = new Interest(0, "java");
		cpp = new Interest(0, "C++");
		lyon = new City(0,"Lyon");
		
		geeks = new ArrayList<Geek>();
		
		mockedEM = mock(EntityManager.class);
		mockedGD = mock(GeekDao.class);
		
		gDaoM = new GeekDao(mockedEM);
	}

	@Test
	public void luckyFindGeek0Test() {
		inters = new String[1];
		cities = new String[1];
		inters[0] = "java";
		cities[0] = "lyon";
		assertEquals(0l, gDaoM.findLuckyGeek(true, inters, cities).getId());
	}
	
	@Test
	public void luckyFindGeek1Test() {
		inters = new String[1];
		cities = new String[1];
		inters[0] = "cpp";
		cities[0] = "lyon";
		TypedQuery<Geek> q = mock(TypedQuery.class);
		when(mockedEM.createQuery(anyString(), eq(Geek.class))).thenReturn(q);
		when(q.getSingleResult()).thenReturn(paul);
		assertEquals(2l, gDaoM.findLuckyGeek(true, inters, cities).getId());
	}
}
