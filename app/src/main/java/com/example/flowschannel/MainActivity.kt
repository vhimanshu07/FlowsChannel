package com.example.flowschannel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    /**
     *
     * Step 1 making use of channel
     *
     */
    val channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         *
         * Step 2 Creating functions for channels
         *
         */
//        producer()
//        consumer()

        /**
         *
         * Step 3 Working on flow now
         *
         */
//        val job = GlobalScope.launch {
//            val data: Flow<Int> = flowProducer()
//            /**
//             *
//             * Step 4 If i comment this collect line it would stop producing values too.
//             *
//             */
////            data.collect {
////                Log.d("Main", it.toString())
////            }
//            data.collect {
//                Log.d("Main", it.toString())
//            }
//        }

        /**
         *
         * Step 5 it would stop printing after 3 as Coroutine  has been cancel now
         *
         */
//        GlobalScope.launch {
//            delay(3300)
//            job.cancel()
//        }

        /**
         *
         * Step 6 Made another flow it would run after 2.5 seconds
         *
         */
//        GlobalScope.launch {
//            val data: Flow<Int> = flowProducer()
//
//            delay(2500)
//            data.collect {
//                Log.d("Main -2", it.toString())
//            }
//        }


        /**
         *
         * Step 7. There are several listeners in flow
         *
         */

//        GlobalScope.launch {
//            val data: Flow<Int> = flowProducer()
//                data
//                    .onStart {
//                        // Can be used to show loader
//                        Log.d("Main", "Flow Started")
//                    }
//                    .onCompletion {
//                        // Can be used to hide loader
//                        Log.d("Main", "Flow Ended")
//                    }
//                    .onEach {
//                        Log.d("Main", "In On Each block")
//                    }
//                    .collect {
//                Log.d("Main", it.toString())
//            }
//        }


        /**
         *
         * Step 8 There are many functions in Flow
         *
         */

//        GlobalScope.launch(Dispatchers.Main) {
//            val result = flowProducer().first()
//            // it will display the first element
//            Log.d("Main", result.toString())
//        }

//        GlobalScope.launch(Dispatchers.Main) {
//            val result = flowProducer().toList()
//            // it will display the whole list, it will wait till all the work (list has been done)
//            // then displays the list
//            Log.d("Main", result.toString())
//        }

        /**
         *
         * Step 9  Maps , Filters usage.
         *
         */
//
//        GlobalScope.launch(Dispatchers.Main) {
//            val data = flowProducer()
//            data
//                .map {
//                    it * 2
//                }
//                .filter {
//                    it < 8
//                }
//                .collect {
//                    Log.d("Main", it.toString())
//                }
//        }
        /**
         *
         * Step 10 another way to Produce data
         *
         */
//        GlobalScope.launch(Dispatchers.Main) {
//            val result = flowProducer2()
//            // it will display the first element
//            result.collect {
//                Log.d("Main", it.toString())
//            }
//        }

        /**
         *
         * Step 11 Buffer and it's usage
         *
         */
//        GlobalScope.launch(Dispatchers.Main) {
//            val time= measureTimeMillis {
//                flowProducer()
//                    .buffer(3)
//                    .collect{
//                        delay(1500)
//                        Log.d("Main", it.toString())
//
//                    }
//
//            }
//            Log.d("Main", time.toString())
//
//        }

        /**
         *
         * Step 12 If we have to switch from IO to Main or from Main to IO we need to use flowOn
         *
         */
//        GlobalScope.launch(Dispatchers.Main) {
//            flowProducer()
//                .flowOn(Dispatchers.IO)
//                .collect {
//                    Log.d("Main", "In subscriber -> ${Thread.currentThread().toString()}")
//
//                }
//        }

//        GlobalScope.launch(Dispatchers.Main) {
//            flowProducer()
//                .map {
//                    it * 2
//                    Log.d("Main", "In map -> ${Thread.currentThread().toString()}")
//                }
//                .filter {
//                    Log.d("Main", "In filter -> ${Thread.currentThread().toString()}")
//                    it < 8
//                }
//                .flowOn(Dispatchers.IO)
//                .collect {
//                    Log.d("Main", "In subscriber -> ${Thread.currentThread().toString()}")
//
//                }
//        }

        /**
         *
         * Step 13 Flows are cold in nature means every consumer has its own producer
         *
         * See below example
         *
         */

//        GlobalScope.launch(Dispatchers.Main) {
//            flowProducer()
//                .collect {
//                    Log.d("Main", it.toString())
//                }
//        }
//
//        GlobalScope.launch(Dispatchers.Main) {
//            val result = flowProducer()
//            delay(2500)
//            result.collect {
//                Log.d("Main 2", it.toString())
//            }
//        }

        /**
         *
         * Step 14 Mutable shared flow behave like hot observables
         *
         *
         *
         */
//        GlobalScope.launch(Dispatchers.Main) {
//            flowSharedProducer()
//                .collect {
//                    Log.d("Main", it.toString())
//                }
//        }
//
//        GlobalScope.launch(Dispatchers.Main) {
//            val result = flowSharedProducer()
//            delay(2500)
//            result.collect {
//                Log.d("Main 2", it.toString())
//            }
//        }
        /**
         *
         * Step 15 if we have a only one consumer and there is delay in consuming values but values were emitted regularly then they would be lost
         *
         */
//        GlobalScope.launch(Dispatchers.Main) {
//            val result = flowSharedProducer()
//            delay(2500)
//            result.collect {
//                Log.d("Main", it.toString())
//            }
//        }

        /**
         *
         * Step 16 MutableStateFlow concept :- It is kind of box stores value
         *
         */
        GlobalScope.launch(Dispatchers.Main) {
            val result = flowStateProducer()
            delay(6000)
            result.update {
                it+20
            }
            result.collect {
                Log.d("Main", it.toString())
            }
        }

        /**
         *
         * Step 17 MutableStateFlow concept getting value of it
         *
         */

//        GlobalScope.launch(Dispatchers.Main) {
//            val result = flowStateProducerNew()
//            Log.d("Main", result.value.toString())
//        }

    }

    private fun consumer() {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Main", channel.receive().toString())
            Log.d("Main", channel.receive().toString())
        }
    }

    private fun producer() {
        CoroutineScope(Dispatchers.Main).launch {
            channel.send(1)
            channel.send(2)
        }
    }

    private fun flowProducer() = flow<Int> {
        val list = listOf(1, 2, 3, 4, 5)
        list.forEach {
            delay(1000)
            Log.d("Main", "Emitting $it")
            emit(it)
        }
    }


    /**
     *
     * Step 14 Mutable shared flow behave like hot observables
     *
     *
     */
    private fun flowSharedProducer(): Flow<Int> {
        val list = listOf(1, 2, 3, 4, 5)
        val mutableSharedFlow = MutableSharedFlow<Int>(2)
        GlobalScope.launch {
            list.forEach {
                mutableSharedFlow.emit(it)
                //  Log.d("Main", "Emitting $it")
                delay(1000)
            }
        }

        return mutableSharedFlow
    }

    /**
     *
     * Step 16 MutableStateFlow concept
     *
     */
    private fun flowStateProducer(): MutableStateFlow<Int> {
        val mutableStateFlow = MutableStateFlow(10)
        GlobalScope.launch {
            delay(2000)
            mutableStateFlow.emit(20)
            delay(2000)
            mutableStateFlow.emit(30)
        }

        return mutableStateFlow
    }

    /**
     *
     * Step 17 MutableStateFlow concept
     *
     */

    private fun flowStateProducerNew(): StateFlow<Int> {
        val mutableStateFlow = MutableStateFlow(10)
        GlobalScope.launch {
            delay(2000)
            mutableStateFlow.emit(20)
            delay(2000)
            mutableStateFlow.emit(30)
        }

        return mutableStateFlow
    }




    /**
     *
     * Step 12 it will crash
     *
     */

//    private fun flowProducer() = flow<Int> {
//        val list = listOf(1, 2, 3, 4, 5)
//        withContext(Dispatchers.IO){
//            list.forEach {
//                Log.d("Main", "Emitting $it")
//                delay(1000)
//                emit(it)
//            }
//        }
//    }

    /**
     *
     * Step 10 another way to Produce data
     *
     */

    private fun flowProducer2(): Flow<Int> {
        val list = listOf(1, 2, 3, 4, 5)
        return list.asFlow()
    }


}