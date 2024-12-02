import java.util.HashSet;
import java.util.Random;

public class UniqueValue<T> {
    private HashSet<T> set;
    private Random random;

    // Constructor
    public UniqueValue() {
        set = new HashSet<>();
        random = new Random();
    }

    public boolean insert(T value) {
        return set.add(value);
    }

    public boolean remove(T value) {
        return set.remove(value);
    }

    public T getRandomValue() {
        if (set.isEmpty()) {
            return null;
        }

        // Convert set to array to enable random access
        T[] values = (T[]) set.toArray();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }
}