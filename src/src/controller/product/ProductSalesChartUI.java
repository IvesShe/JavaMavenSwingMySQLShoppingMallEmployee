package controller.product;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import controller.employee.EmployeeMainUI;
import service.impl.DefaultCategoryDatasetServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductSalesChartUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultCategoryDatasetServiceImpl defaultCategoryDatasetServiceImpl = new DefaultCategoryDatasetServiceImpl();

	public ProductSalesChartUI() {
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
        chartPanel.setLayout(null);
        
        JButton btnNewButton = new JButton("返回管理主頁");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		new EmployeeMainUI().setVisible(true);
        		dispose();
        	}
        });
        btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 14));
        btnNewButton.setBounds(55, 5, 131, 28);
        chartPanel.add(btnNewButton);
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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductSalesChartUI frame = new ProductSalesChartUI();
            frame.setVisible(true);
        });
    }
}
