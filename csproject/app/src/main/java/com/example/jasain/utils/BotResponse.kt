package com.example.jasain.utils

import com.example.jasain.utils.Constants.OPEN_GOOGLE
import com.example.jasain.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //pembuka
            message.contains("hai admin") -> {
                when (random) {
                    0 -> "Halo. Selamat datang di JasaIn Chatbot!"
                    1 -> "Halo. Silahkan jelaskan kendala mu ya!"
                    2 -> "Hai. Sampaikan kendala mu disini ya!"
                    else -> "error" }
            }

            //penutup
            message.contains("terimakasih") -> {
                when (random) {
                    0 -> "Sama-sama. Senang bisa membantu!"
                    1 -> "Sama-sama. Silahkan kembali jika kamu mengalami masalah lain!"
                    2 -> "Sama-sama. Terima kasih telah menghubungi kami!"
                    else -> "error"
                }
            }

            //AC
            message.contains("kenapa ac tidak dingin?") -> {
                when (random) {
                    0 -> "Filter AC mu kotor. Pastikan untuk membersihkan atau mengganti filter secara teratur ya!"
                    1 -> "AC mu kekurangan refrigeran. Segera lakukan pengisian ulang refrigeran ya!"
                    2 -> "Bisa jadi kipas penggerak AC mu rusak. Segera hubungi jasa service untuk melakukan perbaikan."
                    else -> "error"
                }
            }

            //HP
            message.contains("ponsel saya stuck di logo tidak mau menyala") -> {
                when (random) {
                    0 -> "HP mu mengalami bootloop. Coba lakukan restart paksa ya! Semoga berhasil."
                    1 -> "HP mu mengalami bootloop. Coba masuk ke mode pemulihan (recovery mode) untuk membersihkan cache atau melakukan reset pabrik"
                    2 -> "HP mu mengalami bootloop. Segera hubungi jasa service untuk melakukan perbaikan."
                    else -> "error"
                }
            }

            //Laptop
            message.contains("laptop saya ngelag") -> {
                when (random) {
                    0 -> "Coba periksa info update sistem operasi pada laptop. Pembaruan sistem operasi sering mengatasi bug dan masalah kinerja, sehingga sangat penting untuk menjaga sistem Anda tetap terbarui."
                    1 -> "Jika laptop Anda memiliki ruang penyimpanan yang terbatas dan hampir penuh. Kamu bisa mencoba upgrade RAM/SSD/Hardisk mu untuk mengatasi masalah ini"
                    2 -> "kemungkinan laptop mu overheating. Cobalah untuk membersihkan sistem pendingin laptop dan memastikan ventilasi tidak tersumbat oleh debu atau kotoran."
                    else -> "error"
                }
            }

            //Komputer
            message.contains("saran rakit pc dong!") -> {
                when (random) {
                    0 -> "Cari informasi dan lakukan riset tentang komponen PC yang kamu butuhkan."
                    1 -> "Tentukan tujuan penggunaan PC mu nanti agar dapat menentukan spesifikasi yang tepat."
                    2 -> "Tentukan anggaran yang Anda siapkan untuk merakit PC. Ini akan membantu Anda dalam memilih komponen dengan harga yang sesuai."
                    else -> "error" }
            }

            //printer
            message.contains("kenapa hasil printer sering rusak?") -> {
                when (random) {
                    0 -> "Periksa tingkat tinta atau toner. Jika rendah, ganti dengan yang baru."
                    1 -> "Periksa apakah ada kertas yang terjebak di dalam printer. Hati-hati saat mengeluarkannya untuk menghindari kerusakan lebih lanjut."
                    2 -> "Periksa pengaturan kualitas cetakan dalam driver printer dan pastikan pengaturan yang sesuai dengan kebutuhan Anda."
                    else -> "error" }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                Time.timeStamp()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}