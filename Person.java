
public class Person {
	
	String name; // 이름
	String SchoolNumber; // 학번
	String Number; // 휴대폰 번호
	String floor;  // 1층 3층 B1층 
	String height; // 상, 중, 하 원하는 사물함
	int num; // 신청한 사람의 고유 번호 -> 이를 통해 추첨

	// 생성자
	public Person() {
		this.name = "";
		this.SchoolNumber = "";
		this.floor = "";
		this.Number = "";
		this.height = "";
		this.num = 0;
	}
	
	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setSchoolNumber(String schoolNumber) {
		SchoolNumber = schoolNumber;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
    // Getter
	public String getName() {
		return name;
	}

	public String getSchoolNumber() {
		return SchoolNumber;
	}

	public String getNumber() {
		return Number;
	}

	public String getFloor() {
		return floor;
	}

	public String getHeight() {
		return height;
	}

	public int getNum() {
		return num;
	}
}
