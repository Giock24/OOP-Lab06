package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalStateException{

	private static final long serialVersionUID = 1L;
	private int usrID;
	
	/**
	 * Construct new istance of the exception.
	 * 
	 * @param usrID
	 *			when usrID is different cause an exception
	 */
	public WrongAccountHolderException (final int usrID) {
		super();
		this.usrID = usrID;
	}
	
	/**
     * @return the string representation of instances of this class
     */
	@Override
	public String toString() {
		return "" + this.usrID + " you are not allowed to enter in this Account BI**H!";
	}
	
	@Override
    public String getMessage() {
        return this.toString();
    }	
}
