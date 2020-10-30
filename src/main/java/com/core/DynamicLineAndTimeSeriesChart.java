package com.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;


public class DynamicLineAndTimeSeriesChart extends ApplicationFrame implements ActionListener {
    private TimeSeries series;
    private double lastValue ;
 
    private Timer timer2 = new Timer(App.timeinterval *1000, this); //Update time
    
    public DynamicLineAndTimeSeriesChart(final String title) throws IOException {
        super(title);
        
        this.series = new TimeSeries("Valores do sensor de PH", Second.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);
        timer2.setInitialDelay(100);
        
        chart.setBackgroundPaint(Color.WHITE);
        final JPanel content = new JPanel(new BorderLayout());

        //Created Chartpanel for chart area
        final ChartPanel chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 400));
        setContentPane(content);
        content.setLocation(0,0);
        timer2.start();
    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart("Sensor PH", "", 
         "ph",dataset, false, false, false
         );

        final XYPlot plot = result.getXYPlot();
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.WHITE);
        plot.setDomainCrosshairVisible(true);
        plot.setDomainCrosshairLockedOnData(true);
        plot.setRangeCrosshairVisible(true);
        plot.setRangeCrosshairLockedOnData(true);

        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true); //Adjust de x axis to the data values
        xaxis.setVerticalTickLabels(true);

        ValueAxis yaxis = plot.getRangeAxis(); 
        yaxis.setRangeWithMargins(0, 14);
        
        return result;
    }
   
    public void actionPerformed(final ActionEvent e) {
        this.lastValue = connection.number;
        this.series.addOrUpdate(new Second(), this.lastValue);
    }
    
     public  void main(final String[] args) throws IOException {
        
    }

} 