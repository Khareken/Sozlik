package com.example.sozlik.helper.helper

import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class DiskIoThreadExecutor : Executor {

    private val diskIoThreadExecutor = Executors.newSingleThreadExecutor()

    override fun execute(command: Runnable) {
        diskIoThreadExecutor.execute(command)
    }

}