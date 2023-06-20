import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import model.contato.ContatoVO;
import model.contato.dao.ContatoDAO;
import services.ContatoService;

public class Playground {

    private ContatoService service;

    private ContatoVO obj1 = new ContatoVO("Bruno", "bruno@email.com");
    private ContatoVO obj2 = new ContatoVO("Vitor", "vitor@email.com");
    private ContatoVO obj3 = new ContatoVO("Thainá", "thaina@email.com");
    private ContatoVO obj4 = new ContatoVO("Esdras", "esdras@email.com");


    @BeforeEach
    public void setup() {
        service = new ContatoService(null);
    }

    @Test
    public void testSalvarContato() throws Exception {
        service.salvar(obj1);

        ContatoVO contatoSalvo = service.buscarPorId(1);
        Assertions.assertNotNull(contatoSalvo);
        Assertions.assertEquals(obj1.getNome(), contatoSalvo.getNome());
    }
    
    @Test
    public void testBuscarContatoPorId() throws Exception {
        // Criar e salvar um contato de teste
        service.salvar(obj2);

        ContatoVO contatoSalvo = service.buscarPorId(2);

        // Verificar se o contato foi encontrado corretamente
        Assertions.assertNotNull(contatoSalvo);
        Assertions.assertEquals(obj2.getNome(), contatoSalvo.getNome());
    }

    @Test
    public void testAtualizarContato() throws Exception {
        // Criar e salvar um contato de teste
        service.salvar(obj3);

        // Atualizar o nome do contato
        obj3.setNome("Patrícia Silva");
        service.atualizar(obj3);

        // Buscar o contato atualizado
        ContatoVO contatoAtualizado = service.buscarPorId(3);

        // Verificar se o nome foi atualizado corretamente
        Assertions.assertNotNull(contatoAtualizado);
        Assertions.assertEquals(obj3.getNome(), contatoAtualizado.getNome());
    }

    @Test
    public void testExcluirContato() throws Exception {
        // Criar e salvar um contato de teste
        service.salvar(obj4);

        // Excluir o contato
        service.excluir(4);

        // Tentar buscar o contato excluído pelo id
        ContatoVO contatoExcluido = service.buscarPorId(4);

        // Verificar se o contato foi excluído corretamente
        Assertions.assertNull(contatoExcluido);
    }

}
