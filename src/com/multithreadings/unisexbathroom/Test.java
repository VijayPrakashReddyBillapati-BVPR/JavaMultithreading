package com.multithreadings.unisexbathroom;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static IUnisexBathroom unisexBathroom;
	public static void runTest() throws InterruptedException {

        Thread female1 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread female2 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa-2");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread female3 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa-3");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread female4 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa-4");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread female5 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa-5");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread female6 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa-6");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male1 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("John");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male2 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Bob");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male3 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Anil");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male4 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Wentao");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread male5 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Wentao-2");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread male6 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Wentao-3");
                } catch (InterruptedException ie) {

                }
            }
        });
        Set<Thread> list = new HashSet<Thread>();
        for(int i=7; i<15; i++)
        {
        	final int val = i; 
        	Thread male = new Thread(new Runnable() {
                public void run() {
                    try {
                        unisexBathroom.maleUseBathroom("Wentao-"+val);
                    } catch (InterruptedException ie) {

                    }
                }
            });
        	male.setName("male"+i);
        	list.add(male);
        }
        for(Thread th: list)
        	th.start();
        
        female1.start();
        female2.start();
        female3.start();
        female4.start();
        female5.start();
        female6.start();
        male1.start();
        male2.start();
        male3.start();
        male4.start();
        male5.start();
        male6.start();

        female1.join();
        female2.join();
        female3.join();
        female4.join();
        female5.join();
        female6.join();
        male1.join();
        male2.join();
        male3.join();
        male4.join();
        male5.join();
        male6.join();
        
        for(Thread th: list)
        	th.join();

    }
}
