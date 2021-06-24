
public class Person {
	
	String name; // 이름
	String SchoolNumber; // 학번
	String Number; // 휴대폰 번호
	String floor;  // 1층 3층 B1층 
	String height; // 상, 중, 하 원하는 사물함
	int num; // 사물함 번호
	
	public Person(String name, String SchoolNumber, String Number, String floor, String height, int num) {
		this.name = name;
		this.SchoolNumber = SchoolNumber;
		this.Number = Number;
		this.floor = floor;
		this.height = height;
		this.num = num;
	}
	
	public Person() {
		this.name = "";
		this.SchoolNumber = "";
		this.floor = "";
		this.Number = "";
		this.height = "";
		this.num = 0;
	}
	
}
