package org.anhu.websocketClient;

import java.util.Scanner;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class TestApp {

//	private static String URL = "ws://localhost:8080/spring-mvc-java/chat";

	private static String URL = "ws://192.168.225.2:8080";

	public static void main(String[] args) {
//		try {
//			// open websocket
//			final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(
//					new URI("wss://real.okcoin.cn:10440/websocket/okcoinapi"));
//
//			// add listener
//			clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
//				public void handleMessage(String message) {
//					System.out.println(message);
//				}
//			});
//
//			// send message to websocket
//			clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");
//
//			// wait 5 seconds for messages from websocket
//			Thread.sleep(5000);
//
//		} catch (InterruptedException ex) {
//			System.err.println("InterruptedException exception: " + ex.getMessage());
//		} catch (URISyntaxException ex) {
//			System.err.println("URISyntaxException exception: " + ex.getMessage());
//		}

		WebSocketClient client = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(client);

		stompClient.setMessageConverter(new MappingJackson2MessageConverter());

		StompSessionHandler sessionHandler = new MyStompSessionHandler();
		stompClient.connect(URL, sessionHandler);

		new Scanner(System.in).nextLine(); // Don't close immediately..
	}
}