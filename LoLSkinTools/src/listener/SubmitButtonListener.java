package listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;

import Util.FileUtil;
import common.CharacterConstant;
import common.Path;
import thread.ZipEncodeThread;

public class SubmitButtonListener implements ActionListener {

	@Override
	public void actionPerformed( ActionEvent e ) {
		// TODO Auto-generated method stub
		JButton btn = ( JButton )e.getSource();
		Component cp = btn.getParent().getComponents()[ 0 ];
		if( cp instanceof JComboBox ) {
			JComboBox<String> jcb = ( JComboBox )cp;
			String fileName = CharacterConstant.valueMap.get( jcb.getSelectedItem() );
			File file = FileUtil.getNextDirectory( new File( Path.DDS_FILE_BASE_PATH + jcb.getSelectedItem() ) );
			System.out.println( file.getName() );
			new Thread( new ZipEncodeThread( "D:\\" + fileName + Path.format, file ) ).start();
			;
		}
	}

}
