package kr.co.tjoeun.jickbangcopy_20200812.adapters

import android.animation.TypeConverter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.jickbangcopy_20200812.R
import kr.co.tjoeun.jickbangcopy_20200812.datas.Room
import java.lang.Math.abs
import java.text.NumberFormat
import java.util.*

//4. Adapter 클래스 생성
//4-2) Adapter의 주 생성자에서 필요한 재료를 받고
// trello 카드의 어댑터 뼈대 작업 부분 참고 -> 상속/ 생성자 활용
class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: List<Room>

//4-1) ArrayAdapter<Student(뿌려줄 데이터클래스)>() 상속받고
//4-3) ArrayAdapter<Room>(mContext, resId, mList) 생성자에서 필요한 재료 순으로 부모에게 넘기자
) : ArrayAdapter<Room>(mContext, resId, mList) {

    //4-4) 객체로 변환해주는 (화면에 뿌리도록 도와주는) 변수를 멤버변수로 생성
    // inf만든 이유 : 재사용성을 고려한 inflate(xml코드 -> 메모리 등록-객체화)를 실행해주는 주체
    val inf = LayoutInflater.from(mContext)

    //4-5) getView 함수를 오버라이딩
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //4-6) convertView 변수를 -> var tempRow에 옮겨담아서 -> null인 경우에는 새로 inflate해서 담자
        //쓰는 용도 : listView의 재사용성을 위해 (어쩔 수 없을 때만 inflate를 해주자)
        var tempRow = convertView
        if(tempRow == null)
        {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

        // tempRow는 맞는데 절대 null은 아니다 (=!!)
        val row = tempRow!!

        //7. 실제 데이터가 목록에 반영되도록, Adapter클래스의 getView 함수 내부 수정.
        //7-1) 뿌려줄 row안에 있는 텍스트 뷰 변수로 담기
        val descTxt = row.findViewById<TextView>(R.id.descTxt)
        val addrFloorTxt = row.findViewById<TextView>(R.id.addrFloorTxt)
        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)

        // 화면에 뿌려질 근거 데이터 / 기능을 갖고 있는 변수를 상황에 맞게 가져오자.
        // 상황: getView는 매 줄마다 반복적으로 실행됨 : 어떤 줄을 그리는지? position으로 알아내자
        val data = mList[position]

        // 실제 데이터 반영
        descTxt.text = data.description

        // 층수 >= 1 : 2층 5층 등 / 층수 == 0 / 그 외 : 지하 2층, 지하 1층 등
        // 10. floor도 function만들기
//        var flooString : String
//        if(data.floor >= 1)
//        {
//            flooString = "${data.floor}층"
//        }
//        else if(data.floor == 0)
//        {
//            flooString = "반지하"
//        }
//        else
//        {
//            flooString = "지하 ${-data.floor}층"
//        }
//
//        addrFloorTxt.text = "${data.address}, ${flooString}"

        // 10-1) floor 관련 getFormattedFloor() 적용
        addrFloorTxt.text = data.getFormattedFloor()

//        when {
//            data.floor > 0 -> {
//                addrFloorTxt.text = "${data.address}, ${data.floor}층"
//            }
//            data.floor == 0 -> {
//                addrFloorTxt.text = "${data.address}, 반지하"
//            }
//            else -> {
//                addrFloorTxt.text = "${data.address}, 지하 ${abs(data.floor)}층"
//            }
//        }

        // 9번을 하기전에 초창기 데이터
//        if(data.price >= 10000)
//        {
//            val hm = data.price / 10000
//            val thou = data.price % 10000
//            if(thou == 0)
//            {
//                priceTxt.text = "${hm}억"
//            }
//            else
//            {
//                priceTxt.text = "${hm}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(thou)}"
//            }
//        }
//        else
//        {
//            priceTxt.text = NumberFormat.getNumberInstance(Locale.KOREA).format(data.price)
//        }

        //9-1. getFormattedPrice 사용하기
        priceTxt.text = data.getFormattedPrice()

        // 반영이 모두 끝난 row를 뿌려달라고 결과로 지정 return
        return row
    }

}