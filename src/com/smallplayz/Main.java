package com.smallplayz;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class Main {

    static int wait, time, delay; //creates variables

    public static void main(String[] args) throws AWTException {
        getInfo(); // uses scanner to get info to fill in variables
        run(); // runs the autoclicker
    }
    public static void mouseClick() throws AWTException{ // clicks using robot class
        Robot bot = new Robot();
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public static void wait(int x){ //sleeps for 'x' amount of ms
        try {
            Thread.sleep(x);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static void getInfo(){ // fills in variables using scanner
        Scanner reader = new Scanner(System.in);
        System.out.print("(Time before starts clicking[ms]) wait: ");
        wait = reader.nextInt(); // delay before autoclicker runs
        System.out.print("(How long it will click for[ms]) Time: ");
        time = reader.nextInt(); // how long the autoclicker will run for
        System.out.print("(Delay between clicks[ms]) Delay: ");
        delay = reader.nextInt(); // the delay in ms between each click
    }
    public static void run() throws AWTException { // the run method
        wait(wait);
        for(int i = 0; i<time; i++){
            wait(delay);
            mouseClick();
        }
    }
}
