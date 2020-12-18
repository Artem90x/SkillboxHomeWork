
public class Loader {
    private static Generator THREAD_ONE = new Generator(199, "res/numbers1.txt");
    private static Generator THREAD_TWO = new Generator(777, "res/numbers2.txt");

    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            THREAD_ONE.start();
            THREAD_TWO.start();

            THREAD_ONE.join();
            THREAD_TWO.join();
            System.out.println((System.currentTimeMillis() - start) + " ms");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
