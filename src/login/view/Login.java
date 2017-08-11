package login.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import login.controller.LoginController;

@SuppressWarnings("deprecation")
public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JPasswordField pwdPassword;
	private JButton btnOk;
	private JButton btnExit;

	private LoginController loginController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {

		this.setResizable(false);
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblTitle());
		contentPane.add(getLblUsername());
		contentPane.add(getTxtUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getPwdPassword());
		contentPane.add(getBtnOk());
		contentPane.add(getBtnExit());
	}

	private LoginController getLoginController() {
		if (loginController == null)
			loginController = new LoginController();
		return loginController;
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("LOGIN");
			lblTitle.setBounds(10, 10, 424, 40);
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lblTitle;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setBounds(10, 80, 65, 20);
			lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblUsername;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setBounds(85, 80, 334, 20);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(10, 105, 65, 20);
			lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblPassword;
	}

	private JPasswordField getPwdPassword() {
		if (pwdPassword == null) {
			pwdPassword = new JPasswordField();
			pwdPassword.setBounds(85, 105, 334, 20);
		}
		return pwdPassword;
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.setBounds(60, 170, 110, 20);

			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					try {
						String username = getTxtUsername().getText();
						String password = getPwdPassword().getText();

						getLoginController().checkLogin(username, password);

						JOptionPane.showMessageDialog(Login.this, "Successful login", "Success", JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e) {
						JOptionPane.showMessageDialog(Login.this, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
					}

				}
			});

		}
		return btnOk;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setBounds(274, 170, 110, 20);

			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return btnExit;
	}
}
