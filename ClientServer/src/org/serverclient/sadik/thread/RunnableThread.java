package org.serverclient.sadik.thread;
/*
 * author: Sadik Hassan
 * created: 1:05 pm, 11/10/2022
 */

public class RunnableThread {
    public static void main(String[] args) {
        NewThread newThread=new NewThread(1);
        NewThread newThread2=new NewThread(2);
        System.out.println("Thread 1 is alive : "+newThread.thread.isAlive());
        try {
            newThread.thread.join();
            newThread2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
