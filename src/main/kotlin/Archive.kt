object Archive {
    val archive: MutableMap<String, Note> = mutableMapOf()

    fun addArchive(input: String) {
        archive.put(input, Note())
    }

    fun getAllArchives(): List<String> {
        var listOfArchives = archive.keys.toList().toMutableList()
        listOfArchives.add("Выход")
        return listOfArchives
    }

    fun getArchiveContent(input: Int): Note {
        return archive.getValue(archive.keys.elementAt(input))
    }
}