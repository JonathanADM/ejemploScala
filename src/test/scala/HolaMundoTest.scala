import org.scalatest.FunSuite

import java.io.{File, FileNotFoundException}
import scala.collection.mutable.ListBuffer
import scala.io.Source

class HolaMundoTest extends FunSuite{
  test(testName = "HolaMundo_GetPath_ArgsInput_IsNull_ThrowsNullArgumentException"){
      assertThrows[IllegalArgumentException]{
        HolaMundo.GetPath(null)
      }
  }
  test(testName = "HolaMundo_GetPath_ArgsInput_FileNotExists_ThrowsNotFoundException"){
    var file = new File("hola")
    assertThrows[FileNotFoundException]{
      HolaMundo.GetPath(file)
    }
  }

  test(testName = "HolaMundo_MapFill_MapsShouldBeEquals"){
    val Anagrams = Map("moor" -> ListBuffer("romo", "moro"), "ahlo" -> ListBuffer("hola","olah"))
    val expected : scala.collection.mutable.Map[String,ListBuffer[String]] = scala.collection.mutable.Map[String,ListBuffer[String]]()

    HolaMundo.MapFill("romo",expected)
    HolaMundo.MapFill("moro",expected)
    HolaMundo.MapFill("hola",expected)
    HolaMundo.MapFill("olah",expected)

    assert(expected == Anagrams)
  }
  test(testName = "HolaMundo_MapFill_IsDuplicated"){
    val Anagrams = Map("moor" -> ListBuffer("romo", "moro", "moro"), "ahlo" -> ListBuffer("hola","olah"))
    val expected : scala.collection.mutable.Map[String,ListBuffer[String]] = scala.collection.mutable.Map[String,ListBuffer[String]]()

    HolaMundo.MapFill("romo",expected)
    HolaMundo.MapFill("moro",expected)
    HolaMundo.MapFill("hola",expected)
    HolaMundo.MapFill("olah",expected)
    HolaMundo.MapFill("moro",expected)

    assert(expected != Anagrams)
  }
}
