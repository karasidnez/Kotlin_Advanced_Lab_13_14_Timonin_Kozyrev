// 2. Data-классы
data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)

data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)

data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)

sealed class LibraryItem {
    class BookItem(val book: Book) : LibraryItem()
    class MagazineItem(val magazine: Magazine) : LibraryItem()
    class DVDItem(val dvd: DVD) : LibraryItem()
}

class Library<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) = items.add(item)
    fun getAll(): List<T> = items
}

fun filterByYear(items: List<LibraryItem>, year: Int): List<Book> {
    val result = mutableListOf<Book>()
    for (item in items) {
        if (item is LibraryItem.BookItem && item.book.year == year) {
            result.add(item.book)
        }
    }
    return result
}

fun sortByTitle(items: List<LibraryItem>): List<LibraryItem> {
    return items.sortedBy { item ->
        when (item) {
            is LibraryItem.BookItem -> item.book.title
            is LibraryItem.MagazineItem -> item.magazine.title
            is LibraryItem.DVDItem -> item.dvd.title
        }
    }
}

fun groupByAuthor(items: List<LibraryItem>): Map<String, List<Book>> {
    val result = mutableMapOf<String, MutableList<Book>>()

    for (item in items) {
        if (item is LibraryItem.BookItem) {
            val author = item.book.author
            val books = result.getOrDefault(author, mutableListOf())
            books.add(item.book)
            result[author] = books
        }
    }
    return result
}

fun calculateTotalDuration(items: List<LibraryItem>): Int {
    var total = 0
    for (item in items) {
        if (item is LibraryItem.DVDItem) {
            total += item.dvd.duration
        }
    }
    return total
}

fun main() {
    val book1 = Book("Град обречённый", "Стругацкие", 1989, "1")
    val book2 = Book("Сказка о Тройке", "Стругацкие", 1968, "2")
    val book3 = Book("Собачье сердце", "Булгаков", 1968, "3")

    val magazine = Magazine("Forbes", 100, "Январь")
    val dvd1 = DVD("Призрачный гонщик", "Джонсон", 110)
    val dvd2 = DVD("Начало", "Нолан", 148)

    val library = Library<LibraryItem>()
    library.add(LibraryItem.BookItem(book1))
    library.add(LibraryItem.BookItem(book2))
    library.add(LibraryItem.BookItem(book3))
    library.add(LibraryItem.MagazineItem(magazine))
    library.add(LibraryItem.DVDItem(dvd1))
    library.add(LibraryItem.DVDItem(dvd2))

    val allItems = library.getAll()

    println("Книги 1869 года:")
    filterByYear(allItems, 1869).forEach {
        println("  - ${it.title}")
    }

    println("\nПо названию:")
    sortByTitle(allItems).forEach {
        when (it) {
            is LibraryItem.BookItem -> println("  Книга: ${it.book.title}")
            is LibraryItem.MagazineItem -> println("  Журнал: ${it.magazine.title}")
            is LibraryItem.DVDItem -> println("  DVD: ${it.dvd.title}")
        }
    }

    println("\nПо авторам:")
    groupByAuthor(allItems).forEach { (author, books) ->
        println("  $author: ${books.joinToString { it.title }}")
    }

    println("\nОбщее время DVD: ${calculateTotalDuration(allItems)} минут")
}