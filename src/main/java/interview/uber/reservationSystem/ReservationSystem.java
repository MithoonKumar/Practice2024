package interview.uber.reservationSystem;

import java.util.HashMap;
import java.util.TreeMap;

public class ReservationSystem {

    private int numberOfRooms;
    private HashMap<Integer, TreeMap<Integer, Integer>> roomMeetingsMap;


    public ReservationSystem(int numberOfRooms) {
        this.roomMeetingsMap = new HashMap<>();
        this.numberOfRooms = numberOfRooms;
        for (int i=0; i<numberOfRooms; i++) {
            this.roomMeetingsMap.put(i, new TreeMap<>());
        }
    }

    public Meeting addMeeting(int startTime, int endTime) {
        for (int i=0; i<numberOfRooms; i++) {
            Integer lowerKey = this.roomMeetingsMap.get(i).lowerKey(startTime);
            Integer ceilingKey = this.roomMeetingsMap.get(i).ceilingKey(startTime);
            if ((lowerKey == null || this.roomMeetingsMap.get(i).get(lowerKey) < startTime) && (ceilingKey == null || ceilingKey > endTime)) {
                this.roomMeetingsMap.get(i).put(startTime, endTime);
                Meeting meeting = new Meeting(startTime, endTime, i);
                return meeting;
            }
        }
        throw new RuntimeException("No free slot available in any room");
    }

    public void cancelMeeting(Meeting meeting) {
        int startTime = meeting.getStartTime();
        int roomId = meeting.getMeetingRoomId();
        this.roomMeetingsMap.get(roomId).remove(startTime);
    }


    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem(2);
        //Add a meeting in room0;
        Meeting meeting1 = reservationSystem.addMeeting(1, 10);
        //Add another meeting in room0
        Meeting meeting2 = reservationSystem.addMeeting(10, 20);
        //Add third meeting in room1
        Meeting meeting3 = null;
        try {
            meeting3 = reservationSystem.addMeeting(10, 20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(meeting1);
        System.out.println(meeting2);
        System.out.println(meeting3);
        reservationSystem.cancelMeeting(meeting2);

//        //Add third meeting in room0
//        Meeting meeting4 = reservationSystem.addMeeting(10, 20);
//        System.out.println(meeting4);
//
//        //Add third meeting in any room
//        //This should throw an exception
//        Meeting meeting5 = reservationSystem.addMeeting(10, 20);
    }
}
