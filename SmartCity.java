package SmartCityProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SmartCity 
{
	
	String cityname,countryname;
	int rank,S_NO;
	String Name,Address,Gender,Ac,Location,Transportation,name,n,Institute,book,college,na,qual,interest,movie;
	int age,Members,Ticket,Number,year;
	double salary;
	Scanner sc=new Scanner(System.in);
	void get()
	{
		System.out.println("**********SMART CITY PROJECT****");
		System.out.println("      Administration modules    ");
		System.out.println("1.TOURISM MODULE");
		System.out.println("2.STUDENT MODULE");
		System.out.println("3.JOBSEEKERS MODULE");
		
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("1.TOURISM MODULE");
			System.out.println("It maintain the details regarding the Hotels,tourist spot,entertaintment source,theaters");
			System.out.println("1.Hotel");
			System.out.println("2.Tourist Spot");
			System.out.println("3.Entertaintment Source");
			System.out.println("4.Theatres");
			System.out.println("Enter your choice");
			int ch1=sc.nextInt();
			switch(ch1)
			{
			case 1:
				System.out.println("1.Hotel");
				System.out.println("Enter the Name:");
				Name=sc.next();
				System.out.println("Enter the Age");
				age=sc.nextInt();
				System.out.println("Enter the Addresss");
				Address=sc.next();
				System.out.println("Enter the Gender");
				Gender=sc.next();
				System.out.println("Enter the Ac or Non Ac:");
				Ac=sc.next();
				System.out.println("YOUR RESPONSE IS ADDED");


				break;
				
		case 2:
			System.out.println("2.Tourist Spot:");
			System.out.println("Which Location you want:");
			Location=sc.next();
			System.out.println("How many members are coming:");
			Members=sc.nextInt();
			System.out.println("You want booking  Transportation like car,bus,van,flight:");
			Transportation=sc.next();
			System.out.println("YOUR RESPONSE IS ADDED");
			System.out.println("THE TOTAL COST IS 1000");
			break;
			
				
		
		case 3:
			System.out.println("3.Entertainment source");
			System.out.println("Enter the name:");
			Name=sc.next();
			System.out.println("Enter the Number of tickets:");
			Ticket=sc.nextInt();
			System.out.println("THE COST IS 1500");
			break;
		case 4:
			System.out.println("4.Theatres");
			System.out.println("Enter the Movie Name :");
			movie=sc.next();
			System.out.println("Enter the Number of Tickets you want:");
			Number=sc.nextInt();
			System.out.println("THE TOTAL COST OF TICKET IS 1200");

			break;
			}
		}
			System.out.println("       STUDENT MODULE        ");
			System.out.println("1.Searching Institute");
			System.out.println("2.Library");
			System.out.println("3.College");
			System.out.println("Enter your choice:");
	
			int ch2=sc.nextInt();
			switch(ch2)
			{
			
				case 1:
					System.out.println("1.Searching Institue");
					System.out.println("Enter the name :");
					n=sc.next();
					System.out.println("Enter the Institute Name:");
					Institute=sc.next();
					break;
				case 2:
					System.out.println("2.Library");
					System.out.println("Enter the book name :");
					book=sc.next();
					System.out.println("your response will be added");
					break;
				case 3:
					System.out.println("3.College");
					System.out.println("Enter the college name :");
					college=sc.next();
					System.out.println("your response will be added");
					break;

					
				}
			
				System.out.println("      JOB SEEKER MODULE    ");
				System.out.println("ENTER THE NAME:");
				na=sc.next();
				System.out.println("QUALIFICATION :");
				qual=sc.next();
				System.out.println("PASSED OUT :");
				year=sc.nextInt();
				System.out.println("ARE YOU INTRESTED IN :");
				interest=sc.next();
				System.out.println("SALARY EXPECTATION :");
				salary=sc.nextDouble();
				System.out.println("YOUR RECORD HAS BEEN ADDED");
				
	}
			
		
			void put()
			{
				System.out.println("NAME: "+na);
				System.out.println("QUALIFICATION:  "+qual);
				System.out.println("PASSED OUT: "+year);
				System.out.println("INTERESTED IN: "+interest);
				System.out.println("SALARY: "+salary);
				System.out.println("ALL THE BEST!!!!!: ");

			}
		
	void createDB() throws ClassNotFoundException, SQLException
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
			PreparedStatement ps=con.prepareStatement("Create Database smartcity ");
			int i=ps.executeUpdate();
			System.out.println(i+"Database Created Successfully");
		}
	void useDB() throws ClassNotFoundException, SQLException
		{
			String sql;
			System.out.println("Connecting to a selected database....");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity","root","root");
			System.out.println("Connected Database successfully");
			java.sql.Statement ps=con.createStatement();
			{
				sql="CREATE TABLE SMARTCITY" +"(S_NO INTEGER not NULL,"+"CityName VARCHAR(255),"+"CountryName VARCHAR(255),"+"Ranking INTEGER(50))";
			}
			ps.executeUpdate(sql);
			System.out.println("Created table in given database");
				
		}
	void InsertRecord()throws ClassNotFoundException
		{
			try
			{
				System.out.println("you want insert  your database:");
				System.out.println("1.YES");
					
				int ch2=sc.nextInt();
				switch(ch2)
				{
				case 1:
					System.out.println("1.YES");
					break;
						
				}
					System.out.println("Enter Your S_NO :");
					S_NO = sc.nextInt();
					System.out.println("Enter your CityName :");
					cityname = sc.next();
					System.out.println("Enter your CountryName :");
					countryname = sc.next();
					System.out.println("Enter your Ranking :");
					rank = sc.nextInt();
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity","root","root");
					PreparedStatement ps=con.prepareStatement("insert into SMARTCITY values(?,?,?,?)");
					ps.setInt(1, S_NO);
					ps.setString(2, cityname);
					String countryName;
					ps.setString(3, countryname);
					ps.setInt(4, rank);
					int i=ps.executeUpdate();
					System.out.println(i+" Record inserted");
					con.close();
					}
				catch(SQLException e)
				{
					System.out.println(e);
				}
			}
		void RetriveRecord() throws SQLException
			 {
				try
				{
					System.out.println("you want retrive your database:");
					System.out.println("1.YES");
					
					int ch3=sc.nextInt();
					switch(ch3)
					{
					case 1:
						System.out.println("1.YES");
						break;
						}


					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity","root","root");
					PreparedStatement ps=con.prepareStatement("Select * from SMARTCITY");
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
					}	
				}
				catch(ClassNotFoundException e)
				{
					System.out.println(e);
				}
			 }
			
		void UpdateRecord()throws ClassNotFoundException
			{
				try
				{
					System.out.println("Enter the S_NO :");
					S_NO=sc.nextInt();
					System.out.println("Enter the CityName");
					cityname=sc.next();
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity","root","root");
					PreparedStatement ps=con.prepareStatement("UPDATE SMARTCITY SET cityname=? where S_NO=?");
					ps.setString(1, cityname);
					ps.setInt(2, S_NO);
					int i=ps.executeUpdate();
					System.out.println(i+" Record updated");
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			
		 

public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		SmartCity sc=new SmartCity();
		//sc.get();
		//sc.put();
		//sc.createDB();
		//sc.useDB();
		//sc.InsertRecord();
		sc.RetriveRecord();
		//sc.UpdateRecord();
		
	}

}

