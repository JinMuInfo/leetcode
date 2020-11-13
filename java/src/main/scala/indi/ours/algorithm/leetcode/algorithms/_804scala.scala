package indi.ours.algorithm.leetcode.algorithms

import scala.collection.mutable
import scala.collection.mutable._

/**
  *
  * @author wangheng
  * @create 2018-10-16 下午2:07
  * @desc
  *
  **/
object _804scala {

  def main(args: Array[String]): Unit = {
    uniqueMorseRepresentations(Array("gin", "zen", "gig", "msg"))
  }

  val array = Array(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
  def uniqueMorseRepresentations(words: Array[String]): Int = {
    var set = scala.collection.mutable.Set[String]();
    words.foreach(x => {
      var sb =""
      x.toCharArray.foreach(
       c => sb = sb+ array(c -'a'))
      set +=sb


    })
    set.size

  }


}
