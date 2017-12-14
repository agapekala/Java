package lab8.zad4;

import java.sql.*;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt=null;
    private ResultSet rs = null;
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/apekala",
                            "apekala","pVhfjp9dtEhzXKW4");


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }



}
