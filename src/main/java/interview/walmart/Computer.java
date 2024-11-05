package interview.walmart;

public class Computer {
    private boolean hasgpu;
    private boolean hasram;

    private String chipName;



    private Computer(ComputerBuilder builder) {
        this.chipName = builder.chipName;
        this.hasram = builder.hasram;
        this.hasgpu = builder.hasgpu;
    }

    public static class ComputerBuilder {
        private boolean hasgpu;
        private boolean hasram;

        private String chipName;

        public ComputerBuilder setChipName(String chipName) {
            this.chipName = chipName;
            return this;
        }

        public ComputerBuilder setHasgpu(boolean hasgpu) {
            this.hasgpu = hasgpu;
            return this;
        }

        public ComputerBuilder setHasram(boolean hasram) {
            this.hasram = hasram;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "hasgpu=" + hasgpu +
                ", hasram=" + hasram +
                ", chipName='" + chipName + '\'' +
                '}';
    }
}
