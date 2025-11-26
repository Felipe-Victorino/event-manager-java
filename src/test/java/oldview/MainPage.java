package oldview;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPage extends JFrame{

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
	private JButton agendaDeSessoesButton;
    private JButton searchEventButton;
    private JButton registerNewEventButton;
	private JComboBox comboBox1;
	private JLabel MainTitle;
	private JLabel Description;
	private JPanel mainPage;
	private JPanel regPage;
	private JPanel eventPage;
	private CardLayout layout;

    public MainPage(){
        setContentPane(this.contentPane);
        setTitle("ISOLA");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		shiftTabbedPane();
		shiftMainTitle();
        setVisible(true);

    }

	private void shiftMainTitle(){
		Font normalFont = this.MainTitle.getFont();
		Font headerFont = normalFont.deriveFont(42f);
		this.MainTitle.setFont(headerFont);
	}

	private void shiftTabbedPane(){
		this.tabbedPane.setBorder(new EmptyBorder(10, 10, 10,10));
	}
}