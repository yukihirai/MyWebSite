package EC;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class EcHelper {

	static final String LOGIN_PAGE = "/login.jsp";

	static final String REGIST_PAGE = "/userRegistration.jsp";

	static final String REGIST_CONFIRM_PAGE = "/userRegistrationConfirm.jsp";

	static final String REGIST_RESULT_PAGE = "/userRegistrationResult.jsp";

	public static boolean isLoginIdValidation(String inputLoginId) {
		if (inputLoginId.matches("[0-9a-zA-Z-_]+")) {
			return true;
		}

		return false;

	}

	public static Object cutSession(HttpSession session, String str) {
		Object ob = session.getAttribute(str);
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


}
