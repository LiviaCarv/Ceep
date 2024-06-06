package br.com.alura.ceep.webclient.services

import br.com.alura.ceep.webclient.model.NotaRequisicao
import br.com.alura.ceep.webclient.model.NotaResposta
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface NotaService {

    @GET("notas")
    suspend fun buscaTodas(): List<NotaResposta>

    @PUT("notas/{uuid}")
    suspend fun salva(
        @Path("uuid") id: String,
        @Body nota: NotaRequisicao
    ): Response<NotaRequisicao>

    @DELETE("notas/{uuid}")
    suspend fun remove(@Path("uuid") id: String): Response<Void>
}
