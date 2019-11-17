package com.ukuapps.comidastati.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ukuapps.comidastati.ComidasTatiApp
import com.ukuapps.comidastati.R
import com.ukuapps.comidastati.presentation.base.BaseActivity
import com.ukuapps.comidastati.presentation.login.signIn.SignInActivity
import com.ukuapps.comidastati.presentation.main.MainActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() , SplashView{

    private val mDelayHandler = Handler()
    private val TIME_DELAY: Long = 3000
    @Inject
    lateinit var presenter: SplashPresenter

    override fun getLayOut(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as ComidasTatiApp).getAppContent().inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
        presenter.begin()
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    private val mRunnable = Runnable {
        var intent = if (presenter.isLoged()) {
            Intent(applicationContext, MainActivity::class.java)
        } else {
            Intent(applicationContext, SignInActivity::class.java)
        }
        startActivity(intent)
        finish()
    }

    override fun goToApplication() {
        mDelayHandler.postDelayed(mRunnable,TIME_DELAY)
    }
}
