package DataStructure.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumPlatformsRequired {

//0900,0940,0950,1100,1500,1800
//0910,1200,2000,1130,1900,2000
//[ 1, 3,    5,   3,   2,   2]

//arrival of train  0900,0940,0950,1100,1500,1800,1900
//departure of train  0910,1200,2001,1930,2002,2003,2004
//[1    3   5     6     5   5      5]

    // Function to find the minimum number
    // of platforms required
    public static int countPlatforms(int[] arr, int[] dep) {
        TrainSchedule[] trains = new TrainSchedule[arr.length];
        // Store the arrival and departure time
        for(int i=0; i<arr.length; i++) {
            trains[i] = new TrainSchedule(arr[i], dep[i]);
        }
        // Sort trains based on arrival time
        Arrays.sort(trains, new SortByArrival());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(trains[0].deptTime);
        int count = 1;
        for(int i=1; i<arr.length; i++) {
            TrainSchedule curr = trains[i];
            // Check if arrival time of current train
            // is less than or equals to departure time
            // of previous train
            if(curr.arrivalTime <= pq.peek()) {
                count++;
            } else {
                pq.poll();
            }
            pq.add(curr.deptTime);
        }
        // return the count of numner of platforms required
        return count;
    }

    public int findPlatform(int arr[], int dep[])
    {
        int n = arr.length;
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }

            // Else decrement count of platforms needed
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            // Update result if needed
            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }

    public int solution(int[] arr, int[] dep) {
        int result[] = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j < arr.length && arr[j] <= dep[i - 1]) {
                result[i]++;
                j += 1;
            }
            if (j > i)
                i = j - 1;
        }

        Arrays.sort(result);

        return result[result.length-1]+1;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String arrival = myObj.nextLine();
        String departure = myObj.nextLine();

        int[] arrivalArr = Arrays.stream(arrival.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] departureArr = Arrays.stream(departure.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int ans = new MinimumPlatformsRequired().findPlatform(arrivalArr, departureArr);
        System.out.print(ans);
    }

    private static class TrainSchedule {
        int arrivalTime, deptTime;
        TrainSchedule(int arrivalTime, int deptTime) {
            this.arrivalTime = arrivalTime;
            this.deptTime = deptTime;
        }
        public String toString() {
            return "(" + this.arrivalTime + "," + this.deptTime + ")";
        }
    }

    private static class SortByArrival implements Comparator<TrainSchedule> {
        @Override
        public int compare(TrainSchedule o1, TrainSchedule o2) {
            return o1.arrivalTime - o2.arrivalTime;
        }
    }
}

