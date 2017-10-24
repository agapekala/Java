package lab2.zad1.pkg1;

public class B extends A {

    public B(String name, int numbers) {
        super(name, numbers);
    }

    private void increment(){
        numbers+=2;
    }

    @Override
    void changeName() {
        name="new_name_b";
    }

    @Override
    protected void decrement() {
        numbers=numbers-2;
    }
}
