/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.resources;

/**
 *
 * @author mtirn
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class RandomQuoteExample {

    public static void main(String[] args) throws IOException {
        // Make a request to the API
        URL url = new URL("https://api.quotable.io/random");
        InputStream input = url.openStream();

        // Read the response into a string
        Scanner scanner = new Scanner(input);
        String response = scanner.useDelimiter("\\A").next();

        // Extract the quote from the response
        String quote = response.substring(response.indexOf("content") + 10, response.indexOf("author") - 3);

        // Print the quote
        System.out.println(quote);
    }
}
