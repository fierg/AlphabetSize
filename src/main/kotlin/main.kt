import java.io.File
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    if (args.firstOrNull() == null) { println("No folder provided. Exit."); exitProcess(0) }
    val ac = AlphabetCounter()
    File(args.first()).list().sorted().forEach {
        println("Analysing: $it")
        val count = ac.countAlphabet("${args.first()}/$it")
        println("Alphabet size: $count")
    }
}


class AlphabetCounter {
     fun countAlphabet(filename: String): Int {
        val chars = BooleanArray(256)
        File(filename).inputStream().readBytes().forEach {
            chars[it.toUByte().toInt()] = true;
        }
        var count = 0
        chars.forEach { if (it) count++ }
        return count
    }
}