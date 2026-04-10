import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore + " (Bal:" + accountBalance + ")";
    }
}

public class Assignment34 {

    // 🔵 Bubble Sort (Ascending by riskScore)
    public static void bubbleSortAscending(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        System.out.println("🔄 Bubble Sort Swaps:");

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;

                    // visualize swap
                    System.out.println("Swap: " + arr[j].name + " ↔ " + arr[j + 1].name);
                }
            }

            if (!swapped) break; // optimization
        }

        System.out.println("Total Swaps: " + swaps);
    }

    // 🟢 Insertion Sort (Descending by riskScore, tie → higher balance first)
    public static void insertionSortDescending(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && (
                    arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance)
            )) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort completed.");
    }

    // 🔴 Top 10 highest risk clients
    public static void printTopRiskClients(Client[] arr, int k) {
        System.out.println("\n🚨 Top " + k + " High-Risk Clients:");
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.println(arr[i].name + " (" + arr[i].riskScore + ")");
        }
    }

    // 🧪 Main
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        // 🔵 Bubble Sort (Ascending)
        bubbleSortAscending(clients);

        System.out.println("\nAfter Bubble Sort (Ascending):");
        for (Client c : clients) {
            System.out.println(c);
        }

        // 🟢 Insertion Sort (Descending)
        insertionSortDescending(clients);

        System.out.println("\nAfter Insertion Sort (Descending):");
        for (Client c : clients) {
            System.out.println(c);
        }

        // 🔴 Top Risk Clients
        printTopRiskClients(clients, 10);
    }
}