package lab8.zad4;

import lab1.Pesel.*;

public abstract class Pracownik {
    private PeselChecker pesel;
    private double brutto;

    abstract public double obliczNetto();

    public String getPesel() {
        return pesel.getPesel();
    }

    public double getBrutto(){
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public void setPesel(PeselChecker pesel) {
        this.pesel = pesel;
    }
}
