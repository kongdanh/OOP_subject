import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class BarChartExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("a");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(10, "A", "1");
            dataset.addValue(15, "B", "1");
            dataset.addValue(20, "C", "1");

            JFreeChart chart = ChartFactory.createBarChart(
                "abcdef", "month", "number", dataset);

            ChartPanel chartPanel = new ChartPanel(chart);
            frame.setContentPane(chartPanel);

            frame.setVisible(true);
        });
    }
}
