package com.eprogrammerz.examples.exception;

public class ResourceException extends Exception {

	private static final long serialVersionUID = -8926637401097864935L;

	public ResourceException(String message)
	{
		super(message);
	}
	public ResourceException(Throwable error)
	{
		super(error);
	}

}
