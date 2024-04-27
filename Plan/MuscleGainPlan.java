package Plan;
 import java.util.ArrayList;
public class MuscleGainPlan implements WorkoutPlan {

        private ArrayList<String> workoutPlans; // Use ArrayList directly without fully qualified name
    
        // Constructor to initialize workoutPlans and add sample plans
        public MuscleGainPlan() {
            workoutPlans = new ArrayList<>(); // Initialize as an ArrayList of Strings
            
            // Adding sample workout plans
            workoutPlans.add("Day 1: Chest workout");
            workoutPlans.add("Day 1: Chest workout\nDay 2: Back workout");
            workoutPlans.add("Day 1: Chest workout\nDay 2: Back workout\nDay 3: Shoulders workout");
            workoutPlans.add("Day 1: Chest workout\nDay 2: Back workout\nDay 3: Shoulders workout\nDay 4: Arms workout");
            workoutPlans.add("Day 1: Chest workout\nDay 2: Back workout\nDay 3: Shoulders workout\nDay 4: Arms workout\nDay 5: Leg day");
            workoutPlans.add("Day 1: Chest workout\nDay 2: Back workout\nDay 3: Shoulders workout\nDay 4: Arms workout\nDay 5: Leg day\nDay 6: Abs workout");
            workoutPlans.add("Day 1: Chest workout\nDay 2: Back workout\nDay 3: Shoulders workout\nDay 4: Arms workout\nDay 5: Leg day\nDay 6: Abs workout\nDay 7: Rest");
        }
    
    @Override
    public void displayPlan() {
        System.out.println("Muscle gain workout plan");
    }  

    @Override
    public void displayPlan(int index) {
            if (index >= 0 && index < workoutPlans.size()) {
                System.out.println("Workout Plan for Choice " + (index) + ":");
                System.out.println(workoutPlans.get(index-1)); // Retrieve and print the workout plan
            } else {
                System.out.println("Invalid plan index. Please provide a valid index.");
            }
        }
}











