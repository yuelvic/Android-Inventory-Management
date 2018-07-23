package io.chaman.im.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import io.chaman.im.data.dao.RequestDao
import io.chaman.im.data.database.RequestDatabase
import io.chaman.im.data.entities.Request
import org.jetbrains.anko.doAsync

class RequestRepository(application: Application) {

    var mRequestDao: RequestDao
    var mRequests: LiveData<List<Request>>

    init {
        val db = RequestDatabase.getDatabase(application)
        this.mRequestDao = db!!.requestDao()
        this.mRequests = this.mRequestDao.getRequests()
    }

    fun getRequests(): LiveData<List<Request>> {
        return this.mRequests
    }

    fun add(request: Request) {
        doAsync {
            mRequestDao.add(request)
        }
    }

    fun delete(request: Request) {
        doAsync {
            mRequestDao.delete(request)
        }
    }

}