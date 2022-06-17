package java17features;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        RandomGeneratorFactory.all()
                .map(factory-> factory.group() + ":" + factory.name())
                .sorted()
                .forEach(System.out::println);

        RandomGenerator randomGenerator = RandomGeneratorFactory.of("Xoroshiro128PlusPlus").create();
        System.out.println(randomGenerator.getClass());

        int i =0;
        while(i<=0) {
            int num = randomGenerator.nextInt();
            System.out.println(num);
            i++;
        }
    }
}
