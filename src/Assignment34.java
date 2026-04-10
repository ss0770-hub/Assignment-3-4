import java.util.Arrays;

public class Assignment34 {

    // ---------- RESULT HOLDER ----------
    static class Result {
        int firstIndex = -1;
        int lastIndex = -1;
        int foundIndex = -1;
        int comparisons = 0;
        int count = 0;
    }

    // ---------- LINEAR SEARCH ----------
    public static Result linearSearch(String[] logs, String target) {
        Result res = new Result();

        for (int i = 0; i < logs.length; i++) {
            res.comparisons++;

            if (logs[i].equals(target)) {
                if (res.firstIndex == -1) {
                    res.firstIndex = i;
                }
                res.lastIndex = i;
            }
        }
        return res;
    }

    // ---------- BINARY SEARCH + DUPLICATES ----------
    public static Result binarySearch(String[] logs, String target) {
        Result res = new Result();

        int low = 0, high = logs.length - 1;

        // Step 1: standard binary search (find one occurrence)
        while (low <= high) {
            int mid = (low + high) / 2;
            res.comparisons++;

            int cmp = logs[mid].compareTo(target);

            if (cmp == 0) {
                res.foundIndex = mid;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (res.foundIndex == -1) return res;

        // Step 2: find first occurrence (left scan)
        int i = res.foundIndex;
        while (i >= 0 && logs[i].equals(target)) {
            res.comparisons++;
            i--;
        }
        res.firstIndex = i + 1;

        // Step 3: find last occurrence (right scan)
        i = res.foundIndex;
        while (i < logs.length && logs[i].equals(target)) {
            res.comparisons++;
            i++;
        }
        res.lastIndex = i - 1;

        res.count = res.lastIndex - res.firstIndex + 1;

        return res;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        String target = "accB";

        // ---- Linear Search ----
        Result linear = linearSearch(logs, target);
        System.out.println("LINEAR SEARCH:");
        System.out.println("First Index: " + linear.firstIndex);
        System.out.println("Last Index: " + linear.lastIndex);
        System.out.println("Comparisons: " + linear.comparisons);
        System.out.println();

        // ---- Binary Search (requires sorted input) ----
        Arrays.sort(logs);

        Result binary = binarySearch(logs, target);
        System.out.println("BINARY SEARCH:");
        System.out.println("First Index: " + binary.firstIndex);
        System.out.println("Last Index: " + binary.lastIndex);
        System.out.println("Count: " + binary.count);
        System.out.println("Comparisons: " + binary.comparisons);
    }
}