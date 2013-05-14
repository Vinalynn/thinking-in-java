/**
 * 
 */
package org.vinalynn.thinking_in_java.base64.img;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;
import org.vinalynn.thinking_in_java.common.Task;

import com.owtelse.codec.Base64;

/**
 * @author caiwm
 * 
 */
public class ImgConventor extends Task {

	public static void generateImg(String strBase64, String destFilePath,
			String fileName, String fileFix)
			throws IOException {
		strBase64 = StringUtils.remove(StringUtils.remove(strBase64, "\n"), "\r");
		byte[] bytes = Base64.decode(strBase64);
		StringBuilder sb = new StringBuilder();
		String destFile = sb.append(destFilePath).append(fileName).append(".")
				.append(fileFix).toString();

		OutputStream os = new FileOutputStream(destFile);
		os.write(bytes);
		os.close();
		
	}

	public void doTask() {
		// TODO Auto-generated method stub

	}

}
