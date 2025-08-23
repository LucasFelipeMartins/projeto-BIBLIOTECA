package view.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Autor;

public class TMCadAutor extends AbstractTableModel{
    
    private List<Autor> lst;
    
    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_CPF = 2;
    
    public TMCadAutor(List<Autor> lista) {
        this.lst = lista;
    }
    
    @Override
    public int getRowCount() {
        return this.lst.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    public Autor getObjetoAutor(int row){
       return this.lst.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Autor l = this.lst.get(rowIndex);
         if(columnIndex == COL_ID){
            return l.getId();
        }else if(columnIndex == COL_NOME){
            return l.getNome();
        }else if(columnIndex == COL_CPF){
            return l.getCpf();
        }
        return "-";
    }
    
    public Autor getObejctUsuario(int row){
        
        return this.lst.get(row);
    } 
    
    @Override
    public String getColumnName(int columnIndex) {
        //qual o nome da coluna
         if(columnIndex == COL_ID){
            return "Id";
        }else if(columnIndex == COL_NOME){
            return "Nome";
        }else if(columnIndex == COL_CPF){
            return "Cpf";
        }     
        return "";
    }
    
}
