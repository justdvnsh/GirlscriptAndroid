package kitefoundation.tech.lesson1

class SearchRepository() {

    fun validate(text: String): String = text.capitalize().trim()
}