import java.util.ArrayList;

import java.util.Scanner;

public class StudentManagementSystem {

    private static ArrayList<Student> students= new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            showMenu();
            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1-> addStudent();
                    
                case 2->deleteStudent();

                case 3->searchStudent();

                case 4->updateStudent();
                
                case 5->displayAll();

                case 6->findHighestLowest();

                case 7->searchById();
                
                case 0->{
                    System.out.println("exit");
                    return ;
                }
            
                default -> System.out.println("invalid choose try again");
                    
            }
        }
    }
    private static  void showMenu(){
        System.out.println("\n--------Student Record Management System--------");
        System.out.println("1.Add Students.");
        System.out.println("2.Delete Students.");
        System.out.println("3.search Students.");
        System.out.println("4.Update Students.");
        System.out.println("5.Display Students.");
        System.out.println("Find Highest & Lowest Marks of students.");
        System.out.println("Search By Id.");
        System.out.println("0. exit.");
        System.out.println("enter your choice.");
    
    
    }   
    private static void addStudent(){

        System.out.println("enter student id");
        int id = sc.nextInt();
        sc.nextLine();

        for(Student s: students){
            if(s.getid()== id){
                System.out.println("the Student with this id is already int our data");
                return ;
            }
        }
        System.out.println("enter the name of student");
        String name = sc.nextLine();

        System.out.println("enter the marks for studen");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("the information added succesfully");
    }
    private static void deleteStudent(){
        System.out.println("enter the id of the student that you want to delete");
        int id = sc.nextInt();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getid()==id){
                students.remove(i);
                System.out.println("student remove succesfully");
                return;

            }
        }
        System.out.println("student was not int the data");
    }
    private static void searchStudent(){
        System.out.println("enter your name of the student that you want to search");
        String name = sc.nextLine();
        boolean found  = false;
        for(Student s: students){
            if (s.getname().equalsIgnoreCase(name)) {
                System.out.println(s);
                found =true;
                
            }
        }
        if(!found){
            System.out.println("the student is not in the list");
        }
    }
    private static void updateStudent(){
        System.out.println("enter the studen id to update");
        int id = sc.nextInt();
        for(Student s:students){
            if(s.getid()== id){
                System.out.println("enter the new name for student");
                String name = sc.nextLine();
                System.out.println("enter the marks for student");
                double marks = sc.nextDouble();

                s.setmarks(marks);
                s.setname(name);
                System.out.println("your new information updated succesfully");
                return ;

            }

        }
        System.out.println("the student was not available in the information");

    }
    private static void displayAll(){
        if(students.isEmpty()){
            System.out.println("there is no any student int our information");

        }
        System.out.println();
        System.out.println("______ALL STUDENTS______");
        for(Student s: students){
            System.out.println(s);
        }
    }
    private static void findHighestLowest(){
        if(students.isEmpty()){
            System.out.println("there are no any student in our data");
            return ;
        }
        Student highest = students.get(0);
        Student lowest = students.get(0);
        for(Student s: students){
            if(s.getmarks()>highest.getmarks()){
                highest =s;
            }
            if(s.getmarks()<lowest.getmarks()){
                lowest = s;
            }
        }
        System.out.println("Highest Marks ->" + highest);
        System.out.println("lowest marks ->"+ lowest);

    }
    private static void searchById(){
        System.out.println("enter the id of the student that you wnat to search");
        int id = sc.nextInt();

        for(Student s: students){
            if(s.getid()==id){
                System.out.println("fount the student");
                System.out.println(s);
                return ;
            }
        }
        System.out.println("the student id"+id+ "does not Exixts");

    }
}