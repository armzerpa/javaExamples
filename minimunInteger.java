import java.util.*;
import java.util.stream.Collectors;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> arr = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toList());

        Boolean anyPositive = arr.stream().anyMatch(i -> i > 0);
        if (!anyPositive) {
            return 1;
        }

        arr = arr.stream().sorted().collect(Collectors.toList());;
        int diff = 0;
        for (int i = 0; i<arr.size()-1; i++){
            diff = arr.get(i+1) - arr.get(i);
            if (diff > 1) {
                return arr.get(i) + 1;
            }
        }

        return arr.get(arr.size()-1) + 1;
    }
}

