package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.services.NotaService
import retrofit2.Retrofit

private const val BASE_URL = "http://localhost:8080/"

class RetrofitInit {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()

    val notaService = retrofit.create(NotaService::class.java)
}