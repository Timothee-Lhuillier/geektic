package tdd;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Test;

import com.bugsprod.geektic.Geek;
import com.bugsprod.geektic.View;

public class ViewTests {
	@Test
	public void newViewAddInGeek_ViewsNotSet_Test() {
		Geek geek = new Geek(0, "Michu", "Bernadette");
		new View(geek, "127.0.0.1");
		assertEquals(1, geek.getViews().size());
	}
	
	@Test
	public void newViewAddInGeek_ViewsSet_Test() {
		Geek geek = new Geek(0, "Michu", "Bernadette");
		geek.setViews(new ArrayList<View>());
		new View(geek, "127.0.0.1");
		assertEquals(1, geek.getViews().size());
	}
	
	@Test
	public void setGeekAddInGeekTest() {
		Geek geek = new Geek(0, "Michu", "Bernadette");
		View view = new View();
		view.setGeek(geek);
		assertEquals(1, geek.getViews().size());
	}
	
	@Test
	public void setNullGeekAddInGeekTest() {
		View view = new View();
		view.setGeek(null);
		assertEquals(null, view.getGeek());
	}
	
	@Test
	public void setGeekRemoveFromOldGeekTest() {
		Geek michu = new Geek(0l, "Michu", "Bernadette");
		Geek paul = new Geek(1l, "Pontoi", "Paul");
		View view = new View();
		view.setGeek(michu);
		view.setGeek(paul);
		assertEquals(0, michu.getViews().size());
	}
	
	@Test
	public void getGeekTest() {
		Geek geek = new Geek();
		View view = new View(geek, "127.0.0.1");
		assertEquals(geek, view.getGeek());
	}
	
	@Test
	public void getIpTest() {
		View view = new View(new Geek(), "127.0.0.1");
		assertEquals("127.0.0.1", view.getIp());
	}
	
	@Test
	public void setIpTest() {
		View view = new View();
		view.setIp("127.0.0.1");
		assertEquals("127.0.0.1", view.getIp());
	}
	
	@Test
	public void getTimestampTest() {
		View view = new View(new Geek(), "127.0.0.1");
		assertEquals(Timestamp.class, view.getTimestamp().getClass());
	}
	
	@Test
	public void setTimestampTest() {
		View view = new View();
		Timestamp timestamp = new Timestamp(5);
		view.setTimestamp(timestamp);
		assertEquals(timestamp, view.getTimestamp());
	}
}
