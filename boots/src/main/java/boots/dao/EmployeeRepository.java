package boots.dao;

import org.springframework.data.repository.CrudRepository;

import boots.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
