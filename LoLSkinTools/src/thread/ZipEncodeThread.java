package thread;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipEncodeThread implements Runnable {

	private String outPutPath;

	private File source;

	public ZipEncodeThread( String outPutPath, File source ) {
		this.outPutPath = outPutPath;
		this.source = source;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			makeZip( outPutPath, source );
		} catch( Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void makeZip( String outPutPath, File inputBaseFile ) throws Exception {
		ZipOutputStream zos = new ZipOutputStream( new FileOutputStream( outPutPath ) );
		BufferedOutputStream bos = new BufferedOutputStream( zos );
		readFile( zos, bos, inputBaseFile, inputBaseFile.getName() );
		bos.close();
		zos.close();
	}

	private void readFile( ZipOutputStream zos, BufferedOutputStream bos, File inputBaseFile, String fileName ) throws Exception {
		if( inputBaseFile.isDirectory() ) {
			File[] files = inputBaseFile.listFiles();
			if( files.length == 0 ) {
				zos.putNextEntry( new ZipEntry( fileName + "/" ) );
			} else {
				for( int i = 0; i < files.length; i++ ) {
					File file = files[ i ];
					readFile( zos, bos, file, fileName + "/" + file.getName() );
				}
			}
		} else {
			zos.putNextEntry( new ZipEntry( fileName ) );
			FileInputStream fis = new FileInputStream( inputBaseFile );
			BufferedInputStream bis = new BufferedInputStream( fis );
			int b;
			while( ( b = bis.read() ) != -1 ) {
				bos.write( b );
			}
			bis.close();
			fis.close();
		}

	}

	// public static void main( String[] args ) {
	// String outPutPath = "E:\\TEST_LOL_SKIN.zip";
	// File file = new File( "D:\\LOL_SKIN\\未来战士 李青 LeeSin\\" );
	// try {
	// makeZip( outPutPath, file );
	// } catch( Exception e ) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
