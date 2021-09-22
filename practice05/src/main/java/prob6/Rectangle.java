package prob6;

public class Rectangle extends Shape implements Resizable {

	private double width;
	private double height;
	
	public Rectangle(double w , double h) {
		this.width = w;
		this.height = h;
		
	}
	
	@Override
	public Double getArea() {
		
		return width*height;
	}

	@Override
	public Double getPerimeter() {
		
		return (width + height) *2;
	}

	@Override
	public void resize(double s) {
		width = width*s;
		height = height*s;
		
	}

}
