package kr.co.tjoeun.jickbangcopy_20200812.datas

import java.io.Serializable
import java.net.Inet4Address
import java.text.NumberFormat
import java.util.*

//2. ListView가 뿌려줄 데이터들을 묶어서 표현하는 데이터 클래스 작업
class Room (
    //클래스의 생성자에서 val 변수이름: 자료형 나열해서 클래스가 가져야하는 정보 항목들로 설정
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String
//8-2) Serializable로 설정
) : Serializable {

    //9. function추가
    fun getFormattedPrice() : String {

        if(this.price >= 10000)
        {
            val hm = this.price / 10000
            val thou = this.price % 10000
            val thouStr = NumberFormat.getNumberInstance().format(thou)

            if(thou == 0)
            {
                return "${hm}억"
            }
            else
            {
                return "${hm}억 ${thouStr}"
            }
        }
        else
        {
            return NumberFormat.getNumberInstance().format(this.price)
        }
    }

    // 10. function추가 floor
    fun getFormattedFloor() : String {

        var flooString : String
        if(this.floor >= 1)
        {
            flooString = "${this.floor}층"
        }
        else if(this.floor == 0)
        {
            flooString = "반지하"
        }
        else
        {
            flooString = "지하 ${-this.floor}층"
        }
        return flooString
    }
}