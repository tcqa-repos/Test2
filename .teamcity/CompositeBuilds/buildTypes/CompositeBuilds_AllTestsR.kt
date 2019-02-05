package CompositeBuilds.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*

object CompositeBuilds_AllTestsR : BuildType({
    name = "All Tests (R)"

    vcs {
        showDependenciesChanges = true
    }

    dependencies {
        snapshot(CompositeBuilds_SubProject.buildTypes.CompositeBuilds_SubProject_Tests1) {
            reuseBuilds = ReuseBuilds.NO
        }
        snapshot(CompositeBuilds_SubProject.buildTypes.CompositeBuilds_SubProject_Tests2) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})
