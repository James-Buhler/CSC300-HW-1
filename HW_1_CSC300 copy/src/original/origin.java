package original;

import java.util.Random;

public class origin {
	public static void main(String[] args) {
		Random r = new Random();
		
		Salesman[] salesPeople = new Salesman[1000000];
		for(int i = 0; i < 1000000; i++) {
			salesPeople[i] = new Salesman(String.valueOf((i + 1)), r.nextFloat(1000.0f));
		}
		Salesman[] top5 = Salesman.getTopFive(salesPeople);
		
		displayAllSalesman(top5);
	}
	
	public static void displayAllSalesman(Salesman[] s) {
		for(int i = 0; i < s.length; i++) {
			s[i].displaySalesman();
		}
	}
	
	
}