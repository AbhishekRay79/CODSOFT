import java.util.Scanner;

public class gradealculator {
    public static void main(String[] args) {
        calculateGrade();
    }

    public static void calculateGrade() {
        Scanner sc = new Scanner(System.in);
        double[] subjectMarks = new double[5];
        String[] subjects = { "Math", "Physics", "Chemistry", "Biology", "IT" };

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter mark for " + subjects[i] + " (out of 100): ");
            subjectMarks[i] = sc.nextDouble();
        }

        double totalMarks = 0;
        for (double mark : subjectMarks) {
            totalMarks += mark;
        }
        double averagePercentage = (totalMarks / 500) * 100;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Marks:");
        for (int i = 0; i < 5; i++) {
            System.out.println(subjects[i] + ": " + subjectMarks[i]);
        }
        System.out.println("Total Marks: " + totalMarks + "/500");
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
        sc.close();
    }
}