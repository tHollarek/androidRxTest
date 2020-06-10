package com.rxtest.rxtest

import io.reactivex.rxjava3.core.*


class Presenter (view: FirstFragment) {

    val view = view
    val updatableValue: Flowable<Int> = Flowable.create(
        { emitter -> view.registerEmitter(emitter) },
        BackpressureStrategy.BUFFER
    )

    fun showUpdatableValue(){
        updatableValue
            .doOnNext{ value -> view.showValue(value) }
            .subscribe()
    }
}