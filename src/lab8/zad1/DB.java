package lab8.zad1;

import java.sql.*;

public class DB{
    private Connection conn = null;
    private Statement stmt = null;
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


        public void listNames() {
            try {
                connect();
                stmt = conn.createStatement();

                rs = stmt.executeQuery("SELECT * FROM books");
                ResultSetMetaData rsmd = rs.getMetaData();

                int columnsNumber = rsmd.getColumnCount();
                System.out.println(columnsNumber);
                while (rs.next()) {

                    for(int i=1; i<=columnsNumber; i++){
                        System.out.print(rs.getString(i)+" ");
                    }
                    System.out.println();
                }

            } catch (SQLException ex) {

            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) {
                    } // ignore
                    rs = null;
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) {
                    } // ignore

                    stmt = null;
                }
            }
        }
}