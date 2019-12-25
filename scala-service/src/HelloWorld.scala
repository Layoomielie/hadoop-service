object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("hello world")
    var a=new Test()
    println(a.m(10))
    print(a.add(10,13))
  }
}
class Test{
  def m(x: Int) = x + 3
  val f = (x: Int) => x + 3

  def add(x:Int,y:Int) : Int={
    var sum:Int=0
    sum=x+y
    return sum
  }
}