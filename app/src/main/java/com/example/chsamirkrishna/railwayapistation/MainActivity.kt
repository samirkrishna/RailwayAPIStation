package com.example.chsamirkrishna.railwayapistation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var et1:EditText?=null
    var lview:ListView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1=findViewById(R.id.et1)
        lview=findViewById(R.id.lview)
    }

    fun load(v:View){

        var r=Retrofit.Builder().baseUrl("https://api.railwayapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
        var api=r.create(PnrStatusAPI ::class.java)
        var call=api.getPnrStatus(et1?.text.toString())
        call.enqueue(object : Callback<PnrStatus> {
            override fun onFailure(call: Call<PnrStatus>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<PnrStatus>?, response: Response<PnrStatus>?) {
               var pnrstatus=response?.body()
                var list=ArrayList<String>()
                list.add("Train no:"+pnrstatus?.train?.number)
                list.add("Train name"+pnrstatus?.train?.name)
                list.add("Doj:"+pnrstatus?.doj)
                list.add("No of passengers:"+pnrstatus?.total_passengers.toString())
                list.add("From station:"+pnrstatus?.from_station?.name.toString())
                list.add("To Station:"+pnrstatus?.to_station?.name.toString())

                var adapter=ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_dropdown_item_1line,list)
                lview?.adapter=adapter

            }

        })
    }
}
