import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Random;
public class TriviaGame 
{ 
  public static void main(String[] args) throws Exception 
  { 
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
    TriviaGame game = new TriviaGame();
    System.out.println(game.getRandomQandA(questions, answers, wrongAnswers));
  }
  public String getRandomQandA (ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> wrongAnswers) 
  {
    Random rand = new Random();
    int QandA = (int)(Math.random()*9) + 0;
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
    return questions.get(QandA) + "\n\n" + answers.get(QandA) + "\n" + wrongAnswers.get(randAns1) + "\n" + wrongAnswers.get(randAns2) + "\n" + wrongAnswers.get(randAns3);
  }
}

