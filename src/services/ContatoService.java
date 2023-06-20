package services;

import java.util.List;
import java.util.logging.Logger;

import model.contato.ContatoVO;
import model.contato.dao.IContatoDAO;

public class ContatoService implements IContatoService {

    final private Logger logger = Logger.getLogger(ContatoService.class.getName());

    private final IContatoDAO dao;

    public ContatoService(IContatoDAO dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(ContatoVO pContato) throws Exception {
        this.dao.salvar(pContato);
    }

    @Override
    public void atualizar(ContatoVO pContato) throws Exception {
        this.dao.atualizar(pContato);
    }

    @Override
    public ContatoVO buscarPorEmail(String pEmail) throws Exception {
        ContatoVO contato = this.dao.buscarPorEmail(pEmail);
        return contato;
    }

    @Override
    public ContatoVO buscarPorId(Integer pId) throws Exception {
        ContatoVO contato = this.dao.buscarPorId(pId);
        return contato;
    }

    @Override
    public List<ContatoVO> buscarTodos() throws Exception {
        List<ContatoVO> contatos = this.dao.buscarTodos();
        return contatos;
    }

    @Override
    public void excluir(Integer pId) throws Exception {
        this.dao.excluir(pId);
    }

    @Override
    public ContatoVO ultimoDado() throws Exception {
        ContatoVO contato = this.dao.ultimoDado();
        return contato;
    }
}
