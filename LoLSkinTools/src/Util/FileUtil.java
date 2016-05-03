package Util;

import java.io.File;

public class FileUtil {

	public static String getSuffix( String fileName ) {
		return fileName.substring( fileName.lastIndexOf( "." ) + 1 );
	}

	public static String getPrefix( String fileName ) {
		return fileName.substring( 0, fileName.lastIndexOf( "." ) );
	}

	public static String getMaxEn( String fileName ) {
		int maxStart = 0;
		int maxEnd = 0;
		int maxLength = 0;
		int start = 0;
		String prefix = getPrefix( fileName );
		int i = 0;
		while( i < prefix.length() ) {
			char c = prefix.charAt( i );
			if( isEn( c ) ) {
				maxStart = i;
				int j = i;
				if( i + 1 < prefix.length() ) {
					j = i + 1;
					while( j < prefix.length() && isEn( prefix.charAt( j ) ) ) {
						j++;
					}
				}
				maxEnd = j;
				i = j;
				if( ( maxEnd - maxStart ) > maxLength ) {
					start = maxStart;
					maxLength = ( maxEnd - maxStart );
				}
			} else {
				i++;
			}
		}
		// only chinese character
		if( maxLength < 1 ) {
			String src = prefix.trim();
			return PinYinUtils.getPinYin( src );
		}

		return prefix.substring( start, start + maxLength );
	}

	private static boolean isEn( char c ) {
		if( c >= 'a' && c < 'z' || c >= 'A' && c <= 'Z' )
			return true;
		return false;
	}

	public static File getNextDirectory( File file ) {
		File ret = null;
		File[] files = file.listFiles();
		for( int i = 0; i < files.length; i++ ) {
			if( files[ i ].isDirectory() ) {
				ret = files[ i ];
				break;
			}
		}
		return ret;
	}

	// public static void main( String[] args ) throws Exception {
	// DecodeZip( new File( Path.DDS_FILE_BASE_PATH ), "test" );
	// }
}
