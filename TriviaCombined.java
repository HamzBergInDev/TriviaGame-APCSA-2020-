import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.File; 
import java.util.Random;
import java.io.FileNotFoundException;
  
class TriviaCombined {
    
  public static void main (String[] args) throws FileNotFoundException {
      
    // Variables that create windows.
    Draw windowQuiz = new Draw("The Quiz Show Window");
    Draw windowAnnouncer = new Draw("The Announcer Window");
    Draw windowPoints = new Draw("Your Points");
    Draw windowInteractive = new Draw("Your Interactive Window!");
      
    int correctCount = 0;
      
    // Their respective methods
    windowAnnouncerMethod(windowAnnouncer);
     
    windowPointsMethod(windowPoints);
      
    //////////////////////////Copy + Paste Code//////////////////////////////////
    File file = 
      new File("trivia.txt"); 
    Scanner sc = new Scanner(file); 
    ArrayList<String> questions = new ArrayList<String> ();
    ArrayList<String> answers = new ArrayList<String> ();
    ArrayList<String> wrongAnswers = new ArrayList<> ();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      if(line.equals("")){
        break;
      }
      questions.add(line);
      answers.add(sc.nextLine());
    }
    while(sc.hasNextLine()) {
      wrongAnswers.add(sc.nextLine());
    }
    
    playGame(windowQuiz, windowInteractive, correctCount, questions, answers, wrongAnswers);
  
    //////////////////////////Copy + Paste Code//////////////////////////////////
      
  }
  
  public static void playGame (Draw windowQuiz, Draw windowInteractive, int correctCount, ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> wrongAnswers){
    while(true) {
    TriviaCombined game = new TriviaCombined();
    String [] QandA = game.getRandomQandA(questions, answers, wrongAnswers);
    System.out.println(QandA[0]);
    windowQuizMethod(windowQuiz, QandA);
    windowInteractiveMethod(windowInteractive, QandA, correctCount, windowQuiz, questions, answers, wrongAnswers);
    }
  }
    
  // Connects and Modifies Announcer Window
  public static void windowAnnouncerMethod(Draw wAnnouncer) {
    // Strings that call for graphics
    String neutral = "Graphics/NeutralBackground.png";
    String correct = "Graphics/CorrectBackground.png";
    String incorrect = "Graphics/IncorrectBackground.png";
      
    wAnnouncer.setCanvasSize(384,512);
    wAnnouncer.picture(0.5, 0.5, neutral);
    //wAnnouncer.picture(0.5, 0.5, correct);
    //wAnnouncer.picture(0.5, 0.5, incorrect);
    System.out.println("windowAnnouncerMethod Functioning");
  }
    
  // Connects and Modifies Quiz Window
  public static void windowQuizMethod(Draw wQuiz, String[] QandA){
      
    // Window Properties
    wQuiz.setCanvasSize(768,512);
    System.out.println("windowQuizMethod Functioning");
      
    wQuiz.picture(0.5, 0.5, "Graphics/NeutralBackground.png", 1.0, 1.0);
    wQuiz.picture(0.5, 0.5, "Graphics/Template2.png", 0.85, 0.85);
      
    wQuiz.setPenColor(wQuiz.WHITE);
    String titleQuestion = QandA[0];
      
    wQuiz.text(0.5, 0.5, titleQuestion);
  }
    
  public static void windowPointsMethod(Draw wPoints){
    System.out.println("windowPointsMethod Functioning");
    wPoints.setCanvasSize(384,256);
    wPoints.picture(0.5, 0.5, "Graphics/NeutralBackground.png", 1.5, 1.5);
    wPoints.picture(0.5, 0.5, "Graphics/Template1.png", 0.8, 0.8);
  }
    
  // Connects and Modifies Interactive Window
  public static void windowInteractiveMethod(Draw wInteractive, String [] QandA, int correctCount, Draw windowQuiz, ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> wrongAnswers){
    // Strings that hold text to be displayed on window. "p" stands for "possible."
    String trueAnswer = QandA[1];
    String pAnswerOne = QandA[3];
    String pAnswerTwo = QandA[1];
    String pAnswerThree = QandA[2];
    String pAnswerFour = QandA[4]; 
      
    String button = "Graphics/ButtonGraphic.png";
      
    wInteractive.setCanvasSize(768,256);
    System.out.println("windowInteractiveMethod Functioning");
      
    wInteractive.picture(0.5, 0.5, "Graphics/NeutralBackground.png", 1.5, 4.0);
      
    wInteractive.setPenColor(wInteractive.WHITE);
    wInteractive.picture(0.25, 0.75, button);
    wInteractive.text(0.25, 0.75, pAnswerOne);
      
    wInteractive.picture(0.25, 0.25, button);
    wInteractive.text(0.25, 0.25, pAnswerTwo);
      
    wInteractive.picture(0.75, 0.75, button);
    wInteractive.text(0.75, 0.75, pAnswerThree);
      
    wInteractive.picture(0.75, 0.25, button);
    wInteractive.text(0.75, 0.25, pAnswerFour);
      
      
    // System receives input from user
    while (true == true){
      double y = wInteractive.mouseY();
      double x = wInteractive.mouseX();
      boolean mouseInteract = wInteractive.isMousePressed();
        
      // Artificial Hitbox for String 1 Textbox
      if (mouseInteract == true && ((y < 0.9375) && (y > 0.566)) && ((x < 0.375) && (x > 0.125))) {  
        //System.out.println(mouseInteract);
        correctCheck(pAnswerOne, trueAnswer, correctCount);
        break;
      } 
        
      // Artificial Hitbox for String 2 Textbox
      if (mouseInteract == true && ((y < 0.4375) && (y > 0.066)) && ((x < 0.375) && (x > 0.125))) {
        //System.out.println(mouseInteract);
        correctCheck(pAnswerTwo, trueAnswer, correctCount);
        break;
      } 
        
      // Artificial Hitbox for String 3 Textbox
      if (mouseInteract == true && ((y < 0.9375) && (y > 0.566)) && ((x < 0.835) && (x > 0.625))) {
        //System.out.println(mouseInteract);
        correctCheck(pAnswerThree, trueAnswer, correctCount);
        break;
      } 
        
      // Artificial Hitbox for String 2 Textbox
      if (mouseInteract == true && ((y < 0.4375) && (y > 0.066)) && ((x < 0.835) && (x > 0.625))) {
        //System.out.println(mouseInteract);
        correctCheck(pAnswerFour, trueAnswer, correctCount);
        break;
      }
    }
    playGame(windowQuiz, wInteractive, correctCount, questions, answers, wrongAnswers);
  } 
    
  //////////////////////////Copy + Paste Code//////////////////////////////////
  public static String[] getRandomQandA (ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> wrongAnswers) 
  {
    int randQandA = (int)(Math.random()*9) + 0;
    int randAns1 = (int)(Math.random()*9) + 0;
    int randAns2 = (int)(Math.random()*9) + 0;
    int randAns3 = (int)(Math.random()*9) + 0;
    if(randAns1 == randAns3) {
      randAns1 = randAns3++;
    }
    if(randAns1 == randAns2) { 
      randAns1 = randAns1++;
    }
    if(randAns2 == randAns1) { 
      randAns2 = randAns1++;
    }
    if(randAns2 == randAns3) { 
      randAns2 = randAns3++;
    }
    if(randAns3 == randAns1) { 
      randAns3 = randAns1++;
    }
    if(randAns3 == randAns2) { 
      randAns3 = randAns2++;
    }
    String [] QandA = new String [5];
      
    String finalQuestion = questions.get(randQandA);
    String finalAnswer = answers.get(randQandA);
    String wrongAns1 = wrongAnswers.get(randAns1);
    String wrongAns2 = wrongAnswers.get(randAns2);
    String wrongAns3 = wrongAnswers.get(randAns3);
      
    QandA = new String[] {finalQuestion, finalAnswer, wrongAns1, wrongAns2, wrongAns3};
      
    return QandA;
  }
  public static int correctCheck(String pAnswer, String tAnswer, int correctCount) {
    
    
    if( pAnswer.equals(tAnswer) == true ) {
      System.out.println("Correct!");
      correctCount++;
      System.out.println(correctCount);
      
    } else {
      System.out.println("Wrong!");
    }
    return correctCount;
  }
}