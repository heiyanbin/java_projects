package code_practice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindDependenciesTest {

	Map<String,Package> G = new HashMap<String,Package>();
	
	@Before
	public void setUp() throws Exception {
		for(char c='a';c<='g';c++)
		{
			G.put(String.valueOf(c), new Package(String.valueOf(c)));			
		}
		G.get("a").dependencies.add(G.get("b"));
		G.get("a").dependencies.add(G.get("c"));
		G.get("b").dependencies.add(G.get("d"));
		G.get("b").dependencies.add(G.get("e"));
		G.get("c").dependencies.add(G.get("f"));
		G.get("c").dependencies.add(G.get("e"));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind() {
		FindDependencies f = new FindDependencies();
		f.find(G.get("a"));
		for(Package p : f.list)
			System.out.println(p.Name);
	}

}
