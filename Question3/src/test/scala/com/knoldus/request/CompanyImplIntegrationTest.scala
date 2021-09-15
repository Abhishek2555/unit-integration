package com.knoldus.request
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplIntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val companyValidator = new CompanyValidator(companyName,validateEmail)

  "Company" should "not be created as it already exists in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "not be created as email id is not valid" in {
    val googleCompany: Company = Company("Google", "google@gmail", "Gurugram")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(result.isEmpty)
  }

  "Company" should "not be created as it already exists in DB and email id is not valid" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmailcom", "Noida")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be created" in {
    val googleCompany: Company = Company("Google", "google@gmail.com", "Gurugram")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(!result.isEmpty)
  }

}
