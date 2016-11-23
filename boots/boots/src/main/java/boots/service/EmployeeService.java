package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.EmployeeRepository;
import boots.model.Employee;

@Service @Transactional
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository){
		super();
		this.employeeRepository=employeeRepository;
	}
	
	public List<Employee> findAll(){
		List<Employee> employees = new ArrayList<Employee>();
		for(Employee employee : employeeRepository.findAll()){
			employees.add(employee);
		}
		return employees;
	}
	
	public void save(Employee employee){
		employeeRepository.save(employee);
	}
	
	public void delete(int id){
		employeeRepository.delete(id);
	}
	
	public Employee findOne (int id){
		return employeeRepository.findOne(id);
	}

}
