package Util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtils {

	// public static void main( String[] args ) throws Exception {
	// HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	// format.setCaseType( HanyuPinyinCaseType.LOWERCASE );
	// format.setToneType( HanyuPinyinToneType.WITHOUT_TONE );
	// format.setVCharType( HanyuPinyinVCharType.WITH_V );
	// char[] chs = new char[] { '°¡', 'ÎÒ', 'Äý' };
	// for( String s : PinyinHelper.toHanyuPinyinStringArray( '¿Õ', format ) ) {
	// System.out.println( s );
	// }
	// }

	public static String getPinYin( String src ) {
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType( HanyuPinyinCaseType.LOWERCASE );
		format.setToneType( HanyuPinyinToneType.WITHOUT_TONE );
		format.setVCharType( HanyuPinyinVCharType.WITH_V );
		StringBuilder sb = new StringBuilder();
		char[] chs = src.toCharArray();
		for( int i = 0; i < chs.length; i++ ) {
			String pinyin = null;
			try {
				// deal the chinese character
				if( Character.toString( chs[ i ] ).matches( "[\\u4E00-\\u9FA5]+" ) ) {
					pinyin = PinyinHelper.toHanyuPinyinStringArray( chs[ i ], format )[ 0 ];
					sb.append( pinyin );
				}
			} catch( BadHanyuPinyinOutputFormatCombination e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
