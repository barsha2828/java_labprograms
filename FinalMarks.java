import CIE.*;
import SEE.*;
import java.util.Scanner;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Personal[] personal = new Personal[n];
        Internals[] internals = new Internals[n];
        External[] external = new External[n];

        for (int i = 0; i < n; i++) {
            personal[i] = new Personal();
            internals[i] = new Internals();
            external[i] = new External();

            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("USN: ");
            String usn = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Semester: ");
            int sem = sc.nextInt();

            personal[i].readPersonal(usn, name, sem);
            external[i].readPersonal(usn, name, sem);

            int[] intMarks = new int[5];
            System.out.println("Enter 5 internal marks:");
            for (int j = 0; j < 5; j++) {
                intMarks[j] = sc.nextInt();
            }
            internals[i].readInternals(intMarks);

            int[] seeMarks = new int[5];
            System.out.println("Enter 5 SEE marks:");
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = sc.nextInt();
            }
            external[i].readSEE(seeMarks);
        }

        System.out.println("\n--- Final Marks of Students ---");
        for (int i = 0; i < n; i++) {
            personal[i].displayPersonal();
            internals[i].displayInternals();
            external[i].displaySEE();

            System.out.print("Final Marks: ");
            for (int j = 0; j < 5; j++) {
                int finalMark = internals[i].internalMarks[j] + external[i].seeMarks[j];
                System.out.print(finalMark + " ");
            }
            System.out.println("\n-----------------------------");
        }

        sc.close();
    }
} 
