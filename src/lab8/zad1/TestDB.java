package lab8.zad1;

public class TestDB {
    public static void main(String []args){
        DB db=new DB();
        db.connect();
        db.listNames();
    }
}
