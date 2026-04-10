public class Assignment34 {

    static class Result {
        int linearComparisons = 0;
        int binaryComparisons = 0;
        Integer floor = null;
        Integer ceiling = null;
    }

    // ---------- LINEAR SEARCH ----------
    public static Result linearSearch(int[] risks, int target, Result res) {
        for (int i = 0; i < risks.length; i++) {
            res.linearComparisons++;

            if (risks[i] == target) {
                return res; // exact match found
            }
        }
        return res; // not found
    }

    // ---------- BINARY SEARCH FOR FLOOR & CEILING ----------
    public static Result binaryFloorCeiling(int[] risks, int target, Result res) {

        int low = 0, high = risks.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            res.binaryComparisons++;

            if (risks[mid] == target) {
                res.floor = risks[mid];
                res.ceiling = risks[mid];
                return res;
            }

            if (risks[mid] < target) {
                res.floor = risks[mid]; // best so far <= target
                low = mid + 1;
            } else {
                res.ceiling = risks[mid]; // best so far >= target
                high = mid - 1;
            }
        }

        return res;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};
        int target = 30;

        Result res = new Result();

        // Linear Search
        linearSearch(risks, target, res);

        System.out.println("LINEAR SEARCH:");
        System.out.println("Target: " + target);
        System.out.println("Comparisons: " + res.linearComparisons);
        System.out.println("Result: NOT FOUND");
        System.out.println();

        // Binary Search (Floor & Ceiling)
        binaryFloorCeiling(risks, target, res);

        System.out.println("BINARY SEARCH (FLOOR & CEILING):");
        System.out.println("Floor (<= target): " + res.floor);
        System.out.println("Ceiling (>= target): " + res.ceiling);
        System.out.println("Comparisons: " + res.binaryComparisons);
    }
}