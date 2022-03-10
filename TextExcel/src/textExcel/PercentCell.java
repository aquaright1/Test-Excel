package textExcel;

public class PercentCell extends RealCell{

    private String cellIn;

    public PercentCell(String input){
        this.cellIn = input;
    }
    public String abbreviatedCellText() {
        return (cellIn.substring(0,cellIn.indexOf('.')) +"%" +  "             ").substring(0,10);
    }
    public String fullCellText() {
    	return Double.parseDouble(cellIn.substring(0,cellIn.indexOf("%")))/100 + "";
    }
    
    public double getDoubleValue() {
    	return Double.parseDouble(cellIn.substring(0,cellIn.indexOf("%")-1));
    }
}