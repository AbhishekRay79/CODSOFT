import java.util.*;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean restart = true;
        while (restart) {
            System.out.println("You have ten rounds to guess the correct number.....");
            int count = 0;
            int randomnumber = (int) (Math.random() * 100) + 1;
            for (int i = 0; i < 10; i++) {

                System.out.println("Enter Your Guess....");
                int guess = sc.nextInt();
                if (guess == randomnumber) {
                    System.out.println("Your guess is correct....");
                    count += 100;
                    System.out.println("Your score is: " + count);
                    break;

                } else if (guess < randomnumber) {
                    System.out.println("Your guess is too low....");
                    count -= 10;
                    System.out.println("Your score is: " + count);

                } else if (guess > randomnumber) {
                    System.out.println("Your guess is too high....");
                    count -= 10;
                    System.out.println("Your score is: " + count);

                }

            }
            if (count == 100 && count >= 90) {
                System.out.println("Congratulation you have won the game .....");
            } else if (count >= 50 && count <= 89) {
                System.out.println("You have played well but you can do better.....");
            } else if (count < 50) {
                System.out.println("You have lost the game try again.....");
            }

            System.out.println("To play the game again enter yes");
            System.out.println("To exit the game enter no");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("no")) {
                restart = false; 
                System.out.println("Game Over");
            }
        }

        sc.close();
    }
}