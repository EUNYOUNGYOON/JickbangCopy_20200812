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
        // 메인화면에서 넘겨준 Room 가져오기
        // 넘겨줄 때 Serializable 형태로 넘겨줌 -> Room으로 변환해서 지정해야 사용 가능.
        // as Room 추가
        val room = intent.getSerializableExtra("roomInfo") as Room

        // 8-6) as Room 캐스팅이 안하면 에러가 난다.
        // 9-2) getFormattedPrice 적용
        // 실제 데이터 반영
        priceTxt.text = room.getFormattedPrice()
        addressTxt.text = room.address
        descTxt.text = room.description
        floorTxt.text = room.getFormattedFloor()


    }
}