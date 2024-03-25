package practice1;

import java.util.ArrayList;
import java.util.List;

public class practice11main {

	public static void main(String[] args) {
		
		List<practice11> al=new ArrayList<practice11>();
		al.add(new practice11(101,"dhoni",31,"csk"));
		al.add(new practice11(102,"virat kohli",28,"rcb"));
		al.add(new practice11(103,"rahul",22,"csk"));
		al.add(new practice11(104,"raina",38,"csk"));
		al.add(new practice11(105,"rashid khan",25,"kkr"));
		
       
      // al.contains("dhoni");
       System.out.println( al.contains(101));
		
		
		
			
		
	}

}
