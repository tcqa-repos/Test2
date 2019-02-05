package CompositeBuilds_MySimpleProject_NewSubProject.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script

object CompositeBuilds_MySimpleProject_NewSubProject_Tests21 : BuildType({
    name = "Tests 2 (1)"

    artifactRules = "ANSI codes => artifact.zip"

    vcs {
        root(AbsoluteId("HttpsGithubComJuliaReshMyProject_2"))
    }

    steps {
        script {
            scriptContent = """
                echo "##teamcity[testStarted name='pack.Test1' captureStandardOutput='false']"
                echo "##teamcity[testFailed name='pack.Test1' duration='138']"
                echo "##teamcity[testStarted name='pack1.Test2' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack1.Test2' duration='128']"
                echo "##teamcity[testStarted name='pack1.Test3' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack1.Test3' duration='3000']"
                echo "##teamcity[testStarted name='pack1.Test3' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack1.Test3' duration='2000']"
                echo "##teamcity[testStarted name='pack1.TestA' captureStandardOutput='false']"
                echo "##teamcity[testIgnored name='pack1.TestA' duration='2000']"
                echo "##teamcity[testStarted name='pack1.TestIgnored_once' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack1.TestIgnored_once' duration='2000']"
            """.trimIndent()
        }
        step {
            type = "SleepNSeconds"
            enabled = false
            param("timeout-in-seconds", "6000")
        }
    }
})
