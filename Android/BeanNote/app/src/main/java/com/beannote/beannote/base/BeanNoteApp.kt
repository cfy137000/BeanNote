package com.beannote.beannote.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class BeanNoteApp : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
            private set
    }
}
