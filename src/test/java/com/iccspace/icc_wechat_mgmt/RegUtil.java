package com.iccspace.icc_wechat_mgmt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Description:
 * 封装一些正则相关的操作
 */
public final class RegUtil {

    /**
     * Alphanumeric characters
     */
    public static final String  REG_ALNUM               = "\\p{Alnum}";
    /**
     * Alphabetic characters
     */
    public static final String  REG_ALPHA               = "\\p{Alpha}";
    /**
     * ASCII characters
     */
    public static final String  REG_ASCII               = "\\p{ASCII}";
    /**
     * Space and tab
     */
    public static final String  REG_BLANK               = "\\p{Blank}";
    /**
     * Control characters
     */
    public static final String  REG_CNTRL               = "\\p{Cntrl}";
    /**
     * Digits
     */
    public static final String  REG_DIGITS              = "\\p{Digit}";
    /**
     * SVisible characters (i.e. anything except spaces, control characters, etc.)
     */
    public static final String  REG_GRAPH               = "\\p{Graph}";
    /**
     * Lowercase letters
     */
    public static final String  REG_LOWER               = "\\p{Lower}";
    /**
     * Visible characters and spaces (i.e. anything except control characters, etc.)
     */
    public static final String  REG_PRINT               = "\\p{Print}";
    /**
     * Punctuation and symbols.
     */
    public static final String  REG_PUNCT               = "\\p{Punct}";
    /**
     * All whitespace characters, including line breaks
     */
    public static final String  REG_SPACE               = "\\p{Space}";
    /**
     * Uppercase letters
     */
    public static final String  REG_UPPER               = "\\p{Upper}";
    /**
     * Hexadecimal digits
     */
    public static final String  REG_XDIGIT              = "\\p{XDigit}";
    /**
     * 空白行
     */
    public static final String  REG_SPACE_LINE          = "\\n\\s*\\r";
    /**
     * 首尾空白字符
     */
    public static final String  REG_SPACE_POINT         = "^\\s*|\\s*$";
    /**
     * HTML
     */
    public static final String  REG_HTML                = "<(\\S*?)[^>]*>.*?</\\1>|<.*? />";
    /**
     * Email
     */
    public static final String  REG_EMAIL               = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 国内固定电话
     */
    public static final String  REG_FIXED_TELEPHONE     = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";
    /**
     * 邮政编码
     */
    public static final String  REG_POSTALCODE          = "[1-9]\\d{5}(?!\\d)";
    /**
     * 身份证编码
     */
    public static final String  REG_IDENTIFICATION_CARD = "\\d{15}|\\d{18}";
    /**
     * URL地址
     */
    public static final String  REG_URL                 = "^http://([w-]+.)+[w-]+(/[w-./?%&=]*)?$";
    /**
     * 移动电话
     */
    public static final String  REG_MOBILE_TELEPHONE    = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    /**
     * 合法的名字（字母开头，允许5-16字节，允许字母数字下划线）
     */
    public static final String  REG_LEGAL_ACCOUNT       = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
    /**
     * i地址
     */
    public static final String  REG_IP                  = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
    private static      Pattern numericPattern          = Pattern.compile("^[0-9\\-]+$");
    private static      Pattern numericStringPattern    = Pattern.compile("^[0-9\\-\\-]+$");
    private static      Pattern floatNumericPattern     = Pattern.compile("^[0-9\\-\\.]+$");
    private static      Pattern abcPattern              = Pattern.compile("^[a-z|A-Z]+$");

    /**
     * 判断是否数字表示
     *
     * @param src 源字符串
     * @return 是否数字的标志
     */
    public final static boolean isNumeric(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = numericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断是否纯字母组合
     *
     * @param src 源字符串
     * @return 是否纯字母组合的标志
     */
    public final static boolean isABC(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = abcPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }


    /**
     * 判断是否浮点数字表示
     *
     * @param src 源字符串
     * @return 是否数字的标志
     */
    public final static boolean isFloatNumeric(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = floatNumericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断字符串str是否符合正则表达式reg
     *
     * @param str 需要处理的字符串
     * @param reg 正则
     * @return 是否匹配
     */
    public final static boolean isMatche(String str, String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher isNum   = pattern.matcher(str);
        return isNum.matches();
    }

    @Test
    public void replace() {
        String str = "asfas5fsaf5s4fs6af.sdaf.asf.wqre.qwr.fdsf.asf.asf.asf";
        //将字符串中的.替换成_，因为.是特殊字符，所以要用\.表达，又因为\是特殊字符，所以要用\\.来表达.
        str = str.replaceAll("\\.", "_");
        System.out.println(str);        
    }
    /**
     * 替换掉数字
     */
    @Test
    public void removeDigital(){
    	String value="afsdgh123sdg";
    	Pattern p = Pattern.compile("[\\d]");
    	Matcher matcher = p.matcher(value);
    	String result = matcher.replaceAll("");
    	System.out.println(result);
    }
    /**
    * 剔除字母
    * @param value
    */
    public static void removeLetter(String value){
    Pattern p = Pattern.compile("[a-zA-z]");
    Matcher matcher = p.matcher(value);
    String result = matcher.replaceAll("");
    System.out.println(result);
    }
    /**
    * 替换
    * @param value
    * @param replacement
    */
    public static void replaceLetter(String value, String replaceParam){
    Pattern p = Pattern.compile("[a-zA-z]");
    Matcher matcher = p.matcher(value);
    String result = matcher.replaceAll(replaceParam);
    System.out.println(result);
    }
    public static void main(String[] args) {
		System.err.println(isMatche("sadfsdg2", "[^\\d]+"));
		
		String str = "a\\df1,2,3,4";
		String reg = "/(\\d+)/g";
		str = str.replace(reg, "第$1章");
		System.err.println(str.indexOf("\\d"));
		System.err.println(str);
		
		String regEx = "<a>([\\s\\S]*?)</a>";
		String s = "<a>123</a><a>456</a><a>789</a>";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(s);
		boolean rs = mat.find();
		for(int i=1;i<=mat.groupCount();i++){
		System.out.println(mat.group(i));
		}
	}
    /**
     * 获取符合reg正则表达式的字符串在String中出现的次数
     *
     * @param str 需要处理的字符串
     * @param reg 正则
     * @return 出现的次数
     */
    public final static int countSubStrReg(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        int     i = 0;
        while (m.find()) {
            i++;
        }
        return i;
    }


    /**
     * 判断是否是符合邮箱
     *
     * @param email 判断的字符串
     * @return 是否是符合的邮箱
     */
    public final static boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile(REG_EMAIL);
        return pattern.matcher(email).matches();
    }
}