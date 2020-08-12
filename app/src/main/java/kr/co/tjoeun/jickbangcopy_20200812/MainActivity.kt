package kr.co.tjoeun.jickbangcopy_20200812

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.tjoeun.jickbangcopy_20200812.datas.Room

class MainActivity : BaseActivity() {

    //5. 액티비티에서 실제 목록을 담아줄 ArrayList를 만들고, 그 안에서 실제 데이터들을 담아주자.
    val mRoomList = ArrayList<Room>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()

    }

    override fun setupEvents() {
        // 메인화면의 이벤트 관련 코드를 모아둘 장소
    }

    override fun setValues() {
        // 메인화면의 값 출력 관련 코드 모아둘 장소

        //5-1) 실제로 뿌려줄 데이터들을 ArrayList변수에 추가해주자.
        // 방목록을 강제로 추가하는 코드
        mRoomList.add(Room(8000, "서울시 마포구", 1, "마포구의 1층 방입니다."))
        mRoomList.add(Room(78000, "서울시 마포구", 17, "마포구의 17층 방입니다."))
        mRoomList.add(Room(12000, "서울시 마포구", 3, "마포구의 3층 방입니다."))
        mRoomList.add(Room(2400, "서울시 은평구", 0, "은평구의 반지하 방입니다."))
        mRoomList.add(Room(8900, "서울시 은평구", 5, "은평구의 5층 방입니다."))
        mRoomList.add(Room(28000, "서울시 은평구", 6, "은평구의 6층 방입니다."))
        mRoomList.add(Room(18000, "서울시 영등포구", 1, "마포구의 1층 방입니다."))
        mRoomList.add(Room(800, "서울시 영등포구", -2, "마포구의 지하 2층 방입니다."))
        mRoomList.add(Room(118000, "서울시 영등포구", 3, "마포구의 3층 방입니다."))
        mRoomList.add(Room(10000, "수원시 장안구", 7, "마포구의 7층 방입니다."))
        


    }




}