package fm;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author jeff
 *
 */
public class FileManager {
	
	
	public static void main(String[] args) {
		Environment env = new Environment();
		Scanner sc = new Scanner(System.in);
		Programs programs = new Programs();
		
		// program loop
		while(true) {
			Parser parser = new Parser();
			System.out.print(env.getPrompt());
			String input = sc.nextLine();
			boolean ret = parser.parse(input);
			if (ret) {
				programs.setEnv(env);
				String comm = parser.getCommand();
				String[] arguments = parser.getArguments();
				// assumes error checking goes here
				switch (comm) {
				case "cd":
					// error checking!!!! if no argument u self destruct
					env = programs.cd(arguments[0]);
					break;
				case "cp":
					// error checking!!!! if no argument u self destruct
					try {
						programs.cp(arguments[0], arguments[1]);
					} catch (IOException e1) {
						System.out.println("Error");	// pls fix error stuff
					}
					break;
				case "mv":
					// error checking!!!! if no argument u self destruct
					try {
						programs.mv(arguments[0], arguments[1]);
					} catch (IOException e1) {
						System.out.println("Error");	// pls fix error stuff
					}
					break;
				case "rn":
					// error checking!!!! if no argument u self destruct
					try {
						programs.rn(arguments[0], arguments[1]);
					} catch (IOException e1) {
						System.out.println("Error");	// pls fix error stuff
					}
					break;
				case "ls":
					// error checking!!!!
					if (arguments == null) {
						programs.ls();
					} else {
						programs.ls(arguments[0]);
					}
					break;
				case "wer":
					// error checking!!!!
					programs.wer();
					
					break;
				case "rm":
					// error checking!!!!
					programs.rm(arguments[0]);
//					try {
//						programs.rm(arguments[0]);
//					} catch (IOException e1) {
//						System.out.println("Error");	// pls fix error stuff
//					}
					break;
				case "bye":
					// error checking!!!!
					programs.bye();
					break;
				case "run":	// not working pls fix
					// error checking!!!!
					try {
						programs.run(arguments[0]);
					} catch (Exception e) {
						System.out.println("error");	// ayusin
					}
					
					break;
				default:
					System.out.println("INVALID COMMAND");
					break;
				}
			}
		}
		
	}
}

class Environment {
	
	private String prompt;
	private String name = "fm";	// name of program?
	private String loc = "/";	// root by default
	
	public Environment() {
		update();
	}
	
	/**
	 * update the environment
	 */
	public void update() {
		prompt = name + ":" + loc + "# ";
	}

	/**
	 * @return the prompt
	 */
	public String getPrompt() {
		return prompt;
	}

	/**
	 * @param prompt the prompt to set
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
