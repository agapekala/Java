package lab8.zad3;

import java.sql.*;

public class DB{
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt=null;
    private ResultSet rs = null;
    private int iterator=0;
    String wynik="";
    public void connect(){
        try {
            iterator+=1;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/apekala",
                            "apekala","pVhfjp9dtEhzXKW4");


        } catch (SQLException ex) {
            // handle any errors
            if(conn==null && iterator<=3){
                System.out.println("Łączenie"+iterator);
                connect();
                iterator=0;}
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }


    public void search(String aut) {
        try {
            connect();
            String sql="SELECT * FROM books WHERE author LIKE ? OR isbn=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, "%"+aut+"%");
            pstmt.setString(2, aut);
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for(int i=1; i<=columnsNumber; i++){
                    wynik+=rs.getString(i)+" ";
                }
                wynik+='\n';
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

    public void add(String isbn, String title, String author, String year) {
        try {
            stmt = conn.createStatement();
            String sql="INSERT INTO books (isbn,title,author,`year`)"
                    + "values (?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, isbn);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, year);
            pstmt.executeUpdate();
        }catch (SQLException ex){

        }
    }
}