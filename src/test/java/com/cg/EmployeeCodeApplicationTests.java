package com.cg;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.beans.EmployeeCode;
import com.cg.ctrl.EmployeeController;
import com.cg.dao.EmployeeRepository;
import com.cg.exception.EMSNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeCodeApplicationTests {

 @Test
 public void contextLoads() {
 }

 @Mock
 @Autowired
 EmployeeRepository empRepo;

 @InjectMocks
 EmployeeController empCtrl;

 @Spy
 List<EmployeeCode> list = new ArrayList<EmployeeCode>();

 @Captor
 ArgumentCaptor<EmployeeCode> captor;

 @Before
 public void setup() {
 MockitoAnnotations.initMocks(this);
 list.add(new EmployeeCode(1, "Test1", "LHOPH5637H", "Analyst", "JEE Cloud", Date.valueOf(LocalDate.now()),
  Date.valueOf(LocalDate.now()), (float) 25000.25, "test1@gmail.com", "Test1@123"));
 list.add(new EmployeeCode(2, "Test2", "LXGJH4526K", "Senior Analyst", "JEE FullStack",
  Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), (float) 55000.25, "test2@gmail.com",
  "Test2@123"));
 }

 @Test
 public void addEmployee() {
 EmployeeCode addEmp = new EmployeeCode(2, "Test2", "LXGJH4526K", "Senior Analyst", "JEE FullStack",
  Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), (float) 55000.25, "test2@gmail.com",
  "Test2@123");
 when(empRepo.save(any(EmployeeCode.class))).thenReturn(addEmp);
 empCtrl.add(addEmp);
 verify(empRepo, times(1)).save(captor.capture());
 Assert.assertEquals(captor.getValue().getEmpId(), 2);
 Assert.assertEquals(2, list.size());
 verify(list, times(2)).add(any(EmployeeCode.class));
 }

 @Test
 public void updateEmployee() {
 EmployeeCode updEmp = new EmployeeCode(2, "Test2", "LXGJH4526K", "Senior Analyst", "JEE FullStack",
  Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), (float) 55000.25, "test2@gmail.com",
  "Test2@123");
 when(empRepo.save(any(EmployeeCode.class))).thenReturn(updEmp);
 empCtrl.update(updEmp);
 verify(empRepo, times(1)).save(captor.capture());
 Assert.assertEquals(captor.getValue().getEmpId(), 2);
 Assert.assertEquals(2, list.size());
 verify(list, times(2)).add(any(EmployeeCode.class));
 }

 @Test
 public void searchEmployee() {
 EmployeeCode updEmp = new EmployeeCode(2, "Test2", "LXGJH4526K", "Senior Analyst", "JEE FullStack",
  Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), (float) 55000.25, "test2@gmail.com",
  "Test2@123");
 when(empRepo.findById(any(Integer.class))).thenReturn(java.util.Optional.of(updEmp));
 try {
	Assert.assertEquals(2, empCtrl.findEmployeeById(2).getEmpId());
} catch (EMSNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 Assert.assertEquals(2, list.size());
 verify(list, times(2)).add(any(EmployeeCode.class));
 }

 @Test
 public void viewEmployees()
 {
 when(empRepo.findAll()).thenReturn(list);
 Iterable<EmployeeCode> iter = null;
try {
	iter = empCtrl.getAllEmployees();
} catch (EMSNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 List<EmployeeCode> list2 = new ArrayList<EmployeeCode>();
 iter.forEach(list2::add);
 Assert.assertEquals(2, list2.size());
 Assert.assertEquals(2, list.size());
 Assert.assertNotNull(iter);
 }

 @Test
 public void deleteEmployee() throws EMSNotFoundException
 {
  /*doNothing().when(empRepo).deleteById(any(Integer.class));
  empCtrl.deleteEmployee(1);
	verify(empRepo, times(1)).deleteById(1);*/
	  doNothing().when(empRepo).deleteById(any(Integer.class));

	  //Assert.assertEquals("1deleted",empCtrl.deleteEmployee(1));
	  Assert.assertTrue(empCtrl.deleteEmployee(1));

 }
 }
