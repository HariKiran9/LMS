package swissre;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExStreams {

    public static void main(String[] args) {
        new ExStreams().lazyEvaluationMechanics();
    }

    private void lazyEvaluationMechanics() {
        List<String> names = Arrays.asList("Bala", "Hari", "Kiran", "Chebrolu");

        Stream<String> names2 = names.stream().filter(name -> {
//            System.out.println("Filtering: " + name);
            return name.length() > 4;
        }).map(name -> {
//            System.out.println("Mapping: " + name);
            return name.toUpperCase();
        });
        System.out.println("==========");
        names2.forEach(System.out::println);
        System.out.println("==========");

    }

}



