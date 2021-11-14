package it.unibo.oop.lab.exception1;


public class NotEnoughBatteryException extends IllegalStateException{

	private static final long serialVersionUID = 1L;
	private double batteryLevel;
	
	/**
	 * Construct new istance of the exception.
	 * 
	 * @param batteryLevel
	 *			when batteryLevel is equal 0 cause an exception
	 */
	public NotEnoughBatteryException(final double batteryLevel) {
		super();
		this.batteryLevel = batteryLevel;
	}
	
	/**
     * @return the string representation of instances of this class
     */
	@Override
	public String toString() {
		return "The Battery Level is low!! (" + this.batteryLevel + " %)";
	}
	
	@Override
    public String getMessage() {
        return this.toString();
    }
}
