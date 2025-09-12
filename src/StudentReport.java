import java.util.*;

public class StudentReport {
    String studentName;
    public int grade;

    public StudentReport(String name) {
        name = studentName;
    }

    public void addGrade(int input) {
        if ( input > 100 ) {
            grade = 100;
        } else if (input < 100) {
            grade = 0;
        } else {
            grade = input;
        }
        
    }

    public int getGrade() {
        return grade; 
    }    

    public boolean passing(int boundary) {
        if (grade >= boundary) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input;
        StudentReport student;
        int inputGrade;
        double outputGrade;
        int studentNumber;
        String commandEntered;
        ArrayList<StudentReport> studentList = new ArrayList<>();
        String[] availableCommands = {
            "add grade",
            "get grade",
            "get average grade",
            "get highest grade",
            "get lowest grade",
            "get passing students",
            "get failing students",
            "get total students",
        };
        System.out.println("Student Report Database:");
        for (int i = 0; i < availableCommands.length; i++) {
            System.out.println( (i+1) + ". " + availableCommands[i] );
        }
        while (true) {
            input = new Scanner(System.in);
            commandEntered = input.nextLine().toLowerCase();
            for (int i = 0; i < availableCommands.length; i++) {
                if (commandEntered.equals(availableCommands[0])) {
                    System.out.println("Enter student name: ");
                    input = new Scanner(System.in);
                    student = new StudentReport(input.nextLine());
                    if (!studentList.contains(student)) {
                        studentList.add(student);
                    }
                    System.out.println("Enter grade: ");
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
                }
                if (commandEntered.equals(availableCommands[1])) {
                    System.out.println("Enter student name: ");
                    input = new Scanner(System.in);
                    student = new StudentReport(input.nextLine());
                    if (!studentList.contains(student)) {
                        studentList.add(student);
                    }
                    for (StudentReport obj: studentList) {
                        if (obj.equals(student)) {
                            System.out.println("Student has a grade of " + obj.grade);
                        }
                    }
                }
                if (commandEntered.equals(availableCommands[2])) {
                    outputGrade = 0;
                    for (StudentReport obj: studentList) {    
                        outputGrade += obj.grade;
                        outputGrade = outputGrade / studentList.size();
                        
                    }
                    System.out.println("Average grade is " + outputGrade);
                }
                if (commandEntered.equals(availableCommands[3])) {
                    outputGrade = 0;
                    for (StudentReport obj: studentList) {
                        if (outputGrade < obj.grade) {
                            outputGrade = obj.grade;
                        }
                    }
                    System.out.println("Highest grade is " + outputGrade);
                }
                if (commandEntered.equals(availableCommands[4])) {
                    outputGrade = 100;
                    for (StudentReport obj: studentList) {
                        if (outputGrade > obj.grade) {
                            outputGrade = obj.grade;
                        }
                    }
                    System.out.println("Lowest grade is " + outputGrade);
                }
                if (commandEntered.equals(availableCommands[5])) {
                    studentNumber = 0;
                    System.out.println("Enter passing threshold: ");
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
                }
                if (commandEntered.equals(availableCommands[5])) {
                    studentNumber = 0;
                    System.out.println("Enter passing threshold: ");
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
                }
                if (commandEntered.equals(availableCommands[7])) {
                    System.out.println("The number of students that failed is " + studentList.size());
                }
                if (commandEntered.equals(availableCommands[i])) {
                    System.out.println("Student Report Database:");
                    for (int j = 0; j < availableCommands.length; j++) {
                        System.out.println( (i+1) + ". " + availableCommands[i] );
                    }
                    break;
                }
            }
        }
    }
}
