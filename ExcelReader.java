import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// �޴��� ��ȣ 5��° ĭ�� �߰����ּ���

public class ExcelReader {
	
	// ������ �����ϴ� ArrayList
	private ArrayList<Person> list = new ArrayList<Person>();
	private ArrayList<Person> high = new ArrayList<Person>();
	private ArrayList<Person> middle = new ArrayList<Person>();
	private ArrayList<Person> low = new ArrayList<Person>();
	
	public void readExcel(){
		
		// Excel ���� ����
		String path = MyGUI.class.getResource("").getPath();
		ArrayList<Person> list = new ArrayList<Person>();
		int person_num = 1; // ������� ����
		
		try {
			File file = new File(path + "ExcelExFile.xlsx");
			
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			// ���� index �� 0���� �����Ѵ�.
			int rowindex = 0;
			int colindex = 0;
			
			// ��Ʈ ��
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			// ���� �� 
			int rows = sheet.getPhysicalNumberOfRows();

			// �� �б�
			for(rowindex = 1;rowindex<=rows;rowindex++) {
				Person data = new Person();
				
				XSSFRow row = sheet.getRow(rowindex);
				XSSFCell cell = row.getCell(5);

				data.setName(String.valueOf(row.getCell(0)));
				data.setSchoolNumber(String.valueOf(row.getCell(1)));
				data.setFloor(String.valueOf(row.getCell(2)));
				data.setHeight(String.valueOf(row.getCell(3)));
				data.setNumber(String.valueOf(row.getCell(4)));
				data.setNum(person_num++);
				
				if(data.getHeight() == "��") {
					high.add(data);
				}
				else if(data.getHeight() == "��") {
					middle.add(data);
				}
				else if(data.getHeight() == "��") {
					low.add(data);
				}
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}