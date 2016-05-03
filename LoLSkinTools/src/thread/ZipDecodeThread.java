package thread;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JLabel;

import Util.FileUtil;
import Util.ReadDDSImage;
import common.Path;
import view.ImagePanel;

public class ZipDecodeThread implements Runnable {

	private String tag;

	private ImagePanel panel;

	public ZipDecodeThread( String tag, ImagePanel panel ) {
		this.tag = tag;
		this.panel = panel;
	}

	@Override
	public void run() {
		try {
			DecodeZip();
			loadImage();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}

	public void DecodeZip() throws Exception {
    
		String path = Path.DDS_FILE_BASE_PATH + this.tag;

		ZipInputStream zis = null;
		BufferedInputStream bis = null;
		try {
			if( new File( path ).exists() ) {
				// exist
				return;
			}
			System.out.println( "解压"+path + Path.format+"中......." );
			zis = new ZipInputStream( new FileInputStream( path + Path.format ) );
			bis = new BufferedInputStream( zis );
			ZipEntry ze = null;
			File currentFile = null;
			while( ( ( ze = zis.getNextEntry() ) != null ) ) {
				if( ze.isDirectory() ) {
					currentFile = new File( path, ze.getName() );
					if( !currentFile.exists() ) {
						currentFile.mkdirs();
					}
				} else {
					currentFile = new File( path, ze.getName() );
					FileOutputStream fos = new FileOutputStream( currentFile );
					BufferedOutputStream bos = new BufferedOutputStream( fos );
					int b;
					while( ( b = bis.read() ) != -1 ) {
						bos.write( b );
					}
					fos.close();
					bos.close();
				}
			}
			System.out.println( "解压"+tag+"完成!" );
		} catch( FileNotFoundException e ) {
			e.printStackTrace();
		} finally {
			if( zis != null )
				zis.close();
			if( bis != null )
				bis.close();
		}
	}

	private void loadImage() throws IOException {
		File baseFile = new File( Path.DDS_FILE_BASE_PATH + this.tag + "\\" );
		ArrayList<File> destFiles = new ArrayList<File>();
		dfsSearch( baseFile, destFiles );
		if( destFiles.size() != 0 ) {
			JLabel imageLabel = ReadDDSImage.createDDSLabel( destFiles.get( 0 ).getAbsolutePath() );
			this.panel.removeAll();
			this.panel.add( imageLabel );
			this.panel.validate();
			this.panel.repaint();
		}
	}

	private void dfsSearch( File file, ArrayList<File> destFiles ) {
		File[] files = file.listFiles();
		for( int i = 0; i < files.length; i++ ) {
			if( files[ i ].isDirectory() ) {
				dfsSearch( files[ i ], destFiles );
			} else {
				if( FileUtil.getSuffix( files[ i ].getName() ).toLowerCase().equals( "dds" ) ) {
					if( files[ i ].getName().contains( "LoadScreen" ) ) {
						destFiles.add( files[ i ] );
					}
				}
			}
		}
	}

}
