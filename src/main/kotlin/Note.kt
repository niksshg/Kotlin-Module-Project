class Note() {
    val notes: MutableList<String> = mutableListOf()

    fun addNote(input: String) {
        notes.add(input)
    }

    fun displayNote() {
        println("Текущие заметки: ")
        if (notes.isEmpty()) {
            println("Заметки в архиве не найдены")
        } else {
            notes.forEachIndexed { index, note ->
                println("Заметка №$index -- $note")
            }
        }
    }

    override fun toString(): String {
        return notes.toString()
    }
}