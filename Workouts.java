import java.util.ArrayList; // We choose ArrayList over Vector because...? 
import java.util.stream.Collectors;

/**
 * Use the provided enumerations and code framework to create our workouts
 * class. This class should contain all the functionality we need to interact
 * with our workout list. Minimize duplication of code by writing helper
 * functions as needed.
 * 
 * Do not change any of the provided code, although you can, and should, add to
 * it as needed. (E.G. Do not make private attributes public, or change the
 * parameters of a function.)
 */

public class Workouts {

	// Use the Refactor functionality in Eclipse to rename "Muscle" to "Muscle" to
	// match our naming convention.
	private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

	// This function adds a new workout to the Workouts object.
	public final void addWorkout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle,
			Config.Muscle secondaryMuscle, String desc, String reminders) {
		workoutList.add(new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders));
	}

	// This function adds a workout to the Workouts object.
	public final void addWorkout(Workout workout) {
		workoutList.add(workout);
	}

	// This list returns a new Workouts object that contains only the workouts that
	// contain the
	// Equipment value that is provided as an argument. The programmer has an option
	// to get
	// Workouts that only have the Muscle in the PrimaryMuscle attribute, or to also
	// look
	// in the secondaryMuscle category.
	public final Workouts getWorkoutsByMuscle(Config.Muscle m, boolean includeSecondary) {
		Workouts newWorkoutList = new Workouts();
		// if the programmer wants to include secondary muscles in the search
		if (includeSecondary) {
			// for every workout in workoutList
			for (Workout i : workoutList) {
				if (i.getPrimaryMuscle() == m || i.getSecondaryMuscle() == m) {
					newWorkoutList.addWorkout(i);
				}
			}
		}

		// if the programmer does NOT want to search through secondary muscles
		else {
			for (Workout i : workoutList) {
				if (i.getPrimaryMuscle() == m || i.getSecondaryMuscle() == m) {
					newWorkoutList.addWorkout(i);
				}
			}
		}

		return newWorkoutList;
	}

	// This list returns a new Workouts object that contains only the workouts that
	// contain the
	// Equipment value that is provided as an argument.
	public final Workouts getWorkoutsByEquipment(Config.Equipment e) {
		Workouts newWorkoutList = new Workouts();

		// for every workout in workoutList
		for (Workout i : workoutList) {
			// if the equipment at workout i equals the equipment being searched for, add it
			// to the list
			if (i.getEquipment() == e) {
				newWorkoutList.addWorkout(i);
			}
		}

		return newWorkoutList;
	}

	// This returns a new Workouts object that contains only the workouts that
	// contain an Equipment
	// value that is in the provided ArrayList of Equipment.
	public final Workouts getWorkoutsByEquipment(ArrayList<Config.Equipment> e) {
		e = (ArrayList<Config.Equipment>) e.stream().distinct().collect(Collectors.toList());

		Workouts newWorkoutList = new Workouts();

		// for every Workout in workoutList
		for (Workout i : workoutList) {
			// and for every Equipment j in the Equipment list passed in
			for (Config.Equipment j : e) {
				if (i.getEquipment() == j) {
					newWorkoutList.addWorkout(i);
				}
			}
		}

		return newWorkoutList;
	}

	// This method returns an ArrayList of Strings. Each String is a name of a
	// workout in our Workouts list.
	public final ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();

		// for every workout in our workoutList
		for (Workout i : workoutList) {
			// get the name and add it to our ArrayList names
			names.add(i.getName());
		}

		return names;
	}

	// This method returns all the information of the Workouts as an ArrayList of
	// String arrays,
	// one entry in the ArrayList per Workout. The String array should contain the
	// workout's Name,
	// Equipment, Primary and Secondary Muscles, Description, and Reminders. All of
	// these should be strings.
	public final ArrayList<String[]> getFullInformation() {
		ArrayList<String[]> allInfo = new ArrayList<String[]>();

		for (Workout i : workoutList) {
			allInfo.add(new String[] { i.getName(), i.getEquipment().toString(), i.getPrimaryMuscle().toString(),
					i.getSecondaryMuscle().toString(), i.getDesc(), i.getReminders() });

		}

		return allInfo;
	}

	public final Workouts getWorkoutsByMuscle(ArrayList<Config.Muscle> m, boolean includeSecondary) {
		m = (ArrayList<Config.Muscle>) m.stream().distinct().collect(Collectors.toList());

		Workouts newWorkoutList = new Workouts();

		// for every workout in workoutList
		for (Workout i : workoutList) {
			// for every muscle in the ArrayList passed in
			for (Config.Muscle j : m) {
				// if the user wants to include secondary muscles
				if (includeSecondary == true) {
					// if the primary muscle or secondary muscle is equal to the muscle being looked
					// at
					if (i.getPrimaryMuscle() == j || i.getSecondaryMuscle() == j) {
						// add that workout to the list
						newWorkoutList.addWorkout(i);
					}
				}

				// if the user does not want secondary muscles included
				else {
					// if the workout muscle is equal to the muscle in the ArrayList
					if (i.getPrimaryMuscle() == j) {
						// add that workout to our new list
						newWorkoutList.addWorkout(i);
					}
				}
			}
		}

		return newWorkoutList;
	}

	// returns all the Equipment in the list
	public final ArrayList<String> getEquipment() {
		ArrayList<String> allEquipment = new ArrayList<String>();

		// for every workout in the workoutList
		for (Workout i : workoutList) {
			allEquipment.add(String.valueOf(i.getEquipment()));
		}

		allEquipment = (ArrayList<String>) allEquipment.stream().distinct().collect(Collectors.toList());

		return allEquipment;
	}

	// returns the size of the workoutList
	public final int size() {
		int SIZE = workoutList.size();

		return SIZE;
	}

	// returns the workout at the given index
	public final Workout getWorkout(int index) {
		return workoutList.get(index);
	}

	// returns the equipment of the workout at the given index
	public final String getWorkoutEquipment(int index) {
		String workoutEquipment;

		workoutEquipment = String.valueOf(workoutList.get(index).getEquipment());

		return workoutEquipment;
	}

	// find a workout by the name passed in
	public final int findWorkoutByName(String name) {
		int index = 0;

		for (Workout i : workoutList) {
			index++;
			if (i.getName() == name) {
				break;
			}
		}

		return index;
	}
}
