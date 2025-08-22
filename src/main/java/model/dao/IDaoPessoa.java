package model.dao;

import java.util.List;
import model.Pessoa;

public interface IDaoPessoa {
    
    public void salvar(Pessoa p, boolean tipo);
    public void remover(Pessoa p, boolean tipo);
    public void atualizar(int codPessoa, Pessoa p, boolean tipo);
    public Object buscar(int codPessoa, boolean tipo);
    public List<Pessoa> listar(boolean tipo);
    
}
