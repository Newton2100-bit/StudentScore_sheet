import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner input = new Scanner(System.in);
    static int totalUnits = 5;
    static String[] studentName = new String[5];
    static String[] regNumber = new String[5];
    static int[] ccs2211 = new int[5];
    static int[] ccs2212 = new int[5];
    static int[] ccs2213 = new int[5];
    static int[] ccs2214 = new int[5];
    static int[] ccs2215 = new int[5];
    static char[] grade = new char[5];
    static int[] total = new int[5];
    static double[] average = new double[5];
    static int count = 0;
    static int userChoice = 1;

    public static void main(String[] args) {
        while (userChoice == 1) {
            if (count < 5) {
                enterData();
                marksCalculation();
                count++;
            } else {
                errorMessage();
            }
            userDecision();
        }

        while (userChoice != 1) {
            displayScoreSheet();
            displayStudentsMarks();
            userChoice = 1;
        }

    }

    public static void userDecision(){
        System.out.print("Enter 1 to proceed ,Any other number to display score sheet :");
        userChoice = input.nextInt();
        System.out.println();
    }

    public static void errorMessage(){
        System.out.println("Sorry you can only enter data for 5 students!!");
        System.out.println();
    }

    public static void enterData() {
        if (count < 5) {
            getDetails();
            getMarks();
            }
        }

        public static void getDetails() {
            System.out.print("Enter the reg number of the student (no/year):");
            regNumber[count] = getStringData();
            System.out.print("Kindly enter the name of student " + (count + 1) + ":");
            studentName[count] = getStringData();
        }

    static int course=1;


        public static void getMarks(){
        userPrompt();
            ccs2211[count] = getUsermarks();
            userPrompt();
            ccs2212[count] = getUsermarks();
            userPrompt();
            ccs2213[count] = getUsermarks();
            userPrompt();
            ccs2214[count] = getUsermarks();
            userPrompt();
            ccs2215[count] = getUsermarks();
            System.out.println();
            course=1;
        }

    public static void userPrompt(){
        System.out.print("Enter the marks obtained in ccs221"+course+" by student " + (count + 1) + ":");
        ++course;
    }

        public static void marksCalculation(){
            total[count] = ccs2211[count] + ccs2212[count] + ccs2213[count] + ccs2214[count] + ccs2215[count];
            average[count] = total[count] / totalUnits;
            grade[count] = gradeEvaluation(average[count]);
        }

    public static char gradeEvaluation(double average) {
        if ((average >= 70.0) && (average <= 100.0))
            return 'A';
        else if (average >= 60.0)
            return 'B';
        else if (average >= 50.0)
            return 'C';
        else if (average >= 40.0)
            return 'D';
        else
            return 'E';

    }


    public static String getStringData() {
        Scanner keyboard = new Scanner(System.in);
        String userName = keyboard.nextLine();
        return userName;
    }

    public static int getUsermarks() {
        Scanner keyboard = new Scanner(System.in);
        int marks = keyboard.nextInt();
        return marks;
    }


    public static void displayScoreSheet() {
        System.out.println();
        System.out.println("Student Score sheet");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Reg No.    Full Name   CCS2211    CCS2212   CCS2213   CCS2214     CCS2215  total    average    Grade");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public static void displayStudentsMarks(){
        for (int i = 0; i < count; ++i) {
            System.out.print(regNumber[i] + "  " + studentName[i] + "        " + ccs2211[i] + "       " + ccs2212[i]  );
            System.out.print("         " + ccs2213[i] + "        " + ccs2214[i] + "          " + ccs2215[i] + "      " );
            System.out.println(total[i] + "       " + average[i] + "        " + grade[i] + " ");
        }
    }
}
