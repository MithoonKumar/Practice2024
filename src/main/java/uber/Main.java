package uber;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");


        AlarmManager alarmManager = new AlarmManager(10, 100L);
        String alarmId = alarmManager.addAlarm(1000L);
        String alarmId1 = alarmManager.addAlarm(1000L);

        String alarmId2 = alarmManager.addAlarm(1000L);
        String alarmId3 = alarmManager.addAlarm(1000L);

        Thread.sleep(3000L);
        alarmManager.cancelAlarm(alarmId);
        alarmManager.cancelAlarm(alarmId1);
        alarmManager.cancelAlarm(alarmId2);
        alarmManager.cancelAlarm(alarmId3);
    }
}
