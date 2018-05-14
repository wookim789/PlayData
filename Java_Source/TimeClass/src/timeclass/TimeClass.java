package timeclass;
import java.text.SimpleDateFormat;
import java.util.*;


public class TimeClass {

	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		TimeZone timeZone = TimeZone.getTimeZone("Europe/London");
		calendar.setTimeZone(timeZone);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) +1;
		int date = calendar.get(Calendar.DATE);
		int amPm = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		String sAmPm = amPm == Calendar.AM ? "오전" : "오후";
		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초 \n",year,month,date,amPm,hour,min,sec);
		
		GregorianCalendar calendar2 = new GregorianCalendar();
		SimpleDateFormat dateFormat =
					new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
		String str = dateFormat.format(calendar2.getTime());
		System.out.println(str);
	
	}	

}
