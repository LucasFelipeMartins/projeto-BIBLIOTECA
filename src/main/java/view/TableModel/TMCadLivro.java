package view.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Livro;


public class TMCadLivro extends AbstractTableModel {
    
    private List<Livro> lst;
    
    private final int COL_TITULO = 0;
    private final int COL_ANO = 1;
    private final int COL_GENERO = 2;
    private final int COL_AUTOR = 3;
    private final int COL_AVALIACAO = 4;
    
    public TMCadLivro(List<Livro> lista) {
        this.lst = lista;
    }
    
    @Override
    public int getRowCount() {
        return this.lst.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    public Livro getObjetoLivro(int row){
       return this.lst.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Livro l = this.lst.get(rowIndex);
         if(columnIndex == COL_TITULO){
            return l.getTitulo();
        }else if(columnIndex == COL_ANO){
            return l.getAno();
        }else if(columnIndex == COL_GENERO){
            return l.getGenero();
        }else if(columnIndex == COL_AUTOR){
            return l.getLstNomeAutor();
        }else if(columnIndex == COL_AVALIACAO){
            return l.mediaAvaliacoes();
        }
        return "-";
    }
    
    public Livro getObejctLivro(int row){
        
        return this.lst.get(row);
    }
    
    
    @Override
    public String getColumnName(int columnIndex) {
        //qual o nome da coluna
         if(columnIndex == COL_TITULO){
            return "Titulo";
        }else if(columnIndex == COL_ANO){
            return "Ano";
        }else if(columnIndex == COL_GENERO){
            return "Genero";
        }else if(columnIndex == COL_AUTOR){
            return "Autor";
        }else if(columnIndex == COL_AVALIACAO){
            return "Avaliação";
        }     
        return "";
    }

    
}
