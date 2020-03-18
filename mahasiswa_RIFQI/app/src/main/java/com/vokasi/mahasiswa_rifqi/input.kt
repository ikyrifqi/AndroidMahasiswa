package com.vokasi.mahasiswa_rifqi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.vokasi.mahasiswa_rifqi.input
import kotlinx.android.synthetic.main.activity_input.*
import org.json.JSONArray

class input : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        val context=this

        home.setOnClickListener {
            val intent= Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        input.setOnClickListener {
            var nama = nama.text.toString()
            var nim = nim.text.toString()
            var alamat = alamat.text.toString()

            postkerserver(nama, nim, alamat)

            val intent= getIntent()
            startActivity(intent)
            finish()
        }
    }

    fun postkerserver(nama:String,nim:String, alamat:String){
        AndroidNetworking.post("http://192.168.1.22/mahasiswa/insert_data.php")
            .addBodyParameter("nama", nama)
            .addBodyParameter("nim", nim)
            .addBodyParameter("alamat", alamat)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                    Log.i("Teguh", "MANTAP")
                }

                override fun onError(anError: ANError?) {
                    Log.i("Teguh", "BOCOR")
                }
            })
    }

}