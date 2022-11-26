package com.multithreadings.unisexbathroom;

public interface IUnisexBathroom {

	public void maleUseBathroom(String name) throws InterruptedException;
	public void femaleUseBathroom(String name) throws InterruptedException;
}
