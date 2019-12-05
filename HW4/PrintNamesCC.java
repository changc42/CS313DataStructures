import java.util.*;
import java.util.Hashtable;

class PrintNames{
	static Collection<String> printNames(List<String> s1, List<String> s2, List<String> s3){
		Hashtable<String, String> ht = new Hashtable<>();
		for(String s: s1) ht.put(s,s);
		for(String s: s2) ht.put(s,s);
		for(String s: s3) ht.put(s,s);
		return ht.values();
	}
	
	public static void main(String[] args){
		List<String> s1 = Arrays.asList("Tom", "Jerry", "Katherine", "John", "Francis");
		List<String> s2 = Arrays.asList("Tom", "Timmy", "Katherine", "Alfred", "Francis");
		List<String> s3 = Arrays.asList("Kitty", "Jerry", "Katherine", "John", "Doggy");
		System.out.println(printNames(s1,s2,s3));
	}
}