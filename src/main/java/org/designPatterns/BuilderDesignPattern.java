package org.designPatterns;

public class BuilderDesignPattern {

    public static void main(String[] args) {
        System.out.println("hello");
        Computer computer = new Computer.ComputerBuilder()
                .setCpu("intel")
                .setRam("6gb")
                .setIsBluetoothEnabled(true)
                .setIsGraphicsCardEnabled(true)
                .build();
        System.out.println(computer);
    }
}


class Computer {
    private String cpu;
    private String ram;
    private Boolean isBluetoothEnabled;
    private Boolean isGraphicsCardEnabled;

    public Computer(ComputerBuilder computerBuilder) {
        this.cpu = computerBuilder.cpu;
        this.ram = computerBuilder.ram;
        this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled;
        this.isGraphicsCardEnabled = computerBuilder.isGraphicsCardEnabled;
    }

    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private Boolean isBluetoothEnabled;
        private Boolean isGraphicsCardEnabled;

        public ComputerBuilder() {
        }

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setIsBluetoothEnabled(Boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public ComputerBuilder setIsGraphicsCardEnabled(Boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}