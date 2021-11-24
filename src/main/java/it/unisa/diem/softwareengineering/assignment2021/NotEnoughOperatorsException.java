package it.unisa.diem.softwareengineering.assignment2021;

public class NotEnoughOperatorsException extends Exception{
    String message;


    public NotEnoughOperatorsException() {
		super();
	}

	public NotEnoughOperatorsException(String message, Throwable cause) {
		super(message, cause);
        this.message = message;
	}

	public NotEnoughOperatorsException(String message) {
		super(message);
        this.message = message;
	}

}
