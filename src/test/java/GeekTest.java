import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.junit.Before;
import org.junit.Test;

import com.bugsprod.geektic.Geek;
import com.bugsprod.geektic.GeekDao;
import com.bugsprod.geektic.GeekService;
import com.bugsprod.geektic.Interest;

import static org.mockito.Mockito.*;

public class GeekTest {

	@Before
	public void setUp() {
	}
	
	@Test
	public void simpleTest() {
		Geek geek = new Geek(0l, "Dupond", "paul");
		GeekDao mockedGeekDao = mock(GeekDao.class);
		GeekService gServ = new GeekService(mockedGeekDao);
		when(mockedGeekDao.findById(0l)).thenReturn(geek);
		Geek result = gServ.getGeek(0l);
		assertEquals(geek,result);
	}
	
	@Test
	public void InterestEqualsString() {
		Interest inter = new Interest(0, "java");
		assertEquals(true, inter.equals("java"));
	}
	
	@Test
	public void InterestEqualsInterest() {
		Interest inter = new Interest(0, "java");
		Interest inter2 = new Interest(1, "java");
		assertEquals(true, inter.equals(inter2));
	}
}
