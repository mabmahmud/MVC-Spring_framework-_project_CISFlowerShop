package info.hccis.parkingPass.main;


/**
 * Controller class is the main class to show the option of Add, Update,View, Delete and Exit
 *
 * @author mrahman2
 * @since Dec 01, 2020
 */

import com.google.gson.Gson;
import info.hccis.parkingPass.model.jpa.Customer;
import info.hccis.parkingPass.util.UtilityRest;
import java.util.Scanner;
import org.json.JSONArray;

public class Controller {

    final public static String MENU = "\nMain Menu \nA) Add\nU) Update\n"
            + "V) View\n"
            + "D) Delete\n"
            + "X) eXit";
    final static Scanner input = new Scanner(System.in);
    private static final String URL_STRING = "http://localhost:8083/api/CustomerService/customers";

    public static void main(String[] args) {
        boolean endProgram = false;
        do {
            System.out.println(MENU);
            String choice = input.nextLine();
            Customer customer;
            String url;
            switch (choice.toUpperCase()) {
                case "A":
                    customer = createCustomer();
                    url = URL_STRING;
                    System.out.println("Url=" + url);
                    UtilityRest.addUsingRest(url, customer);
                    break;
                case "U":
                    customer = createCustomer();
                    url = URL_STRING + "" + customer.getId();
                    System.out.println("Url=" + url);
                    UtilityRest.updateUsingRest(url, customer);
                    break;
                case "D":
                    System.out.println("Enter id to delete");
                    Scanner input = new Scanner(System.in);
                    int id = input.nextInt();
                    input.nextLine();  //burn
                    UtilityRest.deleteUsingRest(URL_STRING, id);
                    break;
                case "V":
                    String jsonReturned = UtilityRest.getJsonFromRest(URL_STRING);
                    //**************************************************************
                    //Based on the json string passed back, loop through each json
                    //object which is a json string in an array of json strings.
                    //*************************************************************
                    JSONArray jsonArray = new JSONArray(jsonReturned);
                    //**************************************************************
                    //For each json object in the array, show the first and last names
                    //**************************************************************
                    System.out.println("Here are the rows");
                    Gson gson = new Gson();
                    for (int currentIndex = 0; currentIndex < jsonArray.length(); currentIndex++) {
                        Customer current = gson.fromJson(jsonArray.getJSONObject(currentIndex).toString(), Customer.class);
                        System.out.println(current.toString());
                    }
                    break;

                case "X":
                    endProgram = true;
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        } while (!endProgram);
    }

    /**
     * Create a customer object by passing asking user for input.
     *
     * @return customer
     * @since 20171117
     * @author BJM
     *
     * Modified by
     * 
     * @author mrahman2
     * @since Dec 01, 2020
     *
     */
    public static Customer createCustomer() {
        Customer newCustomer = new Customer();

        System.out.println("Enter id: (0 for add)");
        newCustomer.setId(Integer.parseInt(input.nextLine()));

        System.out.println("Full Name:");
        newCustomer.setFullName(input.nextLine());

        System.out.println("Address");
        newCustomer.setAddress1(input.nextLine());

        System.out.println("City:");
        newCustomer.setCity(input.nextLine());

        System.out.println("Province:");
        newCustomer.setProvince(input.nextLine());

        System.out.println("Postal Code:");
        newCustomer.setPostalCode(input.nextLine());

        System.out.println("Phone Number:");
        newCustomer.setPhoneNumber(input.nextLine());

        System.out.println("Date of Birth:");
        newCustomer.setBirthDate(input.nextLine());

        System.out.println("Loyalty Card");
        newCustomer.setLoyaltyCard(input.nextLine());

        System.out.println("Customer Type");
        newCustomer.setCustomerTypeDescription(input.nextLine());

        return newCustomer;
    }
}
