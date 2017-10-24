package lab2.zad1.pkg1;

public class A {

    protected int numbers;
    String name;

    public A(String name, int numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    protected void decrement() {
        numbers -= 1;
    }

    void changeName() {
        name = "ABC";
    }

    private void increment() {
        numbers += 1;
    }

    public void callDecrement() {
        decrement();
    }

    public void callChangeName() {
        changeName();
    }

    public void callIncrement() {
        increment();
    }

    public int getNumbers() {
        return numbers;
    }

    public String getName() {
        return name;
    }
}
