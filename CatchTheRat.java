import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class CatchTheRat extends JFrame {
	JLabel rat;
	Random random;

	public CatchTheRat(int k) {
		setTitle("Catch The Rat");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		setContentPane(new JLabel(new ImageIcon(
				"LOCATION OF THE BACKGROUND IMAGE")));
		getContentPane().setLayout(new FlowLayout());

		rat = new JLabel(new ImageIcon(
				"LOCATION OF THE RAT IMAGE"));
		getContentPane().add(rat);

		random = new Random();
		new Timer(k, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				rat.setLocation(random.nextInt(Math.abs(getWidth() - 75)), random.nextInt(Math.abs(getHeight() - 75)));
			}
		}).start();

		rat.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				Toolkit.getDefaultToolkit().beep();
				System.out.println("Caught!");
			}
		});
		setExtendedState(MAXIMIZED_BOTH);
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the speed");
		int k = s.nextInt();
		new CatchTheRat(k);
	}

}
