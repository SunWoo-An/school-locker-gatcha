import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// 휴대폰 번호 5번째 칸에 추가해주세요

public class ExcelReader {
	
	// 데이터 관리하는 ArrayList
	private ArrayList<Person> list = new ArrayList<Person>();
	private ArrayList<Person> high = new ArrayList<Person>();
	private ArrayList<Person> middle = new ArrayList<Person>();
	private ArrayList<Person> low = new ArrayList<Person>();
	
	public void readExcel(){
		
		// Excel 파일 열기
		String path = MyGUI.class.getResource("").getPath();
		ArrayList<Person> list = new ArrayList<Person>();
		int person_num = 1; // 사람들의 숫자
		
		try {
			File file = new File(path + "ExcelExFile.xlsx");
			
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			// 엑셀 index 는 0부터 시작한다.
			int rowindex = 0;
			int colindex = 0;
			
			// 시트 수
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			// 행의 수 
			int rows = sheet.getPhysicalNumberOfRows();

			// 행 읽기
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
				
				if(data.getHeight() == "상") {
					high.add(data);
				}
				else if(data.getHeight() == "중") {
					middle.add(data);
				}
				else if(data.getHeight() == "하") {
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