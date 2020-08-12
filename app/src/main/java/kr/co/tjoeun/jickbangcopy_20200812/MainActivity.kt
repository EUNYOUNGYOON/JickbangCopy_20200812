package kr.co.tjoeun.jickbangcopy_20200812

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : BaseActivity() {

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
    }




}