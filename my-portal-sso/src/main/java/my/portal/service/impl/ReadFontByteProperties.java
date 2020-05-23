/**
 * 
 */
package my.portal.service.impl;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;



/**
 * 图形验证码 防止报字符串长度过长错误，改为从配置文件读取
 * @author 盼望
 * @date 2019年8月27日上午11:21:21
 */
@Service
public class ReadFontByteProperties {
	static private String fontByteStr = null;
	static {
	    loads();
	}
	synchronized static public void loads() {
	    if (fontByteStr == null) {
	        InputStream is = ReadFontByteProperties.class.getResourceAsStream("/fontByte.properties");
	        Properties dbproperties = new Properties();
	        try {
	            dbproperties.load(is);
	            fontByteStr = dbproperties.getProperty("fontByteStr").toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	        	System.err.println("不能读取属性文件. " + "请确保fontByte.properties在CLASSPATH指定的路径中");
	        }
	    }
	}
	public static String getFontByteStr() {
	    if (fontByteStr == null)
	        loads();
	    System.out.println("fontByteStr="+fontByteStr);
	    return fontByteStr;
	}
}
