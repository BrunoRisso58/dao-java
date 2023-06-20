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

}
