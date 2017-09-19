package org.itbank.app.controll.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/* 
 *	ws protocol ó���� ��Ʈ�ѷ�
 * 		AbstractWebSocketHandler Ȥ��
 *		TextWebSocketHandler ���߿� �ϳ��� ��ӹް� ����ø� �Ǵµ�,
 */
public class BasicWSController extends TextWebSocketHandler{
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// super. afterConnectionEstablished(session);
		// Ŭ���̾�Ʈ������ ������ �߻��Ͽ�����
		System.out.println("afterConnectionEstablished..");
		String msg="ȯ���մϴ�!";
		session.sendMessage(new TextMessage(msg));
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		//Ŭ���̾�Ʈ�����κ��� ������ ���� �Ǿ��� ��
		System.out.println("afterConnectionClosed..");
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//Ŭ���̾�Ʈ�����κ��� �����͸� ���۹޾�����
		System.out.println("handleTextMessage..");
		String m = message.getPayload();
		System.out.println("���ŵ� ���� : ["+m+"]");
	}
}
