package org.serverclient.sadik.thread;
/*
 * author: Sadik Hassan
 * created: 12:56 pm, 11/10/2022
 */

public class MainThread {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Current Thread: " + thread);
        thread.setName("Sad Thread");
        System.out.println("After Change: "+thread);
        for (int i=15;i>0;i--){
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main Thread Interrupted!");
            }
        }
    }
}
