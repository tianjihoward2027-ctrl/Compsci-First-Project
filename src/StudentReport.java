import java.util.*;

public class StudentReport {
    String studentName;
    public int grade;
    static StudentReport lastStudent;
    static ArrayList<StudentReport> studentList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    static String[] availableCommands = {
        "add grade",
        "edit grade",
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

    public static void refreshLastStudentVar() {
        try {
            lastStudent = studentList.get((studentList.size() - 1));
        } catch (Exception e) {
            lastStudent = new StudentReport(null);
        }
    }

    public static int inputGrade() {
        while (true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input, try again: ");
                input = new Scanner(System.in);
            }
        }
    }

    public static void main(String[] args) {
        printAvailableCommands();
        while (true) {
            input = new Scanner(System.in);
            String commandEntered = input.nextLine().toLowerCase();
            refreshLastStudentVar();
            checker: for (int i = 0; i < availableCommands.length; i++) {
                int onebasedIndex = i+1;
                int inputGrade;
                if (commandEntered.equals(availableCommands[0]) || commandEntered.equals(Integer.toString(1))) {
                    System.out.println("Enter student name: ");
                    input = new Scanner(System.in);
                    String nameInput = input.nextLine();
                    StudentReport student = new StudentReport(nameInput);
                    for (StudentReport obj: studentList) {
                        if (obj.studentName.equals(nameInput)) {
                            System.out.println("Student has already been added.");
                            printAvailableCommands();
                            break checker;
                        }
                    }
                    studentList.add(student); 
                    System.out.println("Enter grade: ");
                    inputGrade = inputGrade();
                    refreshLastStudentVar();
                    lastStudent.addGrade(inputGrade);
                    break;
                } else if (commandEntered.equals(availableCommands[i]) || commandEntered.equals(Integer.toString(onebasedIndex))) {
                    if (!(studentList.size() > 0) || i != 0) {
                        System.out.println("List has not been initialized.");   
                        break;
                    }
                    switcher: switch (i) {
                        case 1: 
                            System.out.println("Enter student name: ");
                            for (StudentReport obj: studentList) {
                                if (obj.equals(lastStudent)) {
                                    System.out.println("Student is not found.");
                                    break switcher;
                                }
                            }
                            input = new Scanner(System.in);
                            String nameInput = input.nextLine();
                            refreshLastStudentVar();
                            System.out.println("Enter grade: ");
                            inputGrade = inputGrade();
                            for (StudentReport obj: studentList) {
                                if (obj.studentName.equals(nameInput)) {
                                   obj.addGrade(inputGrade);
                                }
                            }
                            break;
                        case 2:
                        if (!(studentList.size() > 0)) {
                                System.out.println("List has not been initialized.");   
                                break;
                            } 
                            System.out.println("Enter student name: ");
                            input = new Scanner(System.in);
                            nameInput = input.nextLine().toLowerCase();
                            refreshLastStudentVar();
                            for (StudentReport obj: studentList) {
                                if (obj.studentName.toLowerCase().equals(nameInput)) {
                                    System.out.println(obj.studentName + " has a grade of " + obj.grade);
                                    break;
                                } else if (obj.equals(lastStudent)) {
                                    System.out.println("Student is not found.");
                                }
                            }
                            break;
                        case 3:
                            int outputGrade = 0;
                            for (StudentReport obj: studentList) {    
                                outputGrade += obj.grade;
                                outputGrade = outputGrade / studentList.size();
                            }
                            System.out.println("Average grade is " + outputGrade);
                            break;
                        case 4:
                            outputGrade = 0;
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
                        case 5:
                            outputGrade = 100;
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
                        case 6:
                            int studentNumber = 0;
                            System.out.println("Enter passing threshold: ");
                            inputGrade = inputGrade();
                            for (StudentReport obj: studentList) {
                                if (obj.passing(inputGrade)) {
                                    studentNumber += 1;
                                }
                            }
                            System.out.println("The number of students that passed is " + studentNumber);
                            break;
                        case 7:
                            studentNumber = 0;
                            System.out.println("Enter passing threshold: ");
                            inputGrade = inputGrade();
                            for (StudentReport obj: studentList) {
                                if (!obj.passing(inputGrade)) {
                                    studentNumber += 1;
                                }
                            }
                            System.out.println("The number of students that failed is " + studentNumber);
                            break;
                        case 8:
                            System.out.println("Total number of students is " + studentList.size());
                            break;
                    }
                    printAvailableCommands();
                    break;
                } else if (onebasedIndex == availableCommands.length) {
                    System.out.println("Not found. Try again:");
                }
            }
        }
    }
}
