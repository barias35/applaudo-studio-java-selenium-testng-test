package utils;

public class ThreadSleepHelper {
    public static void threadSleep(int timeInMiliSeconds){
        try {
            Thread.sleep(timeInMiliSeconds);
        }catch (Exception ex){
        }
    }
}
