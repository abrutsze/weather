package com.test.weatherapp.view.fragments


import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.test.weatherapp.R
import com.test.weatherapp.view.base.BaseFragment
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit


class SplashFragment : BaseFragment() {

    private val destroyCompositeDisposable = CompositeDisposable()
    override fun initBeforeView() {
    }

    override fun getContentViewId(): Int = R.layout.fragment_splash

    override fun initViews(rootView: View) {

        destroyCompositeDisposable.add(Completable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe({
                Navigation.findNavController(view!!).navigate(
                    R.id.action_splashFragment_to_mainFragment, null,
                    NavOptions.Builder()
                        .setPopUpTo(
                            R.id.splashFragment,
                            true
                        ).build()
                )
            }, {})
        )

    }


    override fun onDestroyView() {
        destroyCompositeDisposable.dispose()
        super.onDestroyView()
    }

}
