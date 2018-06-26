package guitarMain;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Guitar Trainer");
		frame.setLocation(200,200);
		frame.setPreferredSize(new Dimension(1500,800));

		//calculate scale class instance.
		CalculateScaleClass calScale = new CalculateScaleClass();
		//send the root name
		calScale.sixStringRootNumM("C");

//		calScale.majorPentatonic();
//		calScale.minorPentatonic();
		calScale.majorScaleSearch();
		calScale.minorScaleSearch();
	      
		Container mainContentPanel = frame.getContentPane();
	      
		DrawGuitarString dgs = new DrawGuitarString();
	      
		mainContentPanel.add(dgs);


	      
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
