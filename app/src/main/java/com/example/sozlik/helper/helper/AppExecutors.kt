package com.example.sozlik.helper.helper

import java.util.concurrent.Executor

class AppExecutors {
    val diskIo: DiskIoThreadExecutor = DiskIoThreadExecutor()
    val mainThread: MainThreadExecutor = MainThreadExecutor()
}