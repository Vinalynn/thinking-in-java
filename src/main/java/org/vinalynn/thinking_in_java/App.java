package org.vinalynn.thinking_in_java;

import java.io.File;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
	public static File getClassPathFile(String filePath) {
		URL url = Thread.currentThread().getContextClassLoader()
				.getResource(filePath);
		return new File(url.getFile());
	}
    

}
