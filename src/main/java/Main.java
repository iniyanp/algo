import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;


class Person {
    String firstName;
    String lastName;
    String name;
    int age;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name;
    }


}



public class Main {

    public static boolean findGreaterThanThree(int number){
        return number > 3;
    }
    public static boolean findEven(int number){
        return number % 2 == 0;
    }
    public static int findSquare(int number){
        return number * number;
    }

    public static void doSomeOperations(){

        List<Person> persons = Arrays.asList(
                new Person("Iniyan",27),
                new Person("Iniyan Paramasivam",27),
                new Person("Thamarai",29),
                new Person("Kumar",31)
        );

        List<Person> filtered = persons.stream().filter(p -> p.name.startsWith("I")).collect(Collectors.toList());

        Function<Person, Integer> groupbyFunction = (Person p) -> p.age;
         Map<Integer, List<Person>> map = persons.stream().collect(Collectors.groupingBy(groupbyFunction));

        System.out.println(filtered);
        //map foreach function takes BiConsumer as an argument. Takes 2 arguments and consume it.
        //In built collectors.

        map.forEach( (age, p) -> System.out.format("%s => %s\n",age, p));

        System.out.println(persons.stream().collect(Collectors.averagingDouble(p -> p.age)));

        IntSummaryStatistics summaryStatistics = persons.stream().collect(Collectors.summarizingInt(p -> p.age));
        System.out.format("%s\n\n",summaryStatistics.getCount());

        //Convert list to map.
        System.out.println(persons.stream().collect(Collectors.toMap(p -> p.age,
                p -> p.name,
                (name1, name2) -> name1 + "," + name2)));

        //Own collectors.
        Collector<Person,StringJoiner,String> personCollector = Collector.of(
                () -> new StringJoiner("|"," [ ","]"), //supplier
                (j, p) -> j.add(p.name.toUpperCase()), //accumulator => Biconsumer. It consumes 2 arguments.
                (j1, j2) -> j1.merge(j2),               // combiner => BinaryOperator.
                StringJoiner::toString)    ;          // finisher => Function
        System.out.println(persons.stream().collect(personCollector));

    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        doSomeOperations();
        names.add("Kumar");
        names.add("Iniyan");
        names.add("");
        Collections.sort(names, (String s1, String s2) -> s1.compareTo(s2));
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        //names.forEach(System.out::println);
        names.forEach(t -> System.out.println(t));

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        String s  = "";
        names.parallelStream().filter(string -> string.isEmpty()).count();

        System.out.println(names.parallelStream().filter(String::isEmpty).collect(Collectors.toList()));

        //Numbers
        List<Integer> numbers = Arrays.asList(1,2,3,5,4,6);
        System.out.println(numbers.stream().map(j -> j * j * j).collect(Collectors.toList()));

        //If it is a simple pass through we can use method reference. If we are changing the value and passing to method, then we
        // can't use method reference.
        // Get the requirements and give it to the programmer.
        // numbers.stream().filter(number -> findGreaterThanThree(number))

//        Optional e = numbers.stream().filter(Main::findGreaterThanThree)
//                        .filter(Main::findEven)
//                .map(Main :: findSquare).findFirst();

        // Lambda expressions are assigned to predicate.
        Predicate<Integer> isGreaterThan3 = number -> number > 3;
        System.out.println(isGreaterThan3.test(3));
        System.out.println("####");


        // Utility method. Instead of giving a fish, teaching him a lesson that how to catch a fish.
        /*
        Classes and methods.
        Predicate => test method. returns boolean
        Consumer => accept method. returns void
        Function => apply method. returns anything.
         */
        Function<Integer, Predicate<Integer>> isGreater = pivot -> number -> number > pivot;
        Optional e = numbers.stream().filter(isGreater.apply(3))
                        .filter(Main::findEven)
                .map(Main::findSquare).findFirst();
        System.out.println(e.get());

        Predicate<String> isEmpty = t -> Objects.nonNull(t);
        System.out.println(isEmpty.test("Iniyan"));

        //Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, Integer> toInteger = t -> Integer.valueOf(t);
        Function<String, String> sample =toInteger.andThen(String::valueOf);
        System.out.println(sample.apply("123"));

        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("Iniyan ","Paramasivam");
        Person p2 = new Person("Preethika ","Maanickam");
        System.out.println(comparator.reversed().compare(p2, p1));

        Optional<String> optional = Optional.of("Kumar");

        optional.ifPresent(t -> System.out.print(t));
        optional.ifPresent(System.out::print);

        range(0, 100)
                .mapToObj(i -> randomString(new Random(), 'A', 'Z', 10))
                .sorted()
                .collect(groupingBy(name -> name.charAt(0)))
                .forEach((letter, names1) -> System.out.println(letter + "\n\t" + names1.stream().collect(joining("\n\t"))));


        //Stream has anyMatch, allMatch, noneMatch, count.. methods. These operations are terminal.
        System.out.println(names.stream().anyMatch(t -> t.startsWith("I")));

        // Concatenate all the elements in the list.
        List<String> tempList = Arrays.asList("a","b","c");
        tempList.stream().sorted().filter( s1 -> s1.startsWith("b") || s1.startsWith("a")).map(String::toUpperCase).forEach( t -> System.out.println(t));

        Arrays.stream(new int[] {1,2,3,4}).map( n -> 2*n +1 ).average().ifPresent(System.out::print);

        Optional<String> result = tempList.stream().reduce( (a,b) -> a+b);
        System.out.println(result.get());

        Stream.of("a1","a2","a3").map( t -> t.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

        // Mapping double to int and then int to string.
        Stream.of(1.0,2.0,3.0).mapToInt(Double::intValue).mapToObj( t -> "a" + t).forEach(System.out::println);

        //Intermediate operations will get only executed when the terminal operation is present.
        Stream.of(1,2).filter(
                s2 ->
                {
                    String a = "Iniyan";
                    System.out.println( "In filter " + a + s2);
                    return true;
                }
        ).forEach(s3 -> System.out.println("In foreach "  + s3));

        System.out.println("###########");

        // We should use the same variable in all these statements.

        Stream.of("a","b","c").map(
                s5 -> {
                    System.out.println("In map" + s5);
                    return s5.toUpperCase();
                }
        ).filter(
                s5 -> {
                    System.out.println("In filter" + s5);
                    return s5.startsWith("A");
                }
        ).forEach(s5 -> System.out.println("In forEach" + s5));

        System.out.println("######COMPARISION#####");
        //Sorting is a stateful operation in order to sort a collection of elements you have to maintain state during ordering.

        Stream.of("a","b","c").filter(
                s5 -> {
                    System.out.println("In filter" + s5);
                    return s5.startsWith("a");
                }
        ).map(
                s5 -> {
                    System.out.println("In map" + s5);
                    return s5.toUpperCase();
                }
        ).forEach(s5 -> System.out.println("In forEach" + s5));

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("a", "b", "c").filter(s7 -> s7.startsWith("a"));
        System.out.println(streamSupplier.get().anyMatch(sa -> sa.startsWith("a")));
        System.out.println(streamSupplier.get().anyMatch(sa -> sa.startsWith("a")));

    }
    public static String randomString(Random r, char from, char to, int length) {
        return r.ints(from, to + 1).limit(length).mapToObj(x -> Character.toString((char)x)).collect(joining());
    }
}
