package guitarMain;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawGuitarString extends JPanel{
	
	public void paint(Graphics g) {
		
		g.clearRect(0, 0, getWidth(), getHeight());
		
		for(int i = 0; i < 6; i++) {
	         g.drawLine(50,  100 + i * 50 , 1450, 100 +  i * 50);
	      }
		
		for(int i = 0; i < 21; i ++) {
			 g.drawLine(50 + i * 70,  100 , 50 + i * 70, 350 );
		}
		
		g.drawString("E", 35, 400 - 50  );
		g.drawString("A", 35, 400 - 95  );
		g.drawString("D", 35, 400 - 145  );
		g.drawString("G", 35, 400 - 195  );
		g.drawString("B", 35, 400 - 245  );
		g.drawString("E", 35, 400 - 295  );
		
		int dotX = 220;
		for(int i = 0; i < 8; i++) {
		
			if( i == 4 ) {
				g.drawString("oo", 840, 370  );
				dotX= 370;
			}else {
				g.drawString("o", dotX + i * 140, 370  );
			}
		}

	}
}
