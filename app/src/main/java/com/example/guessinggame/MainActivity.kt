package com.example.guessinggame

//手動加入
import android.graphics.Color
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

//手動加入 import kotlinx
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this.setTitle("04-猜拳遊戲");
        
        //加入監聽及程式 //此處btn_mora若變紅色代表需import，alt+enter然後選import
        btn_mora.setOnClickListener{
            //判斷使用者是否輸入姓名
            if(ed_name.length()<1)
                tv_text.text="請輸入玩家姓名"
            else{
                //顯示使用者姓名、出拳
                tv_name.text=String.format("名字\n%s",ed_name.text)
                tv_mmora.text=String.format("我方出拳\n%s",when{
                    btn_scissor.isChecked->"剪刀"
                    btn_stone.isChecked->"石頭"
                    else -> "布"
                })
                //使用亂數產生電腦出拳
                val computer = (Math.random()*3).toInt()
                tv_cmora.text=String.format("電腦出拳\n%s",when(computer){
                    0->"剪刀"
                    1->"石頭"
                    else->"布"
                })
                //判斷勝負
                when{
                    btn_scissor.isChecked && computer == 2 || btn_stone.isChecked && computer == 0 || btn_paper.isChecked && computer == 1 ->{
                        tv_winner.text = String.format("勝利者\n%s",ed_name.text)
                        tv_text.text = "恭喜你獲勝了！！！"
                        var textView = findViewById<TextView>(R.id.tv_text)
                        textView.setTextColor(Color.parseColor("#FF0000"))

                    }
                    btn_scissor.isChecked && computer == 1 || btn_stone.isChecked && computer == 2 || btn_paper.isChecked && computer == 0 ->{
                        tv_winner.text = String.format("勝利者\n電腦")
                        tv_text.text = "可惜，電腦獲勝了！"
                        var textView = findViewById<TextView>(R.id.tv_text)
                        textView.setTextColor(Color.parseColor("#0000FF"))

                    }
                }
            }
        }
    }
}