package br.com.pos.servico;
//http://uaihebert.com/jpa-onetoone-unidirecional-e-bidirecional/
import br.com.pos.controle.FuncionarioControle;
import br.com.pos.controle.IControle;
import br.com.pos.modelo.Funcionario;
import br.com.pos.modelo.Resposta;
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
@Path("funcionario")
public class FuncionarioResource 
{
    @Context
    private UriInfo context;

    public FuncionarioResource() {
    }

    
    @GET
    @Path("/xml/teste")
    @Produces("application/xml")
    public String teste()
    {
        return "<xml>Teste</xml>";
    }
    
     @GET
    @Path("/json/testeTodos/{id}")
    @Produces("application/json")
    public List<Funcionario> testeTodos(@PathParam("id") int id) throws Exception 
    {
        try{
        IControle funcionarioControle = new FuncionarioControle();
        return funcionarioControle.buscarTodosbyId((long)id);
        }catch(Exception ex)
        {
            new Exception(ex.getMessage());
        }
        return null;
    }

    
    @POST
    @Path("/json/addFuncionario")
    @Produces("application/json")
    public Resposta addFuncionario(Funcionario funcionario) 
    {
        Resposta resposta = new Resposta();
        IControle funcionarioControle = new FuncionarioControle();
        if(funcionarioControle.salvar(funcionario) == false)
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
    @Path("/json/atualizarFuncionario")
    @Produces("application/json")
    public boolean atualizarFuncionario(Funcionario funcionario) 
    {
        IControle funcionarioControle = new FuncionarioControle();
        return funcionarioControle.atualizar(funcionario);
    }

    @POST
    @Path("/json/buscaTodos")
    @Produces("application/json")
    public List<Funcionario> buscaTodos(Funcionario funcionario)
    {
        IControle funcionarioControle = new FuncionarioControle();
        return funcionarioControle.buscarTodosbyId(funcionario.getUsuario().getIdUsuario());
    }

    @GET
    @Path("/json/getFuncionario/{codigo}")
    @Produces("application/json")
    public Funcionario getFuncionario(@PathParam("codigo") String codigo) 
    {
        IControle funcionarioControle = new FuncionarioControle();
        return (Funcionario) funcionarioControle.buscarPorCodigo(codigo);
    }
}
