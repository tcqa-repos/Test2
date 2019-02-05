package CompositeBuilds.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*

object CompositeBuilds_AllTestsNoArtifacts : BuildType({
    name = "All Tests (no artifacts)"

    type = BuildTypeSettings.Type.COMPOSITE

    vcs {
        showDependenciesChanges = true
    }

    dependencies {
        snapshot(CompositeBuilds_SubProject_SubSubProject.buildTypes.CompositeBuilds_SubProject_SubSubProject_Tests2_2) {
        }
        dependency(CompositeBuilds_SubProject.buildTypes.CompositeBuilds_SubProject_Tests1) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }

            artifacts {
                artifactRules = "folder with spaces/**/*"
                enabled = false
            }
        }
        dependency(CompositeBuilds_SubProject.buildTypes.CompositeBuilds_SubProject_Tests2) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }

            artifacts {
                artifactRules = "folder with spaces => folder with spaces"
                enabled = false
            }
        }
    }
})
