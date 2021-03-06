package stream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

public class ObjectInputOutputStreamTest {
	@Test
	void test1() {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream("fileTest/object.dat"));
			objectOutputStream.writeObject(new String("我爱北京天安门！"));
			objectOutputStream.flush();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	@Test
	void test2() {
		ObjectInputStream objectInputStream = null;
		String readObject = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream("fileTest/object.dat"));
			readObject = (String) objectInputStream.readObject();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (objectInputStream != null) {
					objectInputStream.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println(readObject);
	}

	@Test
	void test3() {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream("fileTest/Person.dat"));
			Person person = new Person("UZI", 23);
			objectOutputStream.writeObject(person);
			objectOutputStream.flush();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {
				objectOutputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	@Test
	void test4() {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream("fileTest/Person.dat"));
			Person readObject = (Person) objectInputStream.readObject();
			System.err.println(readObject);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
