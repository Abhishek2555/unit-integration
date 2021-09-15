package com.knoldus.validator
import org.scalatest.flatspec.AnyFlatSpec

class PasswordValidatorTest extends AnyFlatSpec {

  val passwordValidator: PasswordValidator = new PasswordValidator()

  "Password" should "be valid" in {

    val result: Boolean = passwordValidator.isValid("Abcd@1234")

    assert(result)

  }

  it should "not be valid as it contains a blank space" in {

    val result: Boolean = passwordValidator.isValid("abcd @1234A")

    assert(!result)

  }


  it should "not be valid as it does not have atleast one digit(0-9)" in {

    val result: Boolean = passwordValidator.isValid("abcdXYZ@L")

    assert(!result)

  }

  it should "not be valid as length should be between 8-15 character" in {

    val result: Boolean = passwordValidator.isValid("ab@12")

    assert(!result)

  }

  it should "not be valid as does not have atleast one lowercase letter" in {

    val result: Boolean = passwordValidator.isValid("ABC@1234")

    assert(!result)

  }


  it should "not be valid as does not have atleast one uppercase letter" in {

    val result: Boolean = passwordValidator.isValid("abcd@1234")

    assert(!result)

  }

  it should "not be valid as it does not have atleast one special character" in {

    val result: Boolean = passwordValidator.isValid("abcd @1234A")

    assert(!result)

  }

}