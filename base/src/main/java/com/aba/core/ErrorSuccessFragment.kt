package com.aba.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aba.core.extension.hide
import com.aba.core.extension.show
import kotlinx.android.synthetic.main.fragment_error_success.*

abstract class ErrorSuccessFragment<State: MviState>: BaseFragment(), ErrorSuccessCallback {

    internal companion object {
        internal const val VIEW_INDEX_CONTENT = 0
        internal const val VIEW_INDEX_ERROR = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_error_success, container, false).run {
        errorContentContainer.addView(
            layoutInflater.inflate(contentResourceId, null)
        )
        this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewListeners()
        subscribeToLiveData()
    }

    abstract fun subscribeToLiveData()
    abstract fun initView()
    abstract fun initViewListeners()
    abstract fun render(state: State)

    open fun onErrorAction() {}
    open fun onEmptyAction() {}

    override fun showLoadingSpinner() {
        switchToView(VIEW_INDEX_CONTENT)
        errorLoadingView.show()
    }

    override fun hideLoadingSpinner() {
        errorLoadingView.hide()
    }

    override fun displayGenericErrorMessage() {
        showErrorScreen(
            getString(R.string.generic_fail_title),
            getString(R.string.generic_network_error),
            getString(R.string.generic_error_button_text)
        )
    }

    override fun displayNetworkErrorMessage() {
        showErrorScreen(
            getString(R.string.generic_fail_title),
            getString(R.string.generic_network_error),
            getString(R.string.generic_error_button_text)
        )
    }

    override fun displayCustomError(title: String, msg: String) {
        showErrorScreen(
            getString(R.string.generic_fail_title),
            getString(R.string.generic_network_error),
            getString(R.string.generic_error_button_text)
        )
    }

    private fun showErrorScreen(title: String, message: String, buttonTitle: String) {
        switchToView(VIEW_INDEX_ERROR)
    }

    private fun switchToView(viewIndex: Int) {
        with(errorSuccessViewSwitcher) {
            if (viewIndex != displayedChild) {
                displayedChild = viewIndex
            }
        }
    }
}