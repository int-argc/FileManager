package fm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author jeff
 *
 */
public class Parser {
	
	private String command = "";
	private String[] arguments;
	
	public boolean parse(String input) {
		// null input, cannot parse return false
		if (input.isEmpty()) {
			return false;
		}
		
		String[] sp = input.split(" ");
		this.command = sp[0];
		if (sp.length > 1) {
			this.arguments = Arrays.copyOfRange(sp, 1, sp.length);
		}
		return true;
	}
	
	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}
	
	/**
	 * @return the arguments
	 */
	public String[] getArguments() {
		return arguments;
	}
	
}
