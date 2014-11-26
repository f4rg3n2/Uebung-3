import static org.junit.Assert.*;

import java.util.function.BiFunction;

import org.junit.Test;

import de.hs_ma.tpews14.ib9.Objects.AArray;
import de.hs_ma.tpews14.ib9.Objects.Dictionary;
import de.hs_ma.tpews14.ib9.Objects.IntegerAssociativeArray;
import de.hs_ma.tpews14.ib9.Objects.StringAssociativeArray;

public class TestClass {

	@Test
	public void test() {

		StringAssociativeArray a = new StringAssociativeArray();
		AArray<String, String> tree = new AArray<>();
		IntegerAssociativeArray intTree = new IntegerAssociativeArray();
		Dictionary dict = new Dictionary();
		StringAssociativeArray b = new StringAssociativeArray();

		intTree.put(23, 23545);
		intTree.put(3, 5);
		intTree.put(123, 1231);
		intTree.put(5, 67);
		intTree.put(1, 23);

		a.put("hans", "Manager");
		a.put("peter", "Angestelter");
		a.put("otto", "Penner");
		a.put("christoph", "Freiberufler");

		dict.put("judo", "Kampfsport");
		dict.put("fuﬂball", "Ballsport");
		dict.put("fechten", "Kampfsport");
		dict.put("schach", "Denksport");
		dict.put("badminton", "Ballsport");

		tree.put("lars", "Student");
		tree.put("ina", "Polizistin");
		tree.put("kathi", "Koch");

	
		assertEquals(true, a.containsKey("christoph"));
		assertEquals(false, a.containsKey("Jens"));

		assertEquals(true, a.containsValue("Freiberufler"));
		assertEquals(false, a.containsValue("Beamter"));

		assertEquals("Angestelter", a.get("peter"));
		assertEquals(null, a.get("lukas"));

		assertEquals(false, a.isEmpty());
		assertEquals(true, b.isEmpty());

		a.put("marcel", "Berufsstudent");
		assertEquals(true, a.containsKey("marcel"));

		assertEquals(false, a.containsKey("lars"));
		assertEquals(false, a.containsKey("ina"));
		assertEquals(false, a.containsKey("kathi"));
		a.putAll(tree);
		assertEquals(true, a.containsKey("lars"));
		assertEquals(true, a.containsKey("ina"));
		assertEquals(true, a.containsKey("kathi"));

		a.remove("marcel");
		assertEquals(false, a.containsKey("marcel"));

		assertEquals(7, a.size());

		a.update("christoph", "Fischer");
		assertEquals(true, a.containsValue("Fischer"));

		assertEquals(false, tree.containsKey("christoph"));
		a.extractAll(tree);
		assertEquals(true, tree.containsKey("hans"));
		assertEquals(true, tree.containsKey("peter"));
		assertEquals(true, tree.containsKey("otto"));
		assertEquals(true, tree.containsKey("christoph"));

		BiFunction<String, String, String> bifunk = (x, y) -> {
			y = y + "a";

			return y;
		};

		assertEquals(false, a.map(bifunk).equals(a));

		assertEquals(true, intTree.containsKey(23));
		assertEquals(true, intTree.containsKey(3));
		assertEquals(true, intTree.containsKey(123));
		assertEquals(true, intTree.containsKey(5));
		assertEquals(true, intTree.containsKey(1));

		dict.keys();
		String[] sportarten = { "judo", "fuﬂball", "fechten", "badminton",
		        "schach" };
		String[] sportkategorie = { "Kampfsport", "Ballsport", "Kampfsport",
		        "Ballsport", "Denksport" };
		assertArrayEquals(sportarten, dict.keys());
		assertArrayEquals(sportkategorie, dict.values());
		
		 a.clear();
		 assertEquals(a, a);

	}
}