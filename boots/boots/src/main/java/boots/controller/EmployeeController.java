package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Employee;
import boots.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/all-employees")
	public String allEmployees(HttpServletRequest request){
		request.setAttribute("employees", employeeService.findAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "employee";
	}
	
	@GetMapping("/new-employee")
	public String newEmployee(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_E");
		return "employee";
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult, HttpServletRequest request){
		
		employeeService.save(employee);
		request.setAttribute("employees", employeeService.findAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "employee";
	}
	
	@GetMapping("/update-employee")
	public String updateEmployee(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("employee", employeeService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_E");
		return "employee";
	}
	
	@GetMapping("/delete-employee")
	public String deleteEmployee(@RequestParam int id, HttpServletRequest request){
		employeeService.delete(id);
		request.setAttribute("employees", employeeService.findAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "employee";
	}
	
 }

