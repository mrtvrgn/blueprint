/*
 * Copyright 2017 Comcast Cable Communications Management, LLC
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xfinity.rmvp_sample.mvp.presenter

import com.xfinity.rmvp.model.ComponentModel
import com.xfinity.rmvp.presenter.ComponentPresenter
import com.xfinity.rmvp.view.ComponentView
import com.xfinity.rmvp_annotations.DefaultPresenter
import com.xfinity.rmvp_sample.mvp.model.HeaderModel
import com.xfinity.rmvp_sample.mvp.view.HeaderView

@DefaultPresenter(viewClass = HeaderView::class)
class HeaderPresenter : ComponentPresenter {
    override fun present(componentView: ComponentView<*>, componentModel: ComponentModel) {
        (componentView as HeaderView).setEnabled((componentModel as HeaderModel).enabled)

        if (componentModel.enabled) {
            componentView.setEnabled(true)
            componentView.setHeader(componentModel.header)
        }
    }

    override fun onComponentClicked(componentView: ComponentView<*>, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}