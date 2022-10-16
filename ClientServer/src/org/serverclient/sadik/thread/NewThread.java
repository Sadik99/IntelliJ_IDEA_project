package org.serverclient.sadik.thread;
/*
 * author: Sadik Hassan
 * created: 1:19 pm, 11/10/2022
 */

public class NewThread implements Runnable{
    Thread thread;
    int number;
    NewThread(int number){
        thread=new Thread(this,"Runnable Thread");
        this.number=number;
        thread.start();
    }
    @Override
    public void run() {
        for (int i=15;i>0;i--){
            System.out.println(number +"-Child Thread: "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Child Thread Interrupted!");
            }
        }
        System.out.println("Exiting Child Thread...");
    }
}
