package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	if(Character.isUpperCase(cellName.charAt(0))) {
    		col =  cellName.charAt(0) - 65;
    	}
    	else {
    		col = cellName.charAt(0) - 97;
    	}
    	
    	row = Integer.parseInt(cellName.substring(1)) - 1;
    }

}
