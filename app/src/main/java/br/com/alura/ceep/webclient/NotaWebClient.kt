package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.model.NotaRequisicao
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

    suspend fun salva(nota: Nota) : Boolean {
        try {
            val resposta = notaService.salva(nota.id, NotaRequisicao(
                nota.titulo, nota.descricao, nota.imagem
            ))
            return (!resposta.isSuccessful)

        } catch (e: Exception) {
            Log.i(TAG, "Erro: ${e.message}")
        }
        return false
    }

    suspend fun remove(id: String): Boolean {
        try {
            val resposta = notaService.remove(id)
            return resposta.isSuccessful
        } catch (e: Exception) {
            Log.i(TAG, "Erro: ${e.message}")
        }
        return false
    }
}