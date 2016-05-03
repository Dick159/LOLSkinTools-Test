package mainview;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyleConstants.CharacterConstants;

import listener.ComboBoxListener;
import listener.SubmitButtonListener;
import view.ImagePanel;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map.Entry;

import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	private JTextField textField;

	private JComboBox comboBox;

	private ImagePanel imgPanel;

	private JButton submitBtn;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {
		EventQueue.invokeLater( new Runnable() {

			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible( true );
				} catch( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initCompoment();
		bindListener();
	}

	private void bindListener() {
		// TODO Auto-generated method stub
		comboBox.addItemListener( new ComboBoxListener( this.imgPanel ) );
		submitBtn.addActionListener( new SubmitButtonListener() );
	}

	private void initCompoment() {
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 749, 666 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout( gbl_contentPane );

		comboBox = new JComboBox();
		loadCobomboxData( comboBox );
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets( 0, 0, 5, 5 );
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		contentPane.add( comboBox, gbc_comboBox );

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets( 0, 0, 5, 5 );
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add( textField, gbc_textField );
		textField.setColumns( 10 );

		submitBtn = new JButton( "È·¶¨" );
		GridBagConstraints gbc_searchBtn = new GridBagConstraints();
		gbc_searchBtn.insets = new Insets( 0, 0, 5, 0 );
		gbc_searchBtn.anchor = GridBagConstraints.WEST;
		gbc_searchBtn.gridx = 2;
		gbc_searchBtn.gridy = 0;
		contentPane.add( submitBtn, gbc_searchBtn );

		imgPanel = new ImagePanel();
		GridBagConstraints gbc_imgPanel = new GridBagConstraints();
		imgPanel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		gbc_imgPanel.gridwidth = 2;
		gbc_imgPanel.insets = new Insets( 0, 0, 0, 5 );
		gbc_imgPanel.fill = GridBagConstraints.BOTH;
		gbc_imgPanel.gridx = 0;
		gbc_imgPanel.gridy = 1;
		contentPane.add( imgPanel, gbc_imgPanel );

		JPanel searchDataPanel = new JPanel();
		GridBagConstraints gbc_searchDataPanel = new GridBagConstraints();
		gbc_searchDataPanel.fill = GridBagConstraints.BOTH;
		gbc_searchDataPanel.gridx = 2;
		gbc_searchDataPanel.gridy = 1;
		contentPane.add( searchDataPanel, gbc_searchDataPanel );
	}

	private void loadCobomboxData( JComboBox<String> box ) {
		for( Entry<String, String> entry : common.CharacterConstant.keyMap.entrySet() ) {
			box.addItem( entry.getValue() );
		}
	}
}
