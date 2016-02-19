package wxweb.tulingrobot;

import com.github.sd4324530.fastweixin.api.response.BaseResponse;

public class TextMesageResponse extends BaseResponse{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String text;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
