import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Marathon {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamil", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate" };

        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265 };

        // int First = Fastest_Runner(times); // For fastest runner
        // int second = Second_Fastest_Runner(times, First); // For second-fastest
        // runner

        // Create a custom Comparator to sort based on times
        Comparator<Integer> timeComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer time1, Integer time2) {
                return time1 - time2;
            }
        };

        // Sort the names and times arrays based on the timeComparator
        Integer[] sortedTimes = Arrays.stream(times).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedTimes, timeComparator);

        // Create a map to associate times with names
        Map<Integer, String> nameByTime = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            nameByTime.put(times[i], names[i]);
        }

        // Print the sorted positions
        System.out.println("Position\tName\t\tTime(minutes)");
        for (int i = 0; i < sortedTimes.length; i++) {
            int time = sortedTimes[i];
            String name = nameByTime.get(time);
            System.out.println((i + 1) + ")\t\t" + name + "\t\t" + time + "min");
        }
    }

    /*
     Function for Fastest runner
     public static int Fastest_Runner(int[] times) {
     int First = 0;
     int fastestTime = times[0];
     for (int i = 1; i < times.length; i++) {
     if (times[i] < fastestTime) {
     fastestTime = times[i];
     First = i; // return index
     }
     }
     return First;
      }
      
      // Function for Second Fastest runner
      public static int Second_Fastest_Runner(int[] times, int First) {
      int second = 0;
      int secondFastestTime = times[0];
      for (int i = 0; i < times.length; i++) {
      if (i != First && times[i] < secondFastestTime) {
      secondFastestTime = times[i];
      second = i;
      }
      }
      return second;
     }
     */
}