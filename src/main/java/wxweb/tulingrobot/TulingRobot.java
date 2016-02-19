package wxweb.tulingrobot;

import java.util.Map;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class TulingRobot implements WxMpMessageHandler{
	RobotApi api = new RobotApi();
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		String content = api.getMessage(wxMessage);
		
		WxMpXmlOutTextMessage m
        = WxMpXmlOutMessage.TEXT().content(content).fromUser(wxMessage.getToUserName())
        .toUser(wxMessage.getFromUserName()).build();
		return m;
	}
}
