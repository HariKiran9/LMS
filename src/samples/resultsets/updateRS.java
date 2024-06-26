/*=====================================================================
File: 	 updateRS.java
Summary: This Microsoft JDBC Driver for SQL Server sample application
         demonstrates how to use an updateable result set to insert,
         update, and delete a row of data in a SQL Server database.
----------------------------------------------------------------------
This file is part of the Microsoft JDBC Driver for SQL Server Code Samples.
Copyright (C) Microsoft Corporation.  All rights reserved.
 
This source code is intended only as a supplement to Microsoft
Development Tools and/or on-line documentation.  See these other
materials for detailed information regarding Microsoft code samples.
 
THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF
ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
PARTICULAR PURPOSE.
=====================================================================*/
package samples.resultsets;
import java.sql.*;

public class updateRS {
   
   public static void main(String[] args) {
      
      // Create a variable for the connection string.
      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=AdventureWorks;integratedSecurity=true;";
      
      // Declare the JDBC objects.
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
         
         // Create and execute an SQL statement, retrieving an updateable result set.
         String SQL = "SELECT * FROM HumanResources.Department;";
         stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         rs = stmt.executeQuery(SQL);
         
         // Insert a row of data.
         rs.moveToInsertRow();
         rs.updateString("Name", "Accounting");
         rs.updateString("GroupName", "Executive General and Administration");
         rs.updateString("ModifiedDate", "08/01/2006");
         rs.insertRow();
         
         // Retrieve the inserted row of data and display it.
         SQL = "SELECT * FROM HumanResources.Department WHERE Name = 'Accounting';";
         rs = stmt.executeQuery(SQL);
         displayRow("ADDED ROW", rs);
         
         // Update the row of data.
         rs.first();
         rs.updateString("GroupName", "Finance");
         rs.updateRow();
         
         // Retrieve the updated row of data and display it.
         rs = stmt.executeQuery(SQL);
         displayRow("UPDATED ROW", rs);
         
         // Delete the row of data.
         rs.first();
         rs.deleteRow();
         System.out.println("ROW DELETED");
      }
      
      // Handle any errors that may have occurred.
      catch (Exception e) {
         e.printStackTrace();
      }
      
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {}
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
   }
   
   private static void displayRow(String title, ResultSet rs) {
      try {
         System.out.println(title);
         while (rs.next()) {
            System.out.println(rs.getString("Name") + " : " + rs.getString("GroupName"));
            System.out.println();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}