package br.com.pos.servico;
import br.com.pos.controle.IControle;
import br.com.pos.controle.UsuarioControle;
import br.com.pos.modelo.Usuario;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author wanderson
 */
@Path("usuario")
public class UsuarioResource
{
    @Context
    private UriInfo context;

    public UsuarioResource() 
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
    @Path("/json/addUsuario")
    @Produces("application/json")
    public void addUsuario(Usuario usuario) 
    {
        IControle usuarioControle = new UsuarioControle();
        usuarioControle.salvar(usuario);
    }

    @POST
    @Path("/json/atualizarUsuario")
    @Produces("application/json")
    public void atualizarUsuario(Usuario usuario) 
    {
        IControle usuarioControle = new UsuarioControle();
        usuarioControle.atualizar(usuario);
    }

    @POST
    @Path("/json/autenticacao")
    @Produces("application/json")
    public Usuario autenticacao(Usuario usuario) 
    {
        if (usuario != null) 
        {
            return UsuarioControle.autenticacao(usuario.getLogin(), usuario.getSenha());
        } 
        else 
        {
            Usuario us = new Usuario();
            us.setAutenticado((byte) 0);
            return us;
        }
    }

}
