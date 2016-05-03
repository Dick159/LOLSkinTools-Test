package Util;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import net.npe.dds.DDSReader;

public class ReadDDSImage {

	public static JLabel createDDSLabel( String path ) throws IOException {

		FileInputStream fis = new FileInputStream( path );
		byte[] buffer = new byte[ fis.available() << 1];
		fis.read( buffer );
		fis.close();
		int[] pixels = DDSReader.read( buffer, DDSReader.ARGB, 0 );
		int width = DDSReader.getWidth( buffer );
		int height = DDSReader.getHeight( buffer );
		BufferedImage image = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
		image.setRGB( 0, 0, width, height, pixels, 0, width );
		ImageIcon icon = new ImageIcon( image.getScaledInstance( width, height, BufferedImage.SCALE_SMOOTH ) );
		return new JLabel( icon );
	}

}
