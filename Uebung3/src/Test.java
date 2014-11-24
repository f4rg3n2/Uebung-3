import static org.junit.Assert.*;

import java.util.function.BiConsumer;

import de.hs_ma.tpews14.ib9.Objects.AArray;


public class Test {

	@org.junit.Test
	public void test() {
		String tmp = "affe";
		String giraffe  = "giraffe";
		//Node blubber =new Node(tmp, giraffe, null, null);
		AArray<String, String> a = new AArray<>();
		AArray<String,String> tree = new AArray<>();
		
		AArray<String, String>.Node n = a.new Node(tmp, giraffe, null, null);
		//AArray<String, String>.Node b = a.new Node("stinkt", "Jens", null, null);
		AArray<String, String>.Node v = a.new Node("asaws", "dfsasd", null, null);
		AArray<String, String>.Node c = a.new Node("gfees", "iklöökk", null, null);
		
		BiConsumer<String, String> biConsumer = (x, y) -> {
		      System.out.print(x);
		      System.out.print("\t");
		      System.out.print(y);
		      System.out.println();
		    };
		
		
		a.put("h", "w3ea");
		a.put("o", "gfsdaa");
		a.put("d", "gfsdaaa");
		a.put("j", "w3ertsdaa");
//		a.put("j", "w3ertsdaa");
//		a.put("a", "uhzgtrsdaa");
//		a.put("e", "lokijusdaa");
//		a.put("f", "wrtsdaa");
//		a.put("g", "rtsdaa");
//		
//		
		tree.put("l", "w3era");
		tree.put("i", "etsaa");
		tree.put("k", "waaasdwa2");
		tree.put("m", "22waa");
		tree.put("n", "34waa");
		tree.put("c", "5665waa");
	
		
		
//		a.print();
//		System.out.println();
//		System.out.println(a.remove("a"));
		a.putAll(tree);
		a.print();
//		a.extractAll(tree);
//		tree.print();
//		a.forEach(biConsumer);
		
		
//		System.out.println(a.containsKey("asdgdhallo"));
//		System.out.println(a.containsValue("w3ertsdaa"));
		
		
	}

}
