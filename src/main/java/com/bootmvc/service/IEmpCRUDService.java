package com.bootmvc.service;

import com.bootmvc.entity.Employee;


public interface IEmpCRUDService {
    public Iterable< Employee > getAllEmployees();
    public String saveEmployee( Employee employee);
    public Employee getEmployeeByID(Integer id);
    public String updateEmployee(Employee employee);
    public String deleteEmployeeByID(Integer id);
}
