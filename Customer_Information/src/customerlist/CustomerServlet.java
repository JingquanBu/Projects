package customerlist;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.List;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  CustomerDatabase customerdatabase;
	
	@Resource(name="jdbc/Customer_Information")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			customerdatabase = new CustomerDatabase(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read parameter from command
			String theCommand = request.getParameter("command");
			
			// in case the command is missing, then default to listing customers
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// access to the right command
			switch (theCommand) {
			
			case "LIST":
				listCustomers(request, response);
				break;
				
			case "ADD":
				addCustomer(request, response);
				break;
				
			case "LOAD":
				loadCustomer(request, response);
				break;
				
			case "EDIT":
				editCustomer(request, response);
				break;
			
			case "REMOVE":
				removeCustomer(request, response);
				break;
				
			default:
				listCustomers(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void removeCustomer(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// get customer id from form database
		String theCustomerId = request.getParameter("customerId");
		
		// remove object customer from database
		customerdatabase.removeCustomer(theCustomerId);
		
		// send them back to list customers
		listCustomers(request, response);
	}

	private void editCustomer(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// get parameters of the customer from form database
		int id = Integer.parseInt(request.getParameter("customerId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String service = request.getParameter("service");
		String price = request.getParameter("price");
		
		// create a customer object
		Customer theCustomer = new Customer(id, firstName, lastName, email, service, price);
		
		// excecute edit method
		customerdatabase.editCustomer(theCustomer);
		
		// send them back to the list customers
		listCustomers(request, response);
		
	}

	private void loadCustomer(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read customer id from database
		String theCustomerId = request.getParameter("customerId");
		
		// get customers from customer database
		Customer theCustomer = customerdatabase.getCustomer(theCustomerId);
		
		// set customer in the request attribute
		request.setAttribute("THE_CUSTOMER", theCustomer);
		
		// send to jsp page: editCustomer.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/editCustomer.jsp");
		dispatcher.forward(request, response);		
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get parameters of the customer from data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");	
		String service = request.getParameter("service");
		String price = request.getParameter("price");
		
		// create customer object
		Customer theCustomer = new Customer(firstName, lastName, email, service, price);
		
		// add the new customer to the database
		customerdatabase.addCustomer(theCustomer);
				
		// send back to list customers
		listCustomers(request, response);
	}
		
	private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get customers from mysql database
		List<Customer> customers = customerdatabase.getCustomers();

		// add customers to the request
		request.setAttribute("CUSTOMER_LIST", customers);

		// send to JSP file
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listCustomers.jsp");
		dispatcher.forward(request, response);
	}
	
}



