package intertProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 客户端发送文件给服务端，服务端将文件保存到本地
 * @author mofeibai
 * @date 2021年4月9日下午10:16:58
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

public class TCPTest2 {
	@Test
	void client() {
		Socket socket = null;
		OutputStream outputStream = null;
		try {
			socket = new Socket("localhost", 8899);
			outputStream = socket.getOutputStream();
			outputStream.write("你好，hello java!".getBytes());
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
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
		}

	}

	@Test
	void server() {
		ServerSocket serverSocket = null;
		Socket accept = null;
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			serverSocket = new ServerSocket(8899);
			accept = serverSocket.accept();
			inputStream = accept.getInputStream();
			fileOutputStream = new FileOutputStream(new File("fileTest/TCP.txt"));

			byte[] byteBuffer = new byte[10];
			int length;
			while ((length = inputStream.read(byteBuffer)) != -1) {
				fileOutputStream.write(byteBuffer, 0, length);
			}
		} catch (FileNotFoundException e) {

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
			if (accept != null) {
				try {
					accept.close();
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
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}
}
