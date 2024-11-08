package interview.uber.alarmLibrary;

/*
Schedule
AlarmType
Alarm
AlarmState
AlarmScheduler
*/


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Schedule schedule = new Schedule(10);
        AlarmManager alarmManager = new AlarmManager(2);
        String alarm1 = alarmManager.addAlarm(schedule, AlarmType.ONETIME);

        Schedule schedule1 = new Schedule(10, 10);
        alarmManager.addAlarm(schedule1, AlarmType.REPETITIVE);

        System.out.println(alarmManager.getAlarmHashMap().get(alarm1).getAlarmState());

        Thread.sleep(20000);
        System.out.println(alarmManager.getAlarmHashMap().get(alarm1).getAlarmState());

    }
}
