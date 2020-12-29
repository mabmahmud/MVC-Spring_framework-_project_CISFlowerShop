# MVC-Spring_framework-_project_CISFlowerShop
CIS2232 Advanced OOP

Project Requirements
CIS Flower Shop
AYR 20202021 



Contents
Overview	2
Additional Resources	2
Common Requirements:	3
Database Notes:	3
Distribution of work	3
Project Requirements	4
Business Requirements	4
File I/O	4
Requirement 1 – Save Orders to File	4
Requirement 2 – Save Customer Information to File	4
Web Application	5
Requirement 3 – Order CRUD	5
Requirement 4 – Customer CRUD	5
Web Application Reports	5
Requirement 5 – Monthly Order Summary	5
Requirement 6 – Show Customer Summary	5
Web Services	5
Requirement 7 – Order Service	5
Requirement 8 – Customer Service	6
Appendix A: Team Assignments	7
Appendix B: Issues Backlog	8
Appendix C: Item Details from 1201	10



Overview
Welcome to the CIS2232 project.  It will require implementation of the basic outcomes of the course.  The project must work with the environment for the CIS development team.  The system code will adhere to CIS standards.  This includes naming and commenting conventions. The project should follow an object-oriented design with packages used to organize classes.  These are constraints put on the development based on the organizational standards.
Although most of the requirements are individual, teams must complete some together.  
•	The project manager (aka learning manager) will assign a color scheme to each team.
•	The developer will build the system according to Object-oriented design principles.   
•	The createDatabase.sql file will create the application database.  The learning manager must approve any changes to the database structure.  
•	The due dates for sprints are contained in the SAM calendar.
Additional Resources
CIS Website	http://www.hollandcollege.com/programs/computer-information-systems/

Create database script	To be provided in CIS2232_20202021_project repository.
	

Common Requirements:
•	All projects must have an about option.  In this page, the information about the developers must be provided.
•	Developer to use Bitbucket for project version control.  The developer must complete the readme in Bitbucket for the project.
Database Notes:
•	When deploying to Linux database table and field names are case sensitive!  Be sure to use database-naming standards and be case specific in your Java code.  Things may work localhost but not when deployed to the Linux web server.
•	The foreign key constraints are not part of this project. This is to simplify the class structure while using Spring Data JPA.
•	Most dates are stored as varchar(8) and yyyymmdd format.
Distribution of work
Teams of developers will complete the project.  Working together will be encouraged, but the assigned tasks are independent of one another.  Working as a team will allow a more real-life experience.  Each developer is responsible for only their assigned requirements.  See Appendix A for team assignments.
Name	Business Requirements
Team member 1	1,3,5,7
Team member 2	2,4,6,8
	

Project Requirements
Your team has been asked to build a flower shop sales system.  This would be used by a flower shop to administer sales.  This activity can grow to be quite complex, so the scope is to be limited in scope for this version.  
Business Requirements  

The core functionality of the system will be to allow the business to administer their business.  There are components which would be required to make this possible.
The cisadmin application can be used to administer the users.  This is not something that needs to be built into the new application.  
File I/O
Requirement 1 – Save Orders to File
Provide the ability to save order data to file using json format.  All the information from the Order table should be written to the file.  The filename should be c:\flowers\orders_yyyymmddhhmmss.json where the yyyymmddhhmmss is replaced with the date and time that the report was run.

Requirement 2 – Save Customer Information to File
Provide the ability to save customer data to file using json format.  All of the information from the Customer table should be written to the file.  The filename should be c:\flowers\customers_yyyymmddhhmmss.json where the yyyymmddhhmmss is replaced with the date and time that the report was run. 
Web Application
Requirement 3 – Order CRUD
Provide the ability to create, read, update and delete Order data.  When the user selects the customer, they should be able to pick from a drop down of customer names and the associated customer id will be stored in the database.  The user is to enter the number of each type of item that they want to order.  It would be good to be able to see the name of the item from the database ItemType reference table.
Requirement 4 – Customer CRUD
Provide the ability to create, read, update and delete data.  When the user is to provide the customer type, they should be able to choose from a drop-down list of values obtained from a reference table.
Web Application Reports
Requirement 5 – Monthly Order Summary
This report should allow the user to specify the date range for a report.  The report should then show all the orders and a summary of the total.
Requirement 6 – Show Customer Summary
The user should be able choose a customer.  The system should then give a summary of the orders for that customer along with a total of the orders.
Web Services
The web services should follow REST standards including the response codes when data is found, not found, inserted, not inserted, etc.
Requirement 7 – Order Service
These services should provide get/post services 
Get
…/api/OrderService/orders
…/api/OrderService/orders/1

Post (to insert an order)
…/api/OrderService/orders/

Requirement 8 – Customer Service
These services should provide get/post services 
Get
…/api/CustomerService/customers
…/api/CustomerService/customers/1

Post (to insert)
…/api/CustomerService/customers


 
Appendix A: Team Assignments
https://en.wikipedia.org/wiki/List_of_colors:_A%E2%80%93F
Taupe
1 Karen
2 Jeff	Black
1 Mohammad
2 Tristan	Orange
1 Brody
2 Cameron

Yellow
1 Cole
2 Devin
	Grey
1 Junior
2 Khari
	Beige
1 Katie
2 Elodie


Green
1 Megha
2 Michael	Brown
1 Neil
2 Rodney	Red
1 Ryan
2 Sean


Vanilla
1 Tariq
2 Tiago
	Pumpkin
1 Vado
2 Recko

	Copper
1 Jon
2 Connor
Aero
1 Angelo
2 Kevin	Amber
1 Logan
2 Parker	Blue
1 Kalyon

 
Appendix B: Issues Backlog

Initial Setup
•	Bitbucket repository created with naming convention:  
o	cis2232_20192020_project_colorname
•	Readme created and committed
•	BJ MacLean setup as collaborator with write access
•	Make sure issues tracking is turned on.  
•	Team members added to repository
•	Trello Boards or issues tracking updated to manage the project completion tasks.  These should be assigned to the appropriate team members.
Sprint 1 Setup
•	Color scheme setup based on team name.  Based on your team color, apply the color to your project.
•	Ability to run the initial version of the project.
Sprint 2 File I/O & JDBC
•	Requirements 1,2
Sprint 3 MVC
•	3,4,5,6
Sprint 4 Web Services
•	7,8
Sprint 5 Project Wrap-up
•	Web application is tested on a computer 
•	Any issues are updated in Bitbucket
•	messages.properties file used to allow multi-language support (html/Java)  List and add page should not have any hard coded text and should obtain text from the messages.properties file.
•	Programmer validates commenting standards
•	About page should list the team members along with the team member #.
•	Demo provided during schedule demo time.
•	Check-in the final code from Bitbucket to SAM drop box.
 
Appendix C: Item Details from 1201
public static final String BUSINESS_NAME = "Bernadette's Flowers";
public static final String BUSINESS_ADDRESS = "25 Hopeton Road\nStratford, PE\nC1B 1H6";
public static final double TAX_RATE = 0.15;
public static final double COST_LARGE = 500;
public static final double COST_STUFFED_SMALL = 10;
public static final double COST_STUFFED_MEDIUM = 20;
public static final double COST_STUFFED_LARGE = 30;
//New array attributes to be used
public static final String[] NAME_BOUQUETS = {"Welcome Baby Boy", "Welcome Baby Girl", "Very Special Delivery"};
public static final double[] COST_BOUQUETS = {90, 85, 100};

Sample I/O 
--- exec-maven-plugin:1.5.0:exec (default-cli) @ Assignment7MacLeanBruce ---
Bernadette's Flowers
25 Hopeton Road
Stratford, PE
C1B 1H6
Main Menu
1 – Add an order
2 – Show total of all orders since program start
0 – Exit
2
Total so far: $0.00
Main Menu
1 – Add an order
2 – Show total of all orders since program start
0 – Exit
1
Customer details
Name (First Last):
bill smith
Address line 1:
Room 107w
Address line 2:
104 Weymouth Street
Postal Code:
c1a 4z1
Phone number (999-999-9999):
902-566-2222
How many 'Welcome Baby Boy' bouquets?
10
How many 'Welcome Baby Girl' bouquets?
5
How many 'Very Special Delivery' bouquets?
4
How many 'Bridal Shower' bouquets?
0
Stuffed animal option (1=Small 2=Medium 3=Large 0=None):
0
Order Summary (Large Order!)
Customer: Bill Smith
Room 107w
104 Weymouth Street
C1A 4Z1
902-566-2222
Number of Welcome Baby Boy bouquets: 10
Number of Welcome Baby Girl bouquets: 5
Number of Very Special Delivery bouquets: 4
Number of Bridal Shower bouquets: 0
Stuffed Animal: None
Subtotal: $1,725.00
Tax: $258.75
Total Cost: $1,983.75
Main Menu
1 – Add an order
2 – Show total of all orders since program start
0 – Exit
2
Total so far: $1,983.75
Main Menu
1 – Add an order
2 – Show total of all orders since program start
0 – Exit
0
Goodbye


