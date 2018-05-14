package scoreGUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		//출력화면 설정
		JFrame frame = new JFrame("성적 그래픽 처리");
		frame.setLocation(500,200);
		frame.setPreferredSize(new Dimension(800,800));
		
		//메인판넬
		Container contentPanel = frame.getContentPane();
		
		//그래프 판넬
		JPanel graph = new JPanel();
		
		//텍스트 필드와 버튼 판넬
		JPanel ui = new JPanel();
		//텍스트 필드
		JTextField kor = new JTextField(3);
		JTextField eng = new JTextField(3);
		JTextField mat = new JTextField(3);
		//버튼필드
		JButton B_draw = new JButton("그래프 그리기");
		//ui판넬에 해당 필드 넣기
		ui.add(kor);
		ui.add(eng);
		ui.add(mat);
		ui.add(B_draw);
		
		//DW클래스 객체 생성
		Drawing dw = new Drawing();
		
		//메인 판넬에 ui판넬 아래에 삽입
		contentPanel.add(ui,BorderLayout.SOUTH);
		//메인 판넬에 DW클래스 삽입
		contentPanel.add(dw,BorderLayout.CENTER);
		//그래프 출력 버튼에 이벤트 객체 삽입, 매개변수에 DW클래스 객체가 들어김
		B_draw.addActionListener(new ActionEventClass1(kor,eng ,mat,dw));
	
		//화면 출력
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);

	}

}
