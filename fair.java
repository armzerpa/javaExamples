import java.util.Arrays;
import java.util.stream.Collectors;

public class fair {

    //         int res = solution2(new int[] {0, 4, -1, 0, 3}, new int[] {0, -2, 5, 0, 3});

    public static int solution(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0 || A.length != B.length) {
            return 0;
        }
        if (!haveAtLeastOneFair(A, B)) {
            return 0;
        }

        int medium = calculateMediumValue(A);
        int k = 0;
        int sumA = A[0];
        int sumB = B[0];

        for (int i = 1; i < A.length - 1; i++) {
            sumA += A[i];
            sumB += B[i];
            System.out.println("sumA " + sumA);
            System.out.println("sumB " + sumB);

            if (sumA == medium && sumA == sumB) {
                int resSlice = A[i+1];
                System.out.println("--i: " + i + " len: " + A.length);
                if (i + 2 <= A.length) {
                    int[] slice = Arrays.copyOfRange(A, i + 1, A.length);
                    System.out.println("i: " + i + " len: " + A.length + " slice: " +slice.length);
                    resSlice = sumSubArray(slice);
                    System.out.println("resSlice " + resSlice);
                }
                if (sumA == resSlice) {
                    System.out.println("FAIR");
                    k++;
                }
            }

        }

        return k;
    }

    private static int sumSubArray(int[] sub) {
        return Arrays.stream(sub)
                .boxed()
                .collect(Collectors.toList()).stream().reduce(0, (a, b) -> a + b);
    }

    private static int calculateMediumValue(int[] arr) {
        int result = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList()).stream().reduce(0, (a, b) -> a + b);

        return result / 2;
    }

    private static boolean haveAtLeastOneFair (int[] A, int[] B) {
        int result1 = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toList()).stream().reduce(0, (a, b) -> a + b);
        int result2 = Arrays.stream(B)
                .boxed()
                .collect(Collectors.toList()).stream().reduce(0, (a, b) -> a + b);

        return result1 == result2 && isEven(result1);
    }

    public static boolean isEven(int N) {
        return (N & 1) == 0 ? true : false;
    }
}
