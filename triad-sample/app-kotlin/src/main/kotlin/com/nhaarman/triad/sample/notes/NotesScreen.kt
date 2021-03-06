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

package com.nhaarman.triad.sample.notes

import com.nhaarman.triad.Presenter
import com.nhaarman.triad.Screen
import com.nhaarman.triad.sample.ApplicationComponent
import com.nhaarman.triad.sample.R
import com.nhaarman.triad.sample.notes.noteslist.NotesListPresenter

internal class NotesScreen : Screen<ApplicationComponent>() {

    override val layoutResId = R.layout.view_notes

    override fun createPresenter(viewId: Int): Presenter<*, *> {
        return when (viewId) {
            R.id.notesView -> NotesPresenter(applicationComponent.triad)
            R.id.notesListView -> NotesListPresenter(
                  applicationComponent.noteRepository,
                  getPresenter(R.id.notesView) as NotesListPresenter.OnNoteClickedListener
            )
            else -> throw AssertionError("Unknown presenter class for view with id: $viewId")
        }
    }
}
