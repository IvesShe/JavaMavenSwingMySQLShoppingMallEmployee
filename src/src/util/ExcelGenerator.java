package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelGenerator {

	public static void generateOrderExcel(String filePath
    		,String shopOrderNo,String productName
    		,Integer productAmount,Integer productPrice
    		,String customerName,String employeeName
    		,Boolean vipMember) {
		
        // 1. 創建 Excel 工作簿
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("訂單資訊");


        String[][] orderData = {
            {"訂單編號", shopOrderNo},
            {"顧客姓名", customerName},
            {"產品名稱", productName},
            {"產品售價", String.valueOf(productPrice)},
            {"產品數量", String.valueOf(productAmount)},
            {"VIP會員", vipMember?"是，打九折":"否，原價"},
            {"成交金額", vipMember?
            		String.format("%d 元 x %d x 0.9 = %d 元", productPrice, productAmount, (int)(productAmount*productPrice*0.9))
            		:String.format("%d 元 x %d = %d 元", productPrice, productAmount, productAmount*productPrice)},
        };
            
        
        

        // 3. 將資料寫入 Excel
        for (int i = 0; i < orderData.length; i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(orderData[i][0]); // 左欄 (標題)
            row.createCell(1).setCellValue(orderData[i][1]); // 右欄 (數值)
        }

        // 4. 自動調整欄寬
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        // 5. 寫入 Excel 檔案
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Excel 訂單已成功生成222：" + filePath);//
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 6. 關閉工作簿
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
