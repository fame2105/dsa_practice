package mutithreading.completableFutureAPIandUsage;

public class ScheduleATask {
    public static void main(String[] args) {

        int allowedWaitingTime = 8000;
        long requestArrivalTime = System.currentTimeMillis();

        while(requestArrivalTime + allowedWaitingTime > System.currentTimeMillis()) {
            System.out.println("Waiting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Done");
    }
}
