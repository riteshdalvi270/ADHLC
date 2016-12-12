package Oct2016.leetcode;

import java.util.*;

/**
 * Created by ritesh on 12/11/16.
 */
public class MeetingRoom {

    public static void main(String args[]) {

        final Interval interval1 = new Interval(0,30);
        final Interval interval2 = new Interval(5,10);
        final Interval interval3 = new Interval(15,20);

        //final Interval interval3 = new Interval(15,20);

        System.out.println(minMeetingRoomsRightSolution(new Interval[]{interval1,interval2,interval3}));

    }

    // not by me.
    public static int minMeetingRoomsRightSolution(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

    public static int minMeetingRooms(Interval[] intervals) {

        final Queue<Meeting> meeting = new ArrayDeque<>();

        if(intervals.length == 1) {
            return 1;
        }

        for(int i=0; i<intervals.length;i++) {
            Interval interval1 = intervals[i];

            final Meeting meetingRoom = new Meeting();

            int j = 0;
            while(j<intervals.length){

                if(j == i) {
                    j++;
                    continue;
                }

                Interval interval2 = intervals[j];

                //no clash
                if(interval2.start >= interval1.end ||interval2.end<=interval1.start) {

                    meetingRoom.clash = false;
                    meetingRoom.visited = true;
                }else {

                    if(!meetingRoom.visited) {
                        meetingRoom.clash = true;
                    }
                    meetingRoom.visited = true;
                }

                j++;
            }

            if(meetingRoom.visited) {
                meeting.add(meetingRoom);
            }
        }

        int minRoomNeeded = 0;
        int roomDidNotClash = 0;

        while(!meeting.isEmpty()) {

            final Meeting room = meeting.remove();

            if(room.clash) {
                minRoomNeeded = minRoomNeeded + 1;
            }else {
                roomDidNotClash = 1;
            }
        }

        return minRoomNeeded + roomDidNotClash;
    }

    public static class Meeting {

        int start;
        int end;
        boolean clash;
        boolean visited;

        Meeting() {

        }

        Meeting(int start, int end, boolean clash, boolean visited) {
            this.start = start;
            this.end = end;
            this.clash = clash;
            this.visited = visited;
        }
    }

    public static class Interval {
        int start;
        int end;

        Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}
