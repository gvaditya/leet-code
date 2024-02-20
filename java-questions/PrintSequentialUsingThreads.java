public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Create three threads
        Thread t1 = new Thread(new Printer(array, 0, array.length / 3));
        Thread t2 = new Thread(new Printer(array, array.length / 3, (2 * array.length) / 3));
        Thread t3 = new Thread(new Printer(array, (2 * array.length) / 3, array.length));

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        try {
            // Wait for threads to finish
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Printer implements Runnable {
        private final int[] array;
        private final int start;
        private final int end;

        public Printer(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            synchronized(array) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + array[i]);
                    try {
                        // Sleep for a short while to simulate processing time
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
