package com.example.casadeproductiefilme.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.casadeproductiefilme.data.local.dao.MovieDAO
import com.example.casadeproductiefilme.data.local.dao.UserDAO
import com.example.casadeproductiefilme.data.local.entity.MovieEntity
import com.example.casadeproductiefilme.data.local.entity.UserEntity
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class AppDatabaseTest : TestCase() {

    private lateinit var db: AppDatabase
    private lateinit var movieDAO: MovieDAO
    private lateinit var userDAO: UserDAO

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries()
            .build()
        movieDAO = db.getMovieDAO()
        userDAO = db.getUserDAO()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun saveAndGetUser() = runBlocking {
        val user = UserEntity(username = "roo1", password = "roo1")
        userDAO.addUser(user)
        val users = userDAO.getAllUsers()
        assertTrue(users.contains(user.username))
    }

    @Test
    fun saveAndDeleteUser() = runBlocking {
        val user = UserEntity(username = "roo1", password = "roo1")
        userDAO.addUser(user)
        userDAO.delete(user.username)
        val searchedUser = userDAO.getUser(user.username)
        assertTrue(searchedUser == null)
    }

    @Test
    fun saveAndGetMovies() = runBlocking {
        val movie1 = MovieEntity(20, "Thor", "action", "artistic", 2015, "")
        movieDAO.saveMovies(listOf(movie1))
        val movies = movieDAO.getAllMovies().blockingGet()
        assertTrue(!movies.contains(movie1))
    }
}