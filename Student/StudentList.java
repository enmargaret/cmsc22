/*
*Created by enmargaret, jezamarts, && noahdominic
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class StudentList {

	public static void main(String[] args) {
		List<Student> stdl = new LinkedList<Student>();
		Student stdinput = new Student();
		BufferedReader br = null;
		Scanner in = new Scanner(System.in);
		String num = "", fname = "",  lname = "",  course = "";
		char initial = ' ';
		int year = 0, i = 1;
		
        try {
            String sCurrentLine;

            br = new BufferedReader(new FileReader("db.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
          
                if(i == 1){
					num = sCurrentLine;
                }
                else if(i == 2){
					fname = sCurrentLine;
				}
                else if(i == 3){
					initial = sCurrentLine.charAt(0);
                }
                else if(i == 4){
					lname = sCurrentLine;
                }
                else if(i == 5){
					course = sCurrentLine;
                }
                else if(i == 6){
					i = 0;
					try{
						year = Integer.parseInt(sCurrentLine);
	        		} catch (NumberFormatException e){
	        			e.printStackTrace();
	        		}
					//year = Integer.parseInt(sCurrentLine);
					//year = sCurrentLine;
					stdinput = new Student(num, fname, initial, lname, course, year);
					stdl.add(stdinput);
                }
                i++;
            }
            
            Iterator<Student> iterator = stdl.iterator();
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
							initial = input.nextLine().charAt(0);
							System.out.print("First Name: ");
							fname = input.nextLine();
							System.out.print("Program: ");
							course = input.nextLine();
							System.out.print("\nYear: ");
							year = input.nextInt();
							stdinput = new Student(num, fname, initial, lname, course, year);
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
        	            File file = new File("db.txt");
        	            if (!file.exists()) {
        	                file.createNewFile();
        	            }
        	            BufferedWriter bw = new BufferedWriter(new FileWriter(file));	
        	            for(Student temp : stdl){
							bw.write(temp.getStudentNumber());     
	        	            bw.newLine();
	        				bw.write(temp.getFirstName());     
	        	            bw.newLine();
							bw.write(temp.getMiddleInitial());     
	        	            bw.newLine();
							bw.write(temp.getLastName());    
	        	            bw.newLine();
							bw.write(temp.getCourse());    
	        	            bw.newLine();
							String yr = String.valueOf(temp.getYearLevel());
							bw.write(yr);
	        	            bw.newLine();
		        		}
        	            bw.close();
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
