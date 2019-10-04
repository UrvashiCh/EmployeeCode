package com.cg.ctrl;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.beans.EmployeeCode;
import com.cg.dao.EmployeeRepository;
import com.cg.exception.EMSNotFoundException;

/**
 * EmployeeController is a REST Controller which is used for handling requests and generating appropriate responses. 
 * @author Hemnath V
 * @author Urvashi Chaudhary
 * @author Sakshi Agrawal
 * @author Archit Khandelwal
 * @author Vikrant Bhardwaj
 * @author Karshni Mitra
 * @author Abhishek Sonavane
 * @author Venkata Surya Reddy
 */


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/employeecode")
public class EmployeeController 
{

	private static Logger log = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository repo;
	
	/**
	 * getAllEmployees method is used to return the list of all employees
	 * @return list of all employees
	 * @throws EMSNotFoundException 
	 */
	
	@GetMapping(value="/display/")
	public List<EmployeeCode> getAllEmployees() throws EMSNotFoundException
	{
		List<EmployeeCode> list = repo.findAll();
		log.info("Returning List of records");
		if(list.isEmpty())
		{
			log.error("No records found");
			throw new EMSNotFoundException("No Records in the Database");
		}
		
		return list;
	}
	
	

	/**
	 * findEmployeeById method is used to find an employee based on Id
	 * @param Id
	 * @return employee with the matching Id
	 * @throws EMSNotFoundException 
	 */
	
	
	@GetMapping(value="/find/{id}")
	public EmployeeCode findEmployeeById (@PathVariable("id") int id) throws EMSNotFoundException
	{
		EmployeeCode employee = repo.findById(id).get();
		log.info("Finding Employee By ID");
		if(employee==null)
		{
			log.error("Invalid Employee ID entered: "+id);
			throw new EMSNotFoundException("Invalid Employee ID: "+id);
		}
		return employee;
	}
	

	/**
	 * add method is used to add an employee 
	 * @param Employee object
	 * @return Employee that has been added
	 */
	
	@PostMapping(value="/addEmployee",consumes=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeCode add(@RequestBody EmployeeCode emp)
	{
		repo.save(emp);
		log.info("Employee Info Added Successfully");
		return emp;
	}
	

	/**
	 * update method is used to update an employee's details
	 * @param Employee object
	 * @return 1 when the changes have been made
	 */
	
	@PutMapping(value="/modify")
	public int update(@RequestBody EmployeeCode emp) {
		repo.save(emp);
		log.info("Employee Info Updated of ID: "+emp.getEmpId());
		return 1;
	}
	
	
	/**
	 * deleteEmployee method is used to delete an employee based on Id
	 * @param Id
	 * @return Id of employee that has been deleted
	 * @throws EMSNotFoundException 
	 */
	
	@DeleteMapping(value="/delete/{unm}")
	public boolean deleteEmployee(@PathVariable("unm") int unm) throws EMSNotFoundException
	{

		repo.deleteById(unm);
		log.info("Employee Deleted");
		return true;
	}
}
