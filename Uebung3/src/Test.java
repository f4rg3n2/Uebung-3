import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import sun.security.action.PutAllAction;
import de.hs_ma.tpews14.ib9.Objects.AArray;
import de.hs_ma.tpews14.ib9.Objects.Dictionary;
import de.hs_ma.tpews14.ib9.Objects.IntegerAssociativeArray;
import de.hs_ma.tpews14.ib9.Objects.StringAssociativeArray;


public class Test {

	@org.junit.Test
	public void test() {
		String tmp = "affe";
		String giraffe  = "giraffe";
		//Node blubber =new Node(tmp, giraffe, null, null);
		StringAssociativeArray a = new StringAssociativeArray();
		AArray<String,String> tree = new AArray<>();
		IntegerAssociativeArray intTree = new IntegerAssociativeArray();
		Dictionary dict = new Dictionary();
		
//		BiConsumer<String, String> biConsumer = (x, y) -> {
//		      System.out.print(x);
//		      System.out.print("\t");
//		      System.out.print(y);
//		      System.out.println();
//		    };
		   
		 
		
		
		intTree.put(1, 2);
//		System.out.println(intTree);
		a.put("h", "w3ea");
		a.put("o", "gfsdaa");
		a.put("d", "gfsdaaa");
		a.put("j", "w3ertsdaa");
		
		dict.put("j", "w3ertsd");
		dict.put("a", "uhzgtrs");
		dict.put("e", "lokijus");
		dict.put("f", "wrtsdaa");
		dict.put("g", "rtsdaaa");
		
		
		tree.put("l", "w3era");
		tree.put("i", "etsaa");
		tree.put("k", "waaasdwa2");
		tree.put("m", "22waa");
		tree.put("n", "34waa");
		tree.put("c", "5665waa");
	
		dict.keys();
		for (int i = 0; i < dict.keys().length; i++) {
	        System.out.print(dict.keys()[i]+"\t");
	        
        }
		System.out.println();
		
		dict.values();
		for (int i = 0; i < dict.values().length; i++) {
	        System.out.print(dict.values()[i]+"\t");
        }
//		a.toString();
//		System.out.println();
//		System.out.println(a.remove("a"));
//		a.putAll(tree);
//		System.out.println(a);
//		a.extractAll(tree);
//		tree.toString();
//		a.forEach(biConsumer);
		
		
//		System.out.println(a.containsKey("asdgdhallo"));
//		System.out.println(a.containsValue("w3ertsdaa"));
		
		
	}

}
