package CompositeBuilds_MySimpleProject.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*

object CompositeBuilds_MySimpleProject_DependOnAllTests : BuildType({
    name = "Depend on All Tests"

    artifactRules = "**/*"

    dependencies {
        dependency(CompositeBuilds_MySimpleProject_AllTests) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }

            artifacts {
                artifactRules = """
                    artifact.zip
                    artifact.zip!/Vstest
                """.trimIndent()
            }
        }
    }
})
