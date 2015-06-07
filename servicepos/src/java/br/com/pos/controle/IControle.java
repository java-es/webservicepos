package br.com.pos.controle;

import java.util.List;

/**
 *
 * @author wanderson
 */
public interface IControle<T> {
    boolean salvar(T objeto);
    boolean atualizar(T objeto);
    T buscarPorId(long id);
    T buscarPorCodigo(String codigo);
    List<T> buscarTodos();
    List<T> buscarTodosbyId(Long id);
}
