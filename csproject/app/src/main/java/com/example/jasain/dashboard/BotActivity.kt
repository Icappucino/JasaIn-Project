package com.example.jasain.dashboard

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jasain.R
import com.example.jasain.adapter.MessagingAdapter
import com.example.jasain.data.Message
import com.example.jasain.utils.BotResponse
import com.example.jasain.utils.Constants.OPEN_GOOGLE
import com.example.jasain.utils.Constants.OPEN_SEARCH
import com.example.jasain.utils.Constants.RECEIVE_ID
import com.example.jasain.utils.Constants.SEND_ID
import com.example.jasain.utils.Time
import kotlinx.android.synthetic.main.activity_bot.*
import kotlinx.coroutines.*

class BotActivity : AppCompatActivity() {

    private lateinit var adapter: MessagingAdapter
    private val botList = listOf("Bot Jasain","MaharajaKevin","YangMuliaArya")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot)

        recyclerView()
        clickEvents()

        val random = (0..2).random()
        customMessage("Halo! Sekarang kamu bicara dengan ${botList[random]}, ada yang bisa ku bantu?")
    }
    private fun clickEvents() {
        btn_send.setOnClickListener {
            sendMessage()
        }

        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)
                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)
    }
    private fun sendMessage() {
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            et_message.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }
    private fun botResponse(message: String) {
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            delay(1000)

            withContext(Dispatchers.Main) {
                val response = BotResponse.basicResponses(message)

                adapter.insertMessage(Message(response, RECEIVE_ID, timeStamp))
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                when (response) {
                    OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfter("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
    private fun customMessage(message: String){
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val timestamp = Time.timeStamp()
                adapter.insertMessage(Message(message, RECEIVE_ID, timestamp))

                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }
}