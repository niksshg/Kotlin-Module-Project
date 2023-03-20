import java.lang.NumberFormatException

class Menu(val menuOptions: List<String>) {

    fun printMenuOptions() {
        if (menuOptions.isEmpty()) {
            println("Данные отсутствуют")
        } else {
            menuOptions.forEachIndexed { index, option ->
                println("$index -- $option")
            }
        }
    }

    fun selectMenuOption(): Int? {
        val input = readLine()
        return try {
            val selectedOption = input?.toInt()
            if (selectedOption in 0..menuOptions.lastIndex) {
                return selectedOption
            } else {
                println("Данного пункта меню не существует. Введите корректный пункт меню")
            }
            return selectedOption
        } catch (e: NumberFormatException) {
            println("Некорректный ввод. Введите номер пункта меню")
            return null
        }
    }

    fun addArchive(archive: Archive) {
        while (true) {
            println("Выбирете опцию:")
            printMenuOptions()

            when (selectMenuOption()) {
                0 -> {
                    println("Введите название архива: ")
                    val input = readLine() ?: ""
                    archive.addArchive(input)
                    println("Архив успешно добавлен")
                }
                1 -> {
                    selectArchive(archive)
                }
                2 -> return
            }
        }
    }

    fun selectArchive(archive: Archive) {
        while (true) {
            println("Выбирите архив: ")
            val listOfArchives = Menu(archive.getAllArchives())
            listOfArchives.printMenuOptions()
            when (val input = listOfArchives.selectMenuOption()) {
                in 0..archive.getAllArchives().lastIndex - 1 -> noteWorker(archive, input!!)
                listOfArchives.menuOptions.lastIndex -> return

            }
        }
    }

    fun noteWorker(archive: Archive, input: Int) {
        while (true) {
            archive.getArchiveContent(input).displayNote()
            val listOfNotes = Menu(listOf("Добавить заметку", "Выйти"))
            listOfNotes.printMenuOptions()
            when (listOfNotes.selectMenuOption()) {
                0 -> {
                    println("Введите текст заметки")
                    archive.getArchiveContent(input).addNote(readLine() ?: "")
                }
                1 -> return
            }
        }
    }
}