package com.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;
import javax.swing.JPanel;
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

public class DynamicLineAndTimeSeriesChart2 extends ApplicationFrame implements ActionListener {
    private TimeSeries series2;
    private double lastValue2 ;
    
    private Timer timer2 = new Timer(App.timei*1000, this); //Update time
 
    public DynamicLineAndTimeSeriesChart2(final String title) throws IOException {
        super(title);

        this.series2 = new TimeSeries("Valores do sensor de Conductividade", Second.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series2);
        final JFreeChart chart = createChart(dataset);
        timer2.setInitialDelay(100);

        chart.setBackgroundPaint(Color.lightGray);
        final JPanel content = new JPanel(new BorderLayout());

        //Created Chartpanel for chart area
        final ChartPanel chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 400));
        setContentPane(content);
        content.setLocation(100, 100);

        timer2.start();
    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
        "Sensor Condutividade","", "µS/cm", dataset, false, false, false
        );

        final XYPlot plot = result.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.WHITE);

        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true); //Adjust de x axis to the data values
   
        xaxis.setFixedAutoRange(100000);  
        xaxis.setVerticalTickLabels(true);

        ValueAxis yaxis = plot.getRangeAxis();
        yaxis.setRangeWithMargins(1, 50);
        
        return result;
    }
   
    public void actionPerformed(final ActionEvent e) {
        this.lastValue2 = connection.number2;
        this.series2.add(new Second(), this.lastValue2);

    }
    public static void main(final String[] args) throws IOException {

    }

} 
