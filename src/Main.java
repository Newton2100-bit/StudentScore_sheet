import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   // Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int totalUnits = 5;
        String[] studentName = new String[5];
        String[] regNumber = new String[5];
        int[] ccs2211 = new int[5];
        int[] ccs2212 = new int[5];
        int[] ccs2213 = new int[5];
        int[] ccs2214 = new int[5];
        int[] ccs2215 = new int[5];
        char[] grade = new char[5];
        int[] total = new int[5];
        double[] average = new double[5];
        Scanner input = new Scanner(System.in);

        int userChoice=1;
        int count=0;
        while(userChoice==1){
            if(count<5){
                System.out.print("Enter the reg number of the student (no/year):");
                regNumber[count]=getStringData();
                System.out.print("Kindly enter the name of student "+(count+1)+":");
                studentName[count]=getStringData();
                System.out.print("Kindly enter the marks obtained in ccs2211 by student "+(count+1)+":");
                ccs2211[count]=getUsermarks();
                System.out.print("Kindly enter the marks obtained in ccs2212 by student "+(count+1)+":");
                ccs2212[count]=getUsermarks();
                System.out.print("Kindly enter the marks obtained in ccs2213 by student "+(count+1)+":");
                ccs2213[count]=getUsermarks();
                System.out.print("Kindly enter the marks obtained in ccs2214 by student "+(count+1)+":");
                ccs2214[count]=getUsermarks();
                System.out.print("Kindly enter the marks obtained in ccs2215 by student "+(count+1)+":");
                ccs2215[count]=getUsermarks();
                System.out.println();
                System.out.println();
                total[count]=ccs2211[count]+ccs2212[count]+ccs2213[count]+ccs2214[count]+ccs2215[count];
                average[count]=total[count]/totalUnits;

                if ((average[count] >= 70.0) && (average[count] <= 100.0))
                    grade[count] = 'A';
                else if (average[count] >= 60.0)
                    grade[count] = 'B';
                else if (average[count] >= 50.0)
                    grade[count] = 'C';
                else if (average[count] >= 40.0)
                    grade[count] = 'D';
                else if ((average[count] >= 0.0) && (average[count] < 40.0))
                    grade[count] = 'E';

            }else{
                System.out.println("Sorry you can only enter data for 5 students!!");
            }
            System.out.print("kindly enter 1 if you want to proceed and 0 if you want to display the Score Sheet :");
            userChoice=input.nextInt();
            count++;
            System.out.println();

        }
        while(userChoice==0){
            System.out.println();
            System.out.println("Student Score sheet");
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("Reg No.    Full Name   CCS2211  CCS2212   CCS2213   CCS2214     CCS2215  total    average    Grade");
            System.out.println("----------------------------------------------------------------------------------------------------");
           for(int i=0;i<count;++i){
                System.out.println(regNumber[i]+"  "+studentName[i]+"        "+ccs2211[i]+"        "+ccs2212[i]+"        "+ccs2213[i]+"        "+ccs2214[i]+"        "+ccs2215[i]+"        "+total[i]+"        "+average[i]+"        "+grade[i]+" ");

        }
            userChoice = 1;
        }
    }

    public static String getStringData(){
       Scanner keyboard = new Scanner(System.in);
        String userName=keyboard.nextLine();
       // close Scanner;
        return userName;
    }
    public static int getUsermarks(){
        Scanner keyboard = new Scanner(System.in);
        int marks=keyboard.nextInt();
        //close Scanner;
        return marks;
    }
}