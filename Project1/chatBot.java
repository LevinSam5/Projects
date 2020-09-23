import java.io.IOException;


import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

public class chatBot {

	public static void main(String[] args) {
		// you can read more about what these lies do in the documentation
		bot ChatBot = new bot();
		ChatBot.setVerbose(true);
		String name = "#testChannel";
		try {
			ChatBot.connect("irc.freenode.net");
		} catch (NickAlreadyInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IrcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // tells it where to connect to
		ChatBot.joinChannel(name); // name of channel you want to connect to
		// default message it will send when your pircbot first goes live
		//ChatBot.sendMessage(name, "Hey! I am a bot that can tell you weather information about any city and "
		//		+ "I can also show you the top trending videos on Youtube! Go on, try me out!");
			//That's it for setting up your bot! After this, you can implement custom logic that will look similar to the next slide
	}

}
