import java.awt.*;//imports needed packages
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class hangmanMain extends JFrame implements ActionListener
{
  //Global Variables
  JLabel prompt1;
  JTextField input, output, output1;
  String word, guessedWord, guessedLetters, temp1, temp2;
  char guess;
  int wrongGuesses, randomWord, temp3;
  String[] possibleWords = new String []{"DELIBERATE", "RHINO", "TRANSPORT", "HELICOPTER", "ESKIMO", "PHANTOM", "SNAKE", "ELEPHANT", "OCTOGENARIAN", "PSEUDOSCIENCE", "XENOPHOBIA", "DEGENARATIVE", "WAXED", "MONITOR", "DESKTOP"};
  
  public hangmanMain()
  {
    //Initiate Variables
    Random r = new Random();
    randomWord = r.nextInt(15);
    word = possibleWords[randomWord];//chooses a random word from the available words
    wrongGuesses = 0;
    int len = word.length();
    guessedWord = ("");
    for (int i = 0; i <len; i++)
      guessedWord = guessedWord + "-";//creates the initial guessedWord varible, fillled up with a - for each letter in the word
    System.out.println(guessedWord);//debugging
    guessedLetters = "";
    
    //set size, location and layout of window
    setSize(700,500);
    setLocation(0,0);
    setLayout(new FlowLayout());
    
    //defines the fonts to be used
    Font font1 = new Font("SansSerif", Font.BOLD, 30);
    Font font2 = new Font("SansSerif", Font.BOLD, 20);
    Font font3 = new Font("SansSerif", Font.BOLD, 26);
    
    //creates the prompts, inputs, and outputs to be displayed on screen
    prompt1 = new JLabel("Good Luck, your going to need it, enter your guess and press enter");
    input = new JTextField(1);
    output = new JTextField(20);
    output1 = new JTextField(26);
    
    //edits how the inputs outputs and prompts are displayed
    input.setFont(font2);
    output.setEditable(false);
    output.setFont(font1);
    output.setText (guessedWord);
    output1.setEditable(false);
    output1.setFont(font3);
    
    //sets everything onto the screen and starts a action listener
    getContentPane().add(prompt1);
    getContentPane().add(input);
    getContentPane().add(output);
    getContentPane().add(output1);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    input.addActionListener(this);
    
  }
  
  public void actionPerformed(ActionEvent ev)
  {
    //initiates needed variable
    temp1 = input.getText();//sets temp1 to what is entered into the input box
    temp2 = "";
    temp3 = 0;
    guess = temp1.charAt(0);//sets guess to the first character in temp (preventing multiple charecters being added)
    guess = Character.toUpperCase(guess);//converts guess to upercase
    if (guessedLetters.length() > 0){//checks whether  the letter has already been entered
      for (int i = 0; i < guessedLetters.length(); i++){
        while (guess == guessedLetters.charAt(i)){
          output1.setText ("Good one mate you already entered that!");
          input.setText("");
          guess = input.getText().charAt(0);
        }
      }
    }
     guessedLetters = guessedLetters + guess;//adds the letter to the string full of guessed letters
     output1.setText (guessedLetters);//places all the guest letters into an output box     
     for (int i = 0; i < word.length(); i++){//creates a new guessed word
       if (guess == word.charAt(i)){
         temp2 += guess;
         temp3 ++;//used to check if player entered wrong guess
       }
       else{
         temp2 += guessedWord.charAt(i);
       }       
      }
     guessedWord = temp2;
     output.setText(guessedWord);//print the new guessed word on the screen      
     input.setText("");
     if (guessedWord.compareTo(word) == 0){//checks to see if you have won
       output1.setText("C O N G R A T U L A T I O N S");
       input.setEditable(false);
     }
     if(temp3 < 1){//adds one to wrong guesses if no new letters were added to guessed word
       wrongGuesses = wrongGuesses + 1;
     System.out.println(wrongGuesses);//debugging
     repaint();
     }
  }
  
  public void paint(Graphics graf){
    super.paint(graf);
     switch(wrongGuesses){//paints hangman and if you make 10 mistakes causes game over
         case 1:graf.drawLine(200,400,400,400);
           break;
         case 2:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           break;
         case 3:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           graf.drawLine(250,400,200,350);
           break;
         case 4:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           graf.drawLine(250,400,200,350);
           graf.drawLine(200,200,400,200);
           break;
         case 5:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           graf.drawLine(250,400,200,350);
           graf.drawLine(200,200,400,200);
           graf.drawLine(400,200,400,230);
           break;
         case 6:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           graf.drawLine(250,400,200,350);
           graf.drawLine(200,200,400,200);
           graf.drawLine(400,200,400,230);
           graf.drawOval(380,230,40,40);
           break;
         case 7:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           graf.drawLine(250,400,200,350);
           graf.drawLine(200,200,400,200);
           graf.drawLine(400,200,400,230);
           graf.drawOval(380,230,40,40);
           graf.drawLine(400,270,400,300);
           break;
         case 8:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           graf.drawLine(250,400,200,350);
           graf.drawLine(200,200,400,200);
           graf.drawLine(400,200,400,230);
           graf.drawOval(380,230,40,40);
           graf.drawLine(400,270,400,300);
           graf.drawLine(400,300,420,330);
           break;
         case 9:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           graf.drawLine(250,400,200,350);
           graf.drawLine(200,200,400,200);
           graf.drawLine(400,200,400,230);
           graf.drawOval(380,230,40,40);
           graf.drawLine(400,270,400,300);
           graf.drawLine(400,300,420,330);
           graf.drawLine(400,300,380,330);
           break;
         case 10:graf.drawLine(200,400,400,400);
           graf.drawLine(200,400,200,200);
           graf.drawLine(250,400,200,350);
           graf.drawLine(200,200,400,200);
           graf.drawLine(400,200,400,230);
           graf.drawOval(380,230,40,40);
           graf.drawLine(400,270,400,300);
           graf.drawLine(400,300,420,330);
           graf.drawLine(400,300,380,330);
           graf.drawLine(380,280,420,280);
           output.setText(word);
           output1.setText("G A M E  O V E R");
           input.setEditable(false);
           break;
       default: break; 
     } 
     }
  
  
  public static void main(String args[])//runs programme
  {
    new hangmanMain();
  }   
}
