package codsoft;
import java.util.*;

class Course {
    String courseCode, title, description, schedule;
    int capacity;
    
    Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    String studentID, name;
    List<Course> registeredCourses;
    
    Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

public class TASK5 {
    static List<Course> courses = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        seedData();
        while (true) {
        	System.out.println("Enrollment Section");
            System.out.println("\n1.Courses Offered\n2.Register Student\n3.Register for Course\n4.Drop Course\n5.Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: listCourses(); break;
                case 2: registerStudent(); break;
                case 3: registerForCourse(); break;
                case 4: dropCourse(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void seedData() {
        courses.add(new Course("CS2001", "Data Structures Algorithms", "Learn about data structures",250 , "Mon-Wed 10AM"));
        courses.add(new Course("CS1004", "Introductory Graph Theory", "Learn about graph theory", 500, "Tue-Fri 2PM"));
        courses.add(new Course("MTH2101", "Calculus", "Learn about calculus", 600, "Mon-Fri 7PM"));
        courses.add(new Course("AMC1001", "Concepts of Indian Knowledge System", "Learn about Indian knowledge system", 50, "Tue-Thu 3PM"));
        
    }
    
    static void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            System.out.println(course.courseCode + " - " + course.title + " | Seats: " + course.capacity + " | " + course.schedule);
        }
    }
    
    static void registerStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student registered successfully!");
    }
    
    static void registerForCourse() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        Student student = findStudent(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        listCourses();
        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();
        Course course = findCourse(code);
        if (course == null || course.capacity <= 0) {
            System.out.println("Course not found or full!");
            return;
        }
        
        student.registeredCourses.add(course);
        course.capacity--;
        System.out.println("Registered successfully");
        System.out.println("Remaining Seats: " + course.capacity);
    }
   
    static void dropCourse() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        Student student = findStudent(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        if (student.registeredCourses.isEmpty()) {
            System.out.println("No registered courses to drop!");
            return;
        }
        
        System.out.println("Registered Courses:");
        for (Course course : student.registeredCourses) {
            System.out.println(course.courseCode + " - " + course.title);
        }
        
        System.out.print("Enter Course Code to Drop: ");
        String code = scanner.nextLine();
        Course course = findCourse(code);
        if (course == null || !student.registeredCourses.remove(course)) {
            System.out.println("Course not found in student's list!");
            return;
        }
        
        course.capacity++;
        System.out.println("Dropped successfully! Updated Capacity: " + course.capacity);
    }
    
    static Student findStudent(String id) {
        for (Student student : students) {
            if (student.studentID.equals(id)) return student;
        }
        return null;
    }
    
    static Course findCourse(String code) {
        for (Course course : courses) {
            if (course.courseCode.equals(code)) return course;
        }
        return null;
    }
}




