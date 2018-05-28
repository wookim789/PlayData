package ex;

import java.util.LinkedList;
public class ReverseStr {
	
	public String reverseStr(String str) {
		//141,172 소
        //101, 132
        LinkedList <Character> a = new LinkedList <Character>();
        String b ="";
        char sw = 's';
        
        for(int i = 0; i < str.length(); i++){
           a.add(str.charAt(i));
        }
      
        for(int i = 0; i < a.size(); i++) {
        	
        	 for(int j = 0; j < a.size(); j++) 
        	 {
        		 if(i < j) {
        			 
        			  if(a.get(i) < a.get(j)){
        				  
        				 sw = a.get(i);
        				 a.set(i, a.get(j));
        				 a.set(j,sw);
        				 i = 0;
        				 j = 0;
        			 }
        		 }else if( i > j ){
        			 if(a.get(i) > a.get(j)) {  
    
        				 sw = a.get(i);
        				 a.set(i, a.get(j));
        				 a.set(j,sw);
        				 i = 0;
        				 j = 0;
        			 }
        		 }
        		
        	 }
        }
        
        for(int i = 0; i < a.size(); i++){
        	b += a.get(i).toString();
           }
           
        
		return b;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		ReverseStr rs = new ReverseStr();
		System.out.println( rs.reverseStr("Zbcdefg") );
	}
	
}