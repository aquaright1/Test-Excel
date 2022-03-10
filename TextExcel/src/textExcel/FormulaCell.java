package textExcel;
import java.util.*;

public class FormulaCell extends RealCell{

    private String input;
    private double result;

    public FormulaCell(String input){
        this.input = input;
        this.result = getDoubleValue();
    }
    public String abbreviatedCellText() { 
    	return (result + "          ").substring(0,10);
    }
    public String fullCellText() {
        return input + "";
    }
    
    public double getDoubleValue() {
    	String[] expArray  = input.split(" ");
    	ArrayList<Double> operands = new ArrayList<Double>();
    	ArrayList<String> operators = new ArrayList<String>();
    	for(int i = 1; i < expArray.length - 1; i++) {
    		if(i % 2 == 1) {
    			operands.add(Double.parseDouble(expArray[i]));
    		}
    		if(i % 2 == 0) {
    			operators.add(expArray[i]);
    		}
    	}
    	double first = operands.get(0);
    	operands.remove(0);
    	for(int i = 0; i < operators.size(); i++) {
    		if(operators.get(i).equals("+")) {
    			first += operands.get(i);
    		}
    		else if(operators.get(i).equals("-")) {
    			first -= operands.get(i);
    		}
    		else if(operators.get(i).equals("*")) {
    			first *= operands.get(i);
    		}
    		else if(operators.get(i).equals("/")) {
    			first /= operands.get(i);
    		}
    	}
    	return first;
    }
}