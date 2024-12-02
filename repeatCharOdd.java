public class repeatCharOdd {
    //String res = solution(14);

    public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String solution(int N) {
        if (N <= 0 && N > 200000) {
            return "not mapped input";
        }

        if (N == 1) {
            return Character.toString(getCharacterFromAlphabet(1));
        }

        int count = 1;
        String result = Character.toString(getCharacterFromAlphabet(count));

        if (!isOdd(N)) {
            result = result.repeat(N-1);
            count++;
            result = result + getCharacterFromAlphabet(count);
        } else {
            result = result.repeat(N);
        }

        return result;
    }

    private static char getCharacterFromAlphabet(int count) {
        return alphabet[alphabet.length - count];
    }

    public static boolean isOdd(int N) {
        return (N & 1) == 0 ? false : true;
    }
}
