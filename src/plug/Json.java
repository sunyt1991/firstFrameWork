package plug;

public class Json implements java.io.Serializable {

	public final static String STAE_CODE_SUCCESS = "200"; // 表示操作成功
	
	public final static String STAE_CODE_ERROR = "300"; // 表示操作失败
	
	public final static String STAE_CODE_OUTTIME = "301"; // 表示超时
	
	private String statusCode; 
	
	private String message; 
	
	private Object params;
	
	private String param;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	
	

}
