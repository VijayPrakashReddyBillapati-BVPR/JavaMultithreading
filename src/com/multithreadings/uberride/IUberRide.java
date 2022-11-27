package com.multithreadings.uberride;

import java.util.concurrent.BrokenBarrierException;

public interface IUberRide {

	void seatDemocrat() throws InterruptedException, BrokenBarrierException;
    void seatRepublican() throws InterruptedException, BrokenBarrierException;
    void seated();
    void drive();
}
