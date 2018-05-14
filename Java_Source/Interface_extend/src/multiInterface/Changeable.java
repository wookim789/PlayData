package multiInterface;

interface Changeable extends Resizeable, Colorable {
	void setFont(String font);
}
