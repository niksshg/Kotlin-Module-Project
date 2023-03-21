fun main() {
    val archive = Archive()
    val archiveMenu =
        Menu(listOf("Создать новый архив", "Посмотреть и выбрать из существующих архивов", "Выйти"))

    archiveMenu.addArchive(archive)

}
