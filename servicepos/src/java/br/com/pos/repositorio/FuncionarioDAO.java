package br.com.pos.repositorio;

import br.com.pos.modelo.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JpaUtil;

/**
 *
 * @author wanderson
 */
public class FuncionarioDAO implements IRepositorio<Funcionario> 
{
    public boolean salvar(Funcionario funcionario) 
    {
        boolean salvo = false;
        if(funcionario!=null)
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            try
            {
                entityManager.getTransaction().begin();
                entityManager.persist(funcionario);
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

    public boolean atualizar(Funcionario funcionario) 
    {
        boolean atualizado = false;
        if(funcionario!=null)
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            try
            {
                entityManager.getTransaction().begin();
                entityManager.persist(funcionario);
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

    public Funcionario buscarPorCodigo(String codigo)
    {
        Funcionario funcionario = new Funcionario();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select f from Funcionario f where f.cpf = :codigo",Funcionario.class);
            query.setParameter("codigo", codigo);
            funcionario = (Funcionario) query.getSingleResult();
        }
        catch(Exception ex)
        {
        }
        return funcionario;
    }

    public List<Funcionario> buscarTodos() 
    {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select f from Funcionario f",Funcionario.class);
            funcionarios = query.getResultList();
        }
        catch(Exception ex){}
        return funcionarios;
    }

    public Funcionario buscarPorId(Long id) 
    {
        Funcionario funcionario = new Funcionario();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select f from Funcionario f where f.idFuncionario = :id",Funcionario.class);
            query.setParameter("id", id);
            funcionario = (Funcionario) query.getSingleResult();
        }
        catch(Exception ex)
        {
        }
        return funcionario;
    }

    public List<Funcionario> buscarTodosbyId(Long id) 
    {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try
        {
            EntityManager entityManager = JpaUtil.getEntityManager();
            Query query = entityManager.createQuery("select f from Funcionario f where f.usuario.idUsuario = :id",Funcionario.class);;
            query.setParameter("id", id);
            funcionarios = query.getResultList();
        }
        catch(Exception ex)
        {
           System.out.println("TESTE: "+ex.getMessage());
        }
        
        return funcionarios;
    }
}
