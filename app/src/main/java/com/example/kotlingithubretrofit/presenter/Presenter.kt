package com.example.kotlingithubretrofit.presenter

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlingithubretrofit.common.Constants
import com.example.kotlingithubretrofit.models.GithubRepo
import com.example.kotlingithubretrofit.network.GetRepo
import com.example.kotlingithubretrofit.network.RetrofitInstance
import com.example.kotlingithubretrofit.views.GithubAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter :BasePresenter<GithubView>(){

    override fun onViewAttached(view: GithubView) {
        super.onViewAttached(view)
        val githubRepo = RetrofitInstance().retrofitInstance.create(GetRepo::class.java)
        val call: Call<List<GithubRepo>> = githubRepo.getRepos(Constants.USER)
        call.enqueue(object: Callback<List<GithubRepo>> {
            override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
                Log.i("errormsg",t.message)
            }

            override fun onResponse(call: Call<List<GithubRepo>>, response: Response<List<GithubRepo>>) {
                val res = response.body()
                Log.i("hello",res!![0].full_name)
                Log.i("hello1",res!![0].description)
                view.showGithubInfo(res)
//                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//                recyclerView.adapter = adapter
            }
        })
    }

}

interface GithubView : BasePresenter.View {
    fun showGithubInfo(githubRepo: List<GithubRepo>)
}