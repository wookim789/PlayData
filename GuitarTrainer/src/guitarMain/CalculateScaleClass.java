package guitarMain;

import java.util.LinkedList;

public class CalculateScaleClass {
	int num,root;
	String rootName;
	
	int majorScale[], 
		majorPentaScale[], 
		
		minorScale[], 
		minorPentaScale[];
	LinkedList <Integer> majSearch = new LinkedList <Integer>();
	LinkedList <Integer> minSearch = new LinkedList <Integer>();
	
	CalculateScaleClass (int root){
		this.root = root;
		this.num = 0;
		this.majorScale = new int[8];
		this.minorScale = new int[8];
		this.majorPentaScale = new int [5];
		this.minorPentaScale = new int [5];
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
		case "Cb":
			this.root = 8;
			break;
			
		case "C":
			this.root = 9;
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
	public void majorScaleM() {
		this.num = this.root;
		this.majorScale[0] = this.root;
		
		for(int i = 0; i <= 7; i ++) {
			if(i == 3||i == 7) {
				this.num = this.num + 1;
			}else {
				this.num = this.num + 2;
			}
			
			this.majorScale[i+1] = this.num;
		}
		this.num = 0;
	}
	
	//Calculate the Elements to the minorScalse 
	public void minorScaleM() {
		this.num = this.root;
		this.minorScale[0] = this.root;
		
		for(int i =0; i <= 7; i ++) {
			if(i == 1||i == 4) {
				this.num = this.num + 1;
			}else {
				this.num = this.num + 2;
			}
			
			this.minorScale[i+1] = this.num;
		}
		this.num = 0;
	}	
	
	//Calculate the Elements to the Pentatonic

	public void majorPentatonic() {
		this.majorPentaScale[0] = this.majorScale[0];
		this.majorPentaScale[1] = this.majorScale[1];
		this.majorPentaScale[2] = this.majorScale[2];
		this.majorPentaScale[3] = this.majorScale[4];
		this.majorPentaScale[4] = this.majorScale[5];
	}
	public void minorPentatonic() {
		this.minorPentaScale[0] = this.majorScale[0];
		this.minorPentaScale[1] = this.majorScale[2]-1;
		this.minorPentaScale[2] = this.majorScale[3];
		this.minorPentaScale[3] = this.majorScale[4];
		this.minorPentaScale[4] = this.majorScale[6]-1;
	}
	
	public void majorScaleSearch() {
		this.num = this.root;
		int cnt = 0;

		//아래로 찾기
		while(  this.num > 0) 
		{
			if(cnt == 7) {
				cnt = 0;
			}
			if((cnt == 0)||(cnt == 4 ))
			{	
				cnt++;
				if(this.num > 0) {
					majSearch.addFirst(this.num - 1);
				}else {
					break;
				}
				
			}else  {
				if(this.num > 0) {
					majSearch.addFirst(this.num - 2);
				}else {
					break;
				}
				if(cnt < 7) {
					cnt++;
				}else {
					cnt = 0;
				}
				
			}
		}
		cnt = 0;
		//위로 찾기
		while( this.num < 49) 
		{
			if(cnt == 7) {
				cnt = 0;
			}
			if((cnt == 2)||(cnt == 6 ))
			{	
				cnt++;
				if(this.num > 0) {
					majSearch.addFirst(this.num + 1);
				}else {
					break;
				}
				
			}else  {
				if(this.num > 0) {
					majSearch.addFirst(this.num + 2);
				}else {
					break;
				}
				if(cnt < 7) {
					cnt++;
				}else {
					cnt = 0;
				}	
			}
		}
	}
	
	public void minorScaleSearch() {
		this.num = this.root;
		//아래로 찾기
		while (this.num > 0) 
		{
			if(twoCount ==2 && threeCount == 5) {
				twoCount = 0;
				threeCount = 0;
			} 
			if((twoCount == 2 && threeCount == 0)||
			   (twoCount == 2 && threeCount == 2)||
			   (twoCount == 2 && threeCount == 5)) 
			{	
				if(threeCount < 5) {
					threeCount++;
				}
				if(this.num > 0) {
					majSearch.addFirst(this.num - 1);
				}else {
					break;
				}
				
			}else if(twoCount < 2) {
				if(this.num > 0) {
					majSearch.addFirst(this.num - 2);
				}else {
					break;
				}
				twoCount++;
				
			}else if(threeCount < 5){
				if(this.num > 0) {
					majSearch.addFirst(this.num - 2);
				}else {
					break;
				}
				threeCount++;
			}
	}
		for(int i = 0; this.num < 49; i++) 
		{
			if( twoCount ==1 && threeCount == 4){
				twoCount = 0;
				threeCount = 0;
			}
			if((twoCount == 2 && threeCount == 0)||
			   (twoCount == 2 && threeCount == 3)) 
			{	
				if(twoCount == 0 ) {
					twoCount++;
				}else if(threeCount ==0) {
					threeCount++;
				}
				if(this.num < 49) {
					majSearch.addFirst(this.num + 1);
				}else {
					break;
				}
				
			}else if(twoCount < 2) {
				if(this.num < 49) 
					majSearch.addFirst(this.num + 2);
				else
					break;
				
				twoCount++;
				
			}else if(threeCount < 3){
				if(this.num > 0) 
					majSearch.addFirst(this.num - 2);
				else 
					break;
				
				threeCount++;
			}
		}
	}
}






