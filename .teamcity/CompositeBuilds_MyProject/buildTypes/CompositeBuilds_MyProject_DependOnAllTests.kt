package CompositeBuilds_MyProject.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*

object CompositeBuilds_MyProject_DependOnAllTests : BuildType({
    name = "Depend on All Tests"

    dependencies {
        dependency(CompositeBuilds_MyProject_AllTests) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }

            artifacts {
                artifactRules = "*"
            }
        }
    }
})
