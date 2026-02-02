data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
enum class Difficulty{
    EASY,
    MEDIUM,
    HARD
}
object StudentProgress{
    var total: Int = 10
    var answered: Int = 3
}
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}
class Quiz : ProgressPrintable {
    companion object StudentProgress{
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "${answered} of ${total} answered"

    val  question1 = Question<String>(
        "Речка спятила с ума - По домам пошла сама. ___",
        "Водопровод",
        Difficulty.MEDIUM
    )
    val question2 = Question<Boolean>(
        "Небо зелёное. Правда или ложь",
        false,
        Difficulty.EASY
    )
    val question3 = Question<Int>(
        "Сколько дней между полнолуниями",
        28,
        Difficulty.HARD

    )
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
    fun printQuiz(){
        question1.let{
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question2.let{
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question3.let{
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }


}




fun main() {
    Quiz().apply { printQuiz() }
}