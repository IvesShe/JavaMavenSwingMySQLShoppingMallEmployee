package controller.product;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import service.impl.DefaultCategoryDatasetServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ProductSalesChartFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultCategoryDatasetServiceImpl defaultCategoryDatasetServiceImpl = new DefaultCategoryDatasetServiceImpl();

	public ProductSalesChartFrame() {
        setTitle("產品銷售報表");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // 視窗置中

        // 取得數據
        CategoryDataset dataset = defaultCategoryDatasetServiceImpl.findAllDefaultCategoryDataset();//getChartData();

        // 產生 JFreeChart 長條圖
        JFreeChart barChart = ChartFactory.createBarChart(
                "產品銷售報表",        // 圖表標題
                "產品名稱",          // X 軸標題
                "銷售數量",         // Y 軸標題
                dataset,            // 數據集
                PlotOrientation.VERTICAL, // 圖表方向
                true,               // 顯示圖例
                true,
                false
        );

        // 設定字體，確保支援中文
        setChartFont(barChart);

        // 使用 ChartPanel 來顯示圖表
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setMouseWheelEnabled(true);
        getContentPane().add(chartPanel);
    }

    /**
     * 設定字體，確保支援中文顯示
     */
    private void setChartFont(JFreeChart chart) {
        Font font = new Font("Microsoft JhengHei", Font.PLAIN, 14); // 可改為 SimHei, PMingLiU, 等等
        CategoryPlot plot = chart.getCategoryPlot();

        // 設定標題字體
        chart.getTitle().setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));

        // 設定 X 軸字體
        plot.getDomainAxis().setLabelFont(font);
        plot.getDomainAxis().setTickLabelFont(font);

        // 設定 Y 軸字體
        plot.getRangeAxis().setLabelFont(font);
        plot.getRangeAxis().setTickLabelFont(font);

        // 設定圖例（Legend）字體
        chart.getLegend().setItemFont(font);
    }

    /**
     * 連接 MySQL 並取得數據
     */
//    private CategoryDataset getChartData() {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        // 資料庫連線資訊
//        String url = "jdbc:mysql://localhost:3306/shopping";
//        String user = "root";  // 你的 MySQL 用戶名
//        String password = "1234";  // 你的 MySQL 密碼
//
//        String query = "SELECT \r\n"
//        		+ "    so.product_no, \r\n"
//        		+ "    p.product_name, \r\n"
//        		+ "    SUM(so.amount) as total\r\n"
//        		+ "FROM shopping.shop_order AS so\r\n"
//        		+ "INNER JOIN shopping.product AS p \r\n"
//        		+ "    ON so.product_no = p.product_no\r\n"
//        		+ "GROUP BY so.product_no, p.product_name\r\n"
//        		+ "ORDER BY SUM(so.amount) DESC;";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            while (rs.next()) {
//                String productName = rs.getString("product_name");
//                int totalSold = rs.getInt(3);
//                dataset.addValue(totalSold, "銷售數量", productName);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return dataset;
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductSalesChartFrame frame = new ProductSalesChartFrame();
            frame.setVisible(true);
        });
    }
}
