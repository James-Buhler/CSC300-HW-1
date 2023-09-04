package original;

public class Salesman {
	String name;
	float sales;
	public Salesman(String name, float sales) {
		this.name = name;
		this.sales = sales;
	}
	
	public String GetName() {
		return this.name;
	}
	
	public float GetSales() {
		return this.sales;
	}
	
	public void displaySalesman() {
		System.out.println("Name: " + this.name + "   Sales: " + this.sales);
	}
	
	public static Salesman[] getTopFive(Salesman[] salesPeople){
		int j = 5;
		Salesman[] top5 = new Salesman[5];
		for(int i = 0; i < 5; i++) {
			top5[i] = salesPeople[i];
		}
		top5 = sortSalesman(top5);
		while(j < salesPeople.length) {
			if(top5[4].GetSales() < salesPeople[j].GetSales()) {
				top5 = addSalesman(top5, salesPeople[j]);
			}
			j++;
		}
		return top5;
	}
	
	public static Salesman[] addSalesman (Salesman[] sarr, Salesman s){
		Salesman placeHolder;
		for(int i = 3; i >= 0; i--) {
			if(s.GetSales() < sarr[i].GetSales()) {
				for(int j = i + 1; j < 5; j++) {
					placeHolder = sarr[j];
					sarr[j] = s;
					s = placeHolder;
				}
				return sarr;
			}
			
		}
		for(int j = 0; j < 5; j++) {
			placeHolder = sarr[j];
			sarr[j] = s;
			s = placeHolder;
		}
		return sarr;
	}
	
	public static Salesman[] sortSalesman(Salesman[] s) {
		Salesman[] s2 = new Salesman[5];
		Salesman baseS = new Salesman("null", -1.0f);
		Salesman highestS = baseS;
		Salesman greaterS = new Salesman("null", 100000000.00f);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(s[j].GetSales() > highestS.GetSales() && s[j].GetSales() < greaterS.GetSales()) {
					highestS = s[j];
				}
			}
			s2[i] = highestS;
			greaterS = highestS;
			highestS = baseS;
		}
		return s2;
	}
}

