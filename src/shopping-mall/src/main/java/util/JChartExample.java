package util;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JChartExample extends ApplicationFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JChartExample(String title) {
        super(title);

        // 創建數據集
        DefaultCategoryDataset dataset = createDataset();

        // 創建圖表
        JFreeChart chart = createChart(dataset);

        // 創建面板顯示圖表
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // 假設的數據：月份 vs 銷售數量
        dataset.addValue(100, "銷售數量", "一月");
        dataset.addValue(150, "銷售數量", "二月");
        dataset.addValue(200, "銷售數量", "三月");
        dataset.addValue(250, "銷售數量", "四月");

        return dataset;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "月銷售量", // 圖表標題
                "月份", // x 軸標題
                "銷售數量", // y 軸標題
                dataset, // 數據集
                PlotOrientation.VERTICAL, // 圖表類型
                true, // 是否顯示圖例
                true, // 是否顯示提示工具
                false // 是否顯示URL
        );

        // 設定字型，支援中文
        Font font = new Font("新細明體", Font.PLAIN, 14);
        chart.getTitle().setFont(font); // 設置標題字型
        chart.getCategoryPlot().getDomainAxis().setLabelFont(font); // 設置x軸標題字型
        chart.getCategoryPlot().getRangeAxis().setLabelFont(font); // 設置y軸標題字型
        chart.getCategoryPlot().getDomainAxis().setTickLabelFont(font); // 設置x軸標籤字型
        chart.getCategoryPlot().getRangeAxis().setTickLabelFont(font); // 設置y軸標籤字型

        return chart;
    }

    public static void main(String[] args) {
        // 創建 JChartExample 例項並顯示圖表
        JChartExample chartExample = new JChartExample("月銷售量圖表");
        chartExample.pack();
        RefineryUtilities.centerFrameOnScreen(chartExample);
        chartExample.setVisible(true);

        // 監聽窗口關閉事件
        chartExample.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
