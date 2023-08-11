package Ch7.Ch7DevEx.arithmeticExercises;

import java.util.Date;

public class Timer {
    // data members
    private static final int MS_TO_S = 1000; // used to convert from milliseconds to seconds
    private Date startTime, endTime;

    // constructors
    public Timer() {

    }

    // start the timer
    public void start() {
        startTime = new Date();
    }

    // end the timer
    public void end() {
        endTime = new Date();
    }

    // get the time taken
    public long getTimeTaken() {
        long timeTaken = (startTime.getTime() - endTime.getTime()) * MS_TO_S;
        return timeTaken;
    }
}
