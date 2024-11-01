package practice.alarmLibrary;



import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Schedule schedule = new Schedule(10L, 5L, TimeUnit.SECONDS);
        Schedule schedule1 = new Schedule(1L, 1L, TimeUnit.SECONDS);
        AlarmScheduler alarmScheduler = new AlarmScheduler(Executors.newScheduledThreadPool(10));
        String alarmId = alarmScheduler.addAlarm(schedule, AlarmType.ONE_TIME, ()-> {
            System.out.println("The first alarm is running");
        });
        String alarmId1 = alarmScheduler.addAlarm(schedule1, AlarmType.REPEATED, ()->{
            System.out.println("The second alarm is running");
        });

        Thread.sleep(15000L);

        alarmScheduler.cancelAlarm(alarmId1);
    }
}
