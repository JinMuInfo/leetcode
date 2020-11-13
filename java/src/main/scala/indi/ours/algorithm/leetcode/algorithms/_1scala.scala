package indi.ours.algorithm.leetcode.algorithms



/**
  *
  * @author wangheng
  * @create 2018-10-05 下午7:26
  * @desc  从目标数组中找到 两个数 使他们的和 等于  target  返回下标
  *
  **/
object _1scala {

  def main(args: Array[String]): Unit = {
    var inpudata : Array[Int] =Array(2,7,11,15)
   var result =  twoSum(inpudata , 9)

    println(result(0)  +"  "+result(1))

  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    import scala.collection.mutable._
    var result : Array[Int] = new Array[Int](2)
    val hashMap = new HashMap[Int,Int]()
    //nums.foreach{

    for(index <- 0 until(nums.length)){
      var x = nums(index)
        if(hashMap.contains(target - x )) {
          result(0) = hashMap(target-x )
          result(1) = index

          return  result
        }else{
          hashMap.put(x ,index )

        }


    }
    return result

  }


}
