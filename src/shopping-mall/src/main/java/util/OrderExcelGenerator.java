package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class OrderExcelGenerator {

    public static void main(String[] args) {
        generateOrderExcel("order.xlsx");
    }

    public static void generateOrderExcel(String filePath) {
        // 1. 創建 Excel 工作簿
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("訂單資訊");

        // 2. 訂單資料 (冒號前後拆分為兩欄)
        String[][] orderData = {
            {"訂單編號", "S202502200022"},
            {"訂單時間", "2025-02-20 19:29:05"},
            {"您的名字是", "顧客艾米斯"},
            {"商品名稱", "羅技搖桿"},
            {"數量", "2"},
            {"成交金額", "699 元 x 2 = 1398 元"},
            {"您是VIP會員，享有九折優惠", ""},
            {"折扣金額", "139 元"},
            {"實付金額", "1258 元"}
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
            System.out.println("Excel 訂單已成功生成：" + filePath);
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
