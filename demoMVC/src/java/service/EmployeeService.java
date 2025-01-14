/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Employee;

/**
 *
 * @author nkmq21
 */
public interface EmployeeService {
    List<Employee> findAll();
    void save(Employee emp);
    Employee findByID(int id);
    void update(int id, Employee emp);
    void remove(int id);
}
