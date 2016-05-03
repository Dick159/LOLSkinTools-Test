package listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import thread.ZipDecodeThread;
import view.ImagePanel;

public class ComboBoxListener implements ItemListener {

	private ImagePanel panel;

	public ComboBoxListener( ImagePanel panel ) {
		this.panel = panel;
	}

	@Override
	public void itemStateChanged( ItemEvent e ) {
		// TODO Auto-generated method stub
		if( e.getStateChange() == ItemEvent.SELECTED ) {
			JComboBox<String> box = ( JComboBox<String> )e.getSource();
			String tag = ( String )box.getSelectedItem();
			Thread th = new Thread( new ZipDecodeThread( tag, panel ) );
			th.start();
		}
	}
}
