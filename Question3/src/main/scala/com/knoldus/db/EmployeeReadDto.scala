package com.knoldus.db

import com.knoldus.models.Employee
import scala.collection.immutable.HashMap

class EmployeeReadDto {

  val ShubhamEmployee: Employee = Employee("Abhishek","Singh",23,12000,"Intern","knoldus","abhishek.singh@knoldus.com")
  val AmanEmployee: Employee = Employee("Abhay","singh",24,15000,"Software Engineer","Philips","aman.singh@philips.com")

  val employees: HashMap[String, Employee] = HashMap("Abhishek" -> ShubhamEmployee, "Abhay" -> AmanEmployee)
  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)

}
