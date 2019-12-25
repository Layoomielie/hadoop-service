import java.io._

class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int): Unit = {
    x += dx;
    y += dy;
    println("x的坐标点：" + x);
    println("y的坐标点：" + y)
  }
}

class Location(val xc: Int, val yc: Int, val zc: Int) extends Point(xc, yc) {
  var z: Int = zc;

  def move(dx: Int, dy: Int, dc: Int): Unit = {
    x += dx;
    y += dy;
    z += dc;
    println("x的坐标点：" + x);
    println("y的坐标点：" + y)
    println("z的坐标点：" + z)
  }
}

object Test2 {
  def main(args: Array[String]): Unit = {
    val p = new Point(10, 10);
    p.move(10, 10);
    val l = new Location(30, 30, 30)
    l.move(10,10,10)
  }
}
