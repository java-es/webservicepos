package br.com.pos.repositorio;

import br.com.pos.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JpaUtil;

/**
 *
 * @author wanderson
 */
public class ClienteDAO implements IRepositorio<Cliente> {

    public boolean salvar(Cliente cliente) 
    {
        boolean salvo = false;
        
        if(cliente!=null)
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            try
            {
                entityManager.getTransaction().begin();
                entityManager.persist(cliente);
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

    public boolean atualizar(Cliente cliente) 
    {
        boolean atualizado = false;
        if(cliente!=null)
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            try
            {
                entityManager.getTransaction().begin();
                entityManager.persist(cliente);
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

    public Cliente buscarPorCodigo(String codigo) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Cliente> buscarTodos() 
    {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select c from Cliente c",Cliente.class);
            clientes = query.getResultList();
        }
        catch(Exception ex){}
        return clientes;
    }

    public Cliente buscarPorId(Long id) 
    {
        Cliente cliente = new Cliente();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select c from Cliente c where c.idCliente = :id",Cliente.class);
            query.setParameter("id", id);
            cliente = (Cliente) query.getSingleResult();
         }
        catch(Exception ex)
        {
        }
        return cliente;
    }

    public List<Cliente> buscarTodosbyId(Long id) 
    {
       List<Cliente> clientes = new ArrayList<Cliente>();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select c from Cliente c where c.usuario.idUsuario = :id",Cliente.class);;
            query.setParameter("id", id);
            clientes = query.getResultList();
        }
        catch(Exception ex)
        {
            String ss = ex.getMessage();
            String sss = ss;
        }
        
        return clientes;
    }

}
