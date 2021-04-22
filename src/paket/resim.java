package paket;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class resim {
	
	//Bu class oyun javada kullanýlacak oyundaki tüm resimlerin deðiþkenleri buradan alýnýcak
	
	public BufferedImage sapan;
	public BufferedImage kus;
	public BufferedImage isaret;
	public BufferedImage domuz2;
	public BufferedImage domuz1;
	public BufferedImage yildiz;
	public BufferedImage yazi;
	//resimin adres adý
	public String a="resource/kus";
	
public resim() {	
	// ayarlar.java daki statik secim deðiþkenine göre resimin adres adý deðiþiyor
			try {
				@SuppressWarnings("unused")
				ayarlar sec = new ayarlar();
				if(ayarlar.secim==2) {
					a="resource/kus2";
				}
				else if(ayarlar.secim==3) {
					a="resource/kus3";
				}
				else if(ayarlar.secim==4) {
					a="resource/kus4";
				}

				//resim adresleri
				domuz2 = ImageIO.read(new FileImageInputStream(new File("resource/domuz2.png")));
				domuz1 = ImageIO.read(new FileImageInputStream(new File("resource/domuz1.png")));
				isaret = ImageIO.read(new FileImageInputStream(new File("resource/isaret.png")));
				sapan = ImageIO.read(new FileImageInputStream(new File("resource/sapan.png")));
				
				//secim deðiþkenine göre farklý resim çaðrýlýrýlýyor varsayalýn adý kus adýndaki kýrmýzý kuþ resmi
				kus = ImageIO.read(new FileImageInputStream(new File(a+".png")));
				
				
				yildiz = ImageIO.read(new FileImageInputStream(new File("resource/yýldýz.png")));
				yazi = ImageIO.read(new FileImageInputStream(new File("resource/yazi.png")));
				
				
			} catch (FileNotFoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
}
}
