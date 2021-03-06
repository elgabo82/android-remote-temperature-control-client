package com.smlnskgmail.jaman.remotetemperaturecontrol.components.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smlnskgmail.jaman.remotetemperaturecontrol.components.bottomsheets.BaseBottomSheet
import com.smlnskgmail.jaman.remotetemperaturecontrol.logic.monitor.btmonitor.connection.targets.BtPauseTarget

abstract class BaseFragment : Fragment(), BtPauseTarget {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeFragment(view)
    }

    abstract fun initializeFragment(view: View)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View = inflater.inflate(getLayoutResId(), container, false)

    abstract fun getLayoutResId(): Int

    fun showBottomSheet(bottomSheet: BaseBottomSheet) {
        bottomSheet.show(
            activity!!.supportFragmentManager,
            bottomSheet::class.java.name
        )
    }

    override fun handleBtInOnPause() {}

}
