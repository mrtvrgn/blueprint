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

package com.xfinity.rmvp_sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.xfinity.rmvp.event.ComponentEventManager
import com.xfinity.rmvp.view.ScreenViewDelegate
import com.xfinity.rmvp_sample.mvp.presenter.StaticScreenPresenter
import com.xfinity.rmvp_sample.rmvp.AppComponentRegistry
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator

/**
 * The static screen example documents how to compose a simple presentation of data.  The screen is interactable, but
 * none of the interactions require any action by the screen, such as adding or removing Components.
 */
class StaticScreenActivity : AppCompatActivity() {
    //These would be injected
    private val componentEventManager = ComponentEventManager()
    private val componentRegistry = AppComponentRegistry(componentEventManager, 0, "defaultDataItem")
    private val presenter = StaticScreenPresenter()

    private val screenViewDelegate: ScreenViewDelegate = ScreenViewDelegate(componentRegistry)
    lateinit var content : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content = findViewById(R.id.content)
        content.setBackgroundColor(resources.getColor(android.R.color.white))

        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        presenter.attachView(screenViewDelegate)
        presenter.present()

        recyclerView.itemAnimator = SlideInUpAnimator()
        recyclerView.adapter = screenViewDelegate.componentAdapter
    }
}
