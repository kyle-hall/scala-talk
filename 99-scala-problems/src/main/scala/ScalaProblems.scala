
trait ScalaProblems {
  def last[A](ls: List[A]): Option[A] = ls match {
    case Nil => None
    case head :: Nil => Some(head)
    case head :: tail => last(tail)
  }

  def penultimate[A](ls: List[A]): Option[A] = ls match {
    case Nil => None
    case head :: (tail :: Nil) => Some(head)
    case head :: tail => penultimate(tail)
  }

  def nth[A](elementNum: Int, ls: List[A]): Option[A] = elementNum match {
    case 1 => Some(ls.head)
    case num => nth(num - 1, ls.tail)
  }

  def length[A](ls: List[A]): Int = {
    def lengthHelper(result: Int, ls1: List[A]): Int = ls1 match {
      case Nil => 0
      case head :: Nil => result + 1
      case head :: tail => lengthHelper(result + 1, tail)
    }
    lengthHelper(0, ls)
  }

  def reverse[A](ls: List[A]): Option[List[A]] = {
    def reverseHelper(result: List[A], ls1: List[A]): Option[List[A]] = ls1 match {
      case Nil => None
      case head :: Nil => Some(head :: result)
      case head :: tail => reverseHelper(head :: result, tail)
    }
    reverseHelper(Nil, ls)
  }

  def isPalindrome[A](ls: List[A]): Boolean = ls match {
    case Nil => false
    case head :: Nil => true
    case head :: tail => ls == reverse(ls).get
  }

  def flatten(ls: List[Any]): Option[List[Any]] = {
    def flattenHelper(result: List[Any], ls1: List[Any]): Option[List[Any]] = ls1 match {
      case Nil => None
      case head :: Nil => Some(head :: result)
      case head :: (head1 :: Nil) => Some(head :: head1 :: result)
      case head :: (head1 :: tail) => Some(head :: flattenHelper(result, tail) :: result)
    }
    flattenHelper(Nil, ls)
  }

}
