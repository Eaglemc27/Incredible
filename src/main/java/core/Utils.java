package core;

class Utils {
    static void sleep(long poolingInterval) {
        try {
            Thread.sleep(poolingInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
