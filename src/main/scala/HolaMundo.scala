import java.io.{BufferedReader, FileReader}
import java.util.stream
import scala.collection.mutable.ListBuffer
import scala.io.Source

object HolaMundo{
    def main(args: Array[String]): Unit = {
      var filename = "src/main/scala/wordlist.txt"
      var filename2 = "D:\\Users\\Jonaa\\Documents\\INTEC\\Trimestre#8\\po\\src\\main\\scala\\WD.txt"
 /*     var beta = ReadFiles(filename2)
      MapFiller(beta.lines())*/
      /*GetPath(args)*/
      val start = System.nanoTime()
      GetPath(filename)
      Print()
      val end = System.nanoTime()
      println(s"Time taken: ${(end - start) / 1000 / 1000 /1000} s")
    }

    def ReadFiles(filename: String): BufferedReader ={
      val br = new BufferedReader(new FileReader(filename))
      return br
    }
  val AnagramSet : scala.collection.mutable.Map[String,ListBuffer[String]] = scala.collection.mutable.Map[String,ListBuffer[String]]()

  def GetPath(filename: String): Unit = {
      if(filename == null) throw new IllegalArgumentException
      for(line <- Source.fromFile(filename).getLines) {
        MapFill(line,AnagramSet)
      }
  }

  def MapFill(line: String, AnagramSet: scala.collection.mutable.Map[String,ListBuffer[String]] = scala.collection.mutable.Map[String,ListBuffer[String]]()): Unit ={
     val new_line = line.sorted
      if(AnagramSet.contains(new_line)) {
        if(!AnagramSet(new_line).contains(line)){
          AnagramSet(new_line) += line
        }
      } else{
        AnagramSet += (new_line -> ListBuffer[String]())
        AnagramSet(new_line) += line
      }
  }

  def Print(): Unit ={
    var sets = 0
    for((key,value) <- AnagramSet) {
      if (value.length > 1) {
        println(value.mkString("->"))
        sets += 1
      }
    }
    println("Cantidad de sets: " + sets)
  }

  /*def MapFiller(file: java.util.stream.Stream[String]): Unit ={
    val A : scala.collection.mutable.Map[String,ListBuffer[String]] = scala.collection.mutable.Map[String,ListBuffer[String]]()

    for (line <- file) {
      val new_line = line.toLowerCase.sorted

      if(A.contains(new_line)) A(new_line) += line
      else{
        A += (new_line -> ListBuffer[String]())
        A(new_line) += line
      }
    }
    for((key,value) <- A) {
      if (value.length > 1) println(value.mkString("->"))
    }
  }*/
}



// www.tutorialspoint.com/scala/scala_maps.html
/*object BufferedReader2 extends App {


  val filename = "C:\\Users\\Miguel\\IdeaProjects\\po\\src\\main\\scala\\wordlist.txt"

  val br = new BufferedReader(new FileReader(filename))
  return br.lines()
 /* var newlineCount = 0L
  var line = ""
  while ({line = br.readLine; line != null}) {
    newlineCount += 1
  }
  br.close
  println(newlineCount)*/*/

/*
}*/
