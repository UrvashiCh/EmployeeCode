package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.beans.EmployeeCode;

/**
 *  annotation is used to indicate that the class JpaRepository provides the mechanism for storage, retrieval, search, update and delete operation on objects.
 * @author Hemnath V
 * @author Urvashi Chaudhary
 * @author Sakshi Agrawal
 * @author Archit Khandelwal
 * @author Vikrant Bhardwaj
 * @author Karshni Mitra
 * @author Abhishek Sonavane
 * @author Venkata Surya Reddy
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeCode, Integer>
{

}
