package customerlist;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CustomerDatabase {

	private DataSource dataSource;
	
	public CustomerDatabase(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Customer> getCustomers() throws Exception {
		
		List<Customer> customers = new ArrayList<>();
		
		Connection connections = null;
		Statement statements = null;
		ResultSet resultsets = null;
		
		try {
			// create connections, connect to mysql database
			connections = dataSource.getConnection();
			
			// create sql query
			String sql = "select * from customer order by last_name";
			
			statements = connections.createStatement();
			
			// execute sql query 
			resultsets = statements.executeQuery(sql);
			
			// get result set
			while (resultsets.next()) {
				
				// access data from result set
				int id = resultsets.getInt("id");
				String firstName = resultsets.getString("first_name");
				String lastName = resultsets.getString("last_name");
				String email = resultsets.getString("email");
				String service = resultsets.getString("service");
				String price = resultsets.getString("price");
				
				// create new customer object
				Customer tempCustomer = new Customer(id, firstName, lastName, email, service, price);
				
				// add to the list of customers
				customers.add(tempCustomer);				
			}
			
			return customers;		
		}
		finally {
			// close JDBC objects
			close(connections, statements, resultsets);
		}		
	}

	private void close(Connection connections, Statement statements, ResultSet resultsets) {

		try {
			if (resultsets != null) {
				resultsets.close();
			}
			
			if (statements != null) {
				statements.close();
			}
			
			if (connections != null) {
				connections.close();   
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addCustomer(Customer theCustomer) throws Exception {

		Connection connections = null;
		PreparedStatement statements = null;
		
		try {
			// create connections, connect to mysql database
			connections = dataSource.getConnection();
			
			// create sql insert statement
			String sql = "insert into customer "
					   + "(first_name, last_name, email, service, price) "
					   + "values (?, ?, ?, ?, ?)";
			
			statements = connections.prepareStatement(sql);
			
			// set the values of the parameters for the customer
			statements.setString(1, theCustomer.getFirstName());
			statements.setString(2, theCustomer.getLastName());
			statements.setString(3, theCustomer.getEmail());
			statements.setString(4, theCustomer.getService());
			statements.setString(5, theCustomer.getPrice());
			
			// execute sql statement
			statements.execute();
		}
		finally {
			// close JDBC objects
			close(connections, statements, null);
		}
	}

	public Customer getCustomer(String theCustomerId) throws Exception {

		Customer theCustomer = null;
		
		Connection connections = null;
		PreparedStatement statements = null;
		ResultSet resultsets = null;
		int customerId;
		
		try {
			// convert string to int
			customerId = Integer.parseInt(theCustomerId);
			
			// create connections, connect to mysql database
			connections = dataSource.getConnection();
			
			// create sql query
			String sql = "select * from customer where id=?";
			
			// create preparestatements
			statements = connections.prepareStatement(sql);
			
			// set parameters for customer
			statements.setInt(1, customerId);
			
			// execute sql query
			resultsets = statements.executeQuery();
			
			// get result set
			if (resultsets.next()) {
				String firstName = resultsets.getString("first_name");
				String lastName = resultsets.getString("last_name");
				String email = resultsets.getString("email");
				String service = resultsets.getString("service");
				String price = resultsets.getString("price");
				
				theCustomer = new Customer(customerId, firstName, lastName, email, service, price);
			}
			else {
				throw new Exception("Could not find customer id: " + customerId);
			}				
			
			return theCustomer;
		}
		finally {
			// close JDBC objects
			close(connections, statements, resultsets);
		}
	}

	public void editCustomer(Customer theCustomer) throws Exception {
		
		Connection connections = null;
		PreparedStatement statements = null;

		try {
			// create connections, connect to mysql database
			connections = dataSource.getConnection();
			
			// create sql edit statement
			String sql = "update customer "
						+ "set first_name=?, last_name=?, email=? ,service=?, price=?"
						+ "where id=?";
			
			// create prepare statement
			statements = connections.prepareStatement(sql);
			
			// set parameters for the customer
			statements.setString(1, theCustomer.getFirstName());
			statements.setString(2, theCustomer.getLastName());
			statements.setString(3, theCustomer.getEmail());
			statements.setString(4, theCustomer.getService());
			statements.setString(5, theCustomer.getPrice());
			statements.setInt(6, theCustomer.getId());
			
			// execute statement
			statements.execute();
		}
		finally {
			// close JDBC objects
			close(connections, statements, null);
		}
	}

	public void removeCustomer(String theCustomerId) throws Exception {

		Connection connections = null;
		PreparedStatement statements = null;
		
		try {
			// convert string to int
			int customerId = Integer.parseInt(theCustomerId);
			
			// connect to mysql database
			connections = dataSource.getConnection();
			
			// create sql delete
			String sql = "delete from customer where id=?";
			
			// create prepare statement
			statements = connections.prepareStatement(sql);
			
			// set parameters of the customer
			statements.setInt(1, customerId);
			
			// execute sql statement
			statements.execute();
		}
		finally {
			// close JDBC code
			close(connections, statements, null);
		}	
	}
}