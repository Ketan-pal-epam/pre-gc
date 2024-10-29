package basics;

import org.testng.annotations.DataProvider;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        // separating by even and odd
        Integer[] input = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(input));
        Map<Boolean, List<Integer>> partitioned = Arrays.stream(input)
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        // Print the partitioned lists
        partitioned.forEach((key, value) -> {
            System.out.println(key ? "Even: " + value : "Odd: " + value);
        });

        //frequency of each character in string
        String str= "missisipi";
        Map<Character, Long> mp=str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        mp.forEach((key,value)-> System.out.println(key+" "+value));


        //sorting in reverse order
        Integer[] reverse = Arrays.stream(input)
                .collect(Collectors.collectingAndThen(Collectors.toList(),list->{
                    Collections.reverse(list);
                    return list.stream();
                }))
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(reverse));

        Integer sec_last = Arrays.stream(input)
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println("Second last "+sec_last);

        Integer arm = 125;
        int armstrong=String.valueOf(arm).chars()
                .map(Character::getNumericValue)
                .map(digit->digit*digit*digit)
                .sum();
        System.out.println(armstrong);

        //sum of all elements in list
        int sum = Arrays.stream(input).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //convert string to upper case
        String upper = str.chars().map(Character::toUpperCase)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
        System.out.println(upper);

        //convert even indexed
        upper = IntStream.range(0,str.length())
                .map(i-> i%2==0?Character.toUpperCase(str.charAt(i)):str.charAt(i))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());

        System.out.println(upper);

        //sort string and get secondlast char

        List<Character> sec = str.chars()
                .sorted()
                .mapToObj(c->(char)c)
                .toList();
        System.out.println(sec);
        System.out.println(sec.get(sec.size()-4));

        //sorting using comparable
        List<Person> people = new ArrayList<>(Arrays.asList(new Person("akash", 18), new Person("jitesh", 12)));
        System.out.println("Before Sort");
        System.out.println(people);
        Collections.sort(people);
        System.out.println(people);

        //comparator
        people.sort((a,b)->b.getAge()-a.getAge());
        System.out.println(people);

//        Integer[] reverse = Arrays.stream(input)
//                .collect(Collectors.toList())
//                .stream()
//                .collect(Collectors.collectingAndThen())

        //builder pattern
        Person obj = Person.builder().setName("dholu").setAge(20).build();
        System.out.println(obj);

        System.out.println("Fibbonacci series");

        Stream.iterate(new int[]{0,1} ,f -> new int[] {f[1],f[0]+f[1]})
                .limit(10)
                .map(f->f[0])
                .forEach(System.out::println);


    }
    @DataProvider
    public Object[][] nameProvider(){
        return new Object[][]{{1,3},{4,5}};
    }
}
