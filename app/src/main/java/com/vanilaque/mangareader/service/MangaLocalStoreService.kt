package com.vanilaque.mangareader.service

class MangaLocalStoreService {
//    suspend fun downloadImage(context: Context, imageUrl: String, fileName: String): File? = withContext(Dispatchers.IO) {
//        try {
//            val url = URL(imageUrl)
//            val connection = url.openConnection()
//            connection.doInput = true
//            connection.connect()
//            val inputStream = connection.getInputStream()
//            val directory = File(context.filesDir, "images")
//            if (!directory.exists()) {
//                directory.mkdirs()
//            }
//            val file = File(directory, fileName)
//            val outputStream = FileOutputStream(file)
//            val buffer = ByteArray(1024)
//            var bytesRead: Int
//            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
//                outputStream.write(buffer, 0, bytesRead)
//            }
//            outputStream.close()
//            inputStream.close()
//            return@withContext file
//        } catch (e: IOException) {
//            e.printStackTrace()
//            return@withContext null
//        }
//    }
//
//    fun loadImageFromFile(context: Context, fileName: String): Bitmap? {
//        val file = File(context.filesDir, "images/$fileName")
//        if (file.exists()) {
//            return BitmapFactory.decodeFile(file.absolutePath)
//        }
//        return null
//    }
}   