import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

object Main{

  def main(args: Array[String]): Unit = {
    var chain = List[String]()
    chain = addListElement(chain, "HELLO")
    chain = addListElement(chain, "World")
    display_list(chain)
    var word = "HowAreYou"
    println("HASHED VALUE: " + hashString(word))
    var arrayOfThings = hashSolver(word, 0)
    var proofInt = arrayOfThings(0)
    var hashCode = arrayOfThings(1)
    println("Solved with number: " + proofInt)
    println("Solved Hash: " + hashCode)

  }


  def addListElement(list: List[String],element : String): List[String] ={
    val added = element :: list
    added
  }

  def display_list(list: List[String])
  {
    println("PRINTED OUT LIST: " + list)
  }

  def hashString(word: String): String ={
    DatatypeConverter.printHexBinary(MessageDigest
      .getInstance("SHA-256")
      .digest(word.getBytes("UTF-8")))
  }

  def hashSolver(last_proof: String, proof: Int): Array[Any] ={
    var proof: Int = 0
    while (validProof(last_proof, proof).takeRight(4) != "0000"){
      proof+= 1
    }

    var arrayOfThings = Array(proof, validProof(last_proof, proof))

    arrayOfThings
  }

  def validProof(last_proof: String, proof: Int): String={
    val testedProof = last_proof.toString + proof.toString
    val guessed_hash = DatatypeConverter.printHexBinary(MessageDigest
      .getInstance("SHA-256")
      .digest(testedProof.getBytes("UTF-8")))

    guessed_hash
  }


}