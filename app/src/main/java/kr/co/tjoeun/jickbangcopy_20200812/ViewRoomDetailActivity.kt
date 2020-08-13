package kr.co.tjoeun.jickbangcopy_20200812

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_room_detail.*
import kr.co.tjoeun.jickbangcopy_20200812.datas.Room

class ViewRoomDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_room_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        //8-4) 데이터 담기
        val room = intent.getSerializableExtra("roomInfo") as Room

        // 8-6) as Room 캐스팅이 안하면 에러가 난다.
        priceTxt.text = room.price.toString()
        addressTxt.text = room.address


    }
}