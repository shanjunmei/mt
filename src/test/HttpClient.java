package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpClient {

	String session;

	public String sendPostRequest(String path, String params)
			throws Exception {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("POST");// 提交模式
		// conn.setConnectTimeout(10000);//连接超时 单位毫秒
		// conn.setReadTimeout(2000);//读取超时 单位毫秒
		conn.setDoOutput(true);// 是否输入参数
		// conn.addRequestProperty("Cookie",
		// "JSESSIONID=64CD44CDC9483AF4587125CFF0B8966B");
		byte[] bypes = params.toString().getBytes();
		conn.getOutputStream().write(bypes);// 输入参数

		// String reqProperties=conn.getResponseMessage();
		Map<String, List<String>> mp = conn.getHeaderFields();
		Set<Entry<String, List<String>>> it = mp.entrySet();
		String session = null;
		for (Entry<String, List<String>> entry : it) {
			if ("set-cookie".equalsIgnoreCase(entry.getKey())) {
				List<String> v = entry.getValue();
				session = v.get(0);
				session = session.substring(0, session.indexOf(";"));
			}
		}
		this.session=session;
		return session;
	}

	/**
	 * 通过HttpURLConnection模拟post表单提交
	 * 
	 * @param path
	 * @param params
	 *            例如"name=zhangsan&age=21"
	 * @return
	 * @throws Exception
	 */
	public  String sendPostRequestByForm(String path,
			String params) throws Exception {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("POST");// 提交模式
		// conn.setConnectTimeout(10000);//连接超时 单位毫秒
		// conn.setReadTimeout(2000);//读取超时 单位毫秒
		conn.setDoOutput(true);// 是否输入参数
		conn.addRequestProperty("Cookie", session);
		byte[] bypes = params.toString().getBytes();
		conn.getOutputStream().write(bypes);// 输入参数
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		StringBuffer buf = new StringBuffer();
		while (reader.ready()) {
			buf.append(reader.readLine());
		}
		return buf.toString();
	}

}
