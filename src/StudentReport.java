import java.util.*;

public class StudentReport {
    String studentName;
    public int grade;
    static String[] availableCommands = {
        "add grade",
        "get grade",
        "get average grade",
        "get highest grade",
        "get lowest grade",
        "get passing students",
        "get failing students",
        "get total students",
    };

    public StudentReport(String name) {
        studentName = name;
    }

    public void addGrade(int input) {
        if ( input > 100 ) {
            grade = 100;
        } else if (input < 0) {
            grade = 0;
        } else {
            grade = input;
        }
        
    }

    public boolean passing(int boundary) {
        if (grade >= boundary) {
            return true;
        } else {
            return false;
        }
    }

    public static void printAvailableCommands() {
        System.out.println("Student Report Database:");
        for (int i = 0; i < availableCommands.length; i++) {
            int index = i+1;
            System.out.println( index + ". " + availableCommands[i] );
        }
    }

    public static void main(String[] args) {
        boolean fail = false;
        ArrayList<StudentReport> studentList = new ArrayList<>();
        printAvailableCommands();
        while (true) {
            Scanner input = new Scanner(System.in);
            String commandEntered = input.nextLine().toLowerCase();
            if (commandEntered.equals(availableCommands[0]) || commandEntered.equals("1")) {
                System.out.println("Enter student name: ");
                input = new Scanner(System.in);
                StudentReport student = new StudentReport(input.nextLine());
                if (!studentList.contains(student)) {
                    studentList.add(student);
                }
                System.out.println("Enter grade: ");
                int inputGrade;
                while (true) {
                    try {
                        inputGrade = input.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input, try again: ");
                        input = new Scanner(System.in);
                    }
                }
                for (StudentReport obj: studentList) {
                    if (obj.equals(student)) {
                        obj.addGrade(inputGrade);
                    }
                }
            } else if (commandEntered.equals(availableCommands[1]) || commandEntered.equals("2")) {
                System.out.println("Enter student name: ");
                input = new Scanner(System.in);
                StudentReport student = new StudentReport(input.nextLine());
                for (StudentReport obj: studentList) {
                    if (obj.studentName.equals(student.studentName)) {
                        System.out.println("Student has a grade of " + obj.grade);
                        break;
                    } else if (studentList.get((studentList.size() - 1)).equals(obj)) {
                        System.out.println("Student is not found.");
                    }
                }
            } else if (commandEntered.equals(availableCommands[2]) || commandEntered.equals("3")) {
                int outputGrade = 0;
                for (StudentReport obj: studentList) {    
                    outputGrade += obj.grade;
                    outputGrade = outputGrade / studentList.size();
                    
                }
                System.out.println("Average grade is " + outputGrade);
            } else if (commandEntered.equals(availableCommands[3]) || commandEntered.equals("4")) {
                int outputGrade = 0;
                StudentReport studentHighest = null;
                for (StudentReport obj: studentList) {
                    if (outputGrade < obj.grade) {
                        outputGrade = obj.grade;
                        studentHighest = obj;
                    }
                }
                if (studentHighest == null) {
                    System.out.println("List has not been initialized.");
                } else {
                    System.out.println("Highest grade is " + outputGrade + " from " + studentHighest.studentName);
                }
            } else if (commandEntered.equals(availableCommands[4]) || commandEntered.equals("5")) {
                int outputGrade = 100;
                StudentReport studentLowest = null;
                for (StudentReport obj: studentList) {
                    if (outputGrade > obj.grade) {
                        outputGrade = obj.grade;
                        studentLowest = obj;
                    }
                }
                if (studentLowest == null) {
                    System.out.println("List has not been initialized.");
                } else {
                    System.out.println("Lowest grade is " + outputGrade + " from " + studentLowest.studentName);
                }
            } else if (commandEntered.equals(availableCommands[5]) || commandEntered.equals("6")) {
                int studentNumber = 0;
                System.out.println("Enter passing threshold: ");
                int inputGrade;
                while (true) {
                    try {
                        inputGrade = input.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input, try again: ");
                        input = new Scanner(System.in);
                    }
                }
                for (StudentReport obj: studentList) {
                    if (obj.passing(inputGrade)) {
                        studentNumber += 1;
                    }
                }
                System.out.println("The number of students that passed is " + studentNumber);
            } else if (commandEntered.equals(availableCommands[6]) || commandEntered.equals("7")) {
                int studentNumber = 0;
                System.out.println("Enter passing threshold: ");
                int inputGrade;
                while (true) {
                    try {
                        inputGrade = input.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input, try again: ");
                        input = new Scanner(System.in);
                    }
                }
                for (StudentReport obj: studentList) {
                    if (!obj.passing(inputGrade)) {
                        studentNumber += 1;
                    }
                }
                System.out.println("The number of students that failed is " + studentNumber);
            } else if (commandEntered.equals(availableCommands[7]) || commandEntered.equals("8")) {
                System.out.println("Total number of students is " + studentList.size());
            } else {
                System.out.println("Not found. Try again:");
                fail = true;
            }
            if (fail == false) {
                printAvailableCommands();
            }
        }
    }
}
