package textExcel;

public abstract class RealCell implements Cell{
	private String input;
	
	public abstract double getDoubleValue();
	public abstract String abbreviatedCellText();
	public abstract String fullCellText();
	
	
}
