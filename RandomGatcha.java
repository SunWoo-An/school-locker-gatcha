import java.util.ArrayList;

public class RandomGatcha {
	ArrayList<Person> list = new ArrayList<Person>();
	
	private int num = 0; // 사물함 번호
	int size = 0; // 몇번
	
	public RandomGatcha(ArrayList<Person> list,int size) {
		this.list = list;
		this.size = size;
	}
	
	public void randomgatcha() {
		int winning = (int)(Math.random()% size + 1);
			
	}
	
	public void Excellent() {
		
	}
}
