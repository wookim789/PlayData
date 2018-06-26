package ex;

public class Palindrome {
	String s = "";
	int iRcnt=0, iLcnt=0;

	public static void main(String[] args) {
		
		
		
		

	}
	 public void checkLoop(String s) {
		 
	 }
	 public int solution(String s)
	    {
	        int answer = 0;
	        
	        
	        for(int i = 0; i < s.length() - 1; i++)  //첫번째 숫자 지정
	        {
	        	for(int j = i + 1; j < s.length() ; j ++ ) //첫번째와 값이 같은 인덱스 찾기
	        		{
	        			if(s.charAt(i) == s.charAt(j)) {
	        				this.iRcnt = i;
	        				this.iLcnt = j;
	        				for(int k = )
	        			}
	        		}
	        		
	        }
	        
	        System.out.println("Hello Java");

	        return answer;
	    }

}
