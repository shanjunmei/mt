package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regp {
	public static void main(String[] args) {
		String sql="select count(*) as col_0_0_ from t_role role0_\n order\n by\n dd \ndesc";
		Pattern pattern=Pattern.compile("\\border\\s+by\\s+[\\s\\S]*",Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(sql);
		if(matcher.find()){
			sql=matcher.replaceFirst("");
		}
		System.out.println(sql);
	}
}
