package br.com.pos.controle;

import br.com.pos.modelo.Usuario;
import br.com.pos.repositorio.IRepositorio;
import br.com.pos.repositorio.UsuarioDAO;
import java.util.List;

/**
 *
 * @author wanderson
 */
public class UsuarioControle implements IControle<Usuario> 
{

    public boolean salvar(Usuario usuario) 
    {
        boolean salvo = false;
        try
        {
            IRepositorio usuarioDAO = new UsuarioDAO();
            salvo = usuarioDAO.salvar(usuario);
        }
        catch(Exception ex){}
        return salvo;
    }

    public boolean atualizar(Usuario usuario)
    {
        boolean atualizado = false;
        try
        {
            IRepositorio usuarioDAO = new UsuarioDAO();
            atualizado = usuarioDAO.atualizar(usuario);
        }
        catch(Exception ex){}
        return atualizado;
    }

    public Usuario buscarPorId(long id) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario buscarPorCodigo(String codigo) 
    {
        Usuario usuario = new Usuario();
        try
        {
            IRepositorio usuarioDAO = new UsuarioDAO();
            usuario = (Usuario) usuarioDAO.buscarPorCodigo(codigo);
        }
        catch(Exception ex){}
        return usuario;
    }

    public List<Usuario> buscarTodos() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Usuario autenticacao(String login, String senha) 
    {
        byte autenticado = 0;
        Usuario usuario = null;
        try 
        {
            if (login != null && !login.isEmpty()) 
            {
                IRepositorio usuarioDAO = new UsuarioDAO();
                usuario = (Usuario) usuarioDAO.buscarPorCodigo(login);
                if (usuario != null && !usuario.getLogin().isEmpty() && !usuario.getSenha().isEmpty()) 
                {
                    if (usuario.getSenha().equals(senha))
                    {
                        autenticado = 1;
                    }
                }
            }
        } catch (Exception ex) 
        {
        }
        if(usuario == null)
        {
            usuario = new Usuario();
        }
        usuario.setAutenticado(autenticado);
        return usuario;
    }

    public List<Usuario> buscarTodosbyId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
