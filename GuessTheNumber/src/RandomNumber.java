import javax.swing.JOptionPane;
import java.util.Random;
public class RandomNumber
{
  public static void main(String[] args) 
  {
    int totalscore=0, rounds=3;
    for(int i=1;i<=rounds;i++)
    {
      int score=0;  
      Random obj= new Random();
      int no= obj.nextInt(100);
      int option= Integer.parseInt(JOptionPane.showInputDialog("Enter a number from 0-100"));
      if(option == no)

        {
          score=10;
          JOptionPane.showMessageDialog(null, "Congratulations you gussed the number in the 1st attempt");
        }
      else
        {
          int count=1;
          while(option!=no && count<5)
          {
            if(option<no)
            {
              JOptionPane.showMessageDialog(null,"Try a bigger number");
            }
            else
            {
              JOptionPane.showMessageDialog(null,"Try a smaller number");
            }

            // Providing a hint after 3 incorrect attempts:-
            if(count==3)
            {
              String hint= generateHint(no);
              JOptionPane.showMessageDialog(null,"Hint:- "+ hint);
            }

            option= Integer.parseInt(JOptionPane.showInputDialog("Re-Enter a number"));
            count++;
          }

          if(option==no)
          {
            score= 10- count+1;
            JOptionPane.showMessageDialog(null,"You've gussed it correctly, score:- "+ score);
          }
          else
          {
            JOptionPane.showMessageDialog(null,"You've used all the attempts. The number was:- "+ no);
          }
          totalscore= totalscore+ score;
          JOptionPane.showMessageDialog(null, "Your score for this round:- "+ score);
          System.out.println("Your score for Round "+i+":- "+ score);
        }
    }
    JOptionPane.showMessageDialog(null,"Game Over ! Your total score:- "+ totalscore);
    System.out.println("Your total score:- "+ totalscore);
  }
  public static String generateHint(int no)
    {
      if(no%2==0){
        return "The number is even";
      }
      else{
        return "The number is odd";
      }
    }
}
