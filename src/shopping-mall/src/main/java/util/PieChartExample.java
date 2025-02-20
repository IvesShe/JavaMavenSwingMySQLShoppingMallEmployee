package util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PieChartExample extends ApplicationFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PieChartExample(String title) {
        super(title);

        // 創建數據集
        PieDataset<String> dataset = createDataset();

        // 創建圓餅圖
        JFreeChart chart = createChart(dataset);

        // 創建面板顯示圖表
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private PieDataset<String> createDataset() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();

        // 假設的數據：各產品銷售比例
        dataset.setValue("產品A", 30);
        dataset.setValue("產品B", 20);
        dataset.setValue("產品C", 50);

        return dataset;
    }

    private JFreeChart createChart(PieDataset<String> dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "產品銷售比例", // 圖表標題
                dataset, // 數據集
                true, // 是否顯示圖例
                true, // 是否顯示提示工具
                false // 是否顯示URL
        );

        // 設定字型，支援中文
        Font font = new Font("新細明體", Font.PLAIN, 14);
        chart.getTitle().setFont(font); // 設置標題字型
        PiePlot<?> plot = (PiePlot<?>) chart.getPlot();
        plot.setLabelFont(font); // 設置標籤字型

        return chart;
    }

    public static void main(String[] args) {
        // 創建 PieChartExample 例項並顯示圖表
        PieChartExample chartExample = new PieChartExample("產品銷售比例圓餅圖");
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
