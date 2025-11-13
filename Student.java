import java.util.Scanner;

public class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int numSubjects;

    // Method to accept student details
    public void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        numSubjects = sc.nextInt();

        credits = new int[numSubjects];
        marks = new int[numSubjects];

        System.out.println("Enter credits and marks for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + " Credits: ");
            credits[i] = sc.nextInt();
            System.out.print("Subject " + (i + 1) + " Marks: ");
            marks[i] = sc.nextInt();
        }

        sc.close(); 
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Number of Subjects: " + numSubjects);
        System.out.println("Subject-wise Credits and Marks:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("  Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
    }

    // Method to calculate SGPA
    public double calculateSGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < numSubjects; i++) {
            int gradePoint;
            if (marks[i] >= 90) {
                gradePoint = 10;
            } else if (marks[i] >= 80) {
                gradePoint = 9;
            } else if (marks[i] >= 70) {
                gradePoint = 8;
            } else if (marks[i] >= 60) {
                gradePoint = 7;
            } else if (marks[i] >= 50) {
                gradePoint = 6;
            } else {
                gradePoint = 0; // Failing grade
            }
            totalGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        } else {
            return totalGradePoints / totalCredits;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.acceptDetails();
        student1.displayDetails();
        double sgpa = student1.calculateSGPA();
        System.out.printf("SGPA: %.2f%n", sgpa);
    }
}