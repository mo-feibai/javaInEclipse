package javacode01;
/**
 * 自定义注解
 * @author mofeibai
 *
 */
public @interface MyAnnotation {
	String value() default "hello";
}
