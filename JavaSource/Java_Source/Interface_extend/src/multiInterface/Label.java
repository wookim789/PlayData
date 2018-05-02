package multiInterface;

public class Label implements Changeable {
	String text, font, foreground, background;
	int width	, height;
	
	Label(String text, String font, String foreground, String background, int width, int height){
		this.text = text;
		this.font = font;
		this.foreground = foreground;
		this.background = background;
		this.width = width;
		this.height = height;
	}
	@Override
	public void resize(int width , int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public void setForeground(String color) {
		this.foreground = color;
		
	}
	@Override
	public void setBackgroind(String color) {
		this.background = color;
	}
	@Override
	public void setFont(String font) {
		this.font = font;
	}
}
