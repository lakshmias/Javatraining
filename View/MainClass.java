package com.dal.View;

import com.dal.Controller.EmpController;
import com.dal.Controller.EmployeeInterface;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.dal.exception.UserNtFoundException;

public class MainClass {

	public static void main(String[] args) throws IOException {

		try {
			String username = null;
			String Password = null;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.println("Enter Username: ");
			username = br.readLine();

			System.out.println("Enter Password: ");
			Password = br.readLine();

			if (username.equals("devi") && Password.equals("password")) {
				System.out.println("Welcome " + username);
			} else {
				throw new UserNtFoundException();
			}

			System.out.println("Welcome");
			EmployeeInterface ec = new EmpController();

			Scanner sc = new Scanner(System.in);
			String choice = null;

			do {
				System.out.println("Enter your choice");
				System.out.println("1.Add Employee");
				System.out.println("2. View Employee ");
				System.out.println("3. serialize ");
				System.out.println("4. Deserialize ");
				System.out.println("5. sortbyID ");
				System.out.println("6. sortbyName ");
				int sch = sc.nextInt();
				switch (sch) {
				case 1: {
					ec.addEmp();
					break;
				}
				case 2: {
					ec.viewEmp();
					break;
				}
				case 3: {
					ec.SerialEg();
					break;
				}
				case 4: {
					ec.Deserial();
					break;
				}
				case 5: {
					ec.sortByEid();
					break;
				}
				case 6: {
					ec.sortByEname();
					break;
				}
				default: {
					System.out.println("Enter your choice");
					break;
				}
				}
				System.out.println("Do you want to continue Y or y");
				choice = sc.next();
			} while (choice.equals("Y") || choice.equals("y"));

			System.out.println("Exited");
			System.exit(0);

		}

		catch (UserNtFoundException unf) {
			System.out.println(unf);
		}

	}

}
