package scoreHashMap;

public class ScoreClass {
	String num;
	String name;
	String kor;
	String eng;
	String mat;
	String tot;
	String avg;
	String grade;
	
	
	ScoreClass(String num){
		this.num = num;
	}

//	@Override
//	public int hashCode() {
//		return this.num.hashCode();
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		
//		if(!(obj instanceof ScoreClass)) {
//			return false;
//		}else {
//			ScoreClass instanceObj = (ScoreClass)obj;
//			if(this.num.equals(instanceObj.num)) {
//				return true;
//			}
//		}
//		return false;
//	}
}
