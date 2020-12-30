package info.hccis.parkingPass.util;

import com.google.gson.Gson;
import info.hccis.parkingPass.model.jpa.Customer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author bjmaclean
 * @since Nov 17, 2017
 *
 * Modified by 
 * 
 * @author mrahman2
 * @since Dec 01, 2020
 */
public class UtilityRest {

    /**
     * This method will call the rest web service and give back the json
     *
     * @since 20171117
     * @author BJM
     *
     * Modified by 
     * 
     * @author mrahman2
     * @since Dec 01, 2020
     */
    public static String getJsonFromRest(String urlString) {

        String content = "";
        try {

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() == 204) {
                System.out.println("No data found");
            } else if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                content += output;
            }

            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * This method will access the CustomerService to get all of the customers
     * from the customer web application service.
     *
     * @since 20161115
     * @author BJM
     *
     * Modified by 
     * 
     * @author mrahman2
     * @since Dec 01, 2020
     */
    public static void addUsingRest(String urlIn, Object objectIn) {
        //**********************************
        //Create a test customer
        //**********************************

        Gson gson = new Gson();
        String temp = "";

        //************************************
        //convert the customer to a json string
        //************************************
        temp = gson.toJson(objectIn);

        //*********************************************
        // Access the rest web service
        //https://www.tutorialspoint.com/restful/restful_quick_guide.htm
        //*********************************************
        try {

            URL url = new URL(urlIn);
            //System.out.println(urlIn);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            //System.out.println("json=" + temp);
            String input = temp;

            //Write the bytes of json to the output stream for the connection.
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                System.out.println("Failed : HTTP error code : "
                        + conn.getResponseCode()
                        + conn.getResponseMessage());
            } else {

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                String content = "";
                while ((output = br.readLine()) != null) {
                    content += output;
                }
                Customer customerReturned = gson.fromJson(content, Customer.class);
                System.out.println("Success : Added booking (" + customerReturned.getId() + ")\n");
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method will access the CustomerService to get all of the customers
     * from the customer web application service.
     *
     * @since 20161115
     * @author BJM
     *
     * Modified by 
     * @author mrahman2
     * @since Dec 01, 2020
     */
    public static void updateUsingRest(String urlIn, Customer customer) {
        //**********************************
        //Create a test customer
        //**********************************

        Gson gson = new Gson();
        String temp = "";

        //************************************
        //convert the customer to a json string
        //************************************
        temp = gson.toJson(customer);

        //*********************************************
        // Access the rest web service
        //https://www.tutorialspoint.com/restful/restful_quick_guide.htm
        //*********************************************
        try {

            URL url = new URL(urlIn);
            //System.out.println(urlIn);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            //System.out.println("json=" + temp);
            String input = temp;

            //Write the bytes of json to the output stream for the connection.
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                System.out.println("Failed : HTTP error code : "
                        + conn.getResponseCode()
                        + conn.getResponseMessage());
            } else {

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                String content = "";
                while ((output = br.readLine()) != null) {
                    content += output;
                }
                Customer customerReturned = gson.fromJson(content, Customer.class);
                System.out.println("Success : Updated booking (" + customerReturned.getId() + ")\n");
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method will access the customer service to delete a customer
     *
     * @since 20200618
     * @author BJM
     *
     * Modified by 
     * 
     * @author mrahman2
     * @since Dec 01, 2020
     */
    public static void deleteUsingRest(String urlIn, int id) {
        //*********************************************
        // Access the rest web service
        //https://www.tutorialspoint.com/restful/restful_quick_guide.htm
        //*********************************************
        try {

            URL url = new URL(urlIn + id);
            //System.out.println(urlIn);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            //Write the bytes of json to the output stream for the connection.
            OutputStream os = conn.getOutputStream();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                System.out.println("Failed : HTTP error code : "
                        + conn.getResponseCode()
                        + conn.getResponseMessage());
            } else {

                System.out.println("Success : deleted customer (" + id + ")\n");
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
