package textExcel;

public class ValueCell extends RealCell{

    private String cellIn;

    public ValueCell(String cellIn){
        this.cellIn = cellIn;
    }
    public String abbreviatedCellText() { 
       return (getDoubleValue() + "          ").substring(0,10);
    }
    public String fullCellText() {
    	String answer = "";
    	if (cellIn.indexOf('.')== -1) {
    		answer = cellIn;
    	}
    	else {
    		answer =  getDoubleValue() + "";
    	}
    	return answer;
    }
    
    public double getDoubleValue() {
    	return Double.parseDouble(cellIn);
    }
}