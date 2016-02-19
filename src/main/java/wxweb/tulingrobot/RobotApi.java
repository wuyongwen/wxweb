package wxweb.tulingrobot;

import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.BaseResponse;
import com.github.sd4324530.fastweixin.util.BeanUtil;
import com.github.sd4324530.fastweixin.util.JSONUtil;
import com.github.sd4324530.fastweixin.util.NetWorkCenter;
import com.github.sd4324530.fastweixin.util.StrUtil;

import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;

public class RobotApi {
	public static final String URL = "http://www.tuling123.com/openapi/api";
	public static final String KEY = "1b1175146795f7d2f6d8d1e5698771a5";
	public String getMessage(WxMpXmlMessage wxMessage){
		TextMesageResponse response = null;
        String url = URL + "?key="+KEY;
        if(StringUtils.isNotBlank(wxMessage.getContent())){
        	url += "&info="+wxMessage.getContent();
        }
        if (StrUtil.isNotBlank(wxMessage.getFromUserName())) {
            url += "&userid=" + wxMessage.getFromUserName();
        }
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, TextMesageResponse.class);
        return response.getText();
	}
	 /**
     * 通用get请求
     *
     * @param url 地址，其中token用#代替
     * @return 请求结果
     */
    protected BaseResponse executeGet(String url) {
        BaseResponse response;
        BeanUtil.requireNonNull(url, "url is null");
        response = NetWorkCenter.get(url);
        return response;
    }
    /**
     * 判断本次请求是否成功
     *
     * @param errCode 错误码
     * @return 是否成功
     */
    protected boolean isSuccess(String errCode) {
        return ResultType.SUCCESS.getCode().toString().equals(errCode);
    }
    public static void main(String[] args) {
		RobotApi api = new RobotApi();
		WxMpXmlMessage ms = new WxMpXmlMessage();
		ms.setContent("你好");
		System.out.println(api.getMessage(ms));
	}
}
