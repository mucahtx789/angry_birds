package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ayarlar extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//resimler ve buton de�i�kenleri 
	public BufferedImage kus;
	public BufferedImage kus2;
	public BufferedImage kus3;
	public BufferedImage kus4;
	
	//bu de�i�ken resimler javada �a�r�lacak int de�erine g�re 4 ku�tan birisi kullan�lacak
	public static int secim=1;
	
	
	public JLabel yazi = new JLabel();
	public JLabel secimlabel = new JLabel();
	public JButton secim1 = new JButton("Se�im 1");
	public JButton secim2 = new JButton("Se�im 2");
	public JButton secim3 = new JButton("Se�im 3");
	public JButton secim4 = new JButton("Se�im 4");
	public JButton baslat = new JButton("Ba�lat");
	Timer zaman = new Timer(80, this);

	public ayarlar() {
		
		
		//�steki yaz�
		yazi.setBounds(75, 35, 350, 100);
		yazi.setForeground(Color.red);
		add(yazi);
		
		//altaki se�ilen ku� yaz�s�
		secimlabel.setBounds(120, 250, 350, 100);
		secimlabel.setForeground(Color.red);
		add(secimlabel);
		
		//arkaplan rengi
		setBackground(Color.cyan);
		
		//ku�lar�n adresleri
		try {
			kus = ImageIO.read(new FileImageInputStream(new File("resource/kus.png")));
			kus2 = ImageIO.read(new FileImageInputStream(new File("resource/kus2.png")));
			kus3 = ImageIO.read(new FileImageInputStream(new File("resource/kus3.png")));
			kus4 = ImageIO.read(new FileImageInputStream(new File("resource/kus4.png")));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//birinci ku�un butonu
		secim1.setBounds(30, 150, 100, 30);
		add(secim1);
		setLayout(null);

		// buton t�klanma durumu
		secim1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				secim=1;
			}
		});
		
		//ikinci ku� butonu
		secim2.setBounds(130, 150, 100, 30);
		add(secim2);
		setLayout(null);

		// buton t�klanma durumu
		secim2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				secim=2;
			}
		});
		secim3.setBounds(30, 250, 100, 30);
		add(secim3);
		setLayout(null);

		// buton t�klanma durumu
		secim3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				secim=3;
			}
		});
		secim4.setBounds(130, 250, 100, 30);
		add(secim4);
		setLayout(null);

		// buton t�klanma durumu
		secim4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				secim=4;
			}
		});
		
		//oyunu ba�latma butonu ekran.java daki frame oyun.java daki panel ekleniyor
		baslat.setBounds(250, 218, 100, 30);
		add(baslat);
		setLayout(null);

		
		// buton t�klanma durumu
		baslat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				resim res =new resim();
				
				
				
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
		zaman.start();
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//ku�lar�n resimlerinin bast�r�lmas�
		g.drawImage(kus, 50, 100, kus.getWidth() / 11, kus.getHeight() / 11, this);
		g.drawImage(kus2, 150, 100, kus2.getWidth() / 11, kus2.getHeight() / 11, this);
		g.drawImage(kus3, 50, 200, kus3.getWidth() / 11, kus3.getHeight() / 11, this);
		g.drawImage(kus4, 150, 200, kus4.getWidth() / 11, kus4.getHeight() / 11, this);
		//�st yaz�
		yazi.setText("KU� SE��M�");
		
		
		
	}
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//butonlar�n t�klanmas�na g�re anl�k de�i�en altdaki label
		secimlabel.setText("Se�ili olan se�im:"+secim);
	}
	
}
