import java.util.ArrayList;
import java.util.Scanner;


public class ClassGrades {
    public static void main(String[] args){

        ArrayList<Course> courses = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        int exit = 0;
        System.out.println("Welcome to the Grading and Absence Management System for Students");
        System.out.println("-----------------------------------------------------------------");
        


        do{
            System.out.println("Enter 'Grades' for adding the grades of students");
            System.out.println("Enter 'Absences' for adding the number of absences for students");
            System.out.println("Enter 'Exit' for exiting from the system");
            
           String prompt = input.nextLine();
           
           
           if(prompt.compareTo("Grades")==0){
                System.out.print("Enter Course Name: ");
                String name = input.nextLine();
                System.out.print("\nEnter Class Size: ");
                int size = input.nextInt();

                Course thisCourse = new Course(name, size);
                int i=1;
                do{

                System.out.print("\nEnter Student ID (1-"+size+", 0 to exit): ");
                Scanner intIn = new Scanner(System.in);
                i = intIn.nextInt();
                if (i==0) break;
                thisCourse.addGrades(i);
                //intIn.close();
                
                }while(i!=0);
                input.nextLine();
                
           }
           if(prompt.compareTo("Absences")==0){
            System.out.print("Enter Course Name: ");
            String name = input.nextLine();
            System.out.print("\nEnter Class Size: ");
            int size = input.nextInt();

            Course thisCourse = new Course(name, size);
            int i=1;
            do{

            System.out.print("\nEnter Student ID (1-"+size+", 0 to exit): ");
            Scanner intIn = new Scanner(System.in);
            i = intIn.nextInt();
            if (i==0) break;
            System.out.print("\nEnter Student Absences: ");
            int a = intIn.nextInt();
            
            thisCourse.addAbsence(i, a);
            //intIn.close();
            
            }while(i!=0);
            input.nextLine();
           }
           if(prompt.compareTo("Exit")==0){
               exit=1;
               System.out.println("Goodbye!");
           }


        }
        while(exit==0);
        input.close();
        


    }

    static class Student{
        int id;
        int grade;
        int absences;

        Student(int i){
            this.id = i;
        }

        
    }

    static class Course{
        String name;
        int size;
        Student[] students;
        //ArrayList<Student> students= new ArrayList<Student>();

        Course(String n, int s){
            this.name = n;
            this.size = s;
            this.students = new Student[s];
            for(int k=0;k<students.length;k++){
                students[k] = new Student(k);
            }
        }

        void addGrades(int i){
            i-=1;
            Scanner in = new Scanner(System.in);
            int assignment,quiz,term,mt,f,total;
            for(int k=0; k< students.length; k++){
                if(i==students[k].id){
                    int n = k+1;
                    System.out.print("Enter Assignment Grade for Student "+n+" (0-15): ");
                    assignment = in.nextInt();
                    System.out.print("Enter Quiz Grade for Student "+n+" (0-15): ");
                    quiz = in.nextInt();
                    System.out.print("Enter Term Project Grade for Student "+n+" (0-25): ");
                    term  = in.nextInt();
                    System.out.print("Enter MidTerm Grade for Student "+n+" (0-20): ");
                    mt =  in.nextInt();
                    System.out.print("Enter Final Exam Grade for Student "+n+" (0-25): ");
                    f = in.nextInt();

                    total = assignment+quiz+term+mt+f;
                    students[k].grade = total;

                    char grade = getGradeSymbol(total);
                    System.out.println("Student "+n+ " has "+total+" of 100");
                    System.out.println("Letter Grade: "+grade);

                }

            }
            //in.close();
        }

        char getGradeSymbol(int t){
            if(t<60) return 'F';
            if(t<70) return 'D';
            if(t<80) return 'C';
            if(t<90) return 'B';
            if(t>=90) return 'A';

            return 'N';
        }
        void addAbsence(int i, int a){
            int n = i;
            i-=1;
            //Scanner in = new Scanner(System.in);
            
            for(int k=0; k< students.length; k++){
                if(i==students[k].id){
                    students[k].absences = a;
                    String warning = getAbsenceStatus(a);
                    System.out.println("Student "+n+ " has "+a+" absences");
                    System.out.println("Status: "+warning);
                }
            }
        }
        String getAbsenceStatus(int a){
            if (a<3){
               return "Without Warning";
            }
            if(a==3){
                return "First Warning";
            }
            if(a>4){
                return "Second Warning";
            }
            return "null";
        }
    }
}
