package javacode03;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FileTest {
	@Test
	void fileTest() throws Exception {
		File file = new File("testFiles/hello.txt");
		File file1 = new File("D:\\eclipse_workspace\\javase\\testFiles\\world.txt");

		System.out.println(file);
		System.out.println(file1);

		File file2 = new File("D:\\\\eclipse_workspace\\\\javase", "tes1");
		System.out.println(file2);

		File file3 = new File(file2, "helloWorld.txt");
		System.out.println(file3);
	}

	@Test
	void test1() throws Exception {
		File file = new File("testFiles/hello.txt");
		File file1 = new File("D:\\Desktop\\Java\\1_课件\\第2部分：Java高级编程\\尚硅谷_宋红康_第13章_IO流\\dbcp.txt");
		File file2 = new File("D:\\Desktop\\Java\\1_课件\\第2部分：Java高级编程\\尚硅谷_宋红康_第13章_IO流");

		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getParent());
		System.out.println(file1.length());
		System.out.println(new Date(file1.lastModified()));

		System.out.println("========================");

		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(file.length());
		System.out.println(file.lastModified());
		System.out.println("====================================");

		for (String str : file2.list()) {
			System.out.println(str);
		}

	}
	/*
	 * public boolean isDirectory()：判断是否是文件目录 public boolean isFile() ：判断是否是文件
	 * public boolean exists() ：判断是否存在 public boolean canRead() ：判断是否可读
	 * publicboolean canWrite() ：判断是否可写 public boolean isHidden() ：判断是否隐藏
	 */

	@Test
	void test2() throws Exception {
		File file = new File("testFiles/hello.txt");
		File file1 = new File("D:\\Desktop\\Java\\1_课件\\第2部分：Java高级编程\\尚硅谷_宋红康_第13章_IO流\\dbcp.txt");
		File file2 = new File("D:\\Desktop\\Java\\1_课件\\第2部分：Java高级编程\\尚硅谷_宋红康_第13章_IO流");
		System.out.println(file.isDirectory());
		System.out.println(file1.isDirectory());
		System.out.println(file2.isDirectory());

		System.out.println(file.canRead());
		System.out.println(file1.canWrite());
		System.out.println(file2.isHidden());

	}

	@Test
	void creat() throws Exception {
		File file = new File("hello.txt");
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("创建成功！");
		} else {
			file.delete();
			System.out.println("删除成功");
		}
	}
	@Test
	void createDirs() throws Exception {
		File file = new File("testFiles");
		if(file.mkdir()) {
			System.out.println("创建成功！");
		}else {
			System.out.println("创建失败");
		}
		
		File file2 = new File("testFiles/io/test");
		if(file2.mkdirs()) {
			System.out.println("创建成功！");
		}else {
			System.out.println("创建失败");
		}
		
		File file3 = new File("testFiles/io/test/test.txt");
		if(file3.createNewFile()) {
			System.out.println("创建成功！");
		}else {
			System.out.println("创建失败");
		}
		
	}
}
