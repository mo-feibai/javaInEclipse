package reflection.compenent;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtil {
	// 存放创建的对象
	private static Map<String, Object> map = new HashMap<String, Object>();

	static {
		/**
		 * 获取当前运行的程序中所有有 reflection.compenent.Compenent 注解的类, 为其中能够创建对象的类创建对象, 使用
		 * 该类的名称(首字母改为小写, 例如: UserName --> userName; Student --> student) 作为key,
		 * 该类创建出来的对象作为value, 存入上述的Map集合
		 */
		ArrayList<String> binFiles = getBinFiles("", new File("bin"));

		for (String binFile : binFiles) {
			try {
				Class<?> clazz = Class.forName(binFile.replace(".class", ""));
				Annotation[] annotations = clazz.getAnnotations();
				for (Annotation annotation : annotations) {
					if ("Compenent".equals(annotation.annotationType().getSimpleName())) {
						Object newInstance = clazz.newInstance();
						char[] charArray = clazz.getSimpleName().toCharArray();
						charArray[0] = Character.toLowerCase(charArray[0]);
						map.put(new String(charArray), newInstance);
					}
				}
			} catch (ClassNotFoundException e) {

				System.out.println(e.getMessage() + "类找不到");
			} catch (InstantiationException e) {

				System.out.println(e.getMessage() + "这个类不能创对象");
			} catch (IllegalAccessException e) {

				System.out.println(e.getMessage() + "无法创建对象");
			}

		}

	}

	private static ArrayList<String> getBinFiles(String extra, File aFile) {
		ArrayList<String> fileNames = new ArrayList<>();

		File f = aFile;
		File[] listFiles = f.listFiles();
		for (File file : listFiles) {
			if (file.isFile()) {
				fileNames.add(extra + file.getName());
			} else {
				fileNames.addAll(getBinFiles(extra + file.getName() + ".", file));
			}
		}

		return fileNames;
	}

	/**
	 * 根据类名获取该类的对象
	 * 
	 * @param key 类名(首字母改为小写, 例如: UserName --> userName; Student --> student)
	 * @return
	 * @throws NullPointerException 如果没有找到对应的对象, 会抛出此异常
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(String key) throws NullPointerException {
		char[] charArray = key.toCharArray();
		charArray[0] = Character.toLowerCase(charArray[0]);
		return (T) map.get(new String(charArray));
	}

}
