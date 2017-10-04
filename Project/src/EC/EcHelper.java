package EC;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class EcHelper {

	static final String LOGIN_PAGE = "/login.jsp";

	static final String USER_REGIST_PAGE = "/userRegistration.jsp";

	static final String REGIST_CONFIRM_PAGE = "/userRegistrationConfirm.jsp";

	static final String REGIST_RESULT_PAGE = "/userRegistrationResult.jsp";

	static final String INDEX_PAGE = "/index.jsp";

	static final String USER_DATA_PAGE = "/userData.jsp";

	static final String USER_LIST_PAGE = "/userList.jsp";

	static final String USER_DETAIL_PAGE = "/userDetail.jsp";

	static final String USER_UPDATE_PAGE = "/userUpdate.jsp";

	static final String USER_UPDATE_CONFIRM_PAGE = "/userUpdateConfirm";

	public static boolean isLoginIdValidation(String inputLoginId) {
		if (inputLoginId.matches("[0-9a-zA-Z-_]+")) {
			return true;
		}

		return false;

	}

	public static Object cutSession(HttpSession session, String str) {
		Object ob = session.getAttribute(str);
		session.removeAttribute(str);

		return ob;
	}

	public static String convertMd5(String password) {
		String source = password;
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";
		byte[] bytes;
		String result=null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			result = DatatypeConverter.printHexBinary(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String convertDate(String date)  {
		String conDate = null;

		try {
			String dateStr = date;
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			Date cDate;
			cDate = f.parse(dateStr);

			SimpleDateFormat f2 = new SimpleDateFormat("yyyy年MM月dd日");
			conDate = f2.format(cDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return date;
		}
		return conDate;
	}
}
