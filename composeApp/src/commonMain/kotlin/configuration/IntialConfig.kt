package configuration

import database.createTables
import database.initDatabase

class IntialConfig {
    init {
        initDatabase()
        createTables()
    }
}