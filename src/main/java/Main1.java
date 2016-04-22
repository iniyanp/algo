import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by paramasivami on 12/23/15.
 */




class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}

public class Main1 {


    public static void doSomeOperations(){
        Person p1 = new Person("Iniyan Paramasivam",31);
        Person p2 = new Person("Kumar ",30);
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);

        //reduce takes binaryOperator as an argument.
        // It means you have to give 2 operators of the type <T>, do some operations and then return the result with the same type. <T>


        persons.stream().reduce( (p3, p4) -> p3.age > p4.age ? p3 : p4).ifPresent(p -> System.out.println(p.name + " ==> " + p.age));

        Person result = persons.stream().reduce(
                new Person("",0),
                (p3, p4) -> {
                    p3.age += p4.age;
                    p3.name += p4.name;
                    return p3;
                }
        );

        System.out.println(result.name);
        System.out.println(result.age);

        //Find summation of age.


        //Reduction operations parallelize more gracefully without needing additional synchronization.
        // We should have associative function in reduce method.
        /*
        so that we can execute the things in parallel.
        a op b op c op d => ( a op b ) op ( c op d )

        * Stream doesn't modify the source. Filtering a collection from a stream doesn't modify the source instead it produces new stream with filtered elements.
        *
        * Non- deterministic => same input different results on different runs.
        *
        * Identity value is an initial seed value.
        *

        *   // Heaviest weight.
        * OptionalInt heaviest = widgets.parallelStream()
                                   .mapToInt(Widget::getWeight)
                                   .max();
            // Sum of weights.
           int sumOfWeights = widgets.stream()
                               .reduce(0,
                                       (sum, b) -> sum + b.getWeight())
                                       Integer::sum);
        *
         */
        Integer sum = Arrays.asList(1,2,3,4).stream().reduce(1, (a,b) -> a + b);
        System.out.println(sum);
    }



    public static void doSomeOperations1(){
        Ordering<String> byLength = new Ordering<String>() {

            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        };

        List<String> famousBridges = Lists.newArrayList(
                "Great Belt Bridge",
                "Chapel Bridge",
                "Chengyang Bridge",
                "null",
                "Brooklyn Bridge",
                "Ponte Vecchio"
        );

        Collections.sort(famousBridges,
                byLength.nullsFirst().reverse());

        System.out.println(famousBridges);

    }

    public static void main(String[] args) {
        doSomeOperations1();
//        List<Foo> foos = new ArrayList<>();
//        IntStream.range(1,4).forEach(
//                i -> foos.add(new Foo("This is my Foo " + i))
//        );

        //create bars.
//        foos.forEach(
//                f -> IntStream.range(1,4).forEach(
//                        i -> f.bars.add(new Bar("This is my Bar " + i + " in " + f.name))
//                )
//        );
//
//        foos.stream().flatMap(foo -> foo.bars.stream()).forEach(
//                f -> System.out.println(f.name)
//        );

        //Way of creating list of foo objects and printing them using flat map.

//        IntStream.range(1,4)
//                .mapToObj(i -> new Foo("This is my Foo " + i))
//                .peek(f -> IntStream.range(1, 4)
//                        .mapToObj(j -> new Bar("This is my Bar " + j + " in foo " + f.name))
//                        .forEach(f.bars::add))
//                .flatMap(foo -> foo.bars.stream())
//                .forEach(bar -> System.out.println(bar.name)
//                );

    }


}
