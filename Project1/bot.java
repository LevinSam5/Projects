import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jibble.pircbot.*;
// extend the main pircbot class
// This class is the main logic of your pircbot, where you will implement any functionality
public class bot extends PircBot{
	// constructor
	boolean cityResponse = false;
	public bot() {
		this.setName("myBotLevin2"); // this is the name the bot will use to join the IRC server
		
	}
	protected void onJoin(String channel, String sender, String login, String hostname) { // opening message
		sendMessage(channel, "Hey! I am a bot that can tell you weather information about any city "
				+ "and I give quotes from randomized famous people! Go on, try me out!");	
	}
	// every time a message is sent, this method will be called and this information will be passed on
	// this is how you read a message from the channel
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		// use this function to read the message that comes in
		// For example, you can have an if statement that says:
		    
			if (message.contains("Bye") || message.contains("bye")) { // terminating program
				sendMessage(channel, "Hope you had fun! See you next time.");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				disconnect(); // to exit immediately
			}
		
			else if (cityResponse) { // depending on the cityResponse, if the response is a city
				weatherAPI data = new weatherAPI(); // create an API object for weather
				quoteAPI quote = new quoteAPI(); // creating an API object for providing random quotes
				try {
					int[] array = data.getData(message); // creating an int array to display the temperatures
													// by calling the getData function
					String[] array1 = quote.getQuote();
					// displaying results
					sendMessage(channel, "The current temperature is " + array[0] + " degrees Fahrenheit");
					sendMessage(channel, "The low for the day is " + array[1] + " degrees Fahrenheit");
					sendMessage(channel, "The high for the day is " + array[2] + " degrees Fahrenheit");
					sendMessage(channel, "Quote: " + array1[0]);
					sendMessage(channel, "From: " + array1[1]);
					cityResponse = false;
				    
				} catch (IOException e) { // if the response is not a valid city, use the catch block
				    	sendMessage(channel, "City was not found. Please enter city again."); // display error message and allow the user to try again
				    	cityResponse = true; 
				    
					e.printStackTrace();
				}
				
			}
			
			else if (message.contains("weather") || message.contains("Weather") || message.contains("temperature") || message.contains("Temperature")) { // if the message has weather or temperature
				sendMessage(channel, "Please enter the city that you would like the temperature for"); // prompt to enter a city
				cityResponse = true; 
			}
			
			// or to start, do something small like:
			else if (message.contains("Hello")) {
				// this is how you send a message back to the channel
				sendMessage(channel, "Hey " + sender + "!");
			}
			else {
				sendMessage(channel, "Sorry, I'm a weather and quote bot. Please type weather "
						+ "or temperature to learn more about your favorite city!");
			}
	}
}
