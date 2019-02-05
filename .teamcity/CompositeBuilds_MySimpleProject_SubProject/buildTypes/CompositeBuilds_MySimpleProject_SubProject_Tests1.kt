package CompositeBuilds_MySimpleProject_SubProject.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script

object CompositeBuilds_MySimpleProject_SubProject_Tests1 : BuildType({
    name = "Tests 1"

    artifactRules = "perfmon.bat"

    vcs {
        root(AbsoluteId("HttpsGithubComJuliaReshMyProject_2"))
    }

    steps {
        script {
            scriptContent = """
                echo "##teamcity[testStarted name='pack.Test1' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack.Test1' duration='138']"
                echo "##teamcity[testStarted name='pack.Test2' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack.Test2' duration='128']"
                echo "##teamcity[testStarted name='pack.Test3' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack.Test3' duration='148']"
                echo "##teamcity[testStarted name='pack1.Test3' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack1.Test3' duration='400']"
            """.trimIndent()
        }
        step {
            type = "SleepNSeconds"
            enabled = false
            param("timeout-in-seconds", "6000")
        }
    }
})
