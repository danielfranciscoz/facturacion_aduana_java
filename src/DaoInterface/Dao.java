/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import java.util.List;

/**
 *
 * @author Daniel-Zamora
 * @param <T>
 */
public interface Dao<T> {
    T findById(int id);
    List<T> findAll();
}