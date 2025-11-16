
package bug.triage;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;



public class graph extends ApplicationFrame {

    
    public graph(final String title) {

        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
         

    }

    private XYDataset createDataset() {
 final XYSeries series1 = new XYSeries("DS-E1");
        series1.add(5,60);
        series1.add(10,65);
        series1.add(20,68);
        series1.add(25,68);
        series1.add(35,75);
        series1.add(40,80);
        series1.add(50,85);
        series1.add(60,89);
        series1.add(70,95);
        series1.add(80,98);
       // series1.add(100,55);

        final XYSeries series2 = new XYSeries("DS-M1");
        series2.add(4,50);
        series2.add(10,60);
        series2.add(20,70);
        series2.add(25,70);
        series2.add(35,78);
        series2.add(40,85);
        series2.add(50,89);
        series2.add(60,95);
        series2.add(70,99);
        series2.add(80,100);
        series2.add(90,110);
      //  series2.add(100,120);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
       dataset.addSeries(series2);
      
      


        return dataset;

    }

    private JFreeChart createChart(final XYDataset dataset) {

       
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Efficiency",      // chart title
            " Dataset Performance",                      // x axis label
            " Loss of Datas ",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     
            true,                     
            false                     
        );

        chart.setBackgroundPaint(Color.white);
        
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0,true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setRange(50,100);//y axis
 

        return chart;

    }

    public static void main(final String[] args) {

        final graph p = new graph("Efficiency");
        p.pack();
        RefineryUtilities.centerFrameOnScreen(p);
        p.setVisible(true);

    }

//    void pack() {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    void setVisible(boolean b) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    void pack() {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

}
