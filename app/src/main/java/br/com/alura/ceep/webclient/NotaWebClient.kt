package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota

private const val TAG = "NotaWebClient"
class NotaWebClient {

    suspend fun buscaTodasNotas() : List<Nota>? {
        return try {
            val notasResposta = RetrofitInit().notaService.buscaTodas()
            notasResposta.map {
                it.nota
            }
        } catch (e: Exception) {
            Log.i(TAG, "oncreate: ${e.message}")
            null
        }

    }
}