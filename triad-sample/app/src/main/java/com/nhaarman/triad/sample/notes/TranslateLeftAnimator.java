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

package com.nhaarman.triad.sample.notes;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.nhaarman.triad.TransitionAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

class TranslateLeftAnimator implements TransitionAnimator {

    @Override
    public boolean forward(@Nullable final View oldView, @NonNull final View newView, @NonNull final ViewGroup parent, @NonNull final Function0<Unit> onComplete) {
        if (oldView == null) {
            return false;
        }

        parent.addView(newView);

        oldView.animate().x(-oldView.getWidth()).setInterpolator(new AccelerateInterpolator());
        newView.setX(parent.getWidth());
        newView.animate().x(0).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animation) {
                newView.animate().setListener(null);
                ((ViewManager) oldView.getParent()).removeView(oldView);

                onComplete.invoke();
            }
        });

        return true;
    }

    @Override
    public boolean backward(@Nullable final View oldView, @NonNull final View newView, @NonNull final ViewGroup parent, @NonNull final Function0<Unit> onComplete) {
        if (oldView == null) {
            return false;
        }

        parent.addView(newView);

        newView.setX(-((View) newView.getParent()).getWidth());
        newView.animate().x(0).setInterpolator(new AccelerateInterpolator());
        oldView.animate().x(parent.getWidth()).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animation) {
                oldView.animate().setListener(null);
                ((ViewManager) oldView.getParent()).removeView(oldView);

                onComplete.invoke();
            }
        });

        return true;
    }
}