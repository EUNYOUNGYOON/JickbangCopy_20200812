package kr.co.tjoeun.jickbangcopy_20200812.datas

import java.io.Serializable
import java.net.Inet4Address
import java.text.NumberFormat
import java.util.*

//2. ListView가 뿌려줄 데이터들을 묶어서 표현하는 데이터 클래스 작업
// 생성자 : Room을 만들 때 필수적으로 넣어줘야 할 정보 항목들을 명시 (가격, 주소, 층수, 설명)
// : Serializable - Room을 통째로 putExtra / getExtra 해주기 위해 필요한 코드
class Room (
    //클래스의 생성자에서 val 변수이름: 자료형 나열해서 클래스가 가져야하는 정보 항목들로 설정
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String
//8-2) Serializable로 설정
) : Serializable {

    //9. function추가
    // 가격을 상황별로 가공해서 String으로 주는 기능
    fun getFormattedPrice() : String {

        // 1억이 넘는지 아닌지 구별. 상황별로 다르게 가공문장을 리턴(결과로 지정)
        if(this.price >= 10000)
        {
            val hm = this.price / 10000                                     // 몇억? 만으로 나는 몫 = 억단위
            val thou = this.price % 10000                                   // 나머지 만원단위 만으로 나눈 나머지 값
            val thouStr = NumberFormat.getNumberInstance().format(thou)     // 구해진 만원 단위를 가지고 세자리마다 , 찍기

            if(thou == 0)
            {
                return "${hm}억"
            }
            else
            {
                // ?억
                return "${hm}억 ${thouStr}"
            }
        }
        else
        {
            // 7000 -> 7,500처럼 세자리마다 , 찍어주는 기능 활용
            return NumberFormat.getNumberInstance().format(this.price)
        }
    }

    // 10. function추가 floor
    // 층수(Int)를 상황별로 가공해서 String으로 만들어주는 기능
    fun getFormattedFloor() : String {

        // 최종 가공 결과가 저장될 변수를 미리 만들자
        var flooString : String

        // 층수가 1이상, 0미만, 그 외 (0) 상황에 따라 다르게 가공하기 위한 조건문을 사용하고 있다.
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

        // 완성된 문구를 이 함수의 결과로 지정(return)
        return flooString
    }
}