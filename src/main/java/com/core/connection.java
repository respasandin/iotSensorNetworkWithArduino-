package com.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.ui.ApplicationFrame;

public class connection extends ApplicationFrame implements ActionListener {
    static int number;
    static int number2;
    static String formattedDate;
    public PreparedStatement  stmt;
    public Connection con;
    public PreparedStatement  stmt2;
    public Connection con2;
    boolean end = false;
    public  String server_IP = App.host;
    public  int server_Port = 8080;
    public  ObjectOutputStream out; 
    public  OutputStream output;
    public  static Socket so;
    static DynamicLineAndTimeSeriesChart demo;
    static DynamicLineAndTimeSeriesChart2 demo2;
    private String host = "127.0.0.1";
    private int db_port = 8889;

    
    public  void main(final String[] args) throws IOException {
        
    }
    
    public connection(String title) throws IOException, InterruptedException {
        super(title);  
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                BufferedInputStream  br;
                try {
                    getCurrentTimeUsingCalendar();
                    try{
                        so = new Socket (server_IP,server_Port); 
                        //Makes connection with Arduino
                        output = so.getOutputStream(); 
                        output.write(App.timei);
                        //Send to Arduino the update time
                        output.write(1);    
                        //Send 1 to go to connection     
                    } 
                    catch ( IOException ex) {
                        Logger.getLogger
                        (App.class.getName()).log(Level.SEVERE, null, ex);
                    }     
                    //Receives the data from Arduino
                    br = new BufferedInputStream(so.getInputStream());
                    //Makes a buffer to read the data
                    number = br.read(); //Read first line
                    number2 = br.read(); //Read second line
                    writeDatabase(); //Go to Database
                } catch (IOException | SQLException ex) {
                    Logger.getLogger
                    (connection.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
            };timer.scheduleAtFixedRate(task, 0 , App.timei*1000);
            //Makes this taks every input time
            
        //Creates the graphs and set visible
        demo = new DynamicLineAndTimeSeriesChart("Sensor de PH");
        demo.pack(); 
        demo.setVisible(true);
        demo2 = new DynamicLineAndTimeSeriesChart2("Sensor de conductividad");
        demo2.pack(); 
        demo2.setVisible(true);
    }

    public void getCurrentTimeUsingCalendar() {
        Calendar cal = Calendar.getInstance();
        java.util.Date date= cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        formattedDate = dateFormat.format(date); 
   }  
    public void writeDatabase() throws SQLException{
         //Makes connection with the database and insert date and value
         con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + db_port + "/'" + App.host + "'?user=root&password=root");
         stmt = con.prepareStatement(" INSERT INTO ph (fecha, valor)" + " values (?, ?)");
         stmt.setString(1,formattedDate);
         stmt.setInt(2, number);
         // execute the preparedstatement
         stmt.executeUpdate();

         con2 = DriverManager.getConnection("jdbc:mysql://" + host + ":" + db_port + "/'" + App.host + "'?user=root&password=root");
         stmt2 = con2.prepareStatement(" INSERT INTO conductividade (fecha, valor)"
                 + " values (?, ?)");
         stmt2.setString(1,formattedDate);
         stmt2.setInt(2, number2);
         // execute the preparedstatement
         stmt2.executeUpdate();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

