// This class is for all our configuration data. By putting it all in one place, we can easily make changes to the program without having to hunt down where in the code a constant is defined.
// Use the defined constant to load the workouts file.

public class Config {
	
  public enum Muscle {ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE} // Why didn't I have to declare this static?
  public enum Equipment {BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH}
  
  public final static String APPLICATIONNAME = "JavaFit: Muscles for Computer Scientists!";
  public final static String WORKOUTFILE = "workouts.csv";
  public final static String WORKOUTFORMATFILE = "workoutformats.csv";
  public enum MuscleGroup {UPPERBODY, LOWERBODY, WHOLEBODY}
}
