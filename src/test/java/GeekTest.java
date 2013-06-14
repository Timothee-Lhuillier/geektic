import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.bugsprod.geektic.Geek;
import com.bugsprod.geektic.GeekDao;
import com.bugsprod.geektic.GeekService;
import com.bugsprod.geektic.Interest;

public class GeekTest {

	Geek geek;
	EntityManager mockedEM;
	GeekDao mockedGD;
	
	@Before
	public void setUp() {
		geek = new Geek(0l, "Dupond", "paul");
		mockedEM = mock(EntityManager.class);
		mockedGD = mock(GeekDao.class);
	}
	
	@Test
	public void equalsStringTestInterest() {
		Interest inter = new Interest(0, "java");
		assertEquals(true, inter.equals("java"));
	}
	
	@Test
	public void equalsInterestTestInterest() {
		Interest inter = new Interest(0, "java");
		Interest inter2 = new Interest(1, "java");
		assertEquals(true, inter.equals(inter2));
	}
}
