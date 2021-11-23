package it.unisa.diem.softwareengineering.assignment2021;

public class NotEnoughOperationsException extends Exception{
    String message;


    public NotEnoughOperationsException() {
		super();
	}

	public NotEnoughOperationsException(String message, Throwable cause) {
		super(message, cause);
        this.message = message;
	}

	public NotEnoughOperationsException(String message) {
		super(message);
        this.message = message;
	}

}
