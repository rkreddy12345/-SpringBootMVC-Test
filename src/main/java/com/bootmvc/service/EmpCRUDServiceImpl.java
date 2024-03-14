package com.bootmvc.service;

import com.bootmvc.entity.Employee;
import com.bootmvc.repository.EmpCRUDRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service("empCRUDService")
public class EmpCRUDServiceImpl implements IEmpCRUDService{
    @Autowired
    private EmpCRUDRepository crudRepository;
    @Override
    public Iterable < Employee > getAllEmployees ( ) {
        return crudRepository.findAll ();
    }

    @Override
    public String saveEmployee (Employee employee ) {
        if(employee!=null)
            employee.setStatus ( "ACTIVE" );

        Integer id=crudRepository.save ( employee ).getId ();
        log.info ( "Employee saved with  ID={}  name={}",id, employee.getName ());
        return "Employee saved with  ID "+id;
    }

    @Override
    public Employee getEmployeeByID ( Integer id ) {
        Optional<Employee> optional=crudRepository.findById ( id );
        if(optional.isPresent ()){
            return optional.get ();
        }
        else
            throw new RuntimeException ("Employee with ID "+id+" not found");

    }

    @Override
    public String updateEmployee ( Employee employee ) {
        return "Employee with ID "+crudRepository.save (employee).getId ()+" updated.";
    }

    @Override
    public String deleteEmployeeByID ( Integer id ) {
        crudRepository.deleteById ( id );
        return "Employee with ID "+id+" deleted." ;
    }
}
