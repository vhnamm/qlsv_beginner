/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddStudentDatabase.connect;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DAOinteface<T> {
    public ArrayList<T> getAllData();
    public boolean addData(T t);
    public boolean deleteByID(int id);
    public boolean updateData(T t);
}
