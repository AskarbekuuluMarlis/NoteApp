package com.example.noteapp

import android.app.Application
import androidx.room.Room
import com.example.noteapp.data.db.AppDataBase

class App : Application() {

    companion object {
        private var appDatabase: AppDataBase? = null
        private var instance: App? = null

        fun getInstance(): App {
            if (instance == null) {
                throw IllegalStateException("Application is not created yet!")
            }
            return instance!!
        }

        fun getDatabase(): AppDataBase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(
                    getInstance().applicationContext,
                    AppDataBase::class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
            return appDatabase!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
