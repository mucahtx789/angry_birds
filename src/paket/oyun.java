package paket;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.lang.Math;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.Timer;

public class oyun extends JPanel implements KeyListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// oyundaki geçicek zaman oluþturulmasý
	Timer tm = new Timer(80, this);

	// oyun sonu deðiþkenleri
	public boolean son = false;
	public int yildizS = 0;

	// sýfýrla butonu ve label
	public JButton sýfýrla = new JButton("Sýfýrla");
	public JLabel gosteraci = new JLabel();

	// birinci atýþ degiskenleri
	public int kusX = 0;
	public int kusY = 470;
	public boolean ates = false;
	public boolean ikincikus = false;

	// ikinci atýþ deðiþkenleri
	public int kus2X = 0;
	public int kus2Y = 470;
	public boolean ates2 = false;

	// açýya göre hareket
	public int aci3 = 0;
	double xdes = Math.cos(aci3 * (Math.PI / 180)) * 15;
	double ydes = Math.sin(aci3 * (Math.PI / 180)) * 15;

	// üst duvar sekme hareket
	public double xdes2 = Math.cos(50 * (Math.PI / 180)) * 15;
	public double ydes2 = Math.sin(50 * (Math.PI / 180)) * 15;

	// alt duvar konumlandýrma ve yýkýlma deðikenleri
	public int dx1 = 400, dx2 = 400, dy1 = 500, dy2 = 400;
	public int altDuvarUstx1 = 400, altDuvarUstx2 = 500, altDuvarUsty1 = 400, altDuvarUsty2 = 400;
	public int altDuvarSagx1 = 500, altDuvarSagx2 = 500, altDuvarSagy1 = 500, altDuvarSagy2 = 400;
	public boolean d1 = false;
	// alt duvar konumlandýrma ve yýkýlma deðikenleri
	public int udx1 = 430, udx2 = 430, udy1 = 175, udy2 = 75;
	public int ustDuvarUstx1 = 430, ustDuvarUstx2 = 530, ustDuvarUsty1 = 75, ustDuvarUsty2 = 75;
	public int ustDuvarSagx1 = 530, ustDuvarSagx2 = 530, ustDuvarSagy1 = 175, ustDuvarSagy2 = 75;
	public boolean ud = false;

	// klavye deðiþkeni
	public int tus;
	// sekme kontrol
	public boolean sekme1 = false;
	public boolean sekme2 = false;

	// oyun constrac
	public oyun() {

		// sýfýrla butonu
		sýfýrla.setBounds(100, 100, 100, 50);
		add(sýfýrla);
		setLayout(null);

		// buton týklanma durumu
		sýfýrla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// birinci atýþ için deðiþken sýfýrlama

				kusX = 0;
				kusY = 470;

				ates = false;

				// duvarlarýn sýfýrlanmasý
				d1 = false;
				ud = false;
				dx1 = 400;
				dx2 = 400;
				dy1 = 500;
				dy2 = 400;
				altDuvarUstx1 = 400;
				altDuvarUstx2 = 500;
				altDuvarUsty1 = 400;
				altDuvarUsty2 = 400;
				altDuvarSagx1 = 500;
				altDuvarSagx2 = 500;
				altDuvarSagy1 = 500;
				altDuvarSagy2 = 400;
				udx1 = 430;
				udx2 = 430;
				udy1 = 175;
				udy2 = 75;
				ustDuvarUstx1 = 430;
				ustDuvarUstx2 = 530;
				ustDuvarUsty1 = 75;
				ustDuvarUsty2 = 75;
				ustDuvarSagx1=530;
				ustDuvarSagx2=530;
				ustDuvarSagy1=175;
				ustDuvarSagy2=75;
				sekme1 = false;
				sekme2 = false;
				// ikinci atýþ için deðiþken sýfýrlanmasý
				ikincikus = false;
				kus2X = 0;
				kus2Y = 470;

				ates2 = false;
				yildizS = 0;
				son = false;
				aci3 = 0;
				// tuþ iþlemleri için panele tekrar odak alma
				requestFocus();
			}
		});

		// açý gösterme labeli
		add(gosteraci);
		gosteraci.setBounds(40, 440, 90, 20);

		// arkaplan
		setBackground(Color.cyan);

		tm.start();
	}// oyun constrac sonu

	// cizim bölümü
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		resim alResim = new resim();

		// açý label oluþturma
		gosteraci.setText("açý deðeri:" + aci3);
		// sapan oluþturma
		g.drawImage(alResim.sapan, 40, 490, alResim.sapan.getWidth() / 100, alResim.sapan.getHeight() / 100, this);
		// kus olusturma
		g.drawImage(alResim.kus, kusX, kusY, alResim.kus.getWidth() / 11, alResim.kus.getHeight() / 11, this);
		// alt duvar domuz resim deðiþimi
		if (d1 == false) {
			g.drawImage(alResim.domuz1, 430, 450, alResim.domuz1.getWidth() / 10, alResim.domuz1.getHeight() / 10,
					this);
		} else if (d1 == true) {
			g.drawImage(alResim.domuz2, 430, 450, alResim.domuz2.getWidth() / 10, alResim.domuz2.getHeight() / 10,
					this);
		}
		// üst duvar domuz resmi deðiþimi
		if (ud == false) {
			g.drawImage(alResim.domuz1, 460, 125, alResim.domuz1.getWidth() / 10, alResim.domuz1.getHeight() / 10,
					this);
		} else if (ud == true) {
			g.drawImage(alResim.domuz2, 460, 125, alResim.domuz2.getWidth() / 10, alResim.domuz2.getHeight() / 10,
					this);
		}
		// ikinci kus olusturma
		if (ikincikus == true) {
			g.drawImage(alResim.kus, kus2X, kus2Y, alResim.kus.getWidth() / 11, alResim.kus.getHeight() / 11, this);
		}
		// 4 kalýnlýkta duvar nesnesi
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(4));
		// alt duvar yýkýlan d1
		g2.drawLine(dx1, dy1, dx2, dy2);
		g2.drawLine(altDuvarUstx1, altDuvarUsty1, altDuvarUstx2, altDuvarUsty2);
		g2.drawLine(altDuvarSagx1, altDuvarSagy1, altDuvarSagx2, altDuvarSagy2);
		// alt zemin
		g2.drawLine(350, 500, 800, 500);
		// sað duvar
		g2.drawLine(785, 500, 785, 0);
		// üst zemin
		g2.drawLine(410, 175, 785, 175);
		// üst duvar yýkýlan ud2
		g2.drawLine(udx1, udy1, udx2, udy2);
		g2.drawLine(ustDuvarUstx1, ustDuvarUsty1, ustDuvarUstx2, ustDuvarUsty2);
		g2.drawLine(ustDuvarSagx1, ustDuvarSagy1, ustDuvarSagx2, ustDuvarSagy2);

		// iþaret resminin açýya göre döndürülmesi ve yeni halinin oluþturulmasý
		double dondurme = Math.toRadians(aci3);
		double isaretX = alResim.isaret.getWidth();
		double isaretY = alResim.isaret.getHeight();
		AffineTransform tx = AffineTransform.getRotateInstance(dondurme, isaretX, isaretY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g.drawImage(op.filter(alResim.isaret, null), 50, 470, alResim.isaret.getWidth() / 10,
				alResim.isaret.getHeight() / 10, null);

	
		// 1.kuþta oyun bitme kontrol
					if(ikincikus == false) {
						
						//üstden dýþarý çýkma
						 if (kusY < 1) {
							son =true;
						}
						//sað duvarda kalma
						if (kusX>748 &&kusX<764) {
							if (kusY>448 && kusY<462) {
								son = true;
							}
						}
					}
					

					// 2.kuþta oyun bitme kontrol
					if(ikincikus==true) {					
						//üsten çýkma
						 if (kus2Y < 1) {
							son = true;
						}
						//sað duvarda kalma
						if (kus2X>748 &&kus2X<764) {
							if (kus2Y>448 && kus2Y<462) {
								son= true;
							}
						}						
					}
					
		
		// oyun sonu ekrana yazý ve resim oluþturna
		if (son == true) {
			g.drawImage(alResim.yazi, 250, 215, alResim.yazi.getWidth(), alResim.yazi.getHeight(), this);

			// bir duvar yýkýldýysa
			if (yildizS == 1) {
				g.drawImage(alResim.yildiz, 275, 300, alResim.yildiz.getWidth() / 3, alResim.yildiz.getHeight() / 3,
						this);
			}
			// 2 duvar yýkýldýysa
			else if (yildizS == 2) {
				g.drawImage(alResim.yildiz, 275, 300, alResim.yildiz.getWidth() / 3, alResim.yildiz.getHeight() / 3,
						this);
				g.drawImage(alResim.yildiz, 325, 300, alResim.yildiz.getWidth() / 3, alResim.yildiz.getHeight() / 3,
						this);
				g.drawImage(alResim.yildiz, 375, 300, alResim.yildiz.getWidth() / 3, alResim.yildiz.getHeight() / 3,
						this);
			}
		}
	}// paint sonu

	@Override
	public void repaint() {
		// timer devam ettikçe tekrar çizim
		super.repaint();
	}

	// klavye tuþ iþlemleri
	@Override
	public void keyPressed(KeyEvent e) {

		// tusa basma deðiþkeni
		tus = e.getKeyCode();

		// yukarý tuþuna basýldýðýnda -60 gelmediyse açý azalt
		if (tus == KeyEvent.VK_UP && aci3 > -60 && ates == false) {

			aci3 -= 5;
			xdes = Math.cos(aci3 * (Math.PI / 180)) * 15;
			ydes = Math.sin(aci3 * (Math.PI / 180)) * 15;
		} // yukarý if sonu

		// aþaðý tuþuna basýldýðýn 0 gelmediyse açý artýr
		if (tus == KeyEvent.VK_DOWN && aci3 < 0 && ates == false) {

			aci3 += 5;
			xdes = Math.cos(aci3 * (Math.PI / 180)) * 15;
			ydes = Math.sin(aci3 * (Math.PI / 180)) * 15;
		} // asaðý if sonu

		// enter basýldýðýnda fýrlat
		if (tus == KeyEvent.VK_ENTER) {
			if (ikincikus == false) {
				ates = true;
			} else {
				ates2 = true;
			}

		} // fýrlat sonu

	}

	// diðer klavye iþlemler
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	// atýþlarýn ve duvar hareketlerinin hesaplanmasý ve oluþturulmasý
	@Override
	public void actionPerformed(ActionEvent e) {

		// birinci atýþta ve enter tuþuna basýldýysa
		if (ates == true && kusX < 750 && kusY > -40) {
			kusX += xdes;
			kusY += ydes;

		} // birinci atýs sonu

		// birinci atýþ kuþ alt duvara geldiyse
		if (kusX == 378) {

			// alt duvarýn tepesine geldiyse
			if (kusY == 389) {
				d1 = true;
				yildizS++;
				kusX = 360;
				kusY = 455;
				ates = false;
				ikincikus = true;
			}
			// alt duvarýn aþaðýsýna geldiyse
			else if (kusY == 416) {
				kusX = 360;
				kusY = 455;
				ates = false;
				son= true;
			}
		}

		// birinci atýþ üst duvar çarptýysa
		if (kusX == 429 && kusY == 80) {
			kusX = 400;
			kusY = 135;
			ates = false;
			ikincikus = true;
			ud = true;
			yildizS++;
		}

		// birinci atýþ sað duvara çarpma
		if (kusX >= 742 && kusY != 455) {
			if (kusY > 450 && kusY < 460) {

			} else {
				kusY += 9;
			}

		}

		// birinci kuþ üst duvar sekme
		if (kusX > 395) {
			if (kusY > 160 && kusY < 167) {

				sekme1 = true;

			}
		}

//-------------------ikinci atýþ hareketleri------------------------		

		// ates2 deðiþkeni aktif ise ikinci atýþ hareketleri
		if (ates2 == true && kus2X < 750 && kus2Y > -40) {

			kus2X += xdes;
			kus2Y += ydes;
		} // ikinci atýþ sonu

		// ikinci atýþ kuþ alt duvara geldiyse
		if (kus2X == 378) {

			// alt duvarýn tepesine geldiyse
			if (kus2Y == 389) {
				d1 = true;
				yildizS++;
				kus2X = 360;
				kus2Y = 455;
				ates2 = false;
				son=true;

			}
			// alt duvarýn aþaðýsýna geldiyse
			else if (kus2Y == 416) {
				kus2X = 360;
				kus2Y = 455;
				ates2 = false;
				son= true;
			}
		}

		// ikinci atýþ sað duvara çarpma
		if (kus2X >= 747 && kus2Y != 455) {
			if (kus2Y > 450 && kus2Y < 460) {

			} else {
				kus2Y += 9;
			}

		}
		// ikinci atýs üst duvar çarptýysa
		if (kus2X == 429 && kus2Y == 80) {
			kus2X = 400;
			kus2Y = 135;
			ates2 = false;
			ud = true;
			yildizS++;
			son=true;
		}
		// ikinci kuþ üst duvar sekme
		if (kus2X > 395) {
			if (kus2Y > 160 && kus2Y < 167) {
				sekme2 = true;
				kus2X += xdes2;
				kus2Y += ydes2;

			}
		}
//------------Duvar Hareketleri-------------------------------------------

		// alt duvar düþme hareketi
		if (d1 == true) {
			if (dy2 != 475) {
				dy2 += 15;
				dx2 += 15;
			}
			if (altDuvarSagy2 != 475) {
				altDuvarSagy2 += 15;
				altDuvarSagx2 += 15;
			}
			if (altDuvarUsty2 != 475) {
				altDuvarUsty1 += 15;
				altDuvarUsty2 += 15;
			}
		}

		// üst duvar düþme hareketi
		if (ud == true) {
			if (udy2 != 150) {
				udy2 += 15;
				udx2 += 15;
			}
			if (ustDuvarSagy2 != 150) {
				ustDuvarSagy2 += 15;
				ustDuvarSagx2 += 15;
			}
			if (ustDuvarUsty2 != 150) {
				ustDuvarUsty1 += 15;
				ustDuvarUsty2 += 15;
			}
		}

		// duvardan sekme
		if (sekme1 == true) {
			if (kusX < 745) {
				kusX += xdes2;
				kusY += ydes2;
			}
		}
		if (sekme2 == true) {
			if (kus2X < 745) {
				kus2X += xdes2;
				kus2Y += ydes2;
			}

		}
		repaint();
	}// action sonu

}
