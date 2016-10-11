package test;

import com.lanhun.framework.orm.po.User;
import com.lanhun.framework.utils.em.Status;

public class UserTest {

	static HttpClient client = new HttpClient();

	public static void main(String[] args) {

		String session = login("666", null);
		System.out.println(session);
		createUsers();
	}

	public static String login(String username, String password) {
		String url = "http://localhost:8080/mt/user/login.iv";
		StringBuffer param = new StringBuffer();
		param.append("number=" + username);
		if (password != null && !password.trim().isEmpty()) {
			param.append("&password=" + password);
		}
		try {
			String session = client.sendPostRequest(url, param.toString());
			return session;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static void createUsers() {

		String name = "测试";
		String number = "ceshi";
		for (int i = 0; i < 100000; ++i) {
			User creator = new User();
			creator.setId("40288018497b093401497b09b8e00001");
			createUser(name + "-" + (i), number + "-" + (i));
		}

	}

	private static void createUser(String name, String number) {
		User user = new User();
		user.setEnabled(Status.E);
		user.setPassword("123");
		user.setName(name);
		user.setNumber(number);
		String url = "http://localhost:8080/mt/user/save.iv";
		StringBuffer param = new StringBuffer();
		param.append("name=" + name);
		param.append("&number=" + number);
		param.append("&enabled=" + Status.E.toString());
		param.append("&password=123");

		try {
			String response = client.sendPostRequestByForm(url,
					param.toString());
			System.out.println("response :" + response);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
