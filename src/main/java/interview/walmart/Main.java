package interview.walmart;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder().setHasgpu(false).build();
        System.out.println(computer.toString());
    }
}
