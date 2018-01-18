package edu.knoldus

class Operations {

  def calculateLengthOfList[A](list: List[A]): Int = {

    val length = 0
    list.foldRight(length) { (_, count) => count + 1 }

  }

  def hasSubsequence[A](originalList: List[A], subSequenceList: List[A]): Boolean = {

    originalList match {
      case Nil => false
      case topElement :: restElements =>
        if (subSequenceList.isEmpty) {
          true
        }
        else if (topElement == subSequenceList.head) {
          hasSubsequence(restElements, subSequenceList.drop(1))
        }
        else if (subSequenceList.isEmpty) {
          true
        }
        else {
          hasSubsequence(restElements, subSequenceList)
        }
    }
  }


  def concateList[A](list1: List[A], list2: List[A]): List[A] = {

    def concatHelper(originalList: List[A], concatenatedList: List[A]): List[A] = {
      originalList match {
        case Nil => concatenatedList
        case firstElement :: Nil => firstElement :: concatenatedList
        case topElement :: remainingList => concatHelper(remainingList, topElement :: concatenatedList)
      }
    }

    val concatenatedList = concatHelper(list1, List())
    concatHelper(list2, concatenatedList).reverse
  }

  def splitFunction[A](topElement: A): Boolean = {

    topElement match {
      case intElement: Int => if ((intElement % 2) == 0) true else false
      case charElement: Char => if (charElement < 'd') true else false
      case stringElement: String => if (stringElement.length > 3) true else false
    }
  }

  def splitList[A](originalList: List[A], splitFunction: A => Boolean): (List[A], List[A]) = {

    def splitListHelper(originalList: List[A], firstSplitList: List[A], secondSplitList: List[A]): (List[A], List[A]) = {
      originalList match {
        case Nil => (firstSplitList.reverse, secondSplitList.reverse)
        case topElement :: restElements =>
          if (splitFunction(topElement)) {
            splitListHelper(restElements, topElement :: firstSplitList, secondSplitList)
          }
          else {
            splitListHelper(restElements, firstSplitList, topElement :: secondSplitList)
          }
      }
    }
    splitListHelper(originalList, List(), List())
  }

}
