package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import system.Software;
import util.ImageResource;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	public GeneralPanel pGeneral;
	public EditGamePanel pEditGame;
	public ViewGamePanel pViewGame;
	public HelpPanel pHelp;
	public ConfigurationPanel pConfig;
	public AboutPanel pAbout;
	
	public MainWindow(){
		// Initialize the frame
		setWindow();
		
		// Initialize the components
		pGeneral = new GeneralPanel();
		pEditGame = new EditGamePanel();
		pViewGame = new ViewGamePanel();
		pHelp = new HelpPanel();
		pConfig = new ConfigurationPanel();
		pAbout = new AboutPanel();
		
		changePanel(pGeneral,null);
	}

	private void setWindow(){
		setTitle(Software.NAME);
		try{
			setIconImage((new ImageResource()).resource(ImageResource.FRAME));
		}catch(IllegalArgumentException | NullPointerException e){/* In case of non-existence, it will be ignored.*/}
		setSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.70),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.70)));
		setMinimumSize(new Dimension(720,480));
		setResizable(true);
	}
	
	public void changePanel(JPanel pNuevo, JScrollBar scrollBar){
		getContentPane().removeAll();
		add(pNuevo);
		pNuevo.setVisible(true);
		if(scrollBar != null) 
			scrollBar.setValue(0);
		getContentPane().validate();
		getContentPane().repaint();
		validate();
		repaint();
	}
}
