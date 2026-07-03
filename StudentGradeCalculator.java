import java.util.Scanner;

public class StudentGradeCalculator {

    static Scanner sc = new Scanner(System.in);

    static String[] studentNames = new String[100];
    static double[] percentages = new double[100];
    static String[] grades = new String[100];
    static int studentCount = 0;

    public static void main(String[] args) {
        welcome();
        menu();
    }

    public static void welcome() {
        System.out.println("========================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("========================================");
    }

    public static void menu() {
        boolean run = true;

        while (run) {
            System.out.println("\n1. Add Student Result");
            System.out.println("2. View All Results");
            System.out.println("3. Class Statistics");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = getInt();

            switch (choice) {
                case 1:
                    calculateResult();
                    break;
                case 2:
                    displayResults();
                    break;
                case 3:
                    classStats();
                    break;
                case 4:
                    run = false;
                    System.out.println("Program Closed.");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void calculateResult() {
        System.out.print("Enter Student Name: ");
        String name = sc.next();

        System.out.print("Enter Number of Subjects: ");
        int subjects = getInt();

        double total = 0;

        for (int i = 1; i <= subjects; i++) {
            double marks;

            while (true) {
                System.out.print("Enter marks of subject " + i + ": ");
                marks = getDouble();

                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Marks must be between 0 and 100.");
                }
            }

            total += marks;
        }

        double percentage = total / subjects;
        String grade = calculateGrade(percentage);

        studentNames[studentCount] = name;
        percentages[studentCount] = percentage;
        grades[studentCount] = grade;
        studentCount++;

        System.out.println("\n===== RESULT =====");
        System.out.println("Name       : " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage : " + percentage + "%");
        System.out.println("Grade      : " + grade);

        if (percentage >= 40) {
            System.out.println("Status     : PASS");
        } else {
            System.out.println("Status     : FAIL");
        }
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90)
            return "A+";
        else if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 40)
            return "D";
        else
            return "F";
    }

    public static void displayResults() {
        if (studentCount == 0) {
            System.out.println("No Data Available.");
            return;
        }

        System.out.println("\n========= ALL RESULTS =========");

        for (int i = 0; i < studentCount; i++) {
            System.out.println("-------------------------------");
            System.out.println("Name       : " + studentNames[i]);
            System.out.println("Percentage : " + percentages[i] + "%");
            System.out.println("Grade      : " + grades[i]);
        }
    }

    public static void classStats() {
        if (studentCount == 0) {
            System.out.println("No Data Available.");
            return;
        }

        double highest = percentages[0];
        double lowest = percentages[0];
        double sum = 0;

        for (int i = 0; i < studentCount; i++) {
            if (percentages[i] > highest)
                highest = percentages[i];

            if (percentages[i] < lowest)
                lowest = percentages[i];

            sum += percentages[i];
        }

        double average = sum / studentCount;

        System.out.println("\n======= CLASS STATS =======");
        System.out.println("Highest Percentage : " + highest);
        System.out.println("Lowest Percentage  : " + lowest);
        System.out.println("Class Average      : " + average);
    }

    public static int getInt() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.print("Enter valid integer: ");
                sc.next();
            }
        }
    }

    public static double getDouble() {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.print("Enter valid number: ");
                sc.next();
            }
        }
    }
}