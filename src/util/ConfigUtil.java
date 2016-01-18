package util;

import java.util.ResourceBundle;

public class ConfigUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("config");
	
	private void ConfigUtil(){}
	
	public static final String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}

	public static final String getUploadFieldName() {
		return bundle.getString("uploadFieldName");
	}

	public static final long getUploadFileMaxSize() {
		return Long.valueOf(bundle.getString("uploadFileMaxSize"));
	}

	public static final String getUploadFileExts() {
		return bundle.getString("uploadFileExts");
	}

	public static final String getUploadDirectory() {
		return bundle.getString("uploadDirectory");
	}

}
