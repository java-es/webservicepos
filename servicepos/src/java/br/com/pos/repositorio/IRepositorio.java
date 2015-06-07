package br.com.pos.repositorio;

import java.util.List;

/**
 *
 * @author wanderson
 */
public interface IRepositorio<T> {
    boolean salvar(T objeto);
    boolean atualizar(T objeto);
    T buscarPorCodigo(String codigo);
    T buscarPorId(Long id);
    List<T> buscarTodos();
    List<T> buscarTodosbyId(Long id);
}
