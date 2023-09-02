import java.sql.*;
import java.util.*;


public class StudentDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

 String url="jdbc:mysql://localhost:3306/jdbcdemo";
 String username="root";
 String password="Test";
 
 Connection con = DriverManager.getConnection(url,username,password);

Statement stmt=con.createStatement();
ResultSet rs;
PreparedStatement st;

String qry="";
int stu_id,yearofstu,mobilenum;
String sname,dep,city;


Scanner in=new Scanner(System.in);
Scanner str=new Scanner(System.in);

while(true)
{
	
	
   System.out.println("STUDENT MANAGEMENT SYSTEM");
   System.out.println("1. Insert");
   System.out.println("2. Update");
   System.out.println("3. Delete");
   System.out.println("4. Select");
   System.out.println("5. Exit");
   System.out.println("Enter a choice: ");
   
   int choice=in.nextInt();
   System.out.println("-------------------------------------------");
   
	
   switch(choice)
   {
   
   case 1:
	   
	        System.out.println("1. Insert New Data");
	      
	        System.out.println("Enter Name  :");
	        sname=str.nextLine();
	        System.out.println("Enter Departement  :");
	        dep=str.nextLine();
	        System.out.println("Enter YearofStudying :");
	       yearofstu=in.nextInt();
	        System.out.println("Enter MobileNo  :");
	        mobilenum=in.nextInt();
	        System.out.println("Enter City  :");
	        city=str.nextLine();
	        
	     qry="insert into students (SNAME,DEP,YEAROFSTU,MOBILENUM,CITY) values(?,?,?,?,?)";
	     st=con.prepareStatement(qry);
	     st.setString(1,sname);
	     st.setString(2,dep);
	     st.setInt(3,yearofstu);
	     st.setInt(4,mobilenum);
	     st.setString(5,city);
	     
	     int rows=st.executeUpdate();
	     if(rows>0)
	    	 System.out.println("Number of rows affected: "+rows);
	     break;
   case 2:
	   
       System.out.println("2. Update a Data");
       
       System.out.println("Enter ID :");
       stu_id=in.nextInt();
       
       System.out.println("Enter Name  :");
       sname=str.nextLine();
       System.out.println("Enter Departement  :");
       dep=str.nextLine();
       System.out.println("Enter YearofStudying :");
      yearofstu=in.nextInt();
       System.out.println("Enter MobileNo  :");
       mobilenum=in.nextInt();
       System.out.println("Enter City  :");
       city=str.nextLine();
       
    qry="update students set SNAME=?,DEP=?,YEAROFSTU=?,MOBILENUM=?,CITY=? where stu_id=?";
    
    st=con.prepareStatement(qry);
    st.setString(1,sname);
    st.setString(2,dep);
    st.setInt(3,yearofstu);
    st.setInt(4,mobilenum);
    st.setString(5,city);
    st.setInt(6,stu_id);

    int rows1=st.executeUpdate();
    if(rows1>0)
   	 System.out.println("Number of rows affected: "+rows1);
       
       break;
   case 3:
       System.out.println("3. Deleting a Data");
       
       System.out.println("Enter ID :");
       stu_id=in.nextInt();
       qry="delete  from students where stu_id=? ";
       st=con.prepareStatement(qry);
       st.setInt(1,stu_id);
       
    int rows2=  st.executeUpdate();
       if(rows2>0)
    	   System.out.println("Number of rows affected: "+rows2);
       
       break;
   case 4:
	   
       System.out.println("4. Read the records");
       
       qry="select *from students";
       rs=stmt.executeQuery(qry);
       
       while(rs.next())
       {
    	    stu_id=rs.getInt(1);
    	    sname=rs.getString(2);
    	    dep=rs.getString(3);
    	    yearofstu=rs.getInt(4);
    	    mobilenum=rs.getInt(5);
    	    city=rs.getString(6);
    	    
    	    System.out.print(stu_id+" ");
    	    System.out.print(sname+" ");
    	    System.out.print(dep+" ");
    	    System.out.print(yearofstu+" ");
    	    System.out.print(mobilenum+" ");
    	    System.out.println(city+" ");	    
       }
     
       break;
   case 5:
	   
       System.out.println("Thank You");
       System.exit(0);
  
       break;

   default:
    
       System.out.println("Invalid Selection");
       break;
   }

   
}








   }




	}


