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
import boots.model.Hotel;
import boots.model.Task;
import boots.service.EmployeeService;
import boots.service.HotelService;
import boots.service.TaskService;

@Controller
public class MainController {
  
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private HotelService hotelService;
	

	@Autowired
	private EmployeeService employeeService;
	
	
	
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}


	@GetMapping("/all-hotels")
	public String allHotels(HttpServletRequest request){
		request.setAttribute("hotels", hotelService.findAll());
		request.setAttribute("mode", "MODE_HOTELS");
		return "index";
	}
	
	
	
	
	
	
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	@GetMapping("/new-hotel")
	public String newHotel(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_H");
		return "index";
	}
	
	
	
	

	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request){
		taskService.save(task);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@PostMapping("/save-hotel")
	public String saveHotel(@ModelAttribute Hotel hotel, BindingResult bindingResult, HttpServletRequest request){
		hotelService.save(hotel);
		request.setAttribute("hotels", hotelService.findAll());
		request.setAttribute("mode", "MODE_HOTELS");
		return "index";
	}
	
	
	
	
	
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("task", taskService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/update-hotel")
	public String updateHotel(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("hotel", hotelService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_H");
		return "index";
	}
	
	
	
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id, HttpServletRequest request){
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	@GetMapping("/delete-hotel")
	public String deleteHotel(@RequestParam int id, HttpServletRequest request){
		hotelService.delete(id);
		request.setAttribute("hotels", hotelService.findAll());
		request.setAttribute("mode", "MODE_HOTELS");
		return "index";
	}
	
	
	
	
	
	
	@GetMapping("/all-employees")
	public String allEmployees(HttpServletRequest request){
		request.setAttribute("employees", employeeService.findAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "index";
	}
	
	@GetMapping("/new-employee")
	public String newEmployee(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_E");
		return "index";
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult, HttpServletRequest request){
		
		employeeService.save(employee);
		request.setAttribute("employees", employeeService.findAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "index";
	}
	
	@GetMapping("/update-employee")
	public String updateEmployee(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("employee", employeeService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_E");
		return "index";
	}
	
	@GetMapping("/delete-employee")
	public String deleteEmployee(@RequestParam int id, HttpServletRequest request){
		employeeService.delete(id);
		request.setAttribute("employees", employeeService.findAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "index";
	}
	
 }
