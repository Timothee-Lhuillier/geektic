package tdd;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bugsprod.model.Interest;

public class InterestTests {

	Interest java;
	List<Interest> inters;
	
	@Before
	public void setUp() {
		java = new Interest(0, "java");
		inters = new ArrayList<Interest>();
	}
	
	@Test
	public void equalsStringTest() {
		assertEquals(true, java.equals("java"));
	}
	
	@Test
	public void equalsInterestTest() {
		Interest inter2 = new Interest(1, "java");
		assertEquals(true, java.equals(inter2));
	}
}
