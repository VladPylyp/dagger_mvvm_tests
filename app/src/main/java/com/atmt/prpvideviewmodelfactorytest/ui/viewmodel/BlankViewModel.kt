package com.atmt.prpvideviewmodelfactorytest.ui.viewmodel


import android.arch.lifecycle.ViewModel
import com.atmt.prpvideviewmodelfactorytest.repositories.TestRepository
import javax.inject.Inject

class BlankViewModel @Inject constructor(private val testRepository: TestRepository) : ViewModel()
