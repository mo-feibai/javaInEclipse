package intertProgramming;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

//客户端发送信息给服务端，服务端显示在终端
public class TCPTest {
	// 客户端
	@Test
	void client() {
		Socket socket = null;
		OutputStream outputStream = null;
		try {
			InetAddress serverAddress = InetAddress.getByName("localhost");
			socket = new Socket(serverAddress, 8899);
			outputStream = socket.getOutputStream();
			outputStream.write("你好，我是客户端mm".getBytes());
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	// 服务端
	@Test
	void server() {
		InputStream inputStream = null;
		ServerSocket serverSocket = null;
		Socket socket = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			serverSocket = new ServerSocket(8899);
			socket = serverSocket.accept();
			inputStream = socket.getInputStream();
//			int length;
//			byte[] byteBuffer = new byte[100];
//			while ((length = inputStream.read(byteBuffer)) != -1) {
//				System.out.print(new String(byteBuffer, 0, length));
//			}

			byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] byteBuffer = new byte[4];
			int length;
			while ((length = inputStream.read(byteBuffer)) != -1) {
				byteArrayOutputStream.write(byteBuffer, 0, length);
			}
			System.out.println(byteArrayOutputStream.toString());
			System.out.println("收到来自：" + socket.getInetAddress().getHostAddress() + "的信息。");
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			if (byteArrayOutputStream != null) {
				try {
					byteArrayOutputStream.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}
	}
}
