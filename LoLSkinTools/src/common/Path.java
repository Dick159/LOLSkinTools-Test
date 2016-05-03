package common;


public class Path {

	public static String LOL_BASE_PATH = "";

	public static String LOL_OUTPUT_DEST_DIRECT = LOL_BASE_PATH + "\\Game";

	public static String LOL_OUTPUT_DEST_FILE = LOL_OUTPUT_DEST_DIRECT + "\\ClientZips.txt";

	public static String DDS_FILE_BASE_PATH = "D:\\LOL_SKIN\\";
	
	public static String format=".zip";
	
	public static String SCREEN_SKIN_PATH = "\\DATA\\Characters\\";
	
	public static String SUB_SCREEN_SKIN_PATH = "\\Skins\\Base\\";

//	public static void main( String[] args ) {
//		File file = new File( DDS_FILE_BASE_PATH );
//		File[] files = file.listFiles();
//		int c=1;
//		for( File f : files ) {
//			String fileName = f.getName();
//			String suffix = fileName.substring( fileName.lastIndexOf( "." ) + 1 );
//			if(suffix.equals( "zip" )){
//				System.out.println( fileName.substring( 0, fileName.lastIndexOf( "." ) ) );
//			}
//		}
//	}
}
