package com.knoldus.request
import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidator = mock[UserValidator]
  val AbhishekUser: User = User("Abhishek","Singh",23,"Knoldus","abhishek.singh@knoldus.com")

  "User" should "be created" in {
    val userImpl = new UserImpl(mockedUserValidator)

    when(mockedUserValidator.userIsValid(AbhishekUser)) thenReturn(true)
    val result = userImpl.createUser(AbhishekUser)
    assert(!result.isEmpty)
  }

  "User" should "not be created" in {
    val userImpl = new UserImpl(mockedUserValidator)

    when(mockedUserValidator.userIsValid(AbhishekUser)) thenReturn(false)
    val result = userImpl.createUser(AbhishekUser)
    assert(result.isEmpty)
  }

}
