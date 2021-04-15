package intertProgramming;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

public class TCPTest3 {
	@Test
	void client() {
		Socket socket = null;
		OutputStream outputStream = null;
		FileInputStream fileInputStream = null;
		InputStream inputStream = null;
		try {
			socket = new Socket("localhost", 8899);
			outputStream = socket.getOutputStream();
			fileInputStream = new FileInputStream(new File("fileTest/美女.jpg"));
			int length;
			byte[] byteBuffer = new byte[1024];
			while ((length = fileInputStream.read(byteBuffer)) != -1) {
				outputStream.write(byteBuffer, 0, length);
			}
			socket.shutdownOutput();
			byte[] byteBuffer1 = new byte[10];
			inputStream = socket.getInputStream();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			while ((length = inputStream.read(byteBuffer1)) != -1) {
				byteArrayOutputStream.write(byteBuffer1, 0, length);
			}
			System.out.println(byteArrayOutputStream.toString());
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
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
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

	@Test
	void server() {
		ServerSocket serverSocket = null;
		Socket accept = null;
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		OutputStream outputStream = null;
		try {
			serverSocket = new ServerSocket(8899);
			accept = serverSocket.accept();
			inputStream = accept.getInputStream();
			fileOutputStream = new FileOutputStream(new File("fileTest/TCP.jpg"));

			byte[] byteBuffer = new byte[10];
			int length;
			while ((length = inputStream.read(byteBuffer)) != -1) {
				fileOutputStream.write(byteBuffer, 0, length);
			}

			System.out.println("图片传输完成");
			outputStream = accept.getOutputStream();
			outputStream.write("你好，照片已经收到！".getBytes());

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
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}
}
