package week04;
public class TallyCounterTester {
    public static void main(String[] args) {
        TallyCounter counter = new TallyCounter();
        TallyCounter counter2 = new TallyCounter();

        counter.countUp();
        counter.countUp();

        for (int i = 0; i < 10; i++) {
            counter2.countDown();
        }



        int value = counter.getCounter();
        System.out.println(value);
        System.out.println(counter2.getCounter());
    }
}
