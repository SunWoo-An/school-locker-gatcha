
public class Person {
	
	String name; // �̸�
	String SchoolNumber; // �й�
	String Number; // �޴��� ��ȣ
	String floor;  // 1�� 3�� B1�� 
	String height; // ��, ��, �� ���ϴ� �繰��
	int num; // �繰�� ��ȣ
	
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
