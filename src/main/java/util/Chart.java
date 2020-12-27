package util;

import java.awt.Color;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart {
    public Chart(String title, List<Integer> data) {
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        for (int i = 0; i < data.size(); i++) {
            mDataset.addValue(data.get(i), "", Integer.toString(i + 1));
        }
        
        JFreeChart mChart = ChartFactory.createLineChart(title, // 图名字
                "月份", // 横坐标
                "数量", // 纵坐标
                mDataset, // 数据集
                PlotOrientation.VERTICAL, false, // 显示图例
                true, // 采用标准生成器
                false);// 是否生成超链接

        CategoryPlot mPlot = (CategoryPlot) mChart.getPlot();
        mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        mPlot.setRangeGridlinePaint(Color.BLUE);// 背景底部横虚线
        mPlot.setOutlinePaint(Color.RED);// 边界线

        ChartFrame mChartFrame = new ChartFrame(title, mChart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);
    }

}