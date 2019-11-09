import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;
import java.util.*;

class A3PrintNameCC{
	public static void main(String[] args){
		File f = new File(args[0]);
		try{
			Scanner sc = new Scanner(f);
			String str;
			Map<Integer, List<String>> map = new TreeMap<>();
			while(sc.hasNextLine()){
				str = sc.nextLine();
				Integer key = new Integer(str.length());
				if(map.get(key)==null){
					map.put(key, new LinkedList<String>());	
				}
				map.get(key).add(str);
				
			}
			System.out.println(map);
			
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}