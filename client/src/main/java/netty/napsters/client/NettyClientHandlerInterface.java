package netty.napsters.client;

public interface NettyClientHandlerInterface {
	void messageHandler(String message,Response response);

	String  getName();
}
