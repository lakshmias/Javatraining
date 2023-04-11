import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class LongRunTest {
    public static void main(String[] args) {
        System.out.println("Before call");
        LongRunTest l = new LongRunTest();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return l.randomBigNumber().toString();
        });

        future.thenAccept(System.out::println);
       
        System.out.println("After call");
        future.join();
    }

    public BigInteger randomBigNumber() {
        //Method that takes long time to return a big number
        //used for testing the future class functionalities
        BigInteger veryBig = new BigInteger(3500, new Random());
        veryBig.nextProbablePrime();
        return veryBig;
    }
}
