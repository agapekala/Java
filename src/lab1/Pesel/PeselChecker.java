package lab1.Pesel;
public class PeselChecker

{
    private String pesel;
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


    public PeselChecker(String pesel) {
        this.pesel = pesel;
    }

    boolean Checker(){
        int wynik=9*Character.getNumericValue(pesel.charAt(0))+7*Character.getNumericValue(pesel.charAt(1))+3*Character.getNumericValue(pesel.charAt(2))
                +Character.getNumericValue(pesel.charAt(3))+9*Character.getNumericValue(pesel.charAt(4))+7*Character.getNumericValue(pesel.charAt(5))
                +3*Character.getNumericValue(pesel.charAt(6))+Character.getNumericValue(pesel.charAt(7))+9*Character.getNumericValue(pesel.charAt(8))+7*Character.getNumericValue(pesel.charAt(9));
        if (wynik%10==Character.getNumericValue(pesel.charAt(10))){
            return true;
        }
        else{
            return false;
        }
    }
}
