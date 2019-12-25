object ClosePackage {
  // 闭包 ， 声明在函数外部的一个变量或者多个变量
  def main(args: Array[String]): Unit = {
    println(multiple(1))
    println(getString())
    getFormatOut()
    printArray()
    fillArray()
  }

  var getting: String = "new String"
  getting = getting.concat(": is not String")

  def getString(): String = {
    return getting
  }

  var factor = 3
  var multiple = (i: Int) => i * factor

  def getFormatOut(): Unit = {
    var price = 1.5
    var num = 3
    var str = "it is not str"
    print("price is %f , num is %d ,str is %s", price, num, str)
  }

  def printArray(): Unit = {
    var mylist = Array(1, 2, 3, 4, 5, 6)
    for (x <- mylist) {
      println(x)
    }
    var total=0.0
    for(i <- 0 to (mylist.length-1)){
      total+=mylist(i)
    }
    Array.concat()
    println("当前总和为："+total)

  }

  def getIterator(): Unit = {
    val list1 = Iterator(1, 2, 3, 4, 5)
    println("it is max:" + list1.max)
    println("it is min" + list1.min)
    while (list1.hasNext){
      println(list1.next())
    }
    val list2 = Iterator(6, 7, 8, 9)
    //list1.++(that:=>list2[1]):list2[2]

  }

  def fillArray():Unit={
    println("填充数据 .....")
    var list=new Array[Int](4)
    var newlist=Array.fill[Int](4:Int)(elem = 1):Array[Int]
    for(x <- newlist){
      print(x)
    }
  }
}
