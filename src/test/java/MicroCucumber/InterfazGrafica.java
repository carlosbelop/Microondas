package MicroCucumber;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InterfazGrafica {

	private JFrame frame;
	private Microwave m=new Microwave();
	private JLabel display;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica window = new InterfazGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazGrafica() {
		initialize();
	}


	private void actualizaDisplay() {
		display.setText(m.getDisplay().getDisplay());
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton open = new JButton("abrir");
		open.setFont(new Font("Tahoma", Font.BOLD, 28));
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.door_opened();
				System.out.println(m.toString());

			}
		});
		open.setBounds(10, 10, 339, 153);
		frame.getContentPane().add(open);
		
		JButton itemIn = new JButton("Meter Comida");
		itemIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.item_placed();
				System.out.println(m.toString());

			}
		});
		itemIn.setBounds(359, 78, 97, 21);
		frame.getContentPane().add(itemIn);
		
		JButton itemOut = new JButton("Sacar Comida");
		itemOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.item_removed();
				System.out.println(m.toString());

			}
		});
		itemOut.setBounds(485, 78, 97, 21);
		frame.getContentPane().add(itemOut);
		
		JButton powerInc = new JButton("+ potencia");
		powerInc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.power_inc();
				System.out.println(m.toString());
			}
		});
		powerInc.setBounds(371, 116, 85, 21);
		frame.getContentPane().add(powerInc);
		
		JButton powerDec = new JButton("- potencia");
		powerDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.power_dec();
				System.out.println(m.toString());

			}
		});
		powerDec.setBounds(485, 116, 85, 21);
		frame.getContentPane().add(powerDec);
		
		JButton power0 = new JButton("potencia 0");
		power0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.power_reset();
				System.out.println(m.toString());

			}
		});
		power0.setBounds(429, 142, 85, 21);
		frame.getContentPane().add(power0);
		
		JButton timeDec = new JButton("- tiempo");
		timeDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.timer_dec();
				System.out.println(m.toString());

			}
		});
		timeDec.setBounds(497, 193, 85, 21);
		frame.getContentPane().add(timeDec);
		
		JButton timeInc = new JButton("+ tiempo");
		timeInc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.timer_inc();
				System.out.println(m.toString());
			}
		});
		timeInc.setBounds(359, 193, 85, 21);
		frame.getContentPane().add(timeInc);
		
		JButton time0 = new JButton("tiempo 0");
		time0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.timer_reset();
				System.out.println(m.toString());
			}
		});
		time0.setBounds(429, 224, 85, 21);
		frame.getContentPane().add(time0);
		
		JButton cookStart = new JButton("cocinar");
		cookStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.cooking_start();
				System.out.println(m.toString());

			}
		});
		cookStart.setBounds(359, 276, 85, 37);
		frame.getContentPane().add(cookStart);
		
		JButton close = new JButton("cerrar");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.door_closed();
				System.out.println(m.toString());

			}
		});
		close.setFont(new Font("Tahoma", Font.BOLD, 28));
		close.setBounds(10, 178, 339, 140);
		frame.getContentPane().add(close);
		
		JButton cookstop = new JButton("parar");
		cookstop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.cooking_stop();
				System.out.println(m.toString());
			}
		});
		cookstop.setBounds(485, 276, 85, 37);
		frame.getContentPane().add(cookstop);
		
		display = new JLabel("display");
		display.setFont(new Font("Tahoma", Font.BOLD, 18));
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setBounds(359, 21, 211, 47);
		frame.getContentPane().add(display);
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleWithFixedDelay(() -> {	
			actualizaDisplay();
        }, 0, 100, TimeUnit.MILLISECONDS);
		
	}
}
