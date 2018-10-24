package WashingMachines;

public abstract class WashingMachine {
	
	private int						washingProgram;
	private final int				minWashingProgram	= 1;
	protected int					maxWashingProgram	= 20;
	private double					washingTemp;
	private final double			minWashingTemp		= 0;
	private double					maxWashingTemp		= 90;
	private int						washingSpeed;
	private final int				minWashingSpeed		= 0;
	private int						maxWashingSpeed		= 1000;
	protected MakersWashingMachines	makersWashingMachines;
	protected double				changeTemp			= 0.5;
	
	public WashingMachine(MakersWashingMachines makersWashingMachines) {
		this.makersWashingMachines = makersWashingMachines;
		this.washingProgram = minWashingProgram;
		this.washingTemp = minWashingTemp;
		this.washingSpeed = minWashingSpeed;
	}
	
	public void setWashingTemp(double washingTemp) throws TemperatureException {
		if (washingTemp >= minWashingTemp && washingTemp <= maxWashingTemp) {
			this.washingTemp = Math.round(washingTemp * 2) / 2.0;
		} else {
			throw new TemperatureException("Chose a temperature from " + minWashingTemp + " to " + maxWashingTemp + "\u00b0" + "C");
		}
	}
	
	public double getWashingTemp() {
		return washingTemp;
	}
	
	public void setWashingSpeed(int washingSpeed) {
		if (washingSpeed >= minWashingSpeed && washingSpeed <= maxWashingSpeed) {
			this.washingSpeed = Math.round(washingSpeed) / 100 * 100;
		} else if (washingSpeed < minWashingSpeed) {
			this.washingSpeed = maxWashingSpeed;
		} else {
			this.washingSpeed = minWashingSpeed;
		}
	}
	
	public int getWashingSpeed() {
		return washingSpeed;
	}
	
	public MakersWashingMachines getMakerWashingMachine() {
		return makersWashingMachines;
	}
	
	public void setMakersWashingMachines(MakersWashingMachines makersWashingMachines) {
		this.makersWashingMachines = makersWashingMachines;
	}
	
	public double getChangeTemp() {
		return changeTemp;
	}
	
	public void setChangeTemp(double changeTemp) {
		this.changeTemp = changeTemp;
	}
	
	public int getMaxWashingProgram() {
		return maxWashingProgram;
	}
	
	public void setMaxWashingProgram(int maxWashingProgram) {
		this.maxWashingProgram = maxWashingProgram;
	}
	
	public int getWashingProgram() {
		return washingProgram;
	}
	
	public void setWashingProgram(int washingProgram) {
		if (washingProgram >= minWashingProgram &&
				washingProgram <= maxWashingProgram) {
			this.washingProgram = washingProgram;
		} else if (washingProgram < minWashingProgram) {
			this.washingProgram = maxWashingProgram;
		} else
			this.washingProgram = minWashingProgram;
	}
	
	public void nextWashingProgram() {
		setWashingProgram(washingProgram + 1);
	}
	
	public void previusWashingProgram() {
		setWashingProgram(washingProgram - 1);
	}
	
	public void washingTempUp() throws TemperatureException {
		setWashingTemp(washingTemp + changeTemp);
	}
	
	public void washingTempDown() throws TemperatureException {
		setWashingTemp(washingTemp - changeTemp);
	}
	
	public void washingSpeedUp() {
		setWashingSpeed(washingSpeed + 100);
	}
	
	public void washingSpeedDown() {
		setWashingSpeed(washingSpeed - 100);
	}
	
	public String showStatus() {
		return "Selected parameters for the washing machine: " + getMakerWashingMachine() + "\n" +
				" a) program: " + getWashingProgram() + "\n" +
				" b) temperature: " + getWashingTemp() + "\u00b0" + "C" + "\n" +
				" c) speed: " + getWashingSpeed();
	}
}
