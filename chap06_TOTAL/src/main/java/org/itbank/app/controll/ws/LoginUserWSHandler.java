package org.itbank.app.controll.ws;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component("lws")
public class LoginUserWSHandler extends TextWebSocketHandler {
	Map<String, WebSocketSession> users = new HashMap<>();
	//Map<String, Set<WebSocketSession>> //Socket 접속자가 多, 확인할때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// HttpSession을 어떻게 접근?
		// Interceptor
		Map<String, Object> hs = session.getAttributes();
			//HttpSession setAttribute 되어있는 값들이 Map으로 추출됨.
		System.out.println("/ws/login :"+hs);
		String id = (String)hs.get("auth_id");
		users.put(id, session);
	}
	//컨트롤러 쪽에서 사용하기 위해서, 메서드 하나를 추가하는건데,
	public void sendMessageToUser(String id, String msg) {
		if(users.containsKey(id)) {
			try {
				users.get(id).sendMessage(new TextMessage(msg));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
