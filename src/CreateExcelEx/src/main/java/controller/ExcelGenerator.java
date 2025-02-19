package controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelGenerator {
	
    public static void main(String[] args) {
        // 1. 創建 Excel 工作簿
        Workbook workbook = new XSSFWorkbook();
        
        // 2. 創建工作表
        Sheet sheet = workbook.createSheet("測試數據");

        // 3. 建立標題行
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "姓名", "年齡", "職業"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // 4. 填充數據
        Object[][] data = {
                {1, "張三", 28, "工程師"},
                {2, "李四", 32, "設計師"},
                {3, "王五", 25, "產品經理"},
                {4, "趙六", 30, "數據分析師"},
                {5, "teacher", 30, "數據分析師"}
        };

        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < data[i].length; j++) {
                row.createCell(j).setCellValue(data[i][j].toString());
            }
        }

        // 5. 自動調整欄位寬度
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // 6. 寫入 Excel 檔案
        try (FileOutputStream fileOut = new FileOutputStream("c:/ABC/data2.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel 檔案已成功生成！");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 7. 關閉工作簿
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
