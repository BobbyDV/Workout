// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Scanner;
import java.util.Set;

import java.io.FileNotFoundException;

public class FileAccess {
  
  public static Workouts loadWorkouts() {
    // What is a try/catch block and why do we need one?
  	// Answer: A try/catch block tries a block of code and if there is an error, throws the exception(error)
  	// and the catch block catches the exception and prints out an error message
    // What is an exception?
  	// An exception is an error
  	
  	Workouts workout = new Workouts();
  	File workoutFile = new File(Config.WORKOUTFILE);
  	try 
  	{
  		Scanner sc = new Scanner(workoutFile);
  		if(workoutFile.exists())
  		{
	  		while(sc.hasNextLine())
	  		{
	  			String[] line = sc.nextLine().split(",");
	  			String name = line[0];
	  			String equipment = line[1];
	  			String primaryMuscle = line[2];
	  			String secondaryMuscle = line[3];
	  			String desc = line[4];
	  			String reminders = line[5];
	  			
	  			workout.addWorkout(name, Config.Equipment.valueOf(equipment), Config.Muscle.valueOf(primaryMuscle), 
	  													Config.Muscle.valueOf(secondaryMuscle), desc, reminders);
	  		}
	  		
	  		sc.close();
  		}
  	}
  	
  	catch(FileNotFoundException e)
  	{
  		e.printStackTrace();
  	}
  	
  	return workout;
  }

  public static EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> loadFormats() 
  {
  	EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> retval  = new EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>>(Config.MuscleGroup.class);
  	ArrayList<Config.Muscle> muscles;
  	
  	File workoutFormatFile = new File(Config.WORKOUTFORMATFILE);
  	try 
  	{
			Scanner sc = new Scanner(workoutFormatFile);
			
			if(workoutFormatFile.exists())
			{
				while(sc.hasNextLine())
				{
					muscles = new ArrayList<Config.Muscle>();
					int i = 1;
					String[] line = sc.nextLine().split(",");
					while(i < line.length)
					{
						
						muscles.add(Config.Muscle.valueOf(line[i]));
						i++;
					}
					retval.put(Config.MuscleGroup.valueOf(line[0]), muscles);
				}
			}
			
			sc.close();
  	}
	  
	  catch(FileNotFoundException e) 
  	{
			e.printStackTrace();
		}
  	
  	return retval;
  }

}