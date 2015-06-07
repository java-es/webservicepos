package br.com.pos.controle;

import br.com.pos.modelo.Cliente;
import br.com.pos.modelo.Usuario;
import br.com.pos.repositorio.ClienteDAO;
import br.com.pos.repositorio.IRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wanderson
 */
public class ClienteControle implements IControle<Cliente> 
{
    public boolean salvar(Cliente cliente) 
    {
     boolean salvo = false;
        try
        {
            if(cliente != null)
            {
                Usuario us = new Usuario();
                if(cliente.getUsuario()!= null && !cliente.getUsuario().getLogin().isEmpty())
                {
                    IControle usuarioControle = new UsuarioControle();
                    us = (Usuario) usuarioControle.buscarPorCodigo(cliente.getUsuario().getLogin());
                }
                cliente.setUsuario(us);
                IRepositorio dao = new ClienteDAO();
                salvo = dao.salvar(cliente);
            }
        }
        catch(Exception ex){}
        return salvo;
    }

    public boolean atualizar(Cliente cliente) 
    {
      boolean atualizado = false;
        
        try
        {
            if(cliente != null)
            {
                IRepositorio dao = new ClienteDAO();
                atualizado = dao.atualizar(cliente);
            }
        }
        catch(Exception ex){}
        return atualizado;
    }

    public Cliente buscarPorId(long id) 
    {
      Cliente cliente = new Cliente();
        try
        {
            IRepositorio dao = new ClienteDAO();
            cliente = (Cliente) dao.buscarPorId(id);
        }
        catch(Exception ex){}
        return cliente;
    }

    public Cliente buscarPorCodigo(String codigo) 
    {
     Cliente cliente = new Cliente();
        try
        {
            IRepositorio dao = new ClienteDAO();
            cliente = (Cliente) dao.buscarPorCodigo(codigo);
        }
        catch(Exception ex){}
        return cliente;
    }

    public List<Cliente> buscarTodos() 
    {
     List<Cliente> clientes = new ArrayList<Cliente>();
        try
        {
            IRepositorio dao = new ClienteDAO();
            clientes = dao.buscarTodos();
        }
        catch(Exception ex){}
        return clientes;
    }

    public List<Cliente> buscarTodosbyId(Long id) {
       List<Cliente> clientes = new ArrayList<Cliente>();
        try
        {
            IRepositorio dao = new ClienteDAO();
            clientes = dao.buscarTodosbyId(id);
        }
        catch(Exception ex){}
        return clientes;
    }
}
