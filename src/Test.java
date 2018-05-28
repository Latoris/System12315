import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.latoris.consume.mapper.UserMapper;

public class Test {

	public static void main(String[] args) {
		System.out.println( "Hello ");
		ApplicationContext ac = new ClassPathXmlApplicationContext("configure.xml");
		UserMapper sd = (UserMapper)ac.getBean("UserMapper");
		System.out.println(sd.findUser());
	}

}