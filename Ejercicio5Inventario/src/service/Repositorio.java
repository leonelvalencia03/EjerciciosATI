/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author HP
 */
public interface Repositorio<T, ID> {
    void agregar(T entidad);
    void actualizar(T entidad);
    void eliminar(ID id);
    Optional<T> buscarPorId(ID id);
    List<T> listar();
}
