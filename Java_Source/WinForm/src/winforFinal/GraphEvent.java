package winforFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;

public class GraphEvent implements ActionListener{
	JTextField num;
	int ko ,en, ma;
	DrawClass dw;
	JTable table;
	String cast[];
	GraphEvent(JTextField num, JTable table, DrawClass dw){
		this.table = table;
		this.num = num;
		this.dw = dw;
		cast = new String[10];
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("이벤트");
		
		System.out.println(table.getValueAt(0, 0));
		
		for(int i = 0; i < table.getRowCount(); i++) 
		{
			if(table.getValueAt(i, 0).equals(this.num.getText())) 
			{
				for(int j = 2 ; j < table.getColumnCount(); j++) {
					this.cast[j] = table.getValueAt(i, j).toString();
				}
				this.ko = Integer.parseInt(cast[2]);
				this.en = Integer.parseInt(cast[3]);
				this.ma = Integer.parseInt(cast[4]);
				
				dw.setData(this.ko, this.en, this.ma, true);
				dw.repaint();
				System.out.println("리페인트");
				this.num.setText("");
				return;
				
			}
		}
	}
}
