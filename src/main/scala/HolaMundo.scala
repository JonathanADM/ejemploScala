import java.io.{BufferedReader, FileReader}
import java.util.stream

object HolaMundo{
    def main(args: Array[String]): Unit = {
      val filename = "C:\\Users\\Miguel\\IdeaProjects\\po\\src\\main\\scala\\wordlist.txt"
      var filename2 = "C:\\Users\\Miguel\\IdeaProjects\\po\\src\\main\\scala\\WD.txt"
      var beta = ReadFiles(filename2)
      MapFiller(beta.lines())

    }
    def IsAnagram(word1: String , word2: String) : Boolean = {
      var srt = word1.toLowerCase.sorted
      var srt2 = word2.toLowerCase.sorted

      if(srt == srt2){
        return true
      }
      return false
    }

    def ReadFiles(filename: String): BufferedReader ={
      val br = new BufferedReader(new FileReader(filename))
      return br
    }

  def MapFiller(file: java.util.stream.Stream[String]): Unit ={
    var anagramsHashTable:scala.collection.mutable.Map[String, List[String]] = scala.collection.mutable.Map()


/*    for ((line) <- file){
      var temporalWord = line.toLowerCase.sorted
      if(anagramsHashTable.contains(temporalWord)){
        anagramsHashTable(temporalWord) += line
      }
      else{
        anagramsHashTable += (line -> List[String]+=line)
      }
    }*/

    for((key,value)<- anagramsHashTable){
      println(key +": "+ value.mkString("->"))
    }

  }
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
