package com.alejandrorios.expose.presentation.favorites

import com.alejandrorios.expose.utils.base.BasePresenter
import com.alejandrorios.expose.utils.base.BaseView

/**
 * @author alejandrorios on 8/30/20
 */
interface FavoritesContract {

    interface View: BaseView

    interface Presenter: BasePresenter<View>
}
