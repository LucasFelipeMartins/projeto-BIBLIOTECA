package view.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuario;

public class TMCadUsuario  extends AbstractTableModel{
 
    private List<Usuario> lst;
    
    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_CPF = 2;
    private final int COL_GENERO = 3;
    
    public TMCadUsuario(List<Usuario> lista) {
        this.lst = lista;
    }
    
    @Override
    public int getRowCount() {
        return this.lst.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    public Usuario getObjetoUsuario(int row){
       return this.lst.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Usuario l = this.lst.get(rowIndex);
         if(columnIndex == COL_ID){
            return l.getId();
        }else if(columnIndex == COL_NOME){
            return l.getNome();
        }else if(columnIndex == COL_CPF){
            return l.getCpf();
        }else if(columnIndex == COL_GENERO){
            return l. getLstGenero();
        }
        return "-";
    }
    
    public Usuario getObejctUsuario(int row){
        
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
        }else if(columnIndex == COL_GENERO){
            return "Genero";
        }     
        return "";
    }
    
}
