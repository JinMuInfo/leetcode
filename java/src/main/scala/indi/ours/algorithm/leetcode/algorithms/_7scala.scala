package indi.ours.algorithm.leetcode.algorithms


/**
  *
  * @author wangheng
  * @create 2018-10-03 下午11:07
  * @desc
  *
  **/
object _7scala {

  def main(args: Array[String]): Unit = {
    val aa = "abcd "
    println(reverse(-123))

  }

  /**
    * 仿照java 版本写一个  结果超时
    * 无奈放弃
    * @param x
    * @return
    */
  def reverse1(x: Int): Int = {
    var input = x
    var answer = 0L
    while (x != 0){
      answer = answer *10 + input %10
      input = input /10
    }

    if(answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE){
      0
    }else{
      answer.toInt
    }

  }


  /**
    * 将其 转为string  直接 倒序排列
    *
    * @param x
    * @return
    */
  def reverse(x: Int): Int = {
        val xReverse = x.toString.reverse
    import scala.util.Try
        if(x < 0) {
          //使用init 去掉尾部的 - 号
          Try(xReverse.init.toInt * -1).getOrElse(0)
        } else {
          Try(xReverse.toInt).getOrElse(0)
        }
  }


  /**
    * 其他方法
    * @param x
    * @return
    */
  def reverse3(x: Int): Int = {
    if(x > Integer.MAX_VALUE) return 0
    var revNum:Long = 0
    var num:Int = x
    if(x < 0) {
      num = ~num + 1
    }

    while (num > 0) {
      revNum = revNum*10 + num%10
      num = num/10
    }

    if (revNum > Integer.MAX_VALUE || revNum < Integer.MIN_VALUE) return 0

    if(x < 0 )
      (~revNum + 1).asInstanceOf[Int]
    else revNum.asInstanceOf[Int]

  }

}
