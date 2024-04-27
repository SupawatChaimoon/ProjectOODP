package Plan;
import java.util.ArrayList;
public class WeightLossPlan implements WorkoutPlan {

    private ArrayList<String> workoutPlans; // Use ArrayList directly without fully qualified name
    
    // Constructor to initialize workoutPlans and add sample plans
    public WeightLossPlan() {
        workoutPlans = new ArrayList<>(); // Initialize as an ArrayList of Strings
        
        // Adding sample workout plans
        
        workoutPlans.add("Day 1: Cardio (e.g., 30 minutes brisk walk)");
        workoutPlans.add("Day 1: Cardio (e.g., 30 minutes jogging)\nDay 2: Cardio (e.g., 30 minutes cycling)");
        workoutPlans.add("Day 1: Cardio (e.g., 30 minutes running)\nDay 2: Cardio (e.g., 30 minutes cycling)\nDay 3: Weight training (e.g., bodyweight exercises)\nRecommendation: Include protein-rich diet.");
        workoutPlans.add("Day 1: Cardio (e.g., 30 minutes running)\nDay 2: Cardio (e.g., 30 minutes cycling)\nDay 3: Weight training (e.g., bodyweight exercises)\nDay 4: Cardio (e.g., 30 minutes brisk walk)");
        workoutPlans.add("Day 1: Cardio (e.g., 30 minutes running)\nDay 2: Cardio (e.g., 30 minutes cycling)\nDay 3: Weight training (e.g., bodyweight exercises)\nDay 4: Cardio (e.g., 30 minutes brisk walk)\nDay 5: Cardio (e.g., 30 minutes swimming)");
        workoutPlans.add("Day 1: Cardio (e.g., 30 minutes running)\nDay 2: Cardio (e.g., 30 minutes cycling)\nDay 3: Weight training (e.g., bodyweight exercises)\nDay 4: Cardio (e.g., 30 minutes brisk walk)\nDay 5: Cardio (e.g., 30 minutes swimming)\nDay 6: Cardio (e.g., 30 minutes jumping rope)");
        workoutPlans.add("Day 1: Cardio (e.g., 30 minutes running)\nDay 2: Cardio (e.g., 30 minutes cycling)\nDay 3: Weight training (e.g., bodyweight exercises)\nDay 4: Cardio (e.g., 30 minutes brisk walk)\nDay 5: Cardio (e.g., 30 minutes swimming)\nDay 6: Cardio (e.g., 30 minutes jumping rope)\nDay 7: rest");

    }

    @Override
    public void displayPlan() {
        System.out.println("Weight loss workout plan");
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