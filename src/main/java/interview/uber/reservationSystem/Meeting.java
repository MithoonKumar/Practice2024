package interview.uber.reservationSystem;

public class Meeting {
    private int startTime;
    private int endTime;
    private int meetingRoomId;

    public Meeting(int startTime, int endTime, int meetingRoomId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingRoomId = meetingRoomId;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getMeetingRoomId() {
        return meetingRoomId;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", meetingRoomId=" + meetingRoomId +
                '}';
    }
}
