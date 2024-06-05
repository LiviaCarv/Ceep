package br.com.alura.ceep.webclient

import br.com.alura.ceep.model.Nota

class NotaWebClient {

    suspend fun buscaTodasNotas() : List<Nota> {
        val notasResposta = RetrofitInit().notaService.buscaTodas()
        return notasResposta.map {
            it.nota
        }

    }
}