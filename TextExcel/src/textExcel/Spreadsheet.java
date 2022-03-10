package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
    private Cell[][] sheet;
    @Override
    public String processCommand(String command)
    {
        String temp = ""; 
        String[] split = command.split(" ",3); 
        EmptyCell empty = new EmptyCell();
        if(split.length == 3) {
        	SpreadsheetLocation locate = new SpreadsheetLocation(split[0]);
        	if(split[2].substring(0,1).equals("\"")) {
                sheet[locate.getRow()][locate.getCol()] = new TextCell(removeQuotes(split[2]));
                temp = getGridText();
        	}
        	else if(split[2].endsWith("%")) {
                sheet[locate.getRow()][locate.getCol()] = new PercentCell(split[2]);
                temp = getGridText();
        	}
        	else if(split[2].substring(0,1).equals("(")) {
                sheet[locate.getRow()][locate.getCol()] = new FormulaCell(split[2]);
                temp = getGridText();
        	}
        	else {
                sheet[locate.getRow()][locate.getCol()] = new ValueCell(split[2]);
                temp = getGridText();
        	}
            

        }else if(split.length == 2){
            SpreadsheetLocation locate = new SpreadsheetLocation(split[1]);
            sheet[locate.getRow()][locate.getCol()] = empty;
            temp = getGridText();
        }else {
            if(split[0].toUpperCase().equals("CLEAR")){ 
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 12; j++) {
                        sheet[i][j] = empty;
                    }
                }
                temp = getGridText();
            } 
            else {
                SpreadsheetLocation located = new SpreadsheetLocation(command);
                temp = getCell(located).fullCellText();
            }
       }
        return temp;
    }
    public String removeQuotes(String Quoted){
        return Quoted.substring(1, Quoted.length()-1);
    }
    @Override
    public int getRows()
    {
        // TODO Auto-generated method stub
        return 20;
    }

    @Override
    public int getCols()
    {
        // TODO Auto-generated method stub
        return 12;
    }

    @Override
    public Cell getCell(Location loc)
    {
        int row = loc.getRow();
        int col = loc.getCol();
        return sheet[row][col];
    }
    public Cell getCell(int row, int col)
    {
        return sheet[row][col];
    }

    @Override
    public String getGridText()
    {
        String ans = "   |";
        
        for (char c = 'A'; c < 'M'; c++) {
            ans += c + "         |";
        }
        for (int i = 0; i <= 19; i++) {
            ans += "\n";
            if (i < 9) ans += (i+1) + "  |";
            if (i >= 9) ans += (i+1) + " |";
            for (int j = 0; j < 12; j++) {
                ans = ans + getCell(i,j).abbreviatedCellText() + "|";
            }
        }
            ans += "\n";
            return ans;    
    }
    public Spreadsheet(){
        EmptyCell nun = new EmptyCell();
        sheet = new Cell[20][12]; // creates an exmpty 2d array of Cells
        for (int i = 0; i <= 19; i++) {
            for (int j = 0; j <= 11; j++) {
                sheet[i][j] = nun;
            }
        }
    }
}