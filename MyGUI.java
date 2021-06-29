import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MyGUI extends JFrame{
	
	// GUI 구성요소
	private JButton[] btn = new JButton[7];
	private JLabel[] la = new JLabel[5];
	private JPanel[] pa = new JPanel[3];
	private JTextField[] tf = new JTextField[2];
	private JTextArea jt;
	private int repo_num = 0; // 사물함 갯수
	private int size = 0; // 세로줄 갯수
	
	// GUI 구성
	public MyGUI() {
		super("사물함 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컨테이너 생성
		Container c = getContentPane();
		c.setLayout(new BorderLayout(2,2));
		
		// 정보를 입력하는 란.
		pa[0] = new JPanel();
		pa[0].setLayout(new GridLayout(4,1));
		JButton submit = new JButton("submit");
		JButton random = new JButton("랜덤추첨");
		random.setSize(100, 100);
		submit.addActionListener(new MyActionListener());
		random.addActionListener(new MyActionListener());

		JPanel[] information = new JPanel[4];
		String[] a = {"사물함 갯수", "1줄의 사물함 갯수 ( 세로 줄 )"};
		for(int i = 0;i<a.length;i++) {
			information[i] = new JPanel();
			la[i] = new JLabel(a[i]);
			tf[i] = new JTextField(3);
			information[i].add(la[i]);
			information[i].add(tf[i]);
		}
		information[2] = new JPanel();
		information[2].add(submit);
		
		information[3] = new JPanel();
		information[3].add(random);
		
		for(int i = 0;i<4;i++) {
			pa[0].add(information[i]);
		}
		c.add(pa[0],BorderLayout.WEST);

		// JTextArea 설정
		pa[1] = new JPanel();
		jt = new JTextArea(40, 70);
		JScrollPane scrollPane = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pa[1].add(jt);
		c.add(pa[1], BorderLayout.CENTER);

		// Button
		JPanel[] layer = new JPanel[2];
		String[] b = {"B1", "등록", "1F", "저장", "3F", "삭제"};

		// 패널 초기화
		for (int i = 0; i < 2; i++) {
			layer[i] = new JPanel();
		}

		// 버튼 초기화
		for (int i = 0; i < b.length; i++) {
			btn[i] = new JButton(b[i]);
			btn[i].addActionListener(new MyActionListener());
			layer[i % 2].add(btn[i]); // 홀짝을 구분해서 String배열 b 를 복잡하게 안넣기 위함.
		}
		
		pa[2] = new JPanel();
		pa[2].add(layer[0]);
		pa[2].add(layer[1]);
		
		c.add(pa[2],BorderLayout.SOUTH);
		
		setSize(1000,750);
		setVisible(true);
	}
	
	void addLog(String log)
	{
		jt.append(log + "\n");
		jt.setCaretPosition(jt.getDocument().getLength());
	}
	
	// 버튼 ActionListener
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand() == "랜덤 추첨") {
				//RandomGatcha lotto = new RandomGatcha(list,0);
				//lotto.randomgatcha();
			}
			
			else if(e.getActionCommand() == "submit") {
				if(tf[0].getText() != null && tf[1].getText() != null) {
					repo_num = Integer.parseInt(tf[0].getText());
					size = Integer.parseInt(tf[1].getText());
				}
			}
			
			else if(e.getActionCommand() == "저장") {
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Save a File");
				fs.setFileFilter(new FileTypeFilter(".txt", "Text File"));
				int result = fs.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					//String content = JTextArea.getText();
					File file = fs.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(file.getPath() + ".txt");
						//fw.write(content);
						fw.flush();
						fw.close();
					}catch(Exception v) {
						JOptionPane.showMessageDialog(null, v.getMessage());
					}
				}
			}
			
			else if(e.getActionCommand() == "B1") { 
				JTable tb = null;
				JScrollPane scroll = new JScrollPane();
				String[][] data;
				String[] title = {"층수","사물함 번호","이름","학번","사물함 비밀번호"};
				tb.add(scroll);
				
			}
			
			else if(e.getActionCommand() == "1F") {
				JTable tb = null;
				JScrollPane scroll = new JScrollPane();
				String[][] data;
				String [] title = {"층수","사물함 번호","이름","학번","사물함 비밀번호"};
				tb.add(scroll);
				
			}
			
			else if(e.getActionCommand() == "3F") {
				JTable tb = null;
				JScrollPane scroll = new JScrollPane();
				String[][] data;
				String[] title = {"층수","사물함 번호","이름","학번","사물함 비밀번호"};
				
				
			}
			
			else if(e.getActionCommand() == "등록") {
				
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
