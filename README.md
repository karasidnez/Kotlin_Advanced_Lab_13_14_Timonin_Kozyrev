# Лабораторная работа №13-14

Коллекции, обобщения и функциональный стиль в Kotlin

## Описание

Данная лабораторная работа посвящена изучению продвинутых возможностей языка Kotlin,
которые активно используются при разработке Android-приложений.
В рамках работы рассматриваются:- обобщённые типы (Generics);- коллекции Kotlin;- функции высшего порядка;- extension-функции;
Все примеры ориентированы на практическое применение и подготовку к разработке
мобильных приложений.
## Как запустить проект

1. Клонируйте репозиторий:
```bash
git clone <URL_репозитория>
```
## Разбираймые темы

## Generics (обобщённые типы)

Когда у свойства может быть разный тип данных, но логика классаостаётсяодинаковой, в Kotlin используется generic-тип.

**Пример:**
```Kotlin
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main() {
    val question1 = Question<String>(
        questionText = "Речка спятила с ума – По домам пошла сама. ____",
        answer = "водопровод",
        difficulty = "medium"
    )

    val question2 = Question<Boolean>(
        questionText = "Небо зелёное. Правда или ложь",
        answer = false,
        difficulty = "easy"
    )

    val question3 = Question<Integer>(
        questionText = "Сколько дней между полнолуниями?",
        answer = 28,
        difficulty = "hard"
    )

    println(question1.answer)
    println(question2.answer)
    println(question3.answer)}
```
## Различные виды классов (data class, enum class);

data class — это класс, предназначенный для хранения данных.

**Пример:**
```Kotlin
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)
```
## Singleton и companion object

Singleton — это класс, у которого может существовать только одинэкземпляр.В Kotlin для этого используется специальная конструкция object.
**Пример:**
```Kotlin
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
```
В Kotlin объекты можно объявлять внутри классов. Если такой объект помечен как companion, его свойства доступнынапрямуючерез имя класса.
**Пример:**
```Kotlin
companion object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}
```

## Extension-функции и свойства

Extensions позволяют:
- добавлять новые свойства и функции к уже существующимтипам;
- использовать их через точечную нотацию (.), как будто они быличастьюкласса;
- не изменять исходный код класса.
  **Пример:**
```Kotlin
val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

fun main() {
    println(Quiz.progressText)
}
```
## Scope-функции
Scope-функции позволяют работать со свойствами и методамиобъекта,неповторяя имя переменной, если это избыточно. Это особенно часто используетсявAndroid-разработке и Jetpack Compose.

Scope-функции — это функции высшего порядка, которые:
- принимают лямбда-выражение;
- временно меняют контекст (scope) внутри этого блока;
- позволяют обращаться к объекту через it или this.


## Автор

Тимонин,Козырев

## Лицензия

Проект создан в учебных целях.