package kr.co.tjoeun.jickbangcopy_20200812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.room_list_item.*
import kr.co.tjoeun.jickbangcopy_20200812.adapters.RoomAdapter
import kr.co.tjoeun.jickbangcopy_20200812.datas.Room

class MainActivity : BaseActivity() {

    //5. 액티비티에서 실제 목록을 담아줄 ArrayList를 만들고, 그 안에서 실제 데이터들을 담아주자.
    // 화면에 나타날 방들이 담길 목록(배열)
    val mRoomList = ArrayList<Room>()

    //6. 만들어둔 (정의해둔) Adapter 클래스를 액티비티에 있는 리스트뷰와 연결
    // lateinit var: 변수는 미리 만들지만 객체 대입은 (초기화)은 나중에 하겠다.
    lateinit var mRoomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 두개의 함수에 적힌 코드는 반드시 onCreate() 내부에서 다시 실행시켜줘야 실제로 동작함.
        setupEvents()
        setValues()
    }


    override fun setupEvents() {
        // 메인화면의 이벤트 관련 코드를 모아둘 장소
        //8. 리스트 클릭 이벤트
        roomListView.setOnItemClickListener { adapterView, view, i, l ->

            val clickedRoom = mRoomList[i]
            val myIntent = Intent(mContext, ViewRoomDetailActivity::class.java)
            //8-1) 해당 방의 가격이랑 주소등의 데이터를 담아줘야한다.
            //myIntent.putExtra("방이름", clickedRoom.price)

            //8-3) Serializable로 설정하면 오류 안나고
            myIntent.putExtra("roomInfo", clickedRoom) // datas > Room 의 Room 상속 Serializable을 넣자
            // 이동
            startActivity(myIntent)

        }

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

        // 초기화를 미뤄둔 어댑터를 실제로 초기화하자
        //6-1) adapter클래스를 객체화(5. 에서 만든 목록과 연결)
        // BaseActivity의 mContext, 어떤 리스트를 보여줄건지, 목록변수의 이름
        mRoomAdapter = RoomAdapter(mContext, R.layout.room_list_item, mRoomList)

        //6-2) 객체화 된 adapter변수를 -> 리스트뷰의 어댑터로 지정
        roomListView.adapter = mRoomAdapter
    }

}