import java.applet.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Music extends JApplet {
	private AudioClip ac;
	
	public Music() 
	{
		File f = new File("/Users/sumomomubezen/Desktop/start.wav");
		URL urlAudio;
		try {
				urlAudio = f.toURL();
				ac = Applet.newAudioClip(urlAudio);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ac.play();
	}
}
