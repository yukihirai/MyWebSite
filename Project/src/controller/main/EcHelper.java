package controller.main;

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

	public static final String LOGIN_PAGE = "/login.jsp";

	public static final String LOGOUT_PAGE = "/logout.jsp";

	static final String INDEX_PAGE = "/index.jsp";

	public static final String BUY_PAGE = "/buy.jsp";

	public static final String BUY_CONFIRM_PAGE = "/buyConfirm.jsp";

	public static final String BUY_DETAIL_PAGE = "/buyDetail.jsp";

	public static final String BUY_RESULT_PAGE = "/buyResult.jsp";

	public static final String CART_PAGE = "/cart.jsp";

	static final String ERROR_PAGE = "/error.jsp";

	public static final String ITEM_DETAIL_PAGE = "/itemDetail.jsp";

	public static final String ITEM_SEARCH_RESULT_PAGE = "/itemSearchResult.jsp";

	public static final String REVIEW_EDIT_PAGE = "/reviewEdit.jsp";

	public static final String REVIEW_EDIT_RESULT_PAGE = "/reviewEditResult.jsp";

	public static final String REVIEW_DELETE_PAGE = "/reviewDelete.jsp";

	public static final String REVIEW_DELETE_RESULT_PAGE = "/reviewDeleteResult.jsp";

	public static final String USER_REGIST_PAGE = "/userRegistration.jsp";

	public static final String USER_REGIST_CONFIRM_PAGE = "/userRegistrationConfirm.jsp";

	public static final String USER_REGIST_RESULT_PAGE = "/userRegistrationResult.jsp";

	public static final String USER_DATA_PAGE = "/userData.jsp";

	public static final String USER_LIST_PAGE = "/userList.jsp";

	public static final String USER_DETAIL_PAGE = "/userDetail.jsp";

	public static final String USER_UPDATE_PAGE = "/userUpdate.jsp";

	public static final String USER_UPDATE_CONFIRM_PAGE = "/userUpdateConfirm.jsp";

	public static final String USER_UPDATE_RESULT_PAGE = "/userUpdateResult.jsp";

	public static final String USER_DELETE_PAGE = "/userDelete.jsp";

	public static final String USER_DELETE_RESULT_PAGE = "/userDeleteResult.jsp";

	public static final String MASTER_PAGE = "/master.jsp";

	public static final String MASTER_ITEM_REGISTRATION_PAGE = "/masterItemRegistration.jsp";

	public static final String MASTER_ITEM_REGISTRATION_CONFILM_PAGE = "/masterItemRegistrationConfirm.jsp";

	public static final String MASTER_ITEM_LIST_PAGE = "/masterItemList.jsp";

	public static final String MASTER_ITEM_DETAIL_PAGE = "/masterItemDetail.jsp";

	public static final String MASTER_ITEM_UPDATE_PAGE = "/masterItemUpdate.jsp";

	public static final String MASTER_ITEM_UPDATE_CONFIRM_PAGE = "/masterItemUpdateConfirm.jsp";

	public static final String MASTER_ITEM_DELETE_PAGE = "/masterItemDelete.jsp";

	public static final String MASTER_ITEM_DELETE_RESULT_PAGE ="/masterItemDeleteResult.jsp";


	/**
	 * ログインIDに使える文字かどうかチェックする
	 * @param inputLoginId
	 * 			チェック対象のログインID
	 * @return boolean
	 */
	public static boolean isLoginIdValidation(String inputLoginId) {
		if (inputLoginId.matches("[0-9a-zA-Z-_]+")) {
			return true;
		}

		return false;

	}

	/**
	 * リスト内の商品の合計金額を計算する
	 * @param ArrayList<ItemDataBeans>items
	 * @return リスト内の商品の合計金額
	 */
	public static int getTotalitemPrice(ArrayList<ItemDataBeans> items) {
		int totalPrice = 0;
		for(ItemDataBeans idb : items) {
			totalPrice += idb.getPrice();
		}
		return totalPrice;
	}


	/**
	 * セッションを破棄し、その中身を取り出す
	 * @param (session,"session名")
	 * @param str
	 * @return セッション内の内容
	 */
	public static Object cutSession(HttpSession session, String str) {
		Object ob = session.getAttribute(str);
		session.removeAttribute(str);

		return ob;
	}

	/**
	 * 文字列をMD5で暗号化する
	 * @param password
	 * @return MD5で暗号化された文字列
	 */
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

	/**
	 * 文字列の日付を年/月/日の形に変える
	 * @param String date
	 * @return yyyy年MM月dd日
	 */
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

	/**
	 * 選択された画像の名前をとってくる
	 * @param part
	 * @return 画像の名前
	 */
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

	/**
	 * 送信された検索項目に応じてSQLを作成する
	 * @param login_id
	 * @param name
	 * @param fromBirth
	 * @param toBirth
	 * @return 作成されたSQL文
	 */
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
