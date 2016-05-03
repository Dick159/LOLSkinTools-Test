package Util;

import java.util.ArrayList;
import java.util.List;
import vo.Message;

public class MessageHelper {

	private static List<Object> register = new ArrayList<Object>();

	public static void regist( Object obj ) {
		register.add( obj );
	}

	public static void handler( Message message ) {
		int type = message.getOperateType();

		switch( type ) {
		case 0x1:
			
			
			break;

		default:
			break;
		}
	}

}
