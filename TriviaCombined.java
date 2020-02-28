import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.File; 
import java.util.Random;
import java.io.FileNotFoundException;

/**
 * A trivia game about computer parts
 * Portrays questions
 */ 

class TriviaCombined {
  
  public static int correctCount = 0;
  
  public static void main (String[] args) throws FileNotFoundException {
    
    // Variables that create windows.
    Draw windowQuiz = new Draw("The Quiz Show Window");
    Draw windowAnnouncer = new Draw("The Announcer Window");
    Draw windowPoints = new Draw("Your Points");
    Draw windowInteractive = new Draw("Your Interactive Window!");
    
    // Their respective methods
    initWindowAnnouncer(windowAnnouncer);
    initWindowPoints(windowPoints);
    
    File file = new File("trivia.txt"); 
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
    
    playGame(windowPoints, windowQuiz, windowInteractive, questions, answers, wrongAnswers);
    
  }
  /*
   * 
   */
  public static void playGame (Draw windowPoints, Draw windowQuiz, Draw windowInteractive, ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> wrongAnswers){
    while(true) {
      TriviaCombined game = new TriviaCombined();
      String [] QandA = game.getRandomQandA(questions, answers, wrongAnswers);
      System.out.println(QandA[0]);
      initWindowQuiz(windowQuiz, QandA);
      initWindowInteractive(windowPoints, windowInteractive, QandA, windowQuiz, questions, answers, wrongAnswers);
    }
  }
  
  // Connects and Modifies Announcer Window
  public static void initWindowAnnouncer(Draw wAnnouncer) {
    
    // Strings that call for graphics
    String neutral = "Graphics/NeutralBackground.png";
    String correct = "Graphics/CorrectBackground.png";
    String incorrect = "Graphics/IncorrectBackground.png";
    
    
    wAnnouncer.setCanvasSize(384,512);
    wAnnouncer.picture(0.5, 0.5, neutral);
    //wAnnouncer.picture(0.5, 0.5, correct);
    //wAnnouncer.picture(0.5, 0.5, incorrect);
    wAnnouncer.setLocationOnScreen(160, 30);
    System.out.println("initWindowAnnouncer Functioning");
  }
  
  // Connects and Modifies Quiz Window
  public static void initWindowQuiz(Draw wQuiz, String[] QandA){
    
    // Window Properties
    wQuiz.setCanvasSize(768,512);
    
    
    wQuiz.picture(0.5, 0.5, "Graphics/NeutralBackground.png", 1.0, 1.0);
    wQuiz.picture(0.5, 0.5, "Graphics/Template2.png", 0.85, 0.85);
    
    wQuiz.setPenColor(wQuiz.WHITE);
    String titleQuestion = QandA[0];
    
    wQuiz.text(0.5, 0.5, titleQuestion);
    wQuiz.setLocationOnScreen(560, 30);
    System.out.println("initWindowQuiz Functioning");
  }
  
  public static void initWindowPoints(Draw wPoints){
    System.out.println("initWindowPoints Functioning");
    wPoints.setCanvasSize(384,256);
    wPoints.picture(0.5, 0.5, "Graphics/NeutralBackground.png", 1.5, 1.5);
    wPoints.picture(0.5, 0.5, "Graphics/Template1.png", 0.8, 0.8);
    wPoints.setLocationOnScreen(160, 610);
    wPoints.setPenColor(wPoints.WHITE);
    
  }
  
  // Connects and Modifies Interactive Window
  public static void initWindowInteractive(Draw windowPoints, Draw wInteractive, String [] QandA, Draw windowQuiz, ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> wrongAnswers){
    // Strings that hold text to be displayed on window. "p" stands for "possible."
    String trueAnswer = QandA[1];
    String pAnswerOne = QandA[3];
    String pAnswerTwo = QandA[1];
    String pAnswerThree = QandA[2];
    String pAnswerFour = QandA[4]; 
    
    String button = "Graphics/ButtonGraphic.png";
    
    wInteractive.setCanvasSize(768,256);
    System.out.println("initWindowInteractive Functioning");
    
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
    
    wInteractive.setLocationOnScreen(560, 610);
    // System receives input from user
    while (true == true){
      double y = wInteractive.mouseY();
      double x = wInteractive.mouseX();
      boolean mouseInteract = wInteractive.isMousePressed();
      
      
      // Artificial Hitbox for String 1 Textbox
      if (mouseInteract == true && ((y < 0.9375) && (y > 0.566)) && ((x < 0.375) && (x > 0.125))) {  
        //System.out.println(mouseInteract);
        correctCheck(windowPoints, pAnswerOne, trueAnswer);
        break;
      } 
      
      // Artificial Hitbox for String 2 Textbox
      if (mouseInteract == true && ((y < 0.4375) && (y > 0.066)) && ((x < 0.375) && (x > 0.125))) {
        //System.out.println(mouseInteract);
        correctCheck(windowPoints, pAnswerTwo, trueAnswer);
        break;
      } 
      
      // Artificial Hitbox for String 3 Textbox
      if (mouseInteract == true && ((y < 0.9375) && (y > 0.566)) && ((x < 0.835) && (x > 0.625))) {
        //System.out.println(mouseInteract);
        correctCheck(windowPoints, pAnswerThree, trueAnswer);
        break;
      } 
      
      // Artificial Hitbox for String 2 Textbox
      if (mouseInteract == true && ((y < 0.4375) && (y > 0.066)) && ((x < 0.835) && (x > 0.625))) {
        //System.out.println(mouseInteract);
        correctCheck(windowPoints, pAnswerFour, trueAnswer);
        break;
      }
    }

    playGame(windowPoints, windowQuiz, wInteractive, questions, answers, wrongAnswers);
    
  }
  
  /**
   * Gets a random question, correct answer, and three random answers
   * @return String array with question, correct answer, and three wrong answers
   * @param questions This holds all questions in the game
   * @param answers This holds all correct answers
   * @param wrongAnswers This holds all incorrect answers
   * @author Zoe Weiner
   */
  
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
  
  /**
   * Checks that the answer chosen is correct
   * Counts the number of correct answers chosen
   * @param windowPoints 
   * @param pAnswer This is the answer chosen
   * @param tAnswer This is the correct answer
   * @author 
   */
  
  public static void correctCheck(Draw windowPoints, String pAnswer, String tAnswer) {
    
    System.out.println("correctCheck Functioning");
    if(pAnswer.equals(tAnswer) == true ) {
      System.out.println("Correct!");
      correctCount++;
      System.out.println(correctCount);
    } else {
      System.out.println("Wrong!");
    }
    String numberCounter = String.valueOf(correctCount);
    windowPoints.text(0.5, 0.5, numberCounter);
  }
}