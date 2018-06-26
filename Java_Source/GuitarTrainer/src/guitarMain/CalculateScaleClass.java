package guitarMain;

import java.util.LinkedList;

public class CalculateScaleClass {
	int num,root;
	String rootName;

	LinkedList <Integer> minorPentaScale = new LinkedList<Integer>();
	LinkedList <Integer> majorPentaScale = new LinkedList<Integer>();
	LinkedList <Integer> majSearch = new LinkedList <Integer>();
	LinkedList <Integer> minSearch = new LinkedList <Integer>();
	
	CalculateScaleClass (){
		this.root = 0;
		this.num = 0;
		this.rootName = null;
	}
	//Choose the root Number
	public void sixStringRootNumM(String rootName) {
		switch(rootName) {
		case "Fb":
		case "E":
			this.root = 0;
			break;
		case "Es":
		case "F":
			this.root = 1;
			break;
		case "Fs":
		case "Gb":
			this.root = 2;
			break;
		case "G":
			this.root = 3;
			break;
		case "Gs":
		case "Ab":
			this.root = 4;
			break;
		case "A":
			this.root = 5;
			break;
		case "As":
		case "Bb":
			this.root = 6;
			break;
		case "B":
			this.root = 7;
			break;
		case "Bs":
		case "C":
			this.root = 8;
			break;
		case "Cs":
		case "Db":
			this.root = 10;
			break;
		case "D":
			this.root = 11;
			break;
		}
	}
	
	//Calculate the Elements to the majorScalse 
	public void majorPentatonic() {
		this.num = this.root;
		majorPentaScale.add(this.root);

		for(int i = 0; i < 7; i ++) {
			if(i == 2||i == 6) {
				this.num = this.num + 1;
			}else {
				this.num = this.num + 2;
			}
			majorPentaScale.add(this.num);
		}
		this.num = 0;

//		minorPentaScale.set(3) 
//		this.minorPentaScale = this.majorScale[1];
//		this.majorPentaScale[2] = this.majorScale[2];
//		this.majorPentaScale[3] = this.majorScale[4];
//		this.majorPentaScale[4] = this.majorScale[5];

	}

	
	public void majorScaleSearch() {
		//num initialize
		this.num = this.root;
		majSearch.add(this.root);
		int cnt = 0;

		//아래로 찾기
		while( this.num > 0 ) {
			switch (cnt) {
				case 0:
				case 4:
					this.num = this.num - 1;
					if (this.num > 0) {
						majSearch.addFirst(this.num);
						cnt++;
					}
					break;
				case 7:
					cnt = 0;
					break;
				default:
					this.num = this.num - 2;
					if (this.num > 0) {
						majSearch.addFirst(this.num);
						cnt++;
					}
					break;
			}
		}
		//num, cnt initialize
		this.num = this.root;
		cnt = 0;

		//위로 찾기
		while( this.num < 49) 
		{
			switch (cnt) {
				case 2:
				case 6:
					this.num = this.num + 1;
					if (this.num > 0) {
						majSearch.add(this.num);
						cnt++;
					}
					break;
				case 7:
					cnt = 0;
					break;
				default:
					this.num = this.num + 2;
					if (this.num > 0) {
						majSearch.add(this.num);
						cnt++;
					}
					break;
			}
		}
	}
	
	public void minorScaleSearch() {
		this.num = this.root;
		int cnt = 0;
		minSearch.add(this.root);
//		System.out.println(this.num);
		//아래로 찾기
		while( this.num > 0 ) {
			switch (cnt) {
				case 2:
				case 5:
					this.num = this.num - 1;
					if (this.num > 0) {
						minSearch.addFirst(this.num);
						cnt++;
					}
					break;
				case 7:
					cnt = 0;
					break;
				default:
					this.num = this.num - 2;
					if (this.num > 0) {
						minSearch.addFirst(this.num);
						cnt++;
					}
					break;
			}
		}
		//num, cnt initialize
		this.num = this.root;
		cnt = 0;

		//위로 찾기
		while( this.num < 49)
		{
			switch (cnt) {
				case 1:
				case 4:
					this.num = this.num + 1;
					if (this.num > 0) {
						minSearch.add(this.num);
						cnt++;
					}
					break;
				case 7:
					cnt = 0;
					break;
				default:
					this.num = this.num + 2;
					if (this.num > 0) {
						minSearch.add(this.num);
						cnt++;
					}
					break;
			}
		}
	}
}






