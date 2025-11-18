package de.patrickwire.myapplication.mavigationexamples

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * 🎯 APPLICATION CLASS WITH HILT
 *
 * This is the entry point for dependency injection in the app.
 * @HiltAndroidApp triggers Hilt's code generation and sets up the
 * application-level dependency container.
 *
 * Required for ALL Hilt-based projects.
 */
@HiltAndroidApp
class MavigationApplication : Application()
