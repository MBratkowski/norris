package io.dotanuki.coroutines.testutils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.ExternalResource

class EnforceMainDispatcher : ExternalResource() {

    private val singleThread = newSingleThreadContext("Testing thread")

    override fun before() {
        Dispatchers.setMain(singleThread)
        super.before()
    }

    override fun after() {
        Dispatchers.resetMain()
        singleThread.close()
        super.after()
    }
}