package fm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jeff
 *
 */
public class Programs {
	
	private Environment env;
	
	// does not check if source is full path or not, assumes full path
	public boolean cp(String source, String dest) throws IOException {
	    byte[] sbytes = Files.readAllBytes(Paths.get(source));
	    Path path = Paths.get(dest);
	    Files.write(path, sbytes);
		
		return true;
	}
	
	// show contents of current dir
	public boolean ls() {
		return ls(this.env.getLoc());
	}
	
	// show contents of path specified
	public boolean ls(String path) {
		System.out.println("path = " + path);	// debug
		File f = new File(path);
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		return true;
	}
	
	// prints current directory
	public boolean wer() {
		System.out.println(env.getLoc());
		return true;
	}
	
	// rename
	public boolean rn(String source, String dest) throws IOException {
		return mv(source, dest);
	}
	
	// remove
	// assumes full path yung path
	public boolean rm(String path) {
		new File(path).delete();
		return true;
	}
	
	// assumes source and dest are already full path
	public boolean mv(String source, String dest) throws IOException {
		boolean ok_lang = cp(source, dest);
		if (ok_lang) {
			return rm(source);
		}
		return false;
	}
	
	// go to directory
	// assumes that path is not full
	public Environment cd(String path) {
		if (path.equals("..")) {	// go back
			String loc = env.getLoc();
			if (!loc.equals("/")) {
				String wos = loc.substring(0, loc.length() - 1);
				wos = wos.substring(0, wos.lastIndexOf("/") + 1);
				this.env.setLoc(wos);
				this.env.update();
				return this.env;
			}	// do things if it is in root, it cannot go back more
		}
		if (path.charAt(path.length() - 1) != '/') {
			path = path + "/";
		}
		this.env.setLoc(env.getLoc() + path);
		this.env.update();
		return this.env;
	}
	
	// pang exit
	public boolean bye() {
		System.exit(0);
		return true;
	}
	
	// view contents of file
	public boolean see(Solomon theProf) {
		return true;
	}
	
	// run a program
	// assumes full path
	public boolean run(String path) throws IOException {
		String dir = path.substring(0, path.lastIndexOf("/") + 1);
		Runtime.getRuntime().exec(path, null, new File(dir));
		return true;
	}
	
	public void setEnv(Environment e) {
		this.env = e;
	}

}

class Solomon {
	
}
