package chapter45;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindScoreApplet extends JApplet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// Declare a service object and a proxy object
	private ScoreWebService scoreWebService = new ScoreWebService();
	private ScoreService proxy = scoreWebService.getScoreServicePort();

	private JButton jbtGetScore = new JButton("Get Score");
	private JTextField jtfName = new JTextField();
	private JTextField jtfScore = new JTextField();

	@Override
	public void init() {
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(2, 2));
		jPanel1.add(new JLabel("Name"));
		jPanel1.add(jtfName);
		jPanel1.add(new JLabel("Score"));
		jPanel1.add(jtfScore);

		add(jbtGetScore, BorderLayout.SOUTH);
		add(jPanel1, BorderLayout.CENTER);

		jbtGetScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				getScore();
			}
		});
	}

	private void getScore() {
		try {
			// Get student score
			double score = proxy.findScore(jtfName.getText().trim());

			// Display the result
			if (score < 0)
				jtfScore.setText("Not found");
			else
				jtfScore.setText(new Double(score).toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
