package code_practice;

import java.util.ArrayList;
import java.util.List;

public class FindDependencies {
	List<Package>  list = new ArrayList<Package>();
	void find(Package p)
	{
		if(p==null) return;
		for(Package d : p.dependencies)
		{
			if(!list.contains(d)) list.add(d);
			find(d);
		}
		
	}
}

class Package
{
	String Name;
	List<Package> dependencies = new ArrayList<Package>();
	
	public Package(String name){this.Name = name;}
}


