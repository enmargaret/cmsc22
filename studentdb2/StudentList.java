package StudentList;

/*
*Created by enmargaret, jezamarts, && noahdominic;
*/

/*
* Modified by enmargaret on 04/11/16;
* */

import java.io.*;
import java.util.*;
import java.lang.*;

public class StudentList {

    public static void main(String[] args) {
        List<Student> stdl = new LinkedList<Student>();
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Student stdinput = new Student();
        BufferedReader br = null;
        Scanner in = new Scanner(System.in);
        String num = "", fname = "",  lname = "",  course = "", crush = "", code = "", desc = "", initial = " ";
        Course fave;
        int year = 0, i = 1;

        try {
            File fin = new File("StudentList.ser");
            if(fin.length() == 0) {
                // file is empty!!
                System.err.println("FILE IS EMPTY. Creating a new file...\n");

            }
            else {
                fis = new FileInputStream(fin);
                ois = new ObjectInputStream(fis);
                stdl = (List<Student>) ois.readObject();

                ois.close();
            }

            int choice = 0;
            while(choice!=6){
                int flag=1;
                System.out.print("\n1.\tRegister a Student\n2.\tSearch Student\n3.\tDelete Student\n4.\tSave Information\n5.\tDisplay Students\n6.\tExit\nChoose which you want to do: ");
                choice = in.nextInt();

                if(choice == 1){
                    while(flag!=0){
                        System.out.print("Student number: ");
                        num = in.next();
                        for(Student temp : stdl){
                            if(num.compareTo(temp.getStudentNumber()) == 0){
                                flag = 0;
                                break;
                            }
                        }
                        if(flag == 1){
                            Scanner input = new Scanner(System.in);
                            System.out.print("Last Name: ");
                            lname = input.nextLine();
                            System.out.print("Middle Initial: ");
                            initial = input.nextLine();
                            System.out.print("First Name: ");
                            fname = input.nextLine();
                            System.out.print("Program: ");
                            course = input.nextLine();
                            System.out.print("Year: ");
                            year = input.nextInt();
                            input = new Scanner(System.in);
                            System.out.println("Favorite Subject:\nCourse Code: ");
                            code = input.nextLine();
                            System.out.println("Course Description: ");
                            desc = input.nextLine();
                            fave = new Course(code, desc);
                            System.out.println("Crush Name: ");
                            crush = input.next();
                            stdinput = new Student(num, fname, initial.charAt(0), lname, course, year, fave,crush);
                            stdl.add(stdinput);
                            flag = 0;
                            System.out.println("Student added!\n");
                            display(stdl);
                            //accept inputs for register
                        }
                        else{
                            System.out.println("Student number already exists!\n");
                            flag = 1;
                            //student number already exists
                        }
                        int ch = 0;
                        while(ch < 1 || ch > 2){
                            System.out.print("\nAdd another student? <1> for YES / <2> for NO: ");
                            ch = in.nextInt();
                            if(ch == 1){
                                flag = 1;
                            }
                            else{
                                flag = 0;
                            }
                        }
                    }
                }
                else if (choice == 2){
                    while(flag!=0){
                        boolean dne = true;
                        System.out.print("\nEnter student number: ");
                        String stnum = in.next();
                        for(Student temp : stdl) {
                            if(stnum.compareTo(temp.getStudentNumber()) == 0){
                                System.out.println(temp);
                                dne = false;
                                break;
                            }
                        }
                        if(dne){
                            System.out.println("Student does not exist!");
                        }
                        int ch = 0;
                        while(ch < 1 || ch > 2){
                            System.out.print("\nSearch another student? <1> for YES / <2> for NO: ");
                            ch = in.nextInt();
                            if(ch == 1){
                                flag = 1;
                            }
                            else{
                                flag = 0;
                            }
                        }
                    }
                }
                else if(choice == 3){
                    while(flag!=0){
                        int j = 0;
                        boolean dne = true;
                        System.out.print("\nEnter student number: ");
                        String stnum = in.next();
                        for(Student temp : stdl){
                            if(stnum.compareTo(temp.getStudentNumber()) == 0){
                                stdl.remove(j);
                                dne = false;
                                break;
                            }
                            j++;
                        }
                        if(dne){
                            System.out.println("Student does not exist!");
                        }
                        int ch = 0;
                        while(ch < 1 || ch > 2){
                            System.out.print("\nRemove another student? <1> for YES / <2> for NO: ");
                            ch = in.nextInt();
                            if(ch == 1){
                                flag = 1;
                            }
                            else{
                                flag = 0;
                            }
                        }
                    }
                }
                else if(choice == 4){
                    try {
                        File fout = new File("StudentList.ser");
                        fos = new FileOutputStream(fout);
                        oos = new ObjectOutputStream(fos);

                        oos.writeObject(stdl);
                        oos.close();
                        System.out.println("Saved!");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(choice == 5){
                    display(stdl);
                }
                else if(choice == 6){
                    System.out.println("Program has been ended.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void display(List<Student> l){
        for(Student temp: l){
            System.out.println(temp+"\n");

        }
    }
}
