public class BostonMarathon {
    public static void main(String[] args) {
        // Create arrays for names and times
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"
        };
        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265
        };
        
        // Find the fastest runner
        int FirstFastestTime = Integer.MAX_VALUE;
        int SecondFastestTime = Integer.MAX_VALUE;
        String FirstFastestRunner = "";
        String SecondFastestRunner = "";
        for (int i = 0; i < names.length; i++) 
        {
            if (times[i] < FirstFastestTime) 
            {
                FirstFastestTime = times[i];
                FirstFastestRunner = names[i];
            }
         else if (times[i] < SecondFastestTime && times[i] != FirstFastestTime)
          {
            SecondFastestTime = times[i];
            SecondFastestRunner = names[i];
        }
          
        }
          
        // Print the name and time of the First fastest runner
        System.out.println("The fastest runner is " + FirstFastestRunner + " with a time of " + FirstFastestTime + " minutes.");
        // Print the name and time of the Second fastest runner
        System.out.println("The Second fastest runner is " + SecondFastestRunner + " with a time of " + SecondFastestTime + " minutes.");
    }
}
