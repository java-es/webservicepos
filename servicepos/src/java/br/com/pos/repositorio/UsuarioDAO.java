package br.com.pos.repositorio;

import br.com.pos.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JpaUtil;

/**
 *
 * @author wanderson
 */
public class UsuarioDAO implements IRepositorio<Usuario> 
{
    public boolean salvar(Usuario usuario) 
    {
        boolean salvo = false;
        if(usuario!=null && !usuario.getLogin().isEmpty())
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            try
            {
                entityManager.getTransaction().begin();
                entityManager.persist(usuario);
                entityManager.getTransaction().commit();
                salvo = true;
            }
            catch(Exception ex)
            {
                if(entityManager.isOpen())
                {
                    entityManager.getTransaction().rollback();
                }
            } 
            finally 
            {
                if(entityManager.isOpen())
                {
                    entityManager.close();
                }
            }
        }
        return salvo;
    }

    public boolean atualizar(Usuario usuario) 
    {
        boolean atualizado = false;
        if(usuario!=null && !usuario.getLogin().isEmpty())
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            try
            {
                entityManager.getTransaction().begin();
                entityManager.persist(usuario);
                entityManager.getTransaction().commit();
                atualizado = true;
            }
            catch(Exception ex)
            {
                if(entityManager.isOpen())
                {
                    entityManager.getTransaction().rollback();
                }
            } 
            finally 
            {
                if(entityManager.isOpen())
                {
                    entityManager.close();
                }
            }
        }
        return atualizado;
    }

    public Usuario buscarPorCodigo(String codigo) 
    {
        Usuario usuario = new Usuario();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select u from Usuario u where u.login = :login",Usuario.class);
            query.setParameter("login", codigo);
            usuario = (Usuario) query.getSingleResult();
        }
        catch(Exception ex)
        {
        }
        return usuario;
    }

    public List<Usuario> buscarTodos() 
    {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select u from Usuario u",Usuario.class);
            usuarios = query.getResultList();
        }
        catch(Exception ex){}
        return usuarios;
    }

    public Usuario buscarPorId(Long id)
    {
        Usuario usuario = new Usuario();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select u from Usuario u where u.idUsuario = :id",Usuario.class);
            query.setParameter("id", id);
            usuario = (Usuario) query.getSingleResult();
        }
        catch(Exception ex)
        {
        }
        return usuario;
    }

    public List<Usuario> buscarTodosbyId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
