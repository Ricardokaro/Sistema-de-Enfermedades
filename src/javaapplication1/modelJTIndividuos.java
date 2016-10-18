/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author borsigr04
 */
public class modelJTIndividuos extends AbstractTableModel {

    private String[] columnNames = {"ERROR PATRON"};;
    ArrayList<Individuo> data;

    public ArrayList<Individuo> getLstdatos() {
        return data;
    }

    public void setLstdatos(ArrayList<Individuo> lstdoc) {
        this.data = lstdoc;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
/*
     * JTable usa este metodo para identificar the default renderer/
     * editor para cada celda.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @Override
    public Class getColumnClass(int c) {

        Object value = this.getValueAt(0, c);
        return (value == null ? Object.class : value.getClass());
    }
   public  Individuo getFila(int row){
        return (Individuo) (data.get(row));
    }
    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void setValueAt(Object value, int row, int col) {
       Individuo macData = (Individuo) (data.get(row));
        switch (col) {
            case 0:
                macData.setErrorPatron((double)value);
                break;          
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        Individuo macData = (Individuo) (data.get(row));
        switch (col) {
            case 0:
                return macData.getErrorPatron();                
        }
        return new String();
    }
}


