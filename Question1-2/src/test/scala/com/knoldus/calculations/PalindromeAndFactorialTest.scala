package com.knoldus.calculations
import org.scalatest.flatspec.AnyFlatSpec

class PalindromeAndFactorialTest extends AnyFlatSpec {

  "number" should "not be a palindrome number" in {
    val obj = new PalindromeAndFactorial
    assert(!obj.palindrome(47538))
  }

  "number" should "not be a palindrome number as it a negative number" in {
    val obj = new PalindromeAndFactorial
    assert(!obj.palindrome(-5874))
  }

  "number" should "be a palindrome number as 0 is palindrome" in {
    val obj = new PalindromeAndFactorial
    assert(obj.palindrome(0))
  }

  "number" should "be a palindrome number" in {
    val obj = new PalindromeAndFactorial
    assert(obj.palindrome(68786))
  }

  "condition" should "be invalid as 5 will not return 110" in {
    val obj = new PalindromeAndFactorial
    assert(!(110==obj.factorial(5)))
  }

  "condition" should "be valid as 0 will return 1" in {
    val obj = new PalindromeAndFactorial
    assert(1==obj.factorial(0))
  }

  "condition" should "be valid as 6 will return 720" in {
    val obj = new PalindromeAndFactorial
    assert(720==obj.factorial(6))
  }
}
