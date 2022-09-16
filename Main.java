import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        arraysExamples();
        listExamples();
        streamExamples();
    }

    private static void streamExamples() {
        List<Integer> nums = Arrays.asList(5,2,4,6,8);
        //nums.stream().forEach(n -> System.out.println(n));
        nums = nums.stream().sorted().collect(Collectors.toList());
        //Collections.sort(nums, Comparator.reverseOrder());
        System.out.println(nums);

        List<String> values = new ArrayList<>();
        values.add("bird");
        values.add("dog");
        values.add("car");
        values.add("mac");
        values.add("cinnabon");


        List<String> filterList = values.stream().filter(v -> v.startsWith("c")).collect(Collectors.toList());
        System.out.println(filterList);

        List<String> skipList = values.stream().skip(2).collect(Collectors.toList());
        System.out.println(skipList);

        String test = values.stream().filter(s -> s.contains("bird")).findFirst().get();
        System.out.println(test);
        test = values.stream().filter(s -> s == "fish").findFirst().orElse("not found");
        System.out.println(test);

        List<Integer> nums2 = Arrays.asList(2,4,5,6,8,9);
        int result = nums2.stream().reduce(0, (a, b) -> a + b);
        int max = nums2.stream().reduce(0, Integer::max);
        System.out.println(max);

        Integer result2 = nums2.stream()
                .reduce(0, (a, b) -> {
                    try {
                        return a / 2 + b / 2;
                    } catch (ArithmeticException e) {
                        System.out.println("Arithmetic Exception: Division by Zero");
                    }
                    return 0;
                });
        System.out.println(result2);

        List<String> words = Arrays.asList("GFG", "Geeks", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");

        Optional<String> longestString = words.stream()
                .reduce((word1, word2)
                        -> word1.length() > word2.length()
                        ? word1 : word2);

        // Displaying the longest String
        longestString.ifPresent(System.out::println);

        Boolean anymatch = words.stream().anyMatch(w -> w.equals("Geeks"));
        System.out.println(anymatch);

        List<String> wordsNotRepeated = words.stream().distinct().collect(Collectors.toList());
        System.out.println(wordsNotRepeated);

        //map
        List<Integer> number = Arrays.asList(2,3,4,5);
        List<Integer> square = number.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(square);

        words = Arrays.asList("GFG", "Geeks", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");

        words = words.stream().filter(a -> a.startsWith("G")).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(words);
    }

    private static void listExamples() {
        List<Integer> basicList = new ArrayList<>();
        basicList.add(1);
        basicList.add(2);
        basicList.addAll(Arrays.asList(1, 2, 3, 4));
        Integer[] array = new Integer[] {55, 66, 77};
        basicList.addAll(Arrays.asList(array));
        System.out.println(basicList);

        List<String> fixedList = Arrays.asList("hey", "night", "yes");
        System.out.println(fixedList);

        //addAll
        List<String> someList = new ArrayList<>();
        someList.add("green");

        String[] simpleArray = {"blue", "red"};
        someList.addAll(Arrays.asList(simpleArray));
        System.out.println(someList);

        String[] strings = someList.stream().toArray(String[]::new);
        System.out.println(strings[0]);

        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }
    }

    private static void arraysExamples() {
        int[] basicArray = new int[] {1,2,3,4,5};
        basicArray[1] = 22;

        int[] basicFixedArray = new int[8];
        basicFixedArray[0] = 66;
        basicFixedArray[1] = 88;
        basicFixedArray[2] = 99;

        String[] strArray = {"hey", "bye", "yes"};
        strArray[0] = "hello";

        Integer[] intArray = {33, 234, 567};

        try {
            intArray[3] = 888;
        } catch (Exception ex) {
            //outOfIndex exception
            System.out.println(ex);
        }

        //multidimensional array
        int[][] twoDimArray = {{1,2,3},{4,5,6},{8,9,6}};
    }
}
