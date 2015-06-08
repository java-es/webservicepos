package br.com.pos.servico;

import br.com.pos.controle.ClienteControle;
import br.com.pos.controle.IControle;
import br.com.pos.modelo.Cliente;
import br.com.pos.modelo.Resposta;
import br.com.pos.modelo.Usuario;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
/**
 * REST Web Service
 *
 * @author wanderson
 */
@Path("cliente")
public class ClienteResource 
{
    @Context
    private UriInfo context;
    public ClienteResource() 
    {
    }

    @GET
    @Path("/xml/teste")
    @Produces("application/xml")
    public String teste()
    {
        return "<xml>Teste</xml>";
    }
    
    @POST
    @Path("/json/addCliente")
    @Produces("application/json")
    public Resposta addCliente(Cliente cliente)
    {
        Resposta resposta = new Resposta();
        IControle funcionarioControle = new ClienteControle();
        if(funcionarioControle.salvar(cliente) == false)
        {
            resposta.setCodigo("1");
            resposta.setIsErro(true);
            resposta.setMensagem("Erro ao salvar.");
        }
        else
        {
            resposta.setCodigo("2");
            resposta.setIsErro(false);
            resposta.setMensagem("");
        }
        return resposta;
    }

    @POST
    @Path("/json/atualizarCliente")
    @Produces("application/json")
    public boolean atualizarCliente(Cliente cliente) 
    {
        IControle clienteControle = new ClienteControle();
        return clienteControle.atualizar(cliente);
    }

    @POST
    @Path("/json/buscaTodos")
    @Produces("application/json")
    public List<Cliente> buscaTodos(Usuario usuario) 
    {
        IControle clienteControle = new ClienteControle();
        return clienteControle.buscarTodosbyId(usuario.getIdUsuario());
    }

    @GET
    @Path("/json/getCliente/{codigo}")
    @Produces("application/json")
    public Cliente getFuncionario(@PathParam("codigo") String codigo)
    {
        IControle funcionarioControle = new ClienteControle();
        return (Cliente) funcionarioControle.buscarPorCodigo(codigo);
    }
}
