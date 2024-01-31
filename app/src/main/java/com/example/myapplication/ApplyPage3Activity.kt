package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ApplyPage3Activity : AppCompatActivity() {

    lateinit var myHelper: myDBHelper
    lateinit var edtName: EditText
    lateinit var edtNumber: EditText
    lateinit var edtEmail1: EditText
    lateinit var edtEmail2: EditText
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applypage3)

        //액션바 이름 변경
        getSupportActionBar()?.setTitle("해외 입양 이동 봉사 신청")

        edtName = findViewById<EditText>(R.id.edtName)
        edtNumber = findViewById<EditText>(R.id.edtNumber)
        edtEmail1 = findViewById<EditText>(R.id.edtEmail1)
        edtEmail2 = findViewById<EditText>(R.id.edtEmail2)

        myHelper = myDBHelper(this)


        // 다음 화면으로 전환
        var nextBtn = findViewById<Button>(R.id.nextBtn)

        nextBtn.setOnClickListener({

            /*sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO applyTBL VALUES ( '"
            + edtName.text.toString() + "', "
            + edtNumber.text.toString() + ","
            + edtEmail1.text.toString() + "', "
            + edtEmail2.text.toString() + "';"

            val name = edtName.text.toString()
            val number = edtNumber.text.toString()
            val email1 = edtEmail1.text.toString()
            val email2 = edtEmail2.text.toString()

            // 데이터베이스에 데이터를 저장
            val sqlDB = myHelper.writableDatabase
            val values = ContentValues().apply {
                put("name", name)
                put("number", number)
                put("email1", email1)
                put("email2", email2)
            }
            sqlDB.insert("applyTBL", null, values)

            sqlDB.close()*/

            //다음 화면으로 넘어감
            val intent = Intent(this, ApplyPage4Activity::class.java)
            startActivity(intent)
        })
    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper ( context, "applyDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE applyTBL ( name char(20), number integer(10), email1 char(15), email2 char(15));")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS applyTBL")
            onCreate(db)
        }
    }
}