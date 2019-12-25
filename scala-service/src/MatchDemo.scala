import java.io.{File, FileNotFoundException, FileReader, IOException, PrintWriter}

import scala.io.Source
import scala.util.matching.Regex

class MatchDemo private(val name: String) {
  println("name: " + name)
  val pattern = "(S|s)cala".r

  def matchMethod(str: String): Unit = {
    val pattern = new Regex("(S|s)cala")
    println((pattern findAllIn str).mkString(","))
    println(pattern.replaceAllIn(str, "python"))
  }
  val ex = (path: String) => {
    try {
      val f = new FileReader(path)
      Source.fromFile("test.txt").foreach{
        print
      }
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    }
  }

  val wr=(str:String)=>{
    val writer=new PrintWriter(new File("text.txt"))
    writer.write(str)
    writer.close()
  }
}


object MatchDemo {
  def main(args: Array[String]): Unit = {
    var str = "Scala is scalable and cool"
    val b = new MatchDemo("ali");
    b.matchMethod(str)
    b.ex("input.txt")
    b.wr("AAAAAAA")
  }


}