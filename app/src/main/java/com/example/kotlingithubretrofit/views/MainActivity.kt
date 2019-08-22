package com.example.kotlingithubretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlingithubretrofit.R
import com.example.kotlingithubretrofit.common.Constants
import com.example.kotlingithubretrofit.models.GithubRepo
import com.example.kotlingithubretrofit.network.GetRepo
import com.example.kotlingithubretrofit.network.RetrofitInstance
import com.example.kotlingithubretrofit.presenter.GithubView
import com.example.kotlingithubretrofit.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),GithubView {
    val presenter:Presenter = Presenter()
    var adapter: GithubAdapter? = null

    override fun showGithubInfo(githubRepo: List<GithubRepo>) {
        adapter = GithubAdapter(githubRepo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewAttached(this)

    }
}


