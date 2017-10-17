package EC;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import beans.ItemDataBeans;

public class EcHelper {

	static final String LOGIN_PAGE = "/login.jsp";

	static final String LOGOUT_PAGE = "/logout.jsp";

	static final String INDEX_PAGE = "/index.jsp";

	static final String BUY_PAGE = "/buy.jsp";

	static final String BUY_CONFIRM_PAGE = "/buyConfirm.jsp";

	static final String BUY_DETAIL_PAGE = "/buyDetail.jsp";

	static final String BUY_RESULT_PAGE = "/buyResult.jsp";

	static final String CART_PAGE = "/cart.jsp";

	static final String ERROR_PAGE = "/error.jsp";

	static final String ITEM_DETAIL_PAGE = "itemDetail.jsp";

	static final String REVIEW_EDIT_PAGE = "/reviewEdit.jsp";

	static final String REVIEW_EDIT_RESULT_PAGE = "/reviewEditResult.jsp";

	static final String REVIEW_DELETE_PAGE = "/reviewDelete.jsp";

	static final String REVIEW_DELETE_RESULT_PAGE = "/reviewDeleteResult.jsp";

	static final String USER_REGIST_PAGE = "/userRegistration.jsp";

	static final String USER_REGIST_CONFIRM_PAGE = "/userRegistrationConfirm.jsp";

	static final String USER_REGIST_RESULT_PAGE = "/userRegistrationResult.jsp";

	static final String USER_DATA_PAGE = "/userData.jsp";

	static final String USER_LIST_PAGE = "/userList.jsp";

	static final String USER_DETAIL_PAGE = "/userDetail.jsp";

	static final String USER_UPDATE_PAGE = "/userUpdate.jsp";

	static final String USER_UPDATE_CONFIRM_PAGE = "/userUpdateConfirm.jsp";

	static final String USER_UPDATE_RESULT_PAGE = "/userUpdateResult.jsp";

	static final String USER_DELETE_PAGE = "/userDelete.jsp";

	static final String USER_DELETE_RESULT_PAGE = "/userDeleteResult.jsp";

	static final String MASTER_PAGE = "/master.jsp";

	static final String MASTER_ITEM_REGISTRATION_PAGE = "/masterItemRegistration.jsp";

	static final String MASTER_ITEM_REGISTRATION_CONFILM_PAGE = "/masterItemRegistrationConfirm.jsp";

	static final String MASTER_ITEM_LIST_PAGE = "/masterItemList.jsp";

	static final String MASTER_ITEM_DETAIL_PAGE = "/masterItemDetail.jsp";

	static final String MASTER_ITEM_UPDATE_PAGE = "/masterItemUpdate.jsp";

	static final String MASTER_ITEM_UPDATE_CONFIRM_PAGE = "/masterItemUpdateConfirm.jsp";

	static final String MASTER_ITEM_DELETE_PAGE = "/masterItemDelete.jsp";

	static final String MASTER_ITEM_DELETE_RESULT_PAGE ="/masterItemDeleteResult.jsp";

	public static boolean isLoginIdValidation(String inputLoginId) {
		if (inputLoginId.matches("[0-9a-zA-Z-_]+")) {
			return true;
		}

		return false;

	}

	public static int getTotalitemPrice(ArrayList<ItemDataBeans> items) {
		int totalPrice = 0;
		for(ItemDataBeans idb : items) {
			totalPrice += idb.getPrice();
		}
		return totalPrice;
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

	public static String getFileName(Part part) {
        String name = null;

        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }

	public static String getSQL(String login_id , String name , String fromBirth , String toBirth) {
		String SQL = "SELECT * FROM user WHERE ";
		List<String> list = new ArrayList<String>();

		if(login_id.length()!=0) {
			String loginStr = "login_id =" + "'" + login_id + "'";
			list.add(loginStr);
		}

		if(name.length()!=0) {
			String nameStr = "name LIKE " + "'%" + name + "%'";
			list.add(nameStr);
		}

		if(fromBirth.length()!=0) {
			String fromBirthStr = "birth_date >=" + "'" + fromBirth + "'";
			list.add(fromBirthStr);
		}

		if(toBirth.length()!=0) {
			String toBirthStr = "birth_date <=" + "'" + toBirth + "'";
			list.add(toBirthStr);
		}

		int count = 0;

		for(String str : list) {
			if(count == 0) {
				SQL +=str + " ";
				count++;
			}else {
				SQL += "AND" + " " + str + " ";
			}
		}
		if(count!=0) {
			return SQL + "AND id>1";
		}else {
			return SQL + "id>1";
		}
	}

}
