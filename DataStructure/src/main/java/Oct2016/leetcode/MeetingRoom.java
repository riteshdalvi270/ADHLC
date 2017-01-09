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

    // after second try
    public static int minMeetingRoomsRightSolution(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });

        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(intervals[0].end);

        int count = 1;

        for(int i = 1; i<intervals.length; i++) {

            if(intervals[i].start<priorityQueue.peek()) {
                count++;
            }else {
                priorityQueue.poll();
            }

            priorityQueue.add(intervals[i].end);
        }

        return count;
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
