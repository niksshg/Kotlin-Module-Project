class Archive {
    val archive: MutableMap<String, Note> = mutableMapOf()

    fun addArchive(input: String) {
        archive[input] = Note()
    }

    fun getAllArchives(): List<String> {
        val listOfArchives = archive.keys.toMutableList()
        listOfArchives.add("Выход")
        return listOfArchives
    }

    fun getArchiveContent(input: Int): Note {
        return archive.getValue(archive.keys.elementAt(input))
    }
}