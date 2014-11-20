import static org.junit.Assert.*;
import de.hs_ma.tpews14.ib9.Objects.AArray;


public class Test {

	@org.junit.Test
	public void test() {
		String tmp = "affe";
		String giraffe  = "giraffe";
		//Node blubber =new Node(tmp, giraffe, null, null);
		AArray<String, String> a = new AArray<>();
		
		AArray<String, String>.Node n = a.new Node(tmp, giraffe, null, null);
		//AArray<String, String>.Node b = a.new Node("stinkt", "Jens", null, null);
		AArray<String, String>.Node v = a.new Node("asaws", "dfsasd", null, null);
		AArray<String, String>.Node c = a.new Node("gfees", "iklöökk", null, null);
		
		
		a.put("h", "w3ea");
		a.put("c", "gfsdaa");
		a.put("d", "gfsdaaa");
		a.put("j", "w3ertsdaa");
		a.put("a", "uhzgtrsdaa");
		a.put("e", "lokijusdaa");
		a.put("f", "wrtsdaa");
		a.put("g", "rtsdaa");
		a.put("l", "w3era");
		a.put("i", "etsaa");
		a.put("k", "waa");
		
		
		
		
		System.out.println(a.remove("h"));
		a.print();
		
		
//		System.out.println(a.containsKey("asdgdhallo"));
//		System.out.println(a.containsValue("w3ertsdaa"));
		
		
	}

}
