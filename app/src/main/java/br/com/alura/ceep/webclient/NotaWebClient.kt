package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.services.NotaService

private const val TAG = "NotaWebClient"
class NotaWebClient {

    private val notaService: NotaService = RetrofitInit().notaService

    suspend fun buscaTodasNotas() : List<Nota>? {
        return try {
            val notasResposta = notaService.buscaTodas()
            notasResposta.map {
                it.nota
            }
        } catch (e: Exception) {
            Log.i(TAG, "buscaTodas: ${e.message}")
            null
        }

    }
}