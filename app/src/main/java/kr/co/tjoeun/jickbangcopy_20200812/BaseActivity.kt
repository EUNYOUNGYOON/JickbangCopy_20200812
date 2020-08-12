package kr.co.tjoeun.jickbangcopy_20200812

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    // 어느 화면인지 알려줄 때 쓰는 용도의 변수 mContext
    val mContext = this

    // 이벤트 처리 코드를 모아두게될 함수
    abstract fun setupEvents()

    // 화면에 데이터를 뿌리는데 관련된 코드를 모아두게 될 함수
    abstract fun setValues()

}