import java.util.Arrays;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class HW11_1 {
    static String Task1(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(n -> (n-1) % 2 != 0)
                .mapToObj(index -> String.format("%d. %s", index, names.get(index)))
                .collect(Collectors.joining(", "));
    }

    public static List<String> Task2(List<String> names) {
         return names.stream()
               .map(String::toUpperCase)
               .sorted(Comparator.reverseOrder())
               .collect(Collectors.toList());
    }


    public static String Task3(String[] arr) {
        return Arrays.stream(arr)
                .flatMap(s -> Stream.of(s.split((", "))))
                .map(Integer::valueOf)
                .sorted(Integer::compareTo)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }


    public static Stream<Long> Task4() {
        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2,48);
        long seed = 0;
        return Stream.iterate(seed, x -> (a * (x + c) % m));
    }


    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.toList();
        List<T> secondList = second.toList();

        int size = Math.min(firstList.size(), secondList.size());
        List<T> result = new ArrayList<>();

        IntStream.range(0,size).forEach((element) ->{
                    result.add(firstList.get(element));
                    result.add(secondList.get(element));
                }
        );

        return result.stream();
    }

}

class HW111Test {
    public static void main (String[] args) {
        List<String> names = Arrays.asList("A_Name1", "F_Name2", "R_Name3", "D_Name4", "G_Name5", "O_Name6", "B_Name7");
        String[] arr = {"1, 2, 0", "4, 5"};
        Stream<String> first = Stream.of("One", "Two", "Three", "Four", "Five");
        Stream<String> second = Stream.of("Six", "Seven", "Eight", "Nine", "Ten");

        //1
        System.out.println(HW11_1.Task1(names));
        //2
        System.out.println(HW11_1.Task2(names));
        //3
        System.out.println(HW11_1.Task3(arr));
        //4
        //lomaet kamputer, no rabotaet
        //HW11_1.Task4().forEach(System.out::println);
        //5
        List<String> result = HW11_1.zip(first, second).collect(Collectors.toList());
        System.out.println(result);

    }
}

