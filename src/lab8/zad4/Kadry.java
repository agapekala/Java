package lab8.zad4;
import lab1.Pesel.*;
import java.sql.*;

public class Kadry {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt=null;
    private ResultSet rs = null;
    public Pracownik pr=null;
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

    public void add(Pracownik p){
        try {
            connect();
            String typ="";
            if(p.getClass().getName()=="Student"){
                typ="student";
            }else{
                typ="pracownik etatowy";
            }
            stmt = conn.createStatement();
            String sql="INSERT INTO pracownicy (pesel,brutto,`type`)"
                    + "values (?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, p.getPesel());
            pstmt.setDouble(2, p.getBrutto());
            pstmt.setString(3, typ);
            pstmt.executeUpdate();
        }catch (SQLException ex){

        }
    }
    public void remove(Pracownik p){
        try{
            connect();
            stmt =conn.createStatement();
            String sql="DELETE FROM pracownicy WHERE pesel=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,p.getPesel());
            pstmt.executeUpdate();
        }catch(SQLException e){

        }

    }
    public Pracownik find(PeselChecker p){
        try {
            connect();
            String sql="SELECT * FROM pracownicy WHERE pesel=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, p.getPesel());
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                if(rs.getString("type")=="student"){
                    pr=new Student();
                }else{
                    pr=new PracownikEtat();
                }
                PeselChecker pesel=new PeselChecker(rs.getString("pesel"));
                pr.setPesel(pesel);
                pr.setBrutto(rs.getDouble("brutto"));
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
        return pr;
    }
    public double getBrutto(Pracownik p){
        double wynik=0;
        try {
            connect();
            String sql="SELECT * FROM pracownicy WHERE pesel=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, p.getPesel());
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                wynik=rs.getDouble("brutto");
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
        return wynik;
    }

    public void changeBrutto(Pracownik p, double new_brutto){
        try {
            connect();
            String sql="UPDATE pracownicy SET brutto=? WHERE pesel=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setDouble(1, new_brutto);
            pstmt.setString(2, p.getPesel());
            pstmt.executeUpdate();

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
