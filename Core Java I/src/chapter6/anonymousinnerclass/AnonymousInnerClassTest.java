package chapter6.anonymousinnerclass;

import java.awt.*;
import java.awt.event.*;
import java.time.*;

import javax.swing.*;

/**
 * This program demonstrates anonymous inner classes.
 * @version 1.12 2017-12-14
 * @author Cay Horstmann
 */
public class AnonymousInnerClassTest
{
   public static void main(String[] args)
   {
      TalkingClock clock = new TalkingClock();
      clock.start(1000, true);

      // keep program running until the user selects "OK"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock
{
   /**
    * Starts the clock.
    * @param interval the interval between messages (in milliseconds)
    * @param beep true if the clock should beep
    */
   public void start(int interval, boolean beep)
   {
      //匿名内部类
      ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
               if (beep) {
                  Toolkit.getDefaultToolkit().beep();
               }
            }
       };
      Timer timer = new Timer(interval, listener);
      timer.start();
   }
}
