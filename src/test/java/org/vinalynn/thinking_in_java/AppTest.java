package org.vinalynn.thinking_in_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.Before;
import org.junit.Test;
import org.vinalynn.thinking_in_java.base64.img.ImgConventor;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private HashMap<String, Integer> testStore; 
	private Iterator<Map.Entry<String, Integer>> entris;
	@Before
	public void setUp(){
		testStore = new HashMap<String, Integer>();
		
		//define tester
		//1-process 0-ignore
		testStore.put(ImgConventor.class.getName(), 1);
		
		
		entris = testStore.entrySet().iterator();
	}
	
	@Test
	public void testApp() {
		Map.Entry<java.lang.String, java.lang.Integer> entry;

		while (entris.hasNext()) {
			entry = (Map.Entry<java.lang.String, java.lang.Integer>) entris
					.next();

			if (entry.getValue() == 1) {
				System.out.println("testing " + entry.getKey());
				try {
					MethodUtils.invokeMethod(Class.forName(entry.getKey())
							.newInstance(), "doTask", new Object[] {});
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("test class[" + entry.getKey()
						+ " was ignored.");
			}

		}

	}
	
	@Test
	public void testImgConventor() throws FileNotFoundException, IOException{
		//File f = new File(getClass().getResource("base64str").getFile());
		
		File f = App.getClassPathFile("base64str");
		String encodeStr = IOUtils.toString(new FileInputStream(f), "UTF-8");
		ImgConventor.generateImg(encodeStr, "d:\\", "sdf555few", "JPEG");
		System.out.println(f.canRead());
	}
}
