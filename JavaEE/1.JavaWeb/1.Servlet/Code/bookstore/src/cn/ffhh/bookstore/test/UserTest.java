package cn.ffhh.bookstore.test;

import java.io.IOException;

import org.junit.Test;

import cn.ffhh.bookstore.Factory.DaoFactory;
import cn.ffhh.bookstore.Factory.ServiceFactory;
import cn.ffhh.bookstore.domain.User;
import cn.itcast.commons.CommonUtils;

public class UserTest {

	public void addUser() {
		User vo = new User();
		vo.setUsername("qwqe");
		vo.setUid(CommonUtils.uuid());
		vo.setPassword("213213");
		vo.setEmail("asdas@awqweq.com");
		vo.setCode("dasdasda");
		vo.setState(0);
		try {
			ServiceFactory.getUserServiceInstance().addUser(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testChar() throws IOException {
		User user = DaoFactory.getUserDaoInstance().findByUesername("admin");
		System.out.println(user);
	}
}
