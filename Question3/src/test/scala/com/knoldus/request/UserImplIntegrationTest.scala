package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val userValidator = new UserValidator(companyName,validateEmail)

  val userImpl = new UserImpl(userValidator)

  "User" should "not be created as company does not exists in DB" in {
    val mohitUser: User = User("Mohit","Kumar",24,"Google","mohit.kumar@gmail.com")

    val result = userImpl.createUser(mohitUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as email id is not valid" in {
    val yanshikUser: User = User("Yanshik","Rajput",23,"Knoldus","yanshik.rajput@knoldus")

    val result = userImpl.createUser(yanshikUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as company does not exists in DB and email id is not valid" in {
    val mukulUser: User = User("Mukul","Kumar",22,"Microsoft","mukul.kumar@microsoft")

    val result = userImpl.createUser(mukulUser)
    assert(result.isEmpty)
  }

  "User" should "be created" in {
    val ShubhamUser: User = User("Shubham","Gupta",23,"Knoldus","shubham.gupta@knoldus.com")

    val result = userImpl.createUser(ShubhamUser)
    assert(!result.isEmpty)
  }

}
