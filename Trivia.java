import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Trivia {
  
  public static int Draw;
  
  public static void main (String[] args){
    
    Draw windowQuiz = new Draw("The Quiz Show Window");
    Draw windowAnnouncer = new Draw("The Announcer Window");
    Draw windowInteractive = new Draw("Your Interactive Window!");

    windowAnnouncerMethod(windowAnnouncer);
    windowQuizMethod(windowQuiz);
    windowInteractiveMethod(windowInteractive);
    
  }
  
  public static void windowAnnouncerMethod(Draw wAnnouncer) {
    wAnnouncer.setCanvasSize(384,512);
    wAnnouncer.picture(0.5, 0.5, "BackgroundsGreen.png");
  }
  
  public static void windowQuizMethod(Draw wQuiz){

    wQuiz.setCanvasSize(768,512);
    // System.out.println("fun stuff");
  }

  
  public static void windowInteractiveMethod(Draw wInteractive){
    wInteractive.setCanvasSize(768,256);
    System.out.println("test");
  }
}