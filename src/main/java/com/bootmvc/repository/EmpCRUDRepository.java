package com.bootmvc.repository;

import com.bootmvc.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmpCRUDRepository extends CrudRepository< Employee, Integer > {
}
