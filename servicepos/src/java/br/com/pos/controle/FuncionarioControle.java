package br.com.pos.controle;

import br.com.pos.modelo.Funcionario;
import br.com.pos.modelo.Usuario;
import br.com.pos.repositorio.FuncionarioDAO;
import br.com.pos.repositorio.IRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wanderson
 */
public class FuncionarioControle implements IControle<Funcionario> 
{

    public boolean salvar(Funcionario funcionario) 
    {
        boolean salvo = false;
        try
        {
            if(funcionario != null)
            {
                Usuario us = new Usuario();
                if(funcionario.getUsuario()!= null && !funcionario.getUsuario().getLogin().isEmpty())
                {
                    IControle usuarioControle = new UsuarioControle();
                    us = (Usuario) usuarioControle.buscarPorCodigo(funcionario.getUsuario().getLogin());
                }
                funcionario.setUsuario(us);
                IRepositorio dao = new FuncionarioDAO();
                salvo = dao.salvar(funcionario);
            }
        }
        catch(Exception ex){}
        return salvo;
    }

    public boolean atualizar(Funcionario funcionario) 
    {
        boolean atualizado = false;
        
        try
        {
            if(funcionario != null)
            {
                IRepositorio dao = new FuncionarioDAO();
                atualizado = dao.atualizar(funcionario);
            }
        }
        catch(Exception ex){}
        return atualizado;
    }

    public Funcionario buscarPorId(long id) 
    {
        Funcionario funcionario = new Funcionario();
        try
        {
            IRepositorio dao = new FuncionarioDAO();
            funcionario = (Funcionario) dao.buscarPorId(id);
        }
        catch(Exception ex){}
        return funcionario;
    }

    public Funcionario buscarPorCodigo(String codigo) 
    {
        Funcionario funcionario = new Funcionario();
        try
        {
            IRepositorio dao = new FuncionarioDAO();
            funcionario = (Funcionario) dao.buscarPorCodigo(codigo);
        }
        catch(Exception ex){}
        return funcionario;
    }

    public List<Funcionario> buscarTodos() 
    {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try
        {
            IRepositorio dao = new FuncionarioDAO();
            funcionarios = dao.buscarTodos();
        }
        catch(Exception ex){}
        return funcionarios;
    }

    public List<Funcionario> buscarTodosbyId(Long id) 
    {
       List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try
        {
            IRepositorio dao = new FuncionarioDAO();
            funcionarios = dao.buscarTodosbyId(id);
        }
        catch(Exception ex){}
        return funcionarios;
    }
    
}
