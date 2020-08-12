package kr.co.tjoeun.jickbangcopy_20200812.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kr.co.tjoeun.jickbangcopy_20200812.R
import kr.co.tjoeun.jickbangcopy_20200812.datas.Room

//4. Adapter 클래스 생성
//4-2) Adapter의 주 생성자에서 필요한 재료를 받고
class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: List<Room>

//4-1) ArrayAdapter<Student(뿌려줄 데이터클래스)>() 상속받고
//4-3) ArrayAdapter<Room>(mContext, resId, mList) 생성자에서 필요한 재료 순으로 부모에게 넘기자
) : ArrayAdapter<Room>(mContext, resId, mList) {

    //4-4) 객체로 변환해주는 (화면에 뿌리도록 도와주는) 변수를 멤버변수로 생성
    val inf = LayoutInflater.from(mContext)

    //4-5) getView 함수를 오버라이딩
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //4-6) convertView 변수를 -> var tempRow에 옮겨담아서 -> null인 경우에는 새로 inflate해서 담자
        //쓰는 용도 : listView의 재사용성을 위해
        var tempRow = convertView
        if(tempRow == null)
        {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

        // tempRow는 맞는데 절대 null은 아니다 (=!!)
        val row = tempRow!!
        return row
    }

}