import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyGUI extends JFrame{
	
	// 데이터 관리하는 ArrayList
	ArrayList<Person> list = new ArrayList<Person>();
	
	// GUI 구성요소
	private JButton[] btn = new JButton[7];
	private JLabel[] la = new JLabel[5];
	private JPanel[] pa = new JPanel[3];
	private JTextField[] tf = new JTextField[5];
	private JTextArea jt;
	private int person_num = 0; // 사람들의 숫자
	
	public MyGUI() {
		super("사물함 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,750);
		setVisible(true);
		
		// 컨테이너 생성
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		// 정보를 입력하는 란.
		pa[0] = new JPanel();
		JPanel[] information = new JPanel[5];
		String[] a = {"이름", "학번", "전화번호","층수","높낮이"};
		for(int i = 0;i<5;i++) {
			information[i] = new JPanel();
			la[i] = new JLabel(a[i]);
			tf[i] = new JTextField(13);
			information[i].add(la[i]);
			information[i].add(tf[i]);
		}
		for(int i = 0;i<5;i++) {
			pa[0].add(information[i]);
		}
		c.add(pa[0],BorderLayout.WEST);
		
		// Button
		JPanel[] layer = new JPanel[2];
		String[] b = {"랜덤 추첨", "B1", "등록","1F","수정","3F","삭제"};
		
		// 패널 초기화
		for(int i = 0;i<2;i++) {
			layer[i] = new JPanel();
		}
		
		// 버튼 초기화
		for(int i = 0;i<7;i++) {
			btn[i] = new JButton(b[i]);
			if(i == 0) {	
				continue;
			}
			layer[i % 2].add(btn[i]); // 홀짝을 구분해서 String배열 b 를 복잡하게 안넣기 위함.
		}
		
		// JTextArea 설정
		jt = new JTextArea(40,3);
		
	}
	
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "랜덤 추첨") {
				RandomGatcha lotto = new RandomGatcha(list);
				lotto.randomgatcha();
			}
			else if(e.getActionCommand() == "B1") { 
				
			}
			else if(e.getActionCommand() == "1F") {
				
			}
			else if(e.getActionCommand() == "3F") {
				
			}
			else if(e.getActionCommand() == "등록") {
				String[] submit = {"","","","",""}; // 패킷에 넣을 정보 초기화
				for(int i =0 ;i<5;i++) {
					submit[i] = tf[i].getText();	// information 란에 있는 정보들 패킷에 넣을 String배열에 넣기
				}
				Person packet = new Person(submit[0],submit[1],submit[2],submit[3],submit[4],person_num++);
				list.add(packet);
			}
			else if(e.getActionCommand() == "수정") {
				
			}
			else if(e.getActionCommand() == "삭제") {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new MyGUI();
	}
}
