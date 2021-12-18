import java.text.BreakIterator

object Hamming {
//    fun compute(leftStrand: String, rightStrand: String): Int {
//        val bi1 = BreakIterator.getCharacterInstance()
//        bi1.setText(leftStrand)
//        val bi2 = BreakIterator.getCharacterInstance()
//        bi2.setText(rightStrand)
//
//        var ct1 = 0
//        var ct2 = 0
//
//        while(bi1.next() != BreakIterator.DONE) {
//            ct1++
//        }
//        while(bi2.next() != BreakIterator.DONE) {
//            ct2++
//        }
//        if(ct1 != ct2) {
//            throw IllegalArgumentException("left and right strands must be of equal length")
//        } else {
//            bi1.setText(leftStrand)
//            bi2.setText(rightStrand)
//
//            var bi1s = bi1.current()
//            var bi2s = bi2.current()
//
//            var bi1e = bi1.next()
//            var bi2e = bi2.next()
//
//            var ct = 0
//            while ( bi1e != BreakIterator.DONE || bi2e != BreakIterator.DONE ) {
//                if ( leftStrand.substring(bi1s, bi1e) != rightStrand.substring(bi2s, bi2e) ) {
//                    ct++
//                }
//
//                bi1s = bi1e
//                bi2s = bi2e
//
//                bi1e = bi1.next()
//                bi2e = bi2.next()
//            }
//            return ct
//        }
//    }


    fun compute(leftStrand: String, rightStrand: String): Int {
        var result = 0
        val rightGraphemes = Graphemes(rightStrand)
        for (lhs in Graphemes(leftStrand)) {
            if (!rightGraphemes.hasNext()) {
                throw DifferentLengthException()
            } else if (lhs != rightGraphemes.next()) {
                result += 1
            }
        }
        if (rightGraphemes.hasNext()) {
            throw DifferentLengthException()
        } else {
            return result
        }
    }

    class DifferentLengthException :
        IllegalArgumentException("left and right strands must be of equal length") {}

}

class Graphemes : Iterator<String> {
    val text: String
    val iterator: BreakIterator
    var startIndex: Int
    var endIndex: Int

    constructor(text: String) {
        this.text = text
        this.iterator = BreakIterator.getCharacterInstance().apply { setText(text) }
        this.startIndex = this.iterator.first()
        this.endIndex = this.iterator.next()
    }

    override fun next(): String {
        var result = text.substring(startIndex,endIndex)
        startIndex = endIndex
        endIndex = iterator.next()
        return result
    }

    override fun hasNext(): Boolean {
        return endIndex != BreakIterator.DONE
    }
}

fun main() {
    println(Hamming.compute("♊️\uD83C\uDD711️⃣क्","asdq"))
}

