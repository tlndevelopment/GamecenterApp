package com.fundatec.gamecenter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.fundatec.gamecenter.adapter.ProdutosAdapter
import com.fundatec.gamecenter.jsonData.ProdutosData
import com.fundatec.gamecenter.request.GsonRequest

import kotlinx.android.synthetic.main.activity_produtos.*
import kotlinx.android.synthetic.main.content_produtos.*

class ProdutosActivity : AppCompatActivity() {

    private var queue : RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)
        setSupportActionBar(toolbar)

        queue = Volley.newRequestQueue(baseContext)
        recyclerProdutos.layoutManager = LinearLayoutManager(baseContext, RecyclerView.VERTICAL, false)
        readProdutos()

    }

    private fun readProdutos() {
        var url = "https://gamecenter-api.herokuapp.com/gamecenter/produtos"

        var request = GsonRequest(url, Array<ProdutosData>::class.java, null, Response.Listener { response ->
                var lista = ArrayList(response.toList())
                if(lista.isEmpty()) {
                    recyclerProdutos.visibility = View.GONE
                    emptyProdutos.visibility = View.VISIBLE
                }

                var adapter = ProdutosAdapter(baseContext, lista)
                recyclerProdutos.adapter = adapter

            },
            Response.ErrorListener { error ->
                Toast.makeText(baseContext, "" + error.message, Toast.LENGTH_LONG).show()
            }
        )
        queue?.add(request)
    }
}
