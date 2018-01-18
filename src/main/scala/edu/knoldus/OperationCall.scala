package edu.knoldus

import org.apache.log4j.Logger

object OperationCall {

  def main(args: Array[String]): Unit = {

    val log = Logger.getLogger(this.getClass)
    val operations = new Operations
    val intList: List[Int] = (1 to 10).toList
    val lengthOfList1: Int = operations.calculateLengthOfList(intList)
    log.info(s"Length of list: $lengthOfList1")

    val stringList: List[String] = List("hi", "hello", "hey")
    val lengthOfList2: Int = operations.calculateLengthOfList(stringList)
    log.info(s"\nLength of list: $lengthOfList2\n")

    val subsequenceResult = operations.hasSubsequence(intList, (7 to 17).toList)
    log.info(s"\nsubsequence result: $subsequenceResult\n")

    val originalList: List[Int] = (1 to 5).toList
    val listToBeConcatinated: List[Int] = (7 to 15).toList
    val concatinatedList = operations.concateList(originalList, listToBeConcatinated)
    log.info(s"\n$concatinatedList\n")


    val evenOrOddLists = operations.splitList(intList, operations.splitFunction)
    log.info(s"\n$evenOrOddLists\n")
    val strList = List("hello", "hi", "welcome", "no")
    val lengthCompareList = operations.splitList(strList, operations.splitFunction)
    log.info(lengthCompareList)
  }
}
