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
	//buton de�i�kenleri
	public JButton basla = new JButton("Ba�lat");
	public JButton ayarlar = new JButton("Ayarlar");
	public JLabel yazi = new JLabel();
	public JLabel yazi2 = new JLabel();
	public menu() {
		
	
		basla.setBounds(60, 40, 100, 50);
		add(basla);
		setLayout(null);

		//ba�latma butonu t�klanma durumu
		basla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Ekran ekrn = new Ekran();
				ekrn.setTitle("k�zg�n ku�lar");
				
				
				
				//jFrame odaklanmamas� i�in
				ekrn.setResizable(false);
				ekrn.setFocusable(false);
				
				//jFrame kapatma tu�u ve boyutu
				ekrn.setSize(800, 600);
				ekrn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//oyun.java �a�r�ld�
				oyun oyn =new oyun();
				
				//klavye islemleri icin
				oyn.requestFocus();
				oyn.addKeyListener(oyn);
				
				//JPanel e odaklanmas� i�in
				oyn.setFocusable(true);
				
				//klavye islemleri i�in
				ekrn.setFocusTraversalKeysEnabled(false);
				
				//jPaneli, jFrame  ekleme
				ekrn.add(oyn);
				
				//ekran g�r�n�rl���
				ekrn.setVisible(true);
			}
		});

		//ipucu yaz�lar� labeli
		add(yazi);
		yazi.setBounds(20, 80, 350, 100);
		yazi.setForeground(Color.red);
		yazi.setText("�pucu :-10 a�� ile altaki hedef -40 ile �steki hedef vuruluyor.");
		add(yazi2);
		yazi2.setBounds(20, 105, 400, 100);
		yazi2.setForeground(Color.red);
		yazi2.setText("�pucu :A�ar�,yukar� ile a�� ayalarlan�p enter tu�uyla at�� yap�l�yor.");
		
		
		//renk de�i�imi yap�ld��� ekrana ge�i� butonu
		ayarlar.setBounds(60, 220, 100, 50);
		add(ayarlar);
		setLayout(null);

		// buton t�klanma durumu
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
		//men� frame 
		menu mn  = new menu();
		mn.setTitle("Men�");
		mn.setSize(400,400);
		mn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mn.setVisible(true);
	}
}
