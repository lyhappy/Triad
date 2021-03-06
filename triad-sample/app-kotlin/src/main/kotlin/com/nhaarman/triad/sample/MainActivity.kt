/*
 * Copyright 2016 Niek Haarman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nhaarman.triad.sample

import android.os.Bundle
import android.view.View
import com.nhaarman.triad.TransitionAnimator
import com.nhaarman.triad.Triad
import com.nhaarman.triad.TriadActivity
import com.nhaarman.triad.sample.notes.NotesScreen

class MainActivity : TriadActivity<ApplicationComponent, ActivityComponent>() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        triad.startWith(NotesScreen())
    }

    override fun createActivityComponent() = ActivityComponent()
}
