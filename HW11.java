import java.util.Arrays;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HW11 {
    public static String Task1(String[] names) {
        String res = "";
        for (int i = 0; i < names.length; i++) {
            res += i+1 + ". " + names[i] + ", ";
            i++;
        }

        return res;
    }


    public static String Task2(String[] names) {

        Arrays.sort(names);

        String[] reverse = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            reverse[reverse.length-i-1] = names[i];
        }

        return Arrays.toString(reverse);
    }


    public static String Task3(String[] arr) {
        String temp = "";

        for (String words: arr) {
            temp += words + " ";
        }

        String[] tmp = temp.split(" ");
        Arrays.sort(tmp);

        for (int j = 0; j < tmp.length; j++) {
            if (tmp[j].length() > 1) {
                tmp[j] = tmp[j].substring(0, tmp[j].length() - 1);
            }
        }

        String answ = "";

        for (int i = 0; i < tmp.length; i++) {
            if (i < tmp.length-1) {
                answ += tmp[i] + ", ";
            } else {
                answ += tmp[i];
            }
        }

        return answ;
    }


    public static Stream<Long> Task4() {
        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2,48);
        long seed = 0;
        return Stream.iterate(seed, x -> (a * (x + c) % m));
    }


    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());

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

class HW11Test {
    public static void main (String[] args) {
        String[] names = {"A_Name1", "F_Name2", "R_Name3", "D_Name4", "G_Name5", "O_Name6", "B_Name7"};
        String[] arr = {"1, 2, 0", "4, 5"};
        Stream<String> first = Stream.of("One", "Two", "Three", "Four", "Five");
        Stream<String> second = Stream.of("Six", "Seven", "Eight", "Nine", "Ten");

        //1
        System.out.println(HW11.Task1(names));
        //2
        System.out.println(HW11.Task2(names));
        //3
        System.out.println(HW11.Task3(arr));
        //4
        //lomaet kamputer, no rabotaet
        //HW11.Task4().forEach(System.out::println);
        //5
        List<String> result = HW11.zip(first, second).collect(Collectors.toList());
        System.out.println(result);

    }
}

