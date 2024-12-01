package interview.Google;

import java.util.Random;

public class Main {

    private static Long getRandomNum() {
        Random random = new Random();
        int min = 10;
        int max = 50;
        int randomNum = random.nextInt((max - min) + 1) + min;
        return Long.valueOf(randomNum);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");
        CustomStreamingClass customStreamingClass = new CustomStreamingClass();
        customStreamingClass.startStreaming(1);
        int counter = 0;
        while (true) {
            Thread.sleep(50);
            customStreamingClass.addData(getRandomNum());
            counter++;
            if (counter == 100) {
                customStreamingClass.stopStreaming();
            }
        }
    }
}
