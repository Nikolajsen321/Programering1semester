package Opgave3;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	private ArrayList<Swimmer> swimmers = new ArrayList<>();


	public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
	}

	public ArrayList<Swimmer> getSwimmer(){
		return new ArrayList<>(swimmers);
	}
	public void addSwimmer(Swimmer swimmer){
		if(!swimmers.contains(swimmer)){
			swimmers.add(swimmer);
			swimmer.setTrainingPlan(this);
		}
	}
	public void removeSwimmer(Swimmer swimmer){
		if(swimmers.contains(swimmer)){
			swimmers.remove(swimmer);
			swimmer.setTrainingPlan(null);
		}
	}


	public char getLevel() {
		return level;
	}
	
	public void setLevel(char niveau) {
		this.level = niveau;
	}
	
	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}
	
	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}
	
	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}


	@Override
	public String toString() {
		return "TrainingPlan{" +
				"level=" + level +
				", weeklyWaterHours=" + weeklyWaterHours +
				", weeklyStrengthHours=" + weeklyStrengthHours + '}';
	}
}
