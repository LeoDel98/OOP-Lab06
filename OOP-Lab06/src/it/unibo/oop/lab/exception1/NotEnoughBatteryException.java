package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	private final double batteryRequired;
	
	public NotEnoughBatteryException(final double btLev, final double btReq) {
		super();
		this.batteryLevel = btLev;
		this.batteryRequired = btReq;
	}

	@Override
	public String toString() {
		return "Can not move. Battery level is " + batteryLevel + " and battery required is " + batteryRequired;
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}

}
