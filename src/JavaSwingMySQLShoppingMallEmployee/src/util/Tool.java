package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Tool {
	// 利用正則判斷是否為數字
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	// 找零計算
	public static String changeCalculator(int receivedAmount, int orderAmount) {

		// 計算找零金額
		int change = receivedAmount - orderAmount;

		// 設定各面額的數值
		int[] denominations = { 1000, 500, 100, 50, 10, 5, 1 };

		// 使用 StringBuilder 收集輸出的結果
		StringBuilder result = new StringBuilder();

		// 收集找零金額
		result.append(String.format("找零金額: %,d元\n", change));

		// 計算並收集每個面額的張數
		for (int denomination : denominations) {
			int count = change / denomination; // 計算該面額需要的張數
			change = change % denomination; // 計算剩餘的找零金額

			if (count > 0) {
				// 收集每個面額的張數
				String unit = (denomination == 50 || denomination == 10 || denomination == 5 || denomination == 1) ? "個": "張";
				result.append(String.format("%-6d元: %2d %s\n", denomination, count, unit));
			}
		}
		return result.toString();

	}
	
	// 生成一個隨機的4位驗證碼
    public static String generateRandomCode() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder verificationCode = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(characters.length());
            verificationCode.append(characters.charAt(index));
        }

        return verificationCode.toString();
    }
    
    // 利用正則判斷所註冊的帳號
    public static String validateUsername(String username) {
        // 長度檢查
        if (username.length() < 5) {
            return "帳號長度太短，最少需要 5 個字元。";
        }
        if (username.length() > 12) {
            return "帳號長度太長，最多可以有 12 個字元。";
        }

        // 使用正則表達式檢查格式
        String regex = "^[A-Za-z][A-Za-z0-9]{4,11}$";  // 首字母大寫，後面可以是英文字母和數字，總長度 5 到 12 個字元
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        if (!matcher.matches()) {
            return "帳號格式錯誤：首字母必須英文，並且只能包含英文字母和數字。";
        }

        return "true";
    }
    
    // 利用正則判斷所註冊的員工編號
    public static String validateEmployeeNo(String employeeNo) {

        String regex = "^e[0-9]{3}$";  // e001~e999
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employeeNo);

        if (!matcher.matches()) {
            return "員工編號 格式錯誤。";
        }

        return "true";
    }
    
    // 利用正則判斷所註冊的顧客編號
    public static String validateConsumerNo(String consumerNo) {

        String regex = "^c[0-9]{3}$";  // e001~e999
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(consumerNo);

        if (!matcher.matches()) {
            return "顧客編號 格式錯誤。";
        }

        return "true";
    }
    
    // 利用正則判斷所新增的產品編號
    public static String validateProductNo(String productNo) {

        String regex = "^p[0-9]{3}$";  // e001~e999
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(productNo);

        if (!matcher.matches()) {
            return "產品編號 格式錯誤。";
        }

        return "true";
    }
    
    // 利用正則判斷所新增的訂單編號
    public static String validateShopOrderNo(String shopOrderNo) {

        String regex = "^s[0-9]{3}$";  // e001~e999
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(shopOrderNo);

        if (!matcher.matches()) {
            return "產品編號 格式錯誤。";
        }

        return "true";
    }
    
    // 格式化日期時間
    public static String formatTimestamp(Timestamp timestamp) {
        if (timestamp == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(timestamp);
    }
    
    public static String showShopOrder(String shopOrderNo,String productName,Integer productAmount,Integer productPrice,String customerName,String employeeName,Boolean vipMember) 
    {
		// 取得當前的系統時間
	    LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String currentTime = now.format(formatter);
	    
	    
	    int sum = productPrice * productAmount;

	    String outputMessage = String.format(
	        "---------------------------------------------------------\n" +
	        "訂單編號: %s\n" + 
	        "訂單時間: %s\n" +  
	        "您的名字是：%s\n" +
	        "商品名稱：%s\n" + // 修正這裡，把 %d 改為 %s
	        "數量：%d\n" +
	        "成交金額：\n" +
	        "%d 元 x %d   = %d 元",
	        shopOrderNo,
	        currentTime,  // 顯示當前時間
	        customerName,
	        productName,  // 這裡要用 %s
	        productAmount,        
	        productPrice, // 修正變數順序
	        productAmount,  
	        sum
	    );

		
	    if (vipMember) {
	        int discountAmount = (int) (sum * 0.1);  // 計算折扣金額（取整數）
	        int finalAmount = (int) (sum * 0.9);  // 計算折後金額（取整數）

	        outputMessage += String.format(
	            "\n您是VIP會員，享有九折優惠\n" +
	            "折扣金額：%d 元\n" +
	            "實付金額：%d 元",
	            discountAmount,  // 折扣金額
	            finalAmount  // 最終支付金額
	        );
	    } else {
	        outputMessage += "\n您是一般會員，無任何優惠";
	    }
	    outputMessage += "\n---------------------------------------------------------";
	    
//	    String outputMessage = String.format(
//	            "---------------------------------------------------------\n" +
//	            "訂單時間: %s\n" +  
//	            "您的名字是：%s\n" +
//	            "1號餐份數：%d\n" +
//	            "2號餐份數：%d\n\n" +
//	            "成交金額：\n" +
//	            "1號餐 %d 元 x %d 份 + 2號餐 %d 元 x %d 份 = %d 元",
//	            currentTime,  // 顯示當前時間
//	            this.getName(),
//	            this.getMealNo1(),
//	            this.getMealNo2(),
//	            ShopOrder.getMealNo1Price(),
//	            this.getMealNo1(),
//	            ShopOrder.getMealNo2Price(),
//	            this.getMealNo2(),
//	            this.getSum()
//	    );
//
//	    if (vipMember) {
//	        outputMessage += String.format(
//	                "\n您是VIP會員，享有九折優惠\n" +
//	                "折扣金額：%d 元\n" +
//	                "實付金額：%d 元",
//	                (this.getSum() - (int)(this.getSum() * 0.9)),
//	                (int)(this.getSum() * 0.9)
//	        );
//	    } else {
//	        outputMessage += "\n您是一般會員，無任何優惠";
//	    }

//	    outputMessage += "\n---------------------------------------------------------";
	    return outputMessage;
	}

}
