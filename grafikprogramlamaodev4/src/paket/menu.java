package paket;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menu extends JFrame {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//buton deðiþkenleri
	public JButton basla = new JButton("Baþlat");
	public JButton ayarlar = new JButton("Ayarlar");
	public JLabel yazi = new JLabel();
	public JLabel yazi2 = new JLabel();
	public menu() {
		
	
		basla.setBounds(60, 40, 100, 50);
		add(basla);
		setLayout(null);

		//baþlatma butonu týklanma durumu
		basla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Ekran ekrn = new Ekran();
				ekrn.setTitle("kýzgýn kuþlar");
				
				
				
				//jFrame odaklanmamasý için
				ekrn.setResizable(false);
				ekrn.setFocusable(false);
				
				//jFrame kapatma tuþu ve boyutu
				ekrn.setSize(800, 600);
				ekrn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//oyun.java çaðrýldý
				oyun oyn =new oyun();
				
				//klavye islemleri icin
				oyn.requestFocus();
				oyn.addKeyListener(oyn);
				
				//JPanel e odaklanmasý için
				oyn.setFocusable(true);
				
				//klavye islemleri için
				ekrn.setFocusTraversalKeysEnabled(false);
				
				//jPaneli, jFrame  ekleme
				ekrn.add(oyn);
				
				//ekran görünürlüðü
				ekrn.setVisible(true);
			}
		});

		//ipucu yazýlarý labeli
		add(yazi);
		yazi.setBounds(20, 80, 350, 100);
		yazi.setForeground(Color.red);
		yazi.setText("Ýpucu :-10 açý ile altaki hedef -40 ile üsteki hedef vuruluyor.");
		add(yazi2);
		yazi2.setBounds(20, 105, 400, 100);
		yazi2.setForeground(Color.red);
		yazi2.setText("Ýpucu :Aþarý,yukarý ile açý ayalarlanýp enter tuþuyla atýþ yapýlýyor.");
		
		
		//renk deðiþimi yapýldýðý ekrana geçiþ butonu
		ayarlar.setBounds(60, 220, 100, 50);
		add(ayarlar);
		setLayout(null);

		// buton týklanma durumu
		ayarlar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//ekran javadaki frame ayarlar java paneli ekleniyor
				Ekran ayr  = new Ekran();
				ayr.setTitle("Ayarlar");
				ayr.setSize(400,400);
				ayr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				ayarlar ayarjava = new ayarlar();
				
				ayr.add(ayarjava);
				ayr.setVisible(true);
			}
		});

		
		
	}
	
	public static void main(String[] args) {
		//menü frame 
		menu mn  = new menu();
		mn.setTitle("Menü");
		mn.setSize(400,400);
		mn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mn.setVisible(true);
	}
}
