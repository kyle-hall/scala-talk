
import org.specs2.mutable._
import org.specs2.matcher.BeEqualTo
import org.specs2.specification.{Before, Scope}

class ScalaProblemsSpec extends Specification with ScalaProblems {

  val list = List(1,2,3,4,5)
  val list2 = List(1,5,32,5,2)
  val stringList = List("This", "is", "a", "list", "of", "Strings")

  "ScalaProblems.last" should {
    "return the last element in the list" in {
      last(list) mustEqual Some(5)
    }
    "not care about the type of the elements in the list" in {
      last(stringList) mustEqual Some("Strings")
    }
    "return None if passed Nil" in {
      last(Nil) mustEqual None
    }
  }

  "ScalaProblems.penultimate" should {
    "return the next to last element in the list" in {
      penultimate(list) mustEqual Some(4)
    }
    "not care about the type of the elements in the list" in {
      penultimate(stringList) mustEqual Some("of")
    }
    "return None if passed Nil" in {
      penultimate(Nil) mustEqual None
    }
  }

  "ScalaProblems.nth" should {
    "return the Kth element of a list" in {
      nth(4, List(1, 1, 2, 3, 5, 8)) mustEqual Some(3)
    }
    "not care about the type of the elements in the list" in {
      nth(3, stringList) mustEqual Some("a")
    }
    // "return None if passed an Nil" in {
    //   nth(4, Nil) mustEqual None
    // }
    // "return None if the Kth element does not exist" in {
    //   nth(4, List(1, 2)) mustEqual None
    // }
  }

  "ScalaProblems.length" should {
    "return the number of elements in a List" in {
      length(list) mustEqual 5
    }
    "not care about the type of the elements in the list" in {
      length(stringList) mustEqual 6
    }
    "return 0 if passed Nil" in {
      length(Nil) mustEqual 0
    }
  }

  "ScalaProblems.reverse" should {
    "return the list it is given with the elements in reverse order" in {
      reverse(list) mustEqual Some(List(5, 4, 3, 2, 1))
    }
    "not care about the type of the elements in the list" in {
      reverse(List("This", "is", "a", "list", "of", "Strings")) mustEqual Some(List("Strings", "of", "list", "a", "is", "This"))
    }
    "return None if passed Nil" in {
      reverse(Nil) mustEqual None
    }
  }

  "ScalaProblems.isPalindrome" should {
    "return true if a list is a palindrome" in {
      isPalindrome(List(1, 2, 3, 2, 1)) mustEqual true
    }
    "return false if a list is not a palindrome" in {
      isPalindrome(list) mustEqual false
    }
    "not care about the type of the elements in the list - test case is a palindrome" in {
      isPalindrome(List("this", "is", "a", "palindrome", "a", "is", "this")) mustEqual true
    }
    "not care about the type of the elements in the list - test case is not a palindrome" in {
      isPalindrome(stringList) mustEqual false
    }
    "return true if the list contains only one element" in {
      isPalindrome(List(1)) mustEqual true
    }
    "return false if passed Nil" in {
      isPalindrome(Nil) mustEqual false
    }
  }

  "ScalaProblems.flatten" should {
    "return None if passed Nil" in {
      flatten(Nil) mustEqual None
    }
    "return the argument list without modification if it does not contain any Lists" in {
      flatten(list) mustEqual Some(list)
    }
    "return a list with single element if given a list with a single non-List element" in {
      flatten(List(6)) mustEqual Some(List(6))
    }
  }

}
