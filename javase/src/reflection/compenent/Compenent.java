package reflection.compenent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 组件
 * 
 * @author liudaolin@itany.com
 * @date 2021年4月16日 下午3:06:52
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Compenent {
	
}
