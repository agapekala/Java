package lab1.LiczbyPierwsze;

public class LiczbyPierwsze {

    public static void main(String[] args) {
        System.out.print("Wprowadz liczbe: ");
        int checkedFor = JIn.getInt();
        System.out.println(checkedFor);
        for (int i = 2 ; i<checkedFor; ++i) {
            if (checkIfPrime(i)) System.out.print(i+" ");
        }
    }
    private static boolean checkIfPrime(int input){
        for (int i = 2; i<input; ++i){
            if (input%i==0) return false;
        }
        return true;
    }
}