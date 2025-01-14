/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import model.Employee;

/**
 *
 * @author nkmq21
 */
public class EmployeeServiceImplement implements EmployeeService {

    private static Map<Integer, Employee> empMap = new HashMap<>();

    public EmployeeServiceImplement() {
        empMap.put(1, new Employee(1, "duy", "a@gmail.com", "ha noi"));
        empMap.put(2, new Employee(2, "beo", "b@gmail.com", "da nang"));
        empMap.put(3, new Employee(3, "chigga", "c@gmail.com", "trung quoc"));

    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(empMap.values());
    }

    @Override
    public void save(Employee emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employee findByID(int id) {
        for (Employee em : empMap.values()) {
            if (em.getId() == id) {
                return em;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Employee emp) {
        empMap.put(id, emp);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        EmployeeServiceImplement emp = new EmployeeServiceImplement();
//        System.out.println(emp.findByID(5).getName());
        for (Map.Entry<Integer, Employee> entry : empMap.entrySet()) {
            System.out.println("id: " + entry.getKey() + "value: " + entry.getValue().getName());
        }
    }

}
